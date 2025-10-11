package ca.shuckle.block.custom.copper;

import ca.shuckle.util.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BulbBlock extends Block {
    public static final BooleanProperty POWERED;
    public static final BooleanProperty LIT;

    static {
        POWERED = Properties.POWERED;
        LIT = Properties.LIT;
    }

    public BulbBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, false).with(POWERED, false));
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean) state.get(POWERED)) {
                blockState = state.cycle(LIT);
                world.playSound(null, pos, blockState.get(LIT) ? ModSounds.BLOCK_COPPER_BULB_TURN_ON : ModSounds.BLOCK_COPPER_BULB_TURN_OFF, SoundCategory.BLOCKS, 2F, 1F);
            }
            world.setBlockState(pos, blockState.with(POWERED, bl), 3);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, POWERED);
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return world.getBlockState(pos).get(LIT) ? 15 : 0;
    }
}
