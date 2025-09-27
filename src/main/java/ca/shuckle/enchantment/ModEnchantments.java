package ca.shuckle.enchantment;

import ca.shuckle.ShuckleQOL;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment SWIFT_SNEAK = register("swift_sneak",
            new SwiftSneakEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.LEGS));

    private static Enchantment register(String name, Enchantment enchantment){
        return Registry.register(Registry.ENCHANTMENT, new Identifier(ShuckleQOL.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments(){

    }
}
