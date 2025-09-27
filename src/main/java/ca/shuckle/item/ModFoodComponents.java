package ca.shuckle.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent MANGROVE_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 100, 0), 0.8f).build();
    public static final FoodComponent CHERRY_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100, 0), 0.8f).build();
    public static final FoodComponent BAMBOO_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 0), 0.8f).build();
    public static final FoodComponent PALE_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), 0.8f).build();
    public static final FoodComponent BERRY_JUICE = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 200, 0), 0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 0), 0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200, 0), 0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0), 0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1200, 99), 0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 0), 0.5f).build();
}
