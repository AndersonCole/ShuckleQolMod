package ca.shuckle.datagen;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //region Backport Blocks
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
        addDrop(ModBackportBlocks.CHERRY_SIGN);

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
        addDrop(ModBackportBlocks.BAMBOO_SIGN);

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
        addDrop(ModBackportBlocks.PALE_OAK_SIGN);

        addDrop(ModBackportBlocks.PALE_MOSS_BLOCK);
        addDrop(ModBackportBlocks.PALE_MOSS_CARPET);

        addDrop(ModBackportBlocks.CREAKING_HEART);
        addDrop(ModBackportBlocks.ACTIVE_CREAKING_HEART);

        addDrop(ModBackportBlocks.RESIN_BLOCK);
        addDrop(ModBackportBlocks.RESIN_BRICKS);
        addDrop(ModBackportBlocks.RESIN_BRICK_SLAB, slabDrops(ModBackportBlocks.RESIN_BRICK_SLAB));
        addDrop(ModBackportBlocks.RESIN_BRICK_STAIRS);
        addDrop(ModBackportBlocks.RESIN_BRICK_WALL);
        addDrop(ModBackportBlocks.CHISELED_RESIN_BRICKS);
        //endregion
        addDrop(ModBackportBlocks.WILDFLOWERS, flowerbedDrops(ModBackportBlocks.WILDFLOWERS));
        addDrop(ModBackportBlocks.LEAF_LITTER, flowerbedDrops(ModBackportBlocks.LEAF_LITTER));
        //endregion
        //region Shuckle Blocks
        addDrop(ModBackportBlocks.REINFORCED_DEEPSLATE);

        addDrop(ModBackportBlocks.PACKED_MUD_SLAB, slabDrops(ModBackportBlocks.PACKED_MUD_SLAB));
        addDrop(ModBackportBlocks.PACKED_MUD_STAIRS);
        addDrop(ModBackportBlocks.PACKED_MUD_WALL);

        addDrop(ModBlocks.CONDENSED_BLACK_ICE);

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
        addDrop(ModBlocks.EBONY_SIGN);
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
}
