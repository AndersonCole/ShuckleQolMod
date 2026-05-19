package ca.shuckle.block.entity.custom;

import ca.shuckle.block.custom.PotentSulfurBlock;
import ca.shuckle.block.entity.ModBlockEntities;
import ca.shuckle.particle.ModParticles;
import ca.shuckle.particle.effect.GeyserParticleEffect;
import ca.shuckle.util.ModSounds;
import ca.shuckle.util.PositionShapeContext;
import ca.shuckle.util.RaycastContextUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.Xoroshiro128PlusPlusRandom;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;
public class PotentSulfurBlockEntity extends BlockEntity {
    private static final int EFFECT_APPLICATION_FREQUENCY_TICKS = 10;
    private static final float EFFECT_DURATION_IN_SECONDS = 4.0F;
    private static final int EFFECT_DURATION_IN_TICKS = 80;
    public static final float EFFECT_RANGE = 3.0F;
    private static final Predicate<Entity> EFFECT_PREDICATE = entity -> !entity.isSpectator() && entity.isAlive();
    public static final int PARTICLE_FREQUENCY_TICKS = 20;
    public static final int SOUND_FREQUENCY_TICKS = 40;
    private static final float GEYSER_BASE_LAUNCH_SPEED = 0.3F;
    private static final float GEYSER_LAUNCH_FORCE = 0.2F;
    public int waitingCountdown = -1;
    public long eruptionTick = -1L;

    public static void serverNauseaEffectTick(World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        if (world.getTime() % 10L == 0L) {
            BlockPos sourceBlock = findNoxiousGasSourceBlock(world, pos);
            if (sourceBlock != null) {
                for (LivingEntity entity : getNearbyLivingEntities(world, sourceBlock)) {
                    if (canBeReachedByNoxiousGas(world, sourceBlock, entity.getEyePos())) {
                        applyNauseaEffect(entity);
                    }
                }
            }
        }
    }

    public static void clientNoxiousGasTick(World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        if (world.getTime() % 20L == 0L) {
            BlockPos sourceBlock = findNoxiousGasSourceBlock(world, pos);
            if (sourceBlock != null) {
                spawnNoxiousGasCloudParticle(world, Vec3d.ofCenter(sourceBlock));
            }
        }
    }

