package ca.shuckle.block.custom;

import ca.shuckle.block.entity.ModBlockEntities;
import ca.shuckle.block.entity.custom.CrafterBlockEntity;
import ca.shuckle.util.ItemScattererAccessor;
import ca.shuckle.util.RecipeCache;
import net.minecraft.block.*;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.block.enums.JigsawOrientation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrafterBlock extends BlockWithEntity {
    public static final BooleanProperty CRAFTING;
    public static final BooleanProperty TRIGGERED;
    private static final EnumProperty<JigsawOrientation> ORIENTATION;
    private static final int field_46802 = 6;
    private static final int TRIGGER_DELAY = 4;
    private static final RecipeCache recipeCache;

    public CrafterBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ORIENTATION, JigsawOrientation.NORTH_UP).with(TRIGGERED, false).with(CRAFTING, false));
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CrafterBlockEntity crafterBlockEntity) {
            return crafterBlockEntity.getComparatorOutput();
        } else {
            return 0;
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean powered = world.isReceivingRedstonePower(pos);
        boolean triggered = state.get(TRIGGERED);

        if (!(world.getBlockEntity(pos) instanceof CrafterBlockEntity crafterBlockEntity)) return;
        if (powered && !triggered) {
            world.scheduleBlockTick(pos, this, TRIGGER_DELAY);
            world.setBlockState(pos, state.with(TRIGGERED, true), 2);
            this.setTriggered(crafterBlockEntity, true);
        } else if (!powered && triggered) {
            world.setBlockState(pos, state.with(TRIGGERED, false).with(CRAFTING, false), 2);
            this.setTriggered(crafterBlockEntity, false);
        }

    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.craft(state, world, pos);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : checkType(type, ModBlockEntities.CRAFTER, CrafterBlockEntity::tickCrafting);
    }

    private void setTriggered(@Nullable BlockEntity blockEntity, boolean triggered) {
        if (blockEntity instanceof CrafterBlockEntity crafterBlockEntity) {
            crafterBlockEntity.setTriggered(triggered);
        }

    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        CrafterBlockEntity crafterBlockEntity = new CrafterBlockEntity(pos, state);
        crafterBlockEntity.setTriggered(state.contains(TRIGGERED) && state.get(TRIGGERED));
        return crafterBlockEntity;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerLookDirection().getOpposite();

        Direction direction2 = switch (direction) {
            case DOWN -> ctx.getHorizontalPlayerFacing().getOpposite();
            case UP -> ctx.getHorizontalPlayerFacing();
            case NORTH, SOUTH, WEST, EAST -> Direction.UP;
            default -> throw new IncompatibleClassChangeError();
        };
        return this.getDefaultState().with(ORIENTATION, JigsawOrientation.byDirections(direction, direction2)).with(TRIGGERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity var7 = world.getBlockEntity(pos);
            if (var7 instanceof CrafterBlockEntity crafterBlockEntity) {
                crafterBlockEntity.setCustomName(itemStack.getName());
            }
        }

        if (state.get(TRIGGERED)) {
            world.scheduleBlockTick(pos, this, 1);
        }

    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScattererAccessor.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CrafterBlockEntity crafterBlockEntity) {
            player.openHandledScreen(crafterBlockEntity);
        }

        return ActionResult.CONSUME;
    }

    protected void craft(BlockState state, ServerWorld world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof CrafterBlockEntity crafterBlockEntity)) return;

        Optional<CraftingRecipe> optional = getCraftingRecipe(world, crafterBlockEntity.getCraftingInventory());
        if (optional.isEmpty()) {
            //world.syncWorldEvent(WorldEvents.DISPENSER_FAILS, pos, 0);
        } else {
            crafterBlockEntity.setCraftingTicksRemaining(6);
            world.setBlockState(pos, state.with(CRAFTING, true), 2);
            CraftingRecipe craftingRecipe = optional.get();
            ItemStack itemStack = craftingRecipe.craft(crafterBlockEntity.getCraftingInventory(), world.getRegistryManager());
            this.transferOrSpawnStack(world, pos, crafterBlockEntity, itemStack, state);
            craftingRecipe.getRemainder(crafterBlockEntity.getCraftingInventory()).forEach((stack) -> {
                this.transferOrSpawnStack(world, pos, crafterBlockEntity, stack, state);
            });
            DefaultedList<ItemStack> stacks = crafterBlockEntity.getInvStackList();
            for (ItemStack invStack : stacks) {
                if (!invStack.isEmpty()) invStack.decrement(1);
            }
            crafterBlockEntity.markDirty();
        }
    }

    public static Optional<CraftingRecipe> getCraftingRecipe(World world, CraftingInventory inventory) {
        return recipeCache.getRecipe(world, inventory);
    }

    private void transferOrSpawnStack(World world, BlockPos pos, CrafterBlockEntity blockEntity, ItemStack stack, BlockState state) {
        Direction direction = state.get(ORIENTATION).getFacing();
        Inventory inventory = HopperBlockEntity.getInventoryAt(world, pos.offset(direction));
        ItemStack itemStack = stack.copy();
        if (inventory instanceof CrafterBlockEntity) {
            while(!itemStack.isEmpty()) {
                ItemStack itemStack2 = itemStack.copyWithCount(1);
                ItemStack itemStack3 = HopperBlockEntity.transfer(blockEntity, inventory, itemStack2, direction.getOpposite());
                if (!itemStack3.isEmpty()) {
                    break;
                }

                itemStack.decrement(1);
            }
        } else if (inventory != null) {
            while(!itemStack.isEmpty()) {
                int i = itemStack.getCount();
                itemStack = HopperBlockEntity.transfer(blockEntity, inventory, itemStack, direction.getOpposite());
                if (i == itemStack.getCount()) {
                    break;
                }
            }
        }

        if (!itemStack.isEmpty()) {
            Vec3d vec3d = Vec3d.ofCenter(pos).offset(direction, 0.7);
            ItemDispenserBehavior.spawnItem(world, itemStack, 6, direction, vec3d);
            world.syncWorldEvent(WorldEvents.DISPENSER_DISPENSES, pos, 0);
        }

    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ORIENTATION, rotation.getDirectionTransformation().mapJigsawOrientation(state.get(ORIENTATION)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ORIENTATION, mirror.getDirectionTransformation().mapJigsawOrientation(state.get(ORIENTATION)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CRAFTING, ORIENTATION, TRIGGERED);
    }

    static {
        CRAFTING = BooleanProperty.of("crafting");
        TRIGGERED = Properties.TRIGGERED;
        ORIENTATION = Properties.ORIENTATION;
        recipeCache = new RecipeCache(10);
    }
}
