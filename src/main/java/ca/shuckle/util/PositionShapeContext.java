package ca.shuckle.util;

import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class PositionShapeContext implements ShapeContext {
    private final double y;

    public PositionShapeContext(final double y) {
        this.y = y;
    }

    @Override
    public boolean isDescending() {
        return false;
    }

    @Override
    public boolean isAbove(VoxelShape shape, BlockPos pos, boolean defaultValue) {
        return this.y > pos.getY() + shape.getMax(Direction.Axis.Y) - 1.0E-5F;
    }

    @Override
    public boolean isHolding(Item item) {
        return false;
    }

    @Override
    public boolean canWalkOnFluid(FluidState stateAbove, FluidState state) {
        return false;
    }
}