    public static void clientGeyserPlumeTick (World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        BlockPos sourceBlock = findNoxiousGasSourceBlock(world, pos);
        if (sourceBlock != null) {
            long eruptionTime = world.getTime() - be.eruptionTick;
            if (eruptionTime % 20L == 0L) {
                spawnGeyserParticle(world, pos, sourceBlock);
            }

            SoundEvent soundEvent;
            if (state.get(PotentSulfurBlock.CONTINUOUS).booleanValue()) {
                soundEvent = ModSounds.GEYSER_CONTINUOUS_ACTIVE;
            } else {
                soundEvent = ModSounds.GEYSER_ERUPTION_ACTIVE;
            }

            if (eruptionTime % 40L == 0L) {
                world.playSound(sourceBlock.getX() + 0.5, sourceBlock.getY() + 0.5, sourceBlock.getZ() + 0.5,
                        soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
        }
    }

    public static void serverWaitingCountdownTick(World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        if (world.getTime() % 20L == 0L) {
            BlockPos sourceBlock = findNoxiousGasSourceBlock(world, pos);
            if (sourceBlock != null) {
                if (be.waitingCountdown <= 0) {
                    int waterBlocks = sourceBlock.getY() - pos.getY() - 1;
                    Random geyserPositional = geyserPositional((ServerWorld)world, pos);
                    if (state.get(PotentSulfurBlock.DORMANT).booleanValue()) {
                        be.waitingCountdown = 10 * (waterBlocks - 1) + geyserPositional.nextBetween(15, 30);
                    } else {
                        geyserPositional.nextInt();
                        be.waitingCountdown = waterBlocks - 1 + geyserPositional.nextBetween(1, 2);
                    }
                }

                if (be.waitingCountdown > 0) {
                    be.waitingCountdown--;
                }

                if (be.waitingCountdown == 0) {
                    if (state.get(PotentSulfurBlock.DORMANT).booleanValue()) {
                        world.setBlockState(pos, (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                                state.with(PotentSulfurBlock.DRY, false))
                                .with(PotentSulfurBlock.WET, false))
                                .with(PotentSulfurBlock.DORMANT, false))
                                .with(PotentSulfurBlock.ERUPTING, true))
                                .with(PotentSulfurBlock.CONTINUOUS, false)), 3);
                    } else {
                        world.setBlockState(pos, (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                                state.with(PotentSulfurBlock.DRY, false))
                                .with(PotentSulfurBlock.WET, false))
                                .with(PotentSulfurBlock.DORMANT, true))
                                .with(PotentSulfurBlock.ERUPTING, false))
                                .with(PotentSulfurBlock.CONTINUOUS, false)), 3);
                        world.emitGameEvent(GameEvent.BLOCK_DEACTIVATE, pos, GameEvent.Emitter.of(state));
                    }
                }
            }
        }
    }

    public static void serverLaunchEntityTick(World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        BlockPos sourceBlock = findNoxiousGasSourceBlock(world, pos);
        if (sourceBlock != null) {
            int waterBlocks = sourceBlock.getY() - pos.getY() - 1;
            int geyserForceHeight = getUnobstructedBlockCount(world, pos.up(), waterBlocks);
            Box box = new Box(pos.up()).stretch(0.0, geyserForceHeight - 1, 0.0);

            for (Entity entityToBeLaunched : world.getEntitiesByClass(Entity.class, box, EFFECT_PREDICATE)) {
                Vec3d entityVelocity = entityToBeLaunched.getVelocity();
                if (!(entityToBeLaunched instanceof PlayerEntity player && player.getAbilities().flying) && entityVelocity.y < 0.3F + waterBlocks * 0.1) {
                    entityToBeLaunched.addVelocity(new Vec3d(0.0, 0.2F, 0.0));
                    entityToBeLaunched.velocityModified = true;
                    entityToBeLaunched.velocityDirty = true;
                }
            }
        }
    }

    public static void serverDormantTick(World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        serverWaitingCountdownTick(world, pos, state, be);
        serverNauseaEffectTick(world, pos, state, be);
    }

    public static void serverEruptingTick(World world, BlockPos pos, BlockState state, PotentSulfurBlockEntity be) {
        serverLaunchEntityTick(world, pos, state, be);
        serverWaitingCountdownTick(world, pos, state, be);
    }

    public PotentSulfurBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(ModBlockEntities.POTENT_SULFUR, worldPosition, blockState);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if(nbt.contains("countdown")) {
            this.waitingCountdown = nbt.getInt("countdown");
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("countdown", this.waitingCountdown);
    }

    @Override
    public void setWorld(final World world) {
        super.setWorld(world);
        if (this.eruptionTick == -1L) {
            this.eruptionTick = world.getTime();
        }
    }

    public void resetCountdown() {
        this.waitingCountdown = -1;
    }

    private static void applyNauseaEffect(final LivingEntity entity) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 80, 0, true, true));
    }

    private static List<LivingEntity> getNearbyLivingEntities(final World world, final BlockPos pos) {
        Box box = new Box(pos).expand(2.5, 0.0, 2.5);
        return world.getEntitiesByClass(LivingEntity.class, box, EFFECT_PREDICATE);
    }

    public static Random geyserPositional(final ServerWorld world, final BlockPos pos) {
        return new Xoroshiro128PlusPlusRandom(world.getSeed() ^ -904011478L).nextSplitter().split(pos);
    }

    private static void spawnGeyserParticle(final World world, final BlockPos sulfurPos, final BlockPos sourcePos) {
        int waterBlocks = sourcePos.getY() - sulfurPos.getY() - 1;
        world.addParticle(
                new GeyserParticleEffect(ModParticles.GEYSER, waterBlocks),
                sourcePos.getX() + 0.5, sourcePos.getY(), sourcePos.getZ() + 0.5, 0.0, 0.0, 0.0
        );
    }

    private static void spawnNoxiousGasCloudParticle(final World world, final Vec3d pos) {
        world.addParticle(ParticleTypes.BUBBLE, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
        //ParticleTypes.NOXIOUS_GAS_CLOUD
    }

    private static int getUnobstructedBlockCount(final World world, final BlockPos pos, final int waterBlocks) {
        int geyserForceHeight = 6 * waterBlocks;

        ShapeContext geyserPositionContext = new PositionShapeContext(pos.down().getY());

        for (int i = 0; i < geyserForceHeight; i++) {
            BlockPos currentPos = pos.up(i);
            BlockState state = world.getBlockState(currentPos);
            if (!isGeyserPassableBlock(state, world, currentPos, geyserPositionContext)) {
                return i;
            }
        }

        return geyserForceHeight;
    }

    private static boolean isGeyserPassableBlock(final BlockState state, final World world, final BlockPos pos, final ShapeContext context) {
        return !state.isAir() && !state.isOf(Blocks.WATER) ? state.getCollisionShape(world, pos, context).isEmpty() : true;
    }

    @Nullable
    private static BlockPos findNoxiousGasSourceBlock(final World world, final BlockPos origin) {
        int maxY = origin.getY() + 4 + 1;
        ShapeContext geyserPositionContext = new PositionShapeContext(origin.getY());
        BlockPos.Mutable pos = origin.up(1).mutableCopy();

        while (pos.getY() <= maxY) {
            BlockState state = world.getBlockState(pos);
            boolean isWaterLogged = world.getFluidState(pos).isOf(Fluids.WATER);
            if (!isWaterLogged || !state.isOf(Blocks.WATER) && !isGeyserPassableBlock(state, world, pos, geyserPositionContext)) {
                if (state.isAir() || isGeyserPassableBlock(state, world, pos, geyserPositionContext)) {
                    return pos.toImmutable();
                }
                break;
            }

            pos.move(Direction.UP);
        }

        return null;
    }

    public static boolean canBeReachedByNoxiousGas(final World world, final BlockPos sourceBlock, final Vec3d pos) {
        BlockPos blockPos = BlockPos.ofFloored(pos);
        ShapeContext geyserPositionContext = new PositionShapeContext(blockPos.down().getY());
        if (!isGeyserPassableBlock(world.getBlockState(blockPos), world, blockPos, geyserPositionContext)) {
            return false;
        } else if (pos.distanceTo(Vec3d.ofCenter(sourceBlock)) > 9.0) {
            return false;
        } else {
            Vec3d belowSource = Vec3d.ofCenter(sourceBlock.down());
            Vec3d belowPos = pos.withAxis(Direction.Axis.Y, pos.y - 1.0);
            return isWater(world, belowPos) && haveLineOfSight(world, belowSource, belowPos);
        }
    }

    private static boolean isWater(final World world, final Vec3d pos) {
        return world.getFluidState(BlockPos.ofFloored(pos)).isOf(Fluids.WATER);
    }

    private static boolean haveLineOfSight(final World world, final Vec3d a, final Vec3d b) {
        HitResult hitResult = world.raycast(RaycastContextUtil.shapeContextRaycast(a, b, RaycastContext.ShapeType.COLLIDER,
                RaycastContext.FluidHandling.NONE, ShapeContext.absent()));
        return hitResult.getType() != HitResult.Type.BLOCK;
    }
}
