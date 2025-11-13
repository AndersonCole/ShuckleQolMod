package ca.shuckle.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ConnectedGlassPaneBlock extends PaneBlock {
    public static final BooleanProperty TEXTURE_CONNECT_NORTH = BooleanProperty.of("connect_north");
    public static final BooleanProperty TEXTURE_CONNECT_EAST = BooleanProperty.of("connect_east");
    public static final BooleanProperty TEXTURE_CONNECT_SOUTH = BooleanProperty.of("connect_south");
    public static final BooleanProperty TEXTURE_CONNECT_WEST = BooleanProperty.of("connect_west");
    public static final BooleanProperty TEXTURE_CONNECT_UP = BooleanProperty.of("connect_up");
    public static final BooleanProperty TEXTURE_CONNECT_DOWN = BooleanProperty.of("connect_down");

    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Util.make(Maps.newEnumMap(Direction.class), directions -> {
        directions.put(Direction.NORTH, TEXTURE_CONNECT_NORTH);
        directions.put(Direction.EAST, TEXTURE_CONNECT_EAST);
        directions.put(Direction.SOUTH, TEXTURE_CONNECT_SOUTH);
        directions.put(Direction.WEST, TEXTURE_CONNECT_WEST);
        directions.put(Direction.UP, TEXTURE_CONNECT_UP);
        directions.put(Direction.DOWN, TEXTURE_CONNECT_DOWN);
    }));

    public ConnectedGlassPaneBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)
                this.stateManager.getDefaultState())
                .with(NORTH, false))
                .with(EAST, false))
                .with(SOUTH, false))
                .with(WEST, false))
                .with(TEXTURE_CONNECT_NORTH, false))
                .with(TEXTURE_CONNECT_EAST, false))
                .with(TEXTURE_CONNECT_SOUTH, false))
                .with(TEXTURE_CONNECT_WEST, false))
                .with(TEXTURE_CONNECT_UP, false))
                .with(TEXTURE_CONNECT_DOWN, false))
                .with(WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldView world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        BlockPos posNorth = pos.north();
        BlockPos posEast = pos.east();
        BlockPos posSouth = pos.south();
        BlockPos posWest = pos.west();
        BlockPos posUp = pos.up();
        BlockPos posDown = pos.down();
        BlockState blockStateNorth = world.getBlockState(posNorth);
        BlockState blockStateEast = world.getBlockState(posEast);
        BlockState blockStateSouth = world.getBlockState(posSouth);
        BlockState blockStateWest = world.getBlockState(posWest);

        return this.getDefaultState()
                .with(NORTH, connectsTo(blockStateNorth, blockStateNorth.isSideSolidFullSquare(world, posNorth, Direction.SOUTH)))
                .with(EAST, connectsTo(blockStateEast, blockStateEast.isSideSolidFullSquare(world, posEast, Direction.WEST)))
                .with(SOUTH, connectsTo(blockStateSouth, blockStateSouth.isSideSolidFullSquare(world, posSouth, Direction.NORTH)))
                .with(WEST, connectsTo(blockStateWest, blockStateWest.isSideSolidFullSquare(world, posWest, Direction.EAST)))
                .with(TEXTURE_CONNECT_NORTH, connectedTexturesTo(world, posNorth))
                .with(TEXTURE_CONNECT_EAST, connectedTexturesTo(world, posEast))
                .with(TEXTURE_CONNECT_SOUTH, connectedTexturesTo(world, posSouth))
                .with(TEXTURE_CONNECT_WEST, connectedTexturesTo(world, posWest))
                .with(TEXTURE_CONNECT_UP, connectedTexturesTo(world, posUp))
                .with(TEXTURE_CONNECT_DOWN, connectedTexturesTo(world, posDown))
                .with(WATERLOGGED, ctx.getWorld().getFluidState(pos).getFluid() == Fluids.WATER);
    }

    protected boolean connectedTexturesTo(WorldView world, BlockPos other) {
        return world.getBlockState(other).isOf(this);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BooleanProperty prop = PROPERTY_BY_DIRECTION.get(direction);
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (direction.getAxis().isHorizontal()) {
            return prop == null ? state : state.with(prop, neighborState.isOf(this))
                    .with(FACING_PROPERTIES.get(direction), this.connectsTo(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, direction.getOpposite())));
        }
        return prop == null ? state : state.with(prop, neighborState.isOf(this));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, TEXTURE_CONNECT_NORTH, TEXTURE_CONNECT_EAST,
                TEXTURE_CONNECT_SOUTH, TEXTURE_CONNECT_WEST, TEXTURE_CONNECT_UP, TEXTURE_CONNECT_DOWN, WATERLOGGED);
    }
}
