package ca.shuckle.block.entity.custom;

import ca.shuckle.block.custom.PotentCinnabarBlock;
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
import net.minecraft.client.render.entity.PlayerEntityRenderer;
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
public class PotentCinnabarBlockEntity extends BlockEntity {
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

    public static void serverNauseaEffectTick(World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        if (world.getTime() % 10L == 0L) {
            BlockPos sourceBlock = findFireParticleSourceBlock(world, pos);
            if (sourceBlock != null) {
                for (LivingEntity entity : getNearbyLivingEntities(world, sourceBlock)) {
                    if (canBeReachedByFireParticle(world, sourceBlock, entity.getEyePos())) {
                        applyNauseaEffect(entity);
                    }
                }
            }
        }
    }

    public static void clientFireParticleTick(World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        if (world.getTime() % 20L == 0L) {
            BlockPos sourceBlock = findFireParticleSourceBlock(world, pos);
            if (sourceBlock != null) {
                spawnSmallFireParticle(world, Vec3d.ofCenter(sourceBlock));
            }
        }
    }

    public static void clientGeyserPlumeTick (World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        BlockPos sourceBlock = findFireParticleSourceBlock(world, pos);
        if (sourceBlock != null) {
            long eruptionTime = world.getTime() - be.eruptionTick;
            if (eruptionTime % 20L == 0L) {
                spawnGeyserParticle(world, pos, sourceBlock);
            }

            SoundEvent soundEvent;
            if (state.get(PotentCinnabarBlock.CONTINUOUS).booleanValue()) {
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

    public static void serverWaitingCountdownTick(World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        if (world.getTime() % 20L == 0L) {
            BlockPos sourceBlock = findFireParticleSourceBlock(world, pos);
            if (sourceBlock != null) {
                if (be.waitingCountdown <= 0) {
                    int lavaBlocks = sourceBlock.getY() - pos.getY() - 1;
                    Random geyserPositional = geyserPositional((ServerWorld)world, pos);
                    if (state.get(PotentCinnabarBlock.DORMANT).booleanValue()) {
                        be.waitingCountdown = 10 * (lavaBlocks - 1) + geyserPositional.nextBetween(15, 30);
                    } else {
                        geyserPositional.nextInt();
                        be.waitingCountdown = lavaBlocks - 1 + geyserPositional.nextBetween(1, 2);
                    }
                }

                if (be.waitingCountdown > 0) {
                    be.waitingCountdown--;
                }

                if (be.waitingCountdown == 0) {
                    if (state.get(PotentCinnabarBlock.DORMANT).booleanValue()) {
                        world.setBlockState(pos, (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                                state.with(PotentCinnabarBlock.DRY, false))
                                .with(PotentCinnabarBlock.WET, false))
                                .with(PotentCinnabarBlock.DORMANT, false))
                                .with(PotentCinnabarBlock.ERUPTING, true))
                                .with(PotentCinnabarBlock.CONTINUOUS, false)), 3);
                    } else {
                        world.setBlockState(pos, (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                                state.with(PotentCinnabarBlock.DRY, false))
                                .with(PotentCinnabarBlock.WET, false))
                                .with(PotentCinnabarBlock.DORMANT, true))
                                .with(PotentCinnabarBlock.ERUPTING, false))
                                .with(PotentCinnabarBlock.CONTINUOUS, false)), 3);
                        world.emitGameEvent(GameEvent.BLOCK_DEACTIVATE, pos, GameEvent.Emitter.of(state));
                    }
                }
            }
        }
    }

    public static void serverLaunchEntityTick(World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        BlockPos sourceBlock = findFireParticleSourceBlock(world, pos);
        if (sourceBlock != null) {
            int lavaBlocks = sourceBlock.getY() - pos.getY() - 1;
            int geyserForceHeight = getUnobstructedBlockCount(world, pos.up(), lavaBlocks);
            Box box = new Box(pos.up()).stretch(0.0, geyserForceHeight - 1, 0.0);

            for (Entity entityToBeLaunched : world.getEntitiesByClass(Entity.class, box, EFFECT_PREDICATE)) {
                Vec3d entityVelocity = entityToBeLaunched.getVelocity();

                if (isLocalInstanceAuthoritative(entityToBeLaunched)){
                    if (entityToBeLaunched instanceof PlayerEntity) {
                        PlayerEntity player = (PlayerEntity) entityToBeLaunched;
                        if (player.getAbilities().flying) {
                            continue;
                        }
                    }

                    if (!(entityToBeLaunched.getVehicle() != null) && entityVelocity.y < 0.3F + lavaBlocks * 0.1) {
                        entityToBeLaunched.addVelocity(new Vec3d(0.0, 0.2F, 0.0));
                        entityToBeLaunched.velocityModified = true;
                        entityToBeLaunched.velocityDirty = true;
                    }
                }
            }
        }
    }

    private static boolean isLocalInstanceAuthoritative(Entity entity) {
        if (entity.world.isClient()) {
            return isLocalClientAuthoritative(entity);
        } else {
            return !isClientAuthoritative(entity);
        }
    }

    private static boolean isLocalClientAuthoritative(Entity entity) {
        LivingEntity passenger = entity.getControllingPassenger();
        return passenger != null && isLocalClientAuthoritative(passenger);
    }

    private static boolean isClientAuthoritative(Entity entity) {
        LivingEntity passenger = entity.getControllingPassenger();
        return passenger != null && isClientAuthoritative(passenger);
    }

    public static void serverDormantTick(World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        serverWaitingCountdownTick(world, pos, state, be);
        serverNauseaEffectTick(world, pos, state, be);
    }

    public static void serverEruptingTick(World world, BlockPos pos, BlockState state, PotentCinnabarBlockEntity be) {
        serverLaunchEntityTick(world, pos, state, be);
        serverWaitingCountdownTick(world, pos, state, be);
    }

    public PotentCinnabarBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(ModBlockEntities.POTENT_CINNABAR, worldPosition, blockState);
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

    private static void spawnGeyserParticle(final World world, final BlockPos cinnabarPos, final BlockPos sourcePos) {
        int lavaBlocks = sourcePos.getY() - cinnabarPos.getY() - 1;
        world.addParticle(
                new GeyserParticleEffect(ModParticles.GEYSER, lavaBlocks, true),
                sourcePos.getX() + 0.5, sourcePos.getY(), sourcePos.getZ() + 0.5, 0.0, 0.0, 0.0
        );
    }

    private static void spawnSmallFireParticle(final World world, final Vec3d pos) {
        world.addParticle(ParticleTypes.SMALL_FLAME, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
    }

    private static int getUnobstructedBlockCount(final World world, final BlockPos pos, final int lavaBlocks) {
        int geyserForceHeight = 6 * lavaBlocks;

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
        return !state.isAir() && !state.isOf(Blocks.LAVA) ? state.getCollisionShape(world, pos, context).isEmpty() : true;
    }

    @Nullable
    private static BlockPos findFireParticleSourceBlock(final World world, final BlockPos origin) {
        int maxY = origin.getY() + 4 + 1;
        ShapeContext geyserPositionContext = new PositionShapeContext(origin.getY());
        BlockPos.Mutable pos = origin.up(1).mutableCopy();

        while (pos.getY() <= maxY) {
            BlockState state = world.getBlockState(pos);
            if (!state.isOf(Blocks.LAVA)) {
                if (state.isAir() || isGeyserPassableBlock(state, world, pos, geyserPositionContext)) {
                    return pos.toImmutable();
                }
                break;
            }

            pos.move(Direction.UP);
        }

        return null;
    }

    public static boolean canBeReachedByFireParticle(final World world, final BlockPos sourceBlock, final Vec3d pos) {
        BlockPos blockPos = BlockPos.ofFloored(pos);
        ShapeContext geyserPositionContext = new PositionShapeContext(blockPos.down().getY());
        if (!isGeyserPassableBlock(world.getBlockState(blockPos), world, blockPos, geyserPositionContext)) {
            return false;
        } else if (pos.distanceTo(Vec3d.ofCenter(sourceBlock)) > 9.0) {
            return false;
        } else {
            Vec3d belowSource = Vec3d.ofCenter(sourceBlock.down());
            Vec3d belowPos = pos.withAxis(Direction.Axis.Y, pos.y - 1.0);
            return isLava(world, belowPos) && haveLineOfSight(world, belowSource, belowPos);
        }
    }

    private static boolean isLava(final World world, final Vec3d pos) {
        return world.getFluidState(BlockPos.ofFloored(pos)).isOf(Fluids.LAVA);
    }

    private static boolean haveLineOfSight(final World world, final Vec3d a, final Vec3d b) {
        HitResult hitResult = world.raycast(RaycastContextUtil.shapeContextRaycast(a, b, RaycastContext.ShapeType.COLLIDER,
                RaycastContext.FluidHandling.NONE, ShapeContext.absent()));
        return hitResult.getType() != HitResult.Type.BLOCK;
    }
}

