package ca.shuckle.item;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SHUCKLE = FabricItemGroupBuilder.build(new Identifier(ShuckleQOL.MOD_ID, "shuckle"),
        () -> new ItemStack(ModBlocks.SHUCKLE_BLOCK));

    public static final ItemGroup SHUCKLE_BACKPORT = FabricItemGroupBuilder.build(new Identifier(ShuckleQOL.MOD_ID, "shuckle_backport"),
            () -> new ItemStack(ModBackportBlocks.ACTIVE_CREAKING_HEART));
}
