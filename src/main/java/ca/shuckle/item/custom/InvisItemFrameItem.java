package ca.shuckle.item.custom;

import ca.shuckle.entity.ModEntities;
import ca.shuckle.entity.custom.InvisGlowItemFrameEntity;
import ca.shuckle.entity.custom.InvisItemFrameEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class InvisItemFrameItem extends Item {

    private final EntityType<? extends AbstractDecorationEntity> entityType;

    public InvisItemFrameItem(EntityType<? extends AbstractDecorationEntity> type, Settings settings) {
        super(settings);
        this.entityType = type;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        AbstractDecorationEntity abstractDecorationEntity;
        BlockPos blockPos = context.getBlockPos();
        Direction direction = context.getSide();
        BlockPos blockPos2 = blockPos.offset(direction);
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();
        if (playerEntity != null && !this.canPlaceOn(playerEntity, direction, itemStack, blockPos2)) {
            return ActionResult.FAIL;
        }
        World world = context.getWorld();
        if (this.entityType == ModEntities.INVIS_ITEM_FRAME) {
            abstractDecorationEntity = new InvisItemFrameEntity(world, blockPos2, direction);
        } else if (this.entityType == ModEntities.INVIS_GLOW_ITEM_FRAME) {
            abstractDecorationEntity = new InvisGlowItemFrameEntity(world, blockPos2, direction);
        } else {
            return ActionResult.success(world.isClient);
        }
        NbtCompound nbtCompound = itemStack.getNbt();
        if (nbtCompound != null) {
            EntityType.loadFromEntityNbt(world, playerEntity, abstractDecorationEntity, nbtCompound);
        }
        if (abstractDecorationEntity.canStayAttached()) {
            if (!world.isClient) {
                abstractDecorationEntity.onPlace();
                world.emitGameEvent((Entity)playerEntity, GameEvent.ENTITY_PLACE, blockPos);
                world.spawnEntity(abstractDecorationEntity);
            }
            itemStack.decrement(1);
            return ActionResult.success(world.isClient);
        }
        return ActionResult.CONSUME;
    }

    protected boolean canPlaceOn(PlayerEntity player, Direction side, ItemStack stack, BlockPos pos) {
        return !player.world.isOutOfHeightLimit(pos) && player.canPlaceOn(pos, side, stack);
    }
}
