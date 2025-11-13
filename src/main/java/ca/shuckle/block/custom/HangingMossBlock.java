package ca.shuckle.block.custom;

import ca.shuckle.block.ModBackportBlocks;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class HangingMossBlock extends HangingRootsBlock {

    public HangingMossBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        return Block.isFaceFullSquare(blockState.getSidesShape(world, pos), Direction.DOWN)
                || Block.isFaceFullSquare(blockState.getCollisionShape(world, pos), Direction.DOWN);
    }
}
