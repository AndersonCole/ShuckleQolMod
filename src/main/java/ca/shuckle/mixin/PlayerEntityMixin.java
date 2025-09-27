package ca.shuckle.mixin;

import ca.shuckle.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    public PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    protected abstract void increaseTravelMotionStats(double dx, double dy, double dz);

    @Shadow
    public PlayerAbilities abilities;

    @Inject(method = "travel", at=@At("HEAD"), cancellable = true)
    private void applySwiftSneakSpeed(Vec3d movementInput, CallbackInfo info){
        if(!this.isSneaking() || this.isFallFlying() || this.isSwimming() || this.abilities.flying || this.hasVehicle()){
            return;
        }

        int level = EnchantmentHelper.getLevel(ModEnchantments.SWIFT_SNEAK, this.getEquippedStack(EquipmentSlot.LEGS));
        if (level > 0) {
            float boost = 1 + (level * 0.5f);
            float finalSneakSpeed = MathHelper.clamp(boost, 1.0f, 3.33f);

            Vec3d boostedInput = new Vec3d(
                    movementInput.x * finalSneakSpeed,
                    movementInput.y,
                    movementInput.z * finalSneakSpeed
            );

            double d = this.getX();
            double e = this.getY();
            double f = this.getZ();

            super.travel(boostedInput);

            this.increaseTravelMotionStats(this.getX() - d, this.getY() - e, this.getZ() - f);

            info.cancel();
        }
    }
}
