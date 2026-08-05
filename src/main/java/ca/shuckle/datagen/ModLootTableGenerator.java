package ca.shuckle.datagen;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //region Backport Blocks
        //region Hanging Signs
        addDrop(ModBackportBlocks.OAK_HANGING_SIGN);
        addDrop(ModBackportBlocks.SPRUCE_HANGING_SIGN);
        addDrop(ModBackportBlocks.BIRCH_HANGING_SIGN);
        addDrop(ModBackportBlocks.JUNGLE_HANGING_SIGN);
        addDrop(ModBackportBlocks.ACACIA_HANGING_SIGN);
        addDrop(ModBackportBlocks.DARK_OAK_HANGING_SIGN);
        addDrop(ModBackportBlocks.MANGROVE_HANGING_SIGN);
        addDrop(ModBackportBlocks.CRIMSON_HANGING_SIGN);
        addDrop(ModBackportBlocks.WARPED_HANGING_SIGN);
        //endregion
        //region Shelves
        addDrop(ModBackportBlocks.OAK_SHELF);
        addDrop(ModBackportBlocks.SPRUCE_SHELF);
        addDrop(ModBackportBlocks.BIRCH_SHELF);
        addDrop(ModBackportBlocks.JUNGLE_SHELF);
        addDrop(ModBackportBlocks.ACACIA_SHELF);
        addDrop(ModBackportBlocks.DARK_OAK_SHELF);
        addDrop(ModBackportBlocks.MANGROVE_SHELF);
        addDrop(ModBackportBlocks.CRIMSON_SHELF);
        addDrop(ModBackportBlocks.WARPED_SHELF);
        //endregion
        addDyeableItemDrops("wool");
        addDyeableItemDrops("concrete");
        //region Cherry
        addDrop(ModBackportBlocks.CHERRY_SAPLING);
        addDrop(ModBackportBlocks.POTTED_CHERRY_SAPLING, pottedPlantDrops(ModBackportBlocks.CHERRY_SAPLING));

        addDrop(ModBackportBlocks.CHERRY_LOG);
        addDrop(ModBackportBlocks.CHERRY_WOOD);
        addDrop(ModBackportBlocks.STRIPPED_CHERRY_LOG);
        addDrop(ModBackportBlocks.STRIPPED_CHERRY_WOOD);

        addDrop(ModBackportBlocks.CHERRY_PLANKS);
        addDrop(ModBackportBlocks.CHERRY_SLAB, slabDrops(ModBackportBlocks.CHERRY_SLAB));
        addDrop(ModBackportBlocks.CHERRY_STAIRS);
        addDrop(ModBackportBlocks.CHERRY_DOOR, doorDrops(ModBackportBlocks.CHERRY_DOOR));
        addDrop(ModBackportBlocks.CHERRY_TRAPDOOR);
        addDrop(ModBackportBlocks.CHERRY_FENCE);
        addDrop(ModBackportBlocks.CHERRY_FENCE_GATE);
        addDrop(ModBackportBlocks.CHERRY_BUTTON);
        addDrop(ModBackportBlocks.CHERRY_PRESSURE_PLATE);
        addDrop(ModBackportBlocks.CHERRY_SHELF);
        addDrop(ModBackportBlocks.CHERRY_SIGN);
        addDrop(ModBackportBlocks.CHERRY_HANGING_SIGN);

        addDrop(ModBackportBlocks.PINK_PETALS, flowerbedDrops(ModBackportBlocks.PINK_PETALS));
        //endregion
        //region Bamboo
        addDrop(ModBackportBlocks.BAMBOO_BLOCK);
        addDrop(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK);

        addDrop(ModBackportBlocks.BAMBOO_PLANKS);
        addDrop(ModBackportBlocks.BAMBOO_SLAB, slabDrops(ModBackportBlocks.BAMBOO_SLAB));
        addDrop(ModBackportBlocks.BAMBOO_STAIRS);
        addDrop(ModBackportBlocks.BAMBOO_DOOR, doorDrops(ModBackportBlocks.BAMBOO_DOOR));
        addDrop(ModBackportBlocks.BAMBOO_TRAPDOOR);
        addDrop(ModBackportBlocks.BAMBOO_FENCE);
        addDrop(ModBackportBlocks.BAMBOO_FENCE_GATE);
        addDrop(ModBackportBlocks.BAMBOO_BUTTON);
        addDrop(ModBackportBlocks.BAMBOO_PRESSURE_PLATE);
        addDrop(ModBackportBlocks.BAMBOO_SHELF);
        addDrop(ModBackportBlocks.BAMBOO_SIGN);
        addDrop(ModBackportBlocks.BAMBOO_HANGING_SIGN);

        addDrop(ModBackportBlocks.BAMBOO_MOSAIC);
        addDrop(ModBackportBlocks.BAMBOO_MOSAIC_SLAB, slabDrops(ModBackportBlocks.BAMBOO_MOSAIC_SLAB));
        addDrop(ModBackportBlocks.BAMBOO_MOSAIC);
        //endregion
        //region Pale Garden
        addDrop(ModBackportBlocks.PALE_OAK_SAPLING);
        addDrop(ModBackportBlocks.POTTED_PALE_OAK_SAPLING, pottedPlantDrops(ModBackportBlocks.PALE_OAK_SAPLING));

        addDrop(ModBackportBlocks.PALE_OAK_LOG);
        addDrop(ModBackportBlocks.PALE_OAK_WOOD);
        addDrop(ModBackportBlocks.STRIPPED_PALE_OAK_LOG);
        addDrop(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD);

        addDrop(ModBackportBlocks.PALE_OAK_PLANKS);
        addDrop(ModBackportBlocks.PALE_OAK_SLAB, slabDrops(ModBackportBlocks.PALE_OAK_SLAB));
        addDrop(ModBackportBlocks.PALE_OAK_STAIRS);
        addDrop(ModBackportBlocks.PALE_OAK_DOOR, doorDrops(ModBackportBlocks.PALE_OAK_DOOR));
        addDrop(ModBackportBlocks.PALE_OAK_TRAPDOOR);
        addDrop(ModBackportBlocks.PALE_OAK_FENCE);
        addDrop(ModBackportBlocks.PALE_OAK_FENCE_GATE);
        addDrop(ModBackportBlocks.PALE_OAK_BUTTON);
        addDrop(ModBackportBlocks.PALE_OAK_PRESSURE_PLATE);
        addDrop(ModBackportBlocks.PALE_OAK_SHELF);
        addDrop(ModBackportBlocks.PALE_OAK_SIGN);
        addDrop(ModBackportBlocks.PALE_OAK_HANGING_SIGN);

        addDrop(ModBackportBlocks.PALE_MOSS_BLOCK);
        addDrop(ModBackportBlocks.PALE_MOSS_CARPET);
        addDrop(ModBackportBlocks.PALE_HANGING_MOSS, dropsWithShears(ModBackportBlocks.PALE_HANGING_MOSS));

        addDrop(ModBackportBlocks.CREAKING_HEART);
        addDrop(ModBackportBlocks.ACTIVE_CREAKING_HEART);

        addDrop(ModBackportBlocks.RESIN_BLOCK);
        addDrop(ModBackportBlocks.RESIN_BRICKS);
        addDrop(ModBackportBlocks.RESIN_BRICK_SLAB, slabDrops(ModBackportBlocks.RESIN_BRICK_SLAB));
        addDrop(ModBackportBlocks.RESIN_BRICK_STAIRS);
        addDrop(ModBackportBlocks.RESIN_BRICK_WALL);
        addDrop(ModBackportBlocks.CHISELED_RESIN_BRICKS);
        //endregion
        //region Poplar
        addDrop(ModBackportBlocks.POPLAR_SAPLING);
        addDrop(ModBackportBlocks.POTTED_POPLAR_SAPLING, pottedPlantDrops(ModBackportBlocks.POPLAR_SAPLING));

        addDrop(ModBackportBlocks.POPLAR_LOG);
        addDrop(ModBackportBlocks.POPLAR_WOOD);
        addDrop(ModBackportBlocks.STRIPPED_POPLAR_LOG);
        addDrop(ModBackportBlocks.STRIPPED_POPLAR_WOOD);

        addDrop(ModBackportBlocks.POPLAR_PLANKS);
        addDrop(ModBackportBlocks.POPLAR_SLAB, slabDrops(ModBackportBlocks.POPLAR_SLAB));
        addDrop(ModBackportBlocks.POPLAR_STAIRS);
        addDrop(ModBackportBlocks.POPLAR_DOOR, doorDrops(ModBackportBlocks.POPLAR_DOOR));
        addDrop(ModBackportBlocks.POPLAR_TRAPDOOR);
        addDrop(ModBackportBlocks.POPLAR_FENCE);
        addDrop(ModBackportBlocks.POPLAR_FENCE_GATE);
        addDrop(ModBackportBlocks.POPLAR_BUTTON);
        addDrop(ModBackportBlocks.POPLAR_PRESSURE_PLATE);
        addDrop(ModBackportBlocks.POPLAR_SHELF);
        addDrop(ModBackportBlocks.POPLAR_SIGN);
        addDrop(ModBackportBlocks.POPLAR_HANGING_SIGN);
        //endregion
        //region Copper
        addDrop(ModBackportBlocks.CHISELED_COPPER);
        addDrop(ModBackportBlocks.EXPOSED_CHISELED_COPPER);
        addDrop(ModBackportBlocks.WEATHERED_CHISELED_COPPER);
        addDrop(ModBackportBlocks.OXIDIZED_CHISELED_COPPER);
        addDrop(ModBackportBlocks.WAXED_CHISELED_COPPER);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER);

        addDrop(ModBackportBlocks.COPPER_GRATE);
        addDrop(ModBackportBlocks.EXPOSED_COPPER_GRATE);
        addDrop(ModBackportBlocks.WEATHERED_COPPER_GRATE);
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_GRATE);
        addDrop(ModBackportBlocks.WAXED_COPPER_GRATE);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_GRATE);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_GRATE);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE);

        addDrop(ModBackportBlocks.COPPER_BULB);
        addDrop(ModBackportBlocks.EXPOSED_COPPER_BULB);
        addDrop(ModBackportBlocks.WEATHERED_COPPER_BULB);
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_BULB);
        addDrop(ModBackportBlocks.WAXED_COPPER_BULB);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_BULB);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_BULB);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_BULB);

        addDrop(ModBackportBlocks.COPPER_DOOR, doorDrops(ModBackportBlocks.COPPER_DOOR));
        addDrop(ModBackportBlocks.EXPOSED_COPPER_DOOR, doorDrops(ModBackportBlocks.EXPOSED_COPPER_DOOR));
        addDrop(ModBackportBlocks.WEATHERED_COPPER_DOOR, doorDrops(ModBackportBlocks.WEATHERED_COPPER_DOOR));
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_DOOR, doorDrops(ModBackportBlocks.OXIDIZED_COPPER_DOOR));
        addDrop(ModBackportBlocks.WAXED_COPPER_DOOR, doorDrops(ModBackportBlocks.WAXED_COPPER_DOOR));
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_DOOR, doorDrops(ModBackportBlocks.WAXED_EXPOSED_COPPER_DOOR));
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_DOOR, doorDrops(ModBackportBlocks.WAXED_WEATHERED_COPPER_DOOR));
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR, doorDrops(ModBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR));

        addDrop(ModBackportBlocks.COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.EXPOSED_COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.WEATHERED_COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.WAXED_COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

        addDrop(ModBackportBlocks.COPPER_BARS);
        addDrop(ModBackportBlocks.EXPOSED_COPPER_BARS);
        addDrop(ModBackportBlocks.WEATHERED_COPPER_BARS);
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_BARS);
        addDrop(ModBackportBlocks.WAXED_COPPER_BARS);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_BARS);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_BARS);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_BARS);

        addDrop(ModBackportBlocks.COPPER_CHAIN);
        addDrop(ModBackportBlocks.EXPOSED_COPPER_CHAIN);
        addDrop(ModBackportBlocks.WEATHERED_COPPER_CHAIN);
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_CHAIN);
        addDrop(ModBackportBlocks.WAXED_COPPER_CHAIN);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_CHAIN);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_CHAIN);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_CHAIN);

        addDrop(ModBackportBlocks.LIGHTNING_ROD);
        addDrop(ModBackportBlocks.EXPOSED_LIGHTNING_ROD);
        addDrop(ModBackportBlocks.WEATHERED_LIGHTNING_ROD);
        addDrop(ModBackportBlocks.OXIDIZED_LIGHTNING_ROD);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_LIGHTNING_ROD);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_LIGHTNING_ROD);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_LIGHTNING_ROD);

        addDrop(ModBackportBlocks.COPPER_TORCH);

        addDrop(ModBackportBlocks.COPPER_LANTERN);
        addDrop(ModBackportBlocks.EXPOSED_COPPER_LANTERN);
        addDrop(ModBackportBlocks.WEATHERED_COPPER_LANTERN);
        addDrop(ModBackportBlocks.OXIDIZED_COPPER_LANTERN);
        addDrop(ModBackportBlocks.WAXED_COPPER_LANTERN);
        addDrop(ModBackportBlocks.WAXED_EXPOSED_COPPER_LANTERN);
        addDrop(ModBackportBlocks.WAXED_WEATHERED_COPPER_LANTERN);
        addDrop(ModBackportBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
        //endregion
        //region Tuff
        addDrop(ModBackportBlocks.TUFF_SLAB, slabDrops(ModBackportBlocks.TUFF_SLAB));
        addDrop(ModBackportBlocks.TUFF_STAIRS);
        addDrop(ModBackportBlocks.TUFF_WALL);

        addDrop(ModBackportBlocks.POLISHED_TUFF);
        addDrop(ModBackportBlocks.POLISHED_TUFF_SLAB, slabDrops(ModBackportBlocks.POLISHED_TUFF_SLAB));
        addDrop(ModBackportBlocks.POLISHED_TUFF_STAIRS);
        addDrop(ModBackportBlocks.POLISHED_TUFF_WALL);

        addDrop(ModBackportBlocks.TUFF_BRICKS);
        addDrop(ModBackportBlocks.TUFF_BRICK_SLAB, slabDrops(ModBackportBlocks.TUFF_BRICK_SLAB));
        addDrop(ModBackportBlocks.TUFF_BRICK_STAIRS);
        addDrop(ModBackportBlocks.TUFF_BRICK_WALL);

        addDrop(ModBackportBlocks.CHISELED_TUFF);
        addDrop(ModBackportBlocks.CHISELED_TUFF_BRICKS);
        //endregion
        //region Cinnabar
        addDrop(ModBackportBlocks.CINNABAR);
        addDrop(ModBackportBlocks.CINNABAR_SLAB, slabDrops(ModBackportBlocks.CINNABAR_SLAB));
        addDrop(ModBackportBlocks.CINNABAR_STAIRS);
        addDrop(ModBackportBlocks.CINNABAR_WALL);

        addDrop(ModBackportBlocks.POLISHED_CINNABAR);
        addDrop(ModBackportBlocks.POLISHED_CINNABAR_SLAB, slabDrops(ModBackportBlocks.POLISHED_CINNABAR_SLAB));
        addDrop(ModBackportBlocks.POLISHED_CINNABAR_STAIRS);
        addDrop(ModBackportBlocks.POLISHED_CINNABAR_WALL);

        addDrop(ModBackportBlocks.CINNABAR_BRICKS);
        addDrop(ModBackportBlocks.CINNABAR_BRICK_SLAB, slabDrops(ModBackportBlocks.CINNABAR_BRICK_SLAB));
        addDrop(ModBackportBlocks.CINNABAR_BRICK_STAIRS);
        addDrop(ModBackportBlocks.CINNABAR_BRICK_WALL);

        addDrop(ModBackportBlocks.CHISELED_CINNABAR);
        addDrop(ModBackportBlocks.POTENT_CINNABAR);
        //endregion
        //region Sulfur
        addDrop(ModBackportBlocks.SULFUR);
        addDrop(ModBackportBlocks.SULFUR_SLAB, slabDrops(ModBackportBlocks.SULFUR_SLAB));
        addDrop(ModBackportBlocks.SULFUR_STAIRS);
        addDrop(ModBackportBlocks.SULFUR_WALL);

        addDrop(ModBackportBlocks.POLISHED_SULFUR);
        addDrop(ModBackportBlocks.POLISHED_SULFUR_SLAB, slabDrops(ModBackportBlocks.POLISHED_SULFUR_SLAB));
        addDrop(ModBackportBlocks.POLISHED_SULFUR_STAIRS);
        addDrop(ModBackportBlocks.POLISHED_SULFUR_WALL);

        addDrop(ModBackportBlocks.SULFUR_BRICKS);
        addDrop(ModBackportBlocks.SULFUR_BRICK_SLAB, slabDrops(ModBackportBlocks.SULFUR_BRICK_SLAB));
        addDrop(ModBackportBlocks.SULFUR_BRICK_STAIRS);
        addDrop(ModBackportBlocks.SULFUR_BRICK_WALL);

        addDrop(ModBackportBlocks.CHISELED_SULFUR);
        addDrop(ModBackportBlocks.POTENT_SULFUR);
        addDrop(ModBackportBlocks.SULFUR_SPIKE);
        //endregion
        addDrop(ModBackportBlocks.WILDFLOWERS, flowerbedDrops(ModBackportBlocks.WILDFLOWERS));
        addDrop(ModBackportBlocks.LEAF_LITTER, flowerbedDrops(ModBackportBlocks.LEAF_LITTER));

        addDrop(ModBackportBlocks.BUSH, dropsWithShears(ModBackportBlocks.BUSH));
        addDrop(ModBackportBlocks.RED_SHRUB, dropsWithShears(ModBackportBlocks.RED_SHRUB));
        addDrop(ModBackportBlocks.FIREFLY_BUSH, dropsWithShears(ModBackportBlocks.FIREFLY_BUSH));
        addDrop(ModBackportBlocks.LIT_FIREFLY_BUSH, dropsWithShears(ModBackportBlocks.LIT_FIREFLY_BUSH));

        addDrop(ModBackportBlocks.SHORT_DRY_GRASS, dropsWithShears(ModBackportBlocks.SHORT_DRY_GRASS));
        addDrop(ModBackportBlocks.TALL_DRY_GRASS, dropsWithShears(ModBackportBlocks.SHORT_DRY_GRASS));

        addDrop(ModBackportBlocks.CRAFTER);
        //endregion
        //region Shuckle Blocks
        addDrop(ModBlocks.SHUCKLE_ORE, oreDrops(ModBlocks.SHUCKLE_ORE, ModItems.DULL_SHUCKLE_GEM));
        addDrop(ModBackportBlocks.REINFORCED_DEEPSLATE);

        addDropWithSilkTouch(ModBlocks.TINTED_GLASS_PANE);

        addDrop(ModBackportBlocks.PACKED_MUD_SLAB, slabDrops(ModBackportBlocks.PACKED_MUD_SLAB));
        addDrop(ModBackportBlocks.PACKED_MUD_STAIRS);
        addDrop(ModBackportBlocks.PACKED_MUD_WALL);

        addDrop(ModBlocks.INVIS_CARPET);
        addDrop(ModBlocks.INVIS_SIGN);
        addDrop(ModBlocks.INVIS_LIGHTNING_ROD);

        addDrop(ModBlocks.SHUCKLE_BLOCK);
        addDrop(ModBlocks.SHINY_SHUCKLE_BLOCK);

        addDrop(ModBlocks.ZYGARDE_CELL, flowerbedDrops(ModBlocks.ZYGARDE_CELL));
        addDrop(ModBlocks.WILDFLOWERS_RED_BLUE, flowerbedDrops(ModBlocks.WILDFLOWERS_RED_BLUE));
        addDrop(ModBlocks.LEAF_LITTER_OAK, flowerbedDrops(ModBlocks.LEAF_LITTER_OAK));
        //endregion
        //region Other Mod Blocks
        //region BYG
        addDropWithSilkTouch(ModBlocks.THERIUM_GLASS);
        addDropWithSilkTouch(ModBlocks.THERIUM_GLASS_PANE);
        //region Sand
        addDrop(ModBlocks.BLACK_SANDSTONE_SLAB, slabDrops(ModBlocks.BLACK_SANDSTONE_SLAB));
        addDrop(ModBlocks.BLACK_SANDSTONE_STAIRS);
        addDrop(ModBlocks.BLACK_SANDSTONE_WALL);
        addDrop(ModBlocks.BLACK_CUT_SANDSTONE_SLAB, slabDrops(ModBlocks.BLACK_CUT_SANDSTONE_SLAB));
        addDrop(ModBlocks.BLACK_CUT_SANDSTONE_STAIRS);
        addDrop(ModBlocks.BLACK_CUT_SANDSTONE_WALL);
        addDrop(ModBlocks.BLACK_SMOOTH_SANDSTONE_SLAB, slabDrops(ModBlocks.BLACK_SMOOTH_SANDSTONE_SLAB));
        addDrop(ModBlocks.BLACK_SMOOTH_SANDSTONE_STAIRS);
        addDrop(ModBlocks.BLACK_SMOOTH_SANDSTONE_WALL);
        //endregion
        //endregion
        //region Fossils
        addDrop(ModBlocks.ANCIENT_STONE_SLAB, slabDrops(ModBlocks.ANCIENT_STONE_SLAB));
        addDrop(ModBlocks.ANCIENT_STONE_STAIRS);
        addDrop(ModBlocks.ANCIENT_STONE_WALL);
        //endregion
        //endregion
    }

    private void addDyeableItemDrops(String baseItemName) {
        List<DyeColor> dyeColours = List.of(DyeColor.values());

        for(DyeColor dyeColour : dyeColours) {
            addDrop(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, dyeColour.getName() + "_" + baseItemName + "_slab")),
                    slabDrops(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, dyeColour.getName() + "_" + baseItemName + "_slab"))));
            addDrop(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, dyeColour.getName() + "_" + baseItemName + "_stairs")));
        }
    }
}
