package ca.shuckle.item;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup SHUCKLE;

    public static ItemGroup SHUCKLE_BACKPORT;

    public static void registerItemGroup() {
        SHUCKLE = FabricItemGroup.builder(new Identifier(ShuckleQOL.MOD_ID, "shuckle"))
                .displayName(Text.literal("Shuckle's Items"))
                .icon(() -> new ItemStack(ModBlocks.SHUCKLE_BLOCK)).build();

        SHUCKLE_BACKPORT = FabricItemGroup.builder(new Identifier(ShuckleQOL.MOD_ID, "shuckle_backport"))
                .displayName(Text.literal("Shuckle's Backport Items"))
                .icon(() -> new ItemStack(ModBackportBlocks.ACTIVE_CREAKING_HEART)).build();
    }
}
