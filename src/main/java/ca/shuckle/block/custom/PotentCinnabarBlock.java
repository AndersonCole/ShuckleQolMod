package ca.shuckle.block.custom;

import ca.shuckle.block.entity.ModBlockEntities;
import ca.shuckle.block.entity.custom.PotentCinnabarBlockEntity;
import ca.shuckle.util.ModSounds;
import ca.shuckle.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class PotentCinnabarBlock extends BlockWithEntity {
    public static final BooleanProperty DRY = BooleanProperty.of("dry");
    public static final BooleanProperty WET = BooleanProperty.of("wet");
    public static final BooleanProperty DORMANT = BooleanProperty.of("dormant");
    public static final BooleanProperty ERUPTING = BooleanProperty.of("erupting");
    public static final BooleanProperty CONTINUOUS = BooleanProperty.of("continuous");

    public PotentCinnabarBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                this.stateManager.getDefaultState()).with(DRY, true))
                .with(WET, false)).with(DORMANT, false)).with(ERUPTING, false)).with(CONTINUOUS, false));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        return new PotentCinnabarBlockEntity(worldPosition, blockState);
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state,
            Direction direction,
            BlockState neighborState,
            WorldAccess world,
            BlockPos pos,
            BlockPos neighborPos) {
        return validBlockState(state, world, pos);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return validBlockState(this.getDefaultState(), ctx.getWorld(), ctx.getBlockPos());
    }

    private static BlockState validBlockState(final BlockState state, WorldAccess world, final BlockPos pos) {
        if (!world.getFluidState(pos.up()).isOf(Fluids.LAVA)) {
            return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                    state.with(PotentCinnabarBlock.DRY, true))
                    .with(PotentCinnabarBlock.WET, false))
                    .with(PotentCinnabarBlock.DORMANT, false))
                    .with(PotentCinnabarBlock.ERUPTING, false))
                    .with(PotentCinnabarBlock.CONTINUOUS, false));
        } else {
            BlockState belowState = world.getBlockState(pos.down());
            if (belowState.isIn(ModTags.Blocks.CAUSES_CONTINUOUS_GEYSER_ERUPTIONS)) {
                return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                        state.with(PotentCinnabarBlock.DRY, false))
                        .with(PotentCinnabarBlock.WET, false))
                        .with(PotentCinnabarBlock.DORMANT, false))
                        .with(PotentCinnabarBlock.ERUPTING, false))
                        .with(PotentCinnabarBlock.CONTINUOUS, true));
            } else if (!belowState.isIn(ModTags.Blocks.CAUSES_PERIODIC_GEYSER_ERUPTIONS)) {
                return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                        state.with(PotentCinnabarBlock.DRY, false))
                        .with(PotentCinnabarBlock.WET, true))
                        .with(PotentCinnabarBlock.DORMANT, false))
                        .with(PotentCinnabarBlock.ERUPTING, false))
                        .with(PotentCinnabarBlock.CONTINUOUS, false));
            } else {
                boolean isGeyser = state.get(PotentCinnabarBlock.ERUPTING).booleanValue() || state.get(PotentCinnabarBlock.DORMANT).booleanValue();
                if (!isGeyser && world.getBlockEntity(pos) instanceof PotentCinnabarBlockEntity potentCinnabarEntity) {
                    potentCinnabarEntity.resetCountdown();
                }

                if (state.get(PotentCinnabarBlock.ERUPTING).booleanValue()) {
                    return state;
                } else {
                    return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                            state.with(PotentCinnabarBlock.DRY, false))
                            .with(PotentCinnabarBlock.WET, false))
                            .with(PotentCinnabarBlock.DORMANT, true))
                            .with(PotentCinnabarBlock.ERUPTING, false))
                            .with(PotentCinnabarBlock.CONTINUOUS, false));
                }
            }
        }
    }

    @Override
    public void onBlockAdded(final BlockState state, final World world, final BlockPos pos, final BlockState oldState, final boolean movedByPiston) {
        super.onBlockAdded(state, world, pos, oldState, movedByPiston);
        if (state.get(PotentCinnabarBlock.ERUPTING).booleanValue() || state.get(PotentCinnabarBlock.CONTINUOUS).booleanValue()) {
            SoundEvent soundEvent;
            if (state.get(PotentCinnabarBlock.CONTINUOUS).booleanValue()) {
                soundEvent = ModSounds.GEYSER_CONTINUOUS_START;
            } else {
                soundEvent = ModSounds.GEYSER_ERUPTION_START;
            }
            world.addSyncedBlockEvent(pos, this, 0, 0);
            world.playSound(
                    null,
                    pos,
                    soundEvent,
                    SoundCategory.BLOCKS,
                    1.0F,
                    1.0F
            );
            world.emitGameEvent(GameEvent.BLOCK_ACTIVATE, pos, GameEvent.Emitter.of(state));
        }
    }

    @Override
    public void randomDisplayTick(final BlockState state, final World world, final BlockPos pos, final Random random) {
        if (!state.get(DRY).booleanValue()) {
            if (world.getFluidState(pos.up()).isOf(Fluids.LAVA)) {
                spawnFireParticlesAt(world, random, pos.getX(), pos.getY() + 1, pos.getZ());
                spawnFireParticlesAt(world, random, pos.getX(), pos.getY() + 1, pos.getZ());
                if (random.nextInt(10) == 0) {
                    world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.AMBIENT, 1.0F, 1.0F, false);
                }
            }
        }
    }

    private static void spawnFireParticlesAt(final World world, final Random random, final double x, final double y, final double z) {
        world.addImportantParticle(ParticleTypes.SMALL_FLAME, x + random.nextFloat(), y + random.nextFloat(), z + random.nextFloat(), 0.0, 0.0, 0.0);
    }

    @Override
    public boolean onSyncedBlockEvent(final BlockState state, final World world, final BlockPos pos, final int b0, final int b1) {
        if (world.getBlockEntity(pos) instanceof PotentCinnabarBlockEntity entity) {
            entity.eruptionTick = world.getTime();
        }

        return true;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        if (world.isClient()) {
            if (state.get(WET).booleanValue() || state.get(DORMANT).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::clientFireParticleTick);
            } else if (state.get(ERUPTING).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::clientGeyserPlumeTick);
            } else if (state.get(CONTINUOUS).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::clientGeyserPlumeTick);
            }
        } else {
            if (state.get(WET).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::serverNauseaEffectTick);
            } else if (state.get(DORMANT).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::serverDormantTick);
            } else if (state.get(ERUPTING).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::serverEruptingTick);
            } else if (state.get(CONTINUOUS).booleanValue()) {
                return checkType(type, ModBlockEntities.POTENT_CINNABAR, PotentCinnabarBlockEntity::serverLaunchEntityTick);
            }
        }
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DRY, WET, DORMANT, ERUPTING, CONTINUOUS);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}