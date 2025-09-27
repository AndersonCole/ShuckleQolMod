package ca.shuckle.enchantment;

import ca.shuckle.ShuckleQOL;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    private static Enchantment register(String name, Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT, new Identifier(ShuckleQOL.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments(){

    }
}
