package ca.shuckle.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class ModOxidizationHelpers {
    private static final String[] copperOxidizationStages = {
            "", "exposed_", "weathered_", "oxidized_"
    };

    public static String[] getCopperOxidizationStages() {
        return copperOxidizationStages;
    }

    public static BlockState tryDegrade(Oxidizable oxidizable, BlockState state){
        var result = oxidizable.getDegradationResult(state);
        if(result.isEmpty()) return state;
        else return result.get();
    }

    public static boolean touchingWater(BlockState state, BlockView world, BlockPos pos){
        if (state.contains(Properties.WATERLOGGED) && state.get(Properties.WATERLOGGED)){
            return true;
        }

        BlockPos.Mutable mutable = pos.mutableCopy();
        for (Direction dir : Direction.values()) {
            mutable.set(pos, dir);
            if (world.getFluidState(mutable).isIn(FluidTags.WATER)) {
                return true;
            }
        }
        return false;
    }
}
