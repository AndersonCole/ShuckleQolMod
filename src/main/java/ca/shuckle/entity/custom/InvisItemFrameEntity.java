package ca.shuckle.entity.custom;

import ca.shuckle.entity.ModEntities;
import ca.shuckle.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class InvisItemFrameEntity extends ItemFrameEntity {
    private boolean fixed;
    private float itemDropChance;

    public InvisItemFrameEntity(EntityType<? extends ItemFrameEntity> entityType, World world) {
        super(entityType, world);
    }

    public InvisItemFrameEntity(World world, BlockPos blockPos, Direction direction) {
        super(ModEntities.INVIS_ITEM_FRAME, world, blockPos, direction);
    }

    @Override
    protected ItemStack getAsItemStack() {
        return new ItemStack(ModItems.INVIS_ITEM_FRAME);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (!this.getHeldItemStack().isEmpty()) {
            nbt.put("Item", this.getHeldItemStack().writeNbt(new NbtCompound()));
            nbt.putByte("ItemRotation", (byte)this.getRotation());
            nbt.putFloat("ItemDropChance", this.itemDropChance);
        }

        nbt.putByte("Facing", (byte)this.facing.getId());
        nbt.putBoolean("Invisible", true);
        nbt.putBoolean("Fixed", this.fixed);
    }
}
