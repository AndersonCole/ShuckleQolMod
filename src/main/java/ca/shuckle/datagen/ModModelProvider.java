package ca.shuckle.datagen;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.block.custom.ConnectedGlassPaneBlock;
import ca.shuckle.block.custom.copper.BulbBlock;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModOxidizationHelpers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.enums.Thickness;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Consumer;

public class ModModelProvider extends FabricModelProvider {
    //https://wiki.fabricmc.net/tutorial:datagen_model if i ever need to do more custom stuff
    public ModModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //region Backport Blocks
        //region Shelves
        registerShelfBlock("minecraft", "oak", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "spruce", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "birch", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "jungle", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "acacia", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "dark_oak", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "mangrove", "_log", blockStateModelGenerator);
        registerShelfBlock("minecraft", "crimson", "_stem", blockStateModelGenerator);
        registerShelfBlock("minecraft", "warped", "_stem", blockStateModelGenerator);
        //endregion
        //region Cherry blocks
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.CHERRY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.CHERRY_LEAVES);

        blockStateModelGenerator.registerLog(ModBackportBlocks.CHERRY_LOG).log(ModBackportBlocks.CHERRY_LOG).wood(ModBackportBlocks.CHERRY_WOOD);
        blockStateModelGenerator.registerLog(ModBackportBlocks.STRIPPED_CHERRY_LOG).log(ModBackportBlocks.STRIPPED_CHERRY_LOG).wood(ModBackportBlocks.STRIPPED_CHERRY_WOOD);

        BlockStateModelGenerator.BlockTexturePool cherryPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.CHERRY_PLANKS);
        cherryPool.slab(ModBackportBlocks.CHERRY_SLAB);
        cherryPool.stairs(ModBackportBlocks.CHERRY_STAIRS);
        blockStateModelGenerator.registerDoor(ModBackportBlocks.CHERRY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBackportBlocks.CHERRY_TRAPDOOR);
        cherryPool.fence(ModBackportBlocks.CHERRY_FENCE);
        cherryPool.fenceGate(ModBackportBlocks.CHERRY_FENCE_GATE);
        cherryPool.button(ModBackportBlocks.CHERRY_BUTTON);
        cherryPool.pressurePlate(ModBackportBlocks.CHERRY_PRESSURE_PLATE);
        cherryPool.family(BlockFamilies.register(ModBackportBlocks.CHERRY_PLANKS)
                .sign(ModBackportBlocks.CHERRY_SIGN, ModBackportBlocks.CHERRY_WALL_SIGN)
                .group("wooden").unlockCriterionName("has_planks").build());
        registerShelfBlock(ShuckleQOL.MOD_ID, "cherry", "_log", blockStateModelGenerator);
        //endregion
        //region Bamboo
        blockStateModelGenerator.registerLog(ModBackportBlocks.BAMBOO_BLOCK).log(ModBackportBlocks.BAMBOO_BLOCK);
        blockStateModelGenerator.registerLog(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK).log(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK);

        BlockStateModelGenerator.BlockTexturePool bambooPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.BAMBOO_PLANKS);
        bambooPool.slab(ModBackportBlocks.BAMBOO_SLAB);
        bambooPool.stairs(ModBackportBlocks.BAMBOO_STAIRS);
        blockStateModelGenerator.registerDoor(ModBackportBlocks.BAMBOO_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBackportBlocks.BAMBOO_TRAPDOOR);
        bambooPool.fence(ModBackportBlocks.BAMBOO_FENCE);
        bambooPool.fenceGate(ModBackportBlocks.BAMBOO_FENCE_GATE);
        bambooPool.button(ModBackportBlocks.BAMBOO_BUTTON);
        bambooPool.pressurePlate(ModBackportBlocks.BAMBOO_PRESSURE_PLATE);
        bambooPool.family(BlockFamilies.register(ModBackportBlocks.BAMBOO_PLANKS)
                .sign(ModBackportBlocks.BAMBOO_SIGN, ModBackportBlocks.BAMBOO_WALL_SIGN)
                .group("wooden").unlockCriterionName("has_planks").build());
        registerShelfBlock(ShuckleQOL.MOD_ID, "bamboo", "_block", blockStateModelGenerator);

        BlockStateModelGenerator.BlockTexturePool bambooMosaicPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.BAMBOO_MOSAIC);
        bambooMosaicPool.slab(ModBackportBlocks.BAMBOO_MOSAIC_SLAB);
        bambooMosaicPool.stairs(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS);
        //endregion
        //region Pale Garden
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.PALE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.PALE_OAK_LEAVES);

        blockStateModelGenerator.registerLog(ModBackportBlocks.PALE_OAK_LOG).log(ModBackportBlocks.PALE_OAK_LOG).wood(ModBackportBlocks.PALE_OAK_WOOD);
        blockStateModelGenerator.registerLog(ModBackportBlocks.STRIPPED_PALE_OAK_LOG).log(ModBackportBlocks.STRIPPED_PALE_OAK_LOG).wood(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD);

        BlockStateModelGenerator.BlockTexturePool paleOakPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.PALE_OAK_PLANKS);
        paleOakPool.slab(ModBackportBlocks.PALE_OAK_SLAB);
        paleOakPool.stairs(ModBackportBlocks.PALE_OAK_STAIRS);
        blockStateModelGenerator.registerDoor(ModBackportBlocks.PALE_OAK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBackportBlocks.PALE_OAK_TRAPDOOR);
        paleOakPool.fence(ModBackportBlocks.PALE_OAK_FENCE);
        paleOakPool.fenceGate(ModBackportBlocks.PALE_OAK_FENCE_GATE);
        paleOakPool.button(ModBackportBlocks.PALE_OAK_BUTTON);
        paleOakPool.pressurePlate(ModBackportBlocks.PALE_OAK_PRESSURE_PLATE);
        paleOakPool.family(BlockFamilies.register(ModBackportBlocks.PALE_OAK_PLANKS)
                .sign(ModBackportBlocks.PALE_OAK_SIGN, ModBackportBlocks.PALE_OAK_WALL_SIGN)
                .group("wooden").unlockCriterionName("has_planks").build());
        registerShelfBlock(ShuckleQOL.MOD_ID, "pale_oak", "_log", blockStateModelGenerator);

        blockStateModelGenerator.registerWoolAndCarpet(ModBackportBlocks.PALE_MOSS_BLOCK, ModBackportBlocks.PALE_MOSS_CARPET);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.PALE_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBackportBlocks.PALE_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.PALE_HANGING_MOSS, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBackportBlocks.CREAKING_HEART).log(ModBackportBlocks.CREAKING_HEART);
        blockStateModelGenerator.registerLog(ModBackportBlocks.ACTIVE_CREAKING_HEART).log(ModBackportBlocks.ACTIVE_CREAKING_HEART);

        blockStateModelGenerator.registerItemModel(ModBackportBlocks.RESIN_CLUMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.RESIN_BLOCK);
        BlockStateModelGenerator.BlockTexturePool resinBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.RESIN_BRICKS);
        resinBrickPool.slab(ModBackportBlocks.RESIN_BRICK_SLAB);
        resinBrickPool.stairs(ModBackportBlocks.RESIN_BRICK_STAIRS);
        resinBrickPool.wall(ModBackportBlocks.RESIN_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.CHISELED_RESIN_BRICKS);
        //endregion
        //region Copper
        createOxidizableModelSet("chiseled_copper",
                blockStateModelGenerator::registerSimpleCubeAll,
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("copper_grate",
                blockStateModelGenerator::registerSimpleCubeAll,
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("copper_bulb",
                registerBulbBlock(blockStateModelGenerator),
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("copper_door",
                blockStateModelGenerator::registerDoor,
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("copper_trapdoor",
                blockStateModelGenerator::registerTrapdoor,
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("copper_bars",
                registerBarsBlock(blockStateModelGenerator),
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("copper_chain",
                registerChainBlock(blockStateModelGenerator),
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        createOxidizableModelSet("lightning_rod",
                registerLightningRodBlock(blockStateModelGenerator),
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        blockStateModelGenerator.registerTorch(ModBackportBlocks.COPPER_TORCH, ModBackportBlocks.COPPER_WALL_TORCH);
        createOxidizableModelSet("copper_lantern",
                blockStateModelGenerator::registerLantern,
                ModOxidizationHelpers.getCopperOxidizationStages(), blockStateModelGenerator);
        //endregion
        //region Tuff
        registerExternalSlabTexture(blockStateModelGenerator,
                "minecraft", "tuff", null, null, null, ModBackportBlocks.TUFF_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "minecraft", "tuff", null, null, ModBackportBlocks.TUFF_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "minecraft", "tuff", ModBackportBlocks.TUFF_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedTuffPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.POLISHED_TUFF);
        polishedTuffPool.slab(ModBackportBlocks.POLISHED_TUFF_SLAB);
        polishedTuffPool.stairs(ModBackportBlocks.POLISHED_TUFF_STAIRS);
        polishedTuffPool.wall(ModBackportBlocks.POLISHED_TUFF_WALL);

        BlockStateModelGenerator.BlockTexturePool tuffBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.TUFF_BRICKS);
        tuffBricksPool.slab(ModBackportBlocks.TUFF_BRICK_SLAB);
        tuffBricksPool.stairs(ModBackportBlocks.TUFF_BRICK_STAIRS);
        tuffBricksPool.wall(ModBackportBlocks.TUFF_BRICK_WALL);

        registerChiseled(blockStateModelGenerator, ModBackportBlocks.CHISELED_TUFF);
        registerChiseled(blockStateModelGenerator, ModBackportBlocks.CHISELED_TUFF_BRICKS);
        //endregion
        //region Cinnabar
        BlockStateModelGenerator.BlockTexturePool cinnabarPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.CINNABAR);
        cinnabarPool.slab(ModBackportBlocks.CINNABAR_SLAB);
        cinnabarPool.stairs(ModBackportBlocks.CINNABAR_STAIRS);
        cinnabarPool.wall(ModBackportBlocks.CINNABAR_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedCinnabarPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.POLISHED_CINNABAR);
        polishedCinnabarPool.slab(ModBackportBlocks.POLISHED_CINNABAR_SLAB);
        polishedCinnabarPool.stairs(ModBackportBlocks.POLISHED_CINNABAR_STAIRS);
        polishedCinnabarPool.wall(ModBackportBlocks.POLISHED_CINNABAR_WALL);

        BlockStateModelGenerator.BlockTexturePool cinnabarBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.CINNABAR_BRICKS);
        cinnabarBricksPool.slab(ModBackportBlocks.CINNABAR_BRICK_SLAB);
        cinnabarBricksPool.stairs(ModBackportBlocks.CINNABAR_BRICK_STAIRS);
        cinnabarBricksPool.wall(ModBackportBlocks.CINNABAR_BRICK_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.CHISELED_CINNABAR);
        //endregion
        //region Sulfur
        BlockStateModelGenerator.BlockTexturePool sulfurPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.SULFUR);
        sulfurPool.slab(ModBackportBlocks.SULFUR_SLAB);
        sulfurPool.stairs(ModBackportBlocks.SULFUR_STAIRS);
        sulfurPool.wall(ModBackportBlocks.SULFUR_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedSulfurPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.POLISHED_SULFUR);
        polishedSulfurPool.slab(ModBackportBlocks.POLISHED_SULFUR_SLAB);
        polishedSulfurPool.stairs(ModBackportBlocks.POLISHED_SULFUR_STAIRS);
        polishedSulfurPool.wall(ModBackportBlocks.POLISHED_SULFUR_WALL);

        BlockStateModelGenerator.BlockTexturePool sulfurBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.SULFUR_BRICKS);
        sulfurBricksPool.slab(ModBackportBlocks.SULFUR_BRICK_SLAB);
        sulfurBricksPool.stairs(ModBackportBlocks.SULFUR_BRICK_STAIRS);
        sulfurBricksPool.wall(ModBackportBlocks.SULFUR_BRICK_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.CHISELED_SULFUR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.POTENT_SULFUR);
        registerPointedSpikeBlock("sulfur_spike", blockStateModelGenerator);
        //endregion
        blockStateModelGenerator.registerFlowerbed(ModBackportBlocks.PINK_PETALS);
        blockStateModelGenerator.registerFlowerbed(ModBackportBlocks.WILDFLOWERS);
        registerFlatFlowerbed(blockStateModelGenerator, ModBackportBlocks.LEAF_LITTER);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.FIREFLY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.SHORT_DRY_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.TALL_DRY_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.CACTUS_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        //endregion
        //region Shuckle Blocks
        registerConnectedGlassPaneBlock("tinted_glass", blockStateModelGenerator);

        registerExternalSlabTexture(blockStateModelGenerator,
                "minecraft", "packed_mud", null, null, null, ModBackportBlocks.PACKED_MUD_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "minecraft", "packed_mud", null, null, ModBackportBlocks.PACKED_MUD_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "minecraft", "packed_mud", ModBackportBlocks.PACKED_MUD_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_BLACK_ICE);
        blockStateModelGenerator.registerFlowerbed(ModBlocks.WILDFLOWERS_RED_BLUE);
        registerFlatFlowerbed(blockStateModelGenerator, ModBlocks.LEAF_LITTER_OAK);
        registerFlatFlowerbed(blockStateModelGenerator, ModBlocks.ZYGARDE_CELL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHUCKLE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHUCKLE_MYSTERY_BLOCK);
        //endregion
        //region Other Mod Blocks
        //region BYG
        registerConnectedGlassBlock("therium_glass", blockStateModelGenerator);
        registerConnectedGlassPaneBlock("therium_glass", blockStateModelGenerator);
        //region Black Sand
        registerExternalSlabTexture(blockStateModelGenerator,
                "byg", "black_sandstone", "black_sandstone_top", "black_sandstone_bottom", null, ModBlocks.BLACK_SANDSTONE_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "byg", "black_sandstone", "black_sandstone_top", "black_sandstone_bottom", ModBlocks.BLACK_SANDSTONE_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "byg", "black_sandstone", ModBlocks.BLACK_SANDSTONE_WALL);
        registerExternalSlabTexture(blockStateModelGenerator,
                "byg", "black_cut_sandstone", "black_sandstone_top", "black_sandstone_top", null, ModBlocks.BLACK_CUT_SANDSTONE_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "byg", "black_cut_sandstone", "black_sandstone_top", "black_sandstone_top", ModBlocks.BLACK_CUT_SANDSTONE_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "byg", "black_cut_sandstone", ModBlocks.BLACK_CUT_SANDSTONE_WALL);
        registerExternalSlabTexture(blockStateModelGenerator,
                "byg", "black_sandstone_top", null, null, "black_smooth_sandstone", ModBlocks.BLACK_SMOOTH_SANDSTONE_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "byg", "black_sandstone_top", null, null, ModBlocks.BLACK_SMOOTH_SANDSTONE_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "byg", "black_sandstone_top", ModBlocks.BLACK_SMOOTH_SANDSTONE_WALL);
        //endregion
        //endregion
        //region Fossils
        registerExternalSlabTexture(blockStateModelGenerator,
                "fossil", "ancient_stone", null, null, null, ModBlocks.ANCIENT_STONE_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "fossil", "ancient_stone", null, null, ModBlocks.ANCIENT_STONE_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "fossil", "ancient_stone", ModBlocks.ANCIENT_STONE_WALL);
        //endregion
        //endregion
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.RESIN_BRICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModBackportBlocks.SULFUR_SPIKE.asItem(), Models.GENERATED);

        //region hanging signs
        itemModelGenerator.register(ModItems.OAK_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPRUCE_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIRCH_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.JUNGLE_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACACIA_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_OAK_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANGROVE_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHERRY_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAMBOO_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALE_OAK_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_HANGING_SIGN, Models.GENERATED);
        //endregion

        //region shelves
        registerShelfItem("minecraft", "oak", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "spruce", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "birch", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "jungle", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "acacia", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "dark_oak", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "mangrove", "_log", itemModelGenerator);
        registerShelfItem(ShuckleQOL.MOD_ID, "cherry", "_log", itemModelGenerator);
        registerShelfItem(ShuckleQOL.MOD_ID, "bamboo", "_block", itemModelGenerator);
        registerShelfItem(ShuckleQOL.MOD_ID, "pale_oak", "_log", itemModelGenerator);
        registerShelfItem("minecraft", "crimson", "_stem", itemModelGenerator);
        registerShelfItem("minecraft", "warped", "_stem", itemModelGenerator);
        //endregion

        //region copper
        registerWaxedOxidizableItems("copper_bulb",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);
        registerWaxedOxidizableItems("copper_door",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);
        registerWaxedOxidizableItems("copper_trapdoor",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);
        registerAllOxidizableItems("copper_bars",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);
        registerAllOxidizableItems("copper_chain",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);
        registerWaxedOxidizableItems("lightning_rod",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);
        registerWaxedOxidizableItems("copper_lantern",
                ModOxidizationHelpers.getCopperOxidizationStages(), itemModelGenerator);

        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.COPPER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.COPPER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.COPPER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.COPPER_BOOTS);
        //endregion

        registerConnectedGlassPaneItem("therium_glass", itemModelGenerator);
        registerConnectedGlassPaneItem("tinted_glass", itemModelGenerator);

        itemModelGenerator.register(ModItems.DULL_SHUCKLE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHUCKLE_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.PICKAXE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AXE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHOVEL_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOE_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SHUCKLE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHUCKLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHUCKLE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHUCKLE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.INVIS_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.INVIS_ITEM_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.INVIS_GLOW_ITEM_FRAME, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLACK_ICE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_ICE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_FAMILIAR_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FAMILIAR_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEAK_SHUCKLE_DNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.NORMAL_SHUCKLE_DNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWOLE_SHUCKLE_DNA, Models.GENERATED);

        itemModelGenerator.register(ModItems.MANGROVE_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHERRY_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAMBOO_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALE_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BERRY_JUICE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ZYGARDE_CELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZYGARDE_CELL_FIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZYGARDE_CELL_TWENTY_FIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZYGARDE_CELL_HUNDRED_TWENTY_FIVE, Models.GENERATED);
    }

    private void registerExternalSlabTexture(BlockStateModelGenerator blockStateModelGenerator,
                                             String namespace,
                                             String texture,
                                             @Nullable String topTexture,
                                             @Nullable String bottomTexture,
                                             @Nullable String blockName,
                                             Block slabBlock) {
        TextureMap blockTextures = createBlockTextureMap(namespace, texture, topTexture, bottomTexture);

        final Identifier slabModelId = Models.SLAB.upload(slabBlock, blockTextures, blockStateModelGenerator.modelCollector);
        final Identifier topSlabModelId = Models.SLAB_TOP.upload(slabBlock, blockTextures, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSlabBlockState(slabBlock,
                        slabModelId,
                        topSlabModelId,
                        new Identifier(namespace, "block/" + (blockName != null ? blockName : texture))));
        blockStateModelGenerator.registerParentedItemModel(slabBlock, slabModelId);
    }

    private void registerExternalStairsTexture(BlockStateModelGenerator blockStateModelGenerator,
                                              String namespace,
                                              String texture,
                                              @Nullable String topTexture,
                                              @Nullable String bottomTexture,
                                              Block stairBlock) {
        TextureMap blockTextures = createBlockTextureMap(namespace, texture, topTexture, bottomTexture);

        final Identifier stairsModelId = Models.STAIRS.upload(stairBlock, blockTextures, blockStateModelGenerator.modelCollector);
        final Identifier innerStairsModelId = Models.INNER_STAIRS.upload(stairBlock, blockTextures, blockStateModelGenerator.modelCollector);
        final Identifier outerStairsModelId = Models.OUTER_STAIRS.upload(stairBlock, blockTextures, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createStairsBlockState(stairBlock,
                        innerStairsModelId,
                        stairsModelId,
                        outerStairsModelId));
        blockStateModelGenerator.registerParentedItemModel(stairBlock, stairsModelId);
    }

    private void registerExternalWallTexture(BlockStateModelGenerator blockStateModelGenerator,
                                             String namespace,
                                             String texture,
                                             Block wallBlock) {
        TextureMap blockTextures = new TextureMap().put(TextureKey.WALL, new Identifier(namespace, "block/" + texture));

        final Identifier wallModelId = Models.TEMPLATE_WALL_POST.upload(wallBlock, blockTextures, blockStateModelGenerator.modelCollector);
        final Identifier sideWallModelId = Models.TEMPLATE_WALL_SIDE.upload(wallBlock, blockTextures, blockStateModelGenerator.modelCollector);
        final Identifier tallWallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(wallBlock, blockTextures, blockStateModelGenerator.modelCollector);
        final Identifier inventoryWallModelId = Models.WALL_INVENTORY.upload(wallBlock, blockTextures, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createWallBlockState(wallBlock,
                        wallModelId,
                        sideWallModelId,
                        tallWallModelId));
        blockStateModelGenerator.registerParentedItemModel(wallBlock, inventoryWallModelId);
    }

    private TextureMap createBlockTextureMap(String namespace,
                                             String texture,
                                             @Nullable String topTexture,
                                             @Nullable String bottomTexture) {
        Identifier sideTextureId = new Identifier(namespace, "block/" + texture);
        Identifier topTextureId = topTexture != null ? new Identifier(namespace, "block/" + topTexture) : sideTextureId;
        Identifier bottomTextureId = bottomTexture != null ? new Identifier(namespace, "block/" + bottomTexture) : sideTextureId;

        return new TextureMap()
                .put(TextureKey.SIDE, sideTextureId)
                .put(TextureKey.TOP, topTextureId)
                .put(TextureKey.BOTTOM, bottomTextureId);
    }

    private void registerChiseled(BlockStateModelGenerator gen, Block block) {
        gen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block,
                Models.CUBE_COLUMN.upload(block, new TextureMap()
                                .put(TextureKey.END, TextureMap.getSubId(block, "_top"))
                                .put(TextureKey.SIDE, TextureMap.getSubId(block, "")),
                        gen.modelCollector)
        ));
    }

    private static TextureMap flatFlowerbedTextureMap(Block block) {
        return new TextureMap().put(TextureKey.FLOWERBED, TextureMap.getId(block));
    }

    private static TexturedModel.Factory getFlatFlowerbedFactory(int flowerbedNum) {
        return TexturedModel.makeFactory(ModModelProvider::flatFlowerbedTextureMap,
                new Model(Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/flat_flowerbed_" + flowerbedNum)),
                        Optional.of("_" + flowerbedNum), TextureKey.FLOWERBED));
    }

    private void registerFlatFlowerbed(BlockStateModelGenerator gen, Block flowerbed) {
        gen.registerItemModel(flowerbed.asItem());

        Identifier flowerbed1 = getFlatFlowerbedFactory(1).upload(flowerbed, gen.modelCollector);
        Identifier flowerbed2 = getFlatFlowerbedFactory(2).upload(flowerbed, gen.modelCollector);
        Identifier flowerbed3 = getFlatFlowerbedFactory(3).upload(flowerbed, gen.modelCollector);
        Identifier flowerbed4 = getFlatFlowerbedFactory(4).upload(flowerbed, gen.modelCollector);

        gen.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(flowerbed)

                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1),
                                new Integer[]{2, 3, 4}).set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed1))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1),
                                new Integer[]{2, 3, 4}).set(Properties.HORIZONTAL_FACING, Direction.EAST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed1)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1),
                                new Integer[]{2, 3, 4}).set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed1)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1),
                                new Integer[]{2, 3, 4}).set(Properties.HORIZONTAL_FACING, Direction.WEST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed1)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2),
                                new Integer[]{3, 4}).set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed2))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2),
                                new Integer[]{3, 4}).set(Properties.HORIZONTAL_FACING, Direction.EAST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed2)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2),
                                new Integer[]{3, 4}).set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed2)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2),
                                new Integer[]{3, 4}).set(Properties.HORIZONTAL_FACING, Direction.WEST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed2)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3),
                                new Integer[]{4}).set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed3))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3),
                                new Integer[]{4}).set(Properties.HORIZONTAL_FACING, Direction.EAST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed3)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3),
                                new Integer[]{4}).set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed3)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3),
                                new Integer[]{4}).set(Properties.HORIZONTAL_FACING, Direction.WEST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed3)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, 4)
                                        .set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed4))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, 4)
                                .set(Properties.HORIZONTAL_FACING, Direction.EAST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed4)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, 4)
                                .set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed4)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with((When)When.create().set(Properties.FLOWER_AMOUNT, 4)
                                .set(Properties.HORIZONTAL_FACING, Direction.WEST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, flowerbed4)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }

    private void registerShelfBlock(String woodNamespace, String woodType, String woodSuffix, BlockStateModelGenerator gen) {
        String[] shelfFiles = {
                "_body",
                "_powered",
                "_unpowered"
        };

        Identifier bodyModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + woodType + "_shelf_body");
        Identifier poweredModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + woodType + "_shelf_powered");
        Identifier unpoweredModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + woodType + "_shelf_unpowered");

        gen.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, woodType + "_shelf")))
                        .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, bodyModel))
                        .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.EAST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, bodyModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                                BlockStateVariant.create().put(VariantSettings.MODEL, bodyModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.WEST),
                                BlockStateVariant.create().put(VariantSettings.MODEL, bodyModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.NORTH)
                                        .set(Properties.POWERED, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, unpoweredModel))
                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.EAST)
                                        .set(Properties.POWERED, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, unpoweredModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.SOUTH)
                                        .set(Properties.POWERED, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, unpoweredModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.WEST)
                                        .set(Properties.POWERED, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, unpoweredModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.NORTH)
                                        .set(Properties.POWERED, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, poweredModel))
                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.EAST)
                                        .set(Properties.POWERED, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, poweredModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.SOUTH)
                                        .set(Properties.POWERED, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, poweredModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with(When.create()
                                        .set(Properties.HORIZONTAL_FACING, Direction.WEST)
                                        .set(Properties.POWERED, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, poweredModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
        );

        for (String shelfFile : shelfFiles) {
            new Model(
                    Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_shelf" + shelfFile)),
                    Optional.empty(),
                    TextureKey.ALL, TextureKey.PARTICLE
            ).upload(
                    new Identifier(ShuckleQOL.MOD_ID, "block/" + woodType + "_shelf" + shelfFile),
                    new TextureMap()
                            .put(TextureKey.ALL, new Identifier(ShuckleQOL.MOD_ID, "block/" + woodType + "_shelf"))
                            .put(TextureKey.PARTICLE, new Identifier(woodNamespace, "block/stripped_" + woodType + woodSuffix)),
                    gen.modelCollector
            );
        }
    }

    private void registerConnectedGlassBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier baseModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_base");
        Identifier upModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_up");
        Identifier downModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_down");
        Identifier leftModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_left");
        Identifier rightModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_right");
        Identifier cornerUpModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_corner_up");
        Identifier cornerDownModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_corner_down");

        gen.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, baseBlockId)))
                        .with(BlockStateVariant.create().put(VariantSettings.MODEL, baseModel))

                        .with(When.create().set(ConnectingBlock.DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downModel).put(VariantSettings.UVLOCK, false))
                        .with(When.create().set(ConnectingBlock.UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upModel).put(VariantSettings.UVLOCK, false))
                        .with(When.create().set(ConnectingBlock.EAST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, rightModel).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .with(When.create().set(ConnectingBlock.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, leftModel).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .with(When.create().set(ConnectingBlock.NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, leftModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(ConnectingBlock.SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, rightModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))

                        .with(When.create().set(ConnectingBlock.EAST, false).set(ConnectingBlock.UP, false).set(ConnectingBlock.NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerUpModel).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .with(When.create().set(ConnectingBlock.EAST, false).set(ConnectingBlock.UP, false).set(ConnectingBlock.SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerUpModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(ConnectingBlock.WEST, false).set(ConnectingBlock.UP, false).set(ConnectingBlock.SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerUpModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with(When.create().set(ConnectingBlock.WEST, false).set(ConnectingBlock.UP, false).set(ConnectingBlock.NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerUpModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .with(When.create().set(ConnectingBlock.EAST, false).set(ConnectingBlock.DOWN, false).set(ConnectingBlock.NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerDownModel).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .with(When.create().set(ConnectingBlock.EAST, false).set(ConnectingBlock.DOWN, false).set(ConnectingBlock.SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerDownModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(ConnectingBlock.WEST, false).set(ConnectingBlock.DOWN, false).set(ConnectingBlock.SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerDownModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with(When.create().set(ConnectingBlock.WEST, false).set(ConnectingBlock.DOWN, false).set(ConnectingBlock.NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, cornerDownModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
        );

        new Model(
                Optional.of(new Identifier("minecraft", "block/cube_all")),
                Optional.empty(),
                TextureKey.ALL, TextureKey.PARTICLE
        ).upload(
                new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_base"),
                new TextureMap()
                        .put(TextureKey.ALL, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/base"))
                        .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                gen.modelCollector
        );

        new Model(
                Optional.of(new Identifier("minecraft", "block/cube_all")),
                Optional.empty(),
                TextureKey.ALL
        ).upload(
                new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_all"),
                new TextureMap()
                        .put(TextureKey.ALL, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                gen.modelCollector
        );

        for (String side : new String[] { "left", "right" }) {
            String opposite;
            if (side.equals("left")) {
                opposite = "right";
            } else {
                opposite = "left";
            }

            new Model(
                    Optional.of(new Identifier("minecraft", "block/cube")),
                    Optional.empty(),
                    TextureKey.DOWN, TextureKey.UP, TextureKey.NORTH, TextureKey.EAST,
                    TextureKey.SOUTH, TextureKey.WEST, TextureKey.PARTICLE
            ).upload(
                    new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_" + side),
                    new TextureMap()
                            .put(TextureKey.DOWN, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + side))
                            .put(TextureKey.UP, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + side))
                            .put(TextureKey.NORTH, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + opposite))
                            .put(TextureKey.EAST, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                            .put(TextureKey.SOUTH, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + side))
                            .put(TextureKey.WEST, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                            .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                    gen.modelCollector
            );
        }

        for (String orientation : new String[] { "up", "down"}) {
            new Model(
                    Optional.of(new Identifier("minecraft", "block/cube")),
                    Optional.empty(),
                    TextureKey.DOWN, TextureKey.UP, TextureKey.NORTH, TextureKey.EAST,
                    TextureKey.SOUTH, TextureKey.WEST, TextureKey.PARTICLE
            ).upload(
                    new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_" + orientation),
                    new TextureMap()
                            .put(TextureKey.DOWN, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                            .put(TextureKey.UP, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                            .put(TextureKey.NORTH, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + orientation))
                            .put(TextureKey.EAST, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + orientation))
                            .put(TextureKey.SOUTH, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + orientation))
                            .put(TextureKey.WEST, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + orientation))
                            .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                    gen.modelCollector
            );

            new Model(
                    Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_corner_" + orientation)),
                    Optional.empty(),
                    TextureKey.TEXTURE, TextureKey.INSIDE, TextureKey.PARTICLE
            ).upload(
                    new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_corner_" + orientation),
                    new TextureMap()
                            .put(TextureKey.TEXTURE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/corner"))
                            .put(TextureKey.INSIDE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                            .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                    gen.modelCollector
            );
        }

        gen.registerParentedItemModel(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, baseBlockId)),
                new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_all"));
    }


    private void registerConnectedGlassPaneBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier upPostModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_post_up");
        Identifier downPostModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_post_down");

        Identifier upSideModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_up");
        Identifier downSideModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_down");
        Identifier upSideAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_alt_up");
        Identifier downSideAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_alt_down");

        Identifier baseModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_base");
        Identifier baseAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_alt_base");

        Identifier upModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_up");
        Identifier downModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_down");
        Identifier upAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_alt_up");
        Identifier downAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_alt_down");
        Identifier leftModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_left");
        Identifier rightModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_right");

        Identifier baseCenterModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_base");
        Identifier upCenterModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_up");
        Identifier downCenterModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_down");
        Identifier baseCenterAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_alt_base");
        Identifier upCenterAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_alt_up");
        Identifier downCenterAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_alt_down");

        Identifier cornerUpModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_corner_up");
        Identifier cornerDownModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_corner_down");

        gen.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_pane")))
                        //middle post of the glass, only top and bottom edge textures
                        .with(When.create().set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upPostModel))
                        .with(When.create().set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downPostModel))

                        //sides extending, only top and bottom edges
                        .with(When.create()
                                        .set(Properties.NORTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upSideModel))
                        .with(When.create()
                                        .set(Properties.NORTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downSideModel))
                        .with(When.create()
                                        .set(Properties.EAST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upSideModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.EAST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downSideModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.SOUTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upSideAltModel))
                        .with(When.create()
                                        .set(Properties.SOUTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downSideAltModel))
                        .with(When.create()
                                        .set(Properties.WEST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upSideAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.WEST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downSideAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))

                        //sides extending, only the side faces
                        .with(When.create()
                                        .set(Properties.NORTH, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseModel))
                        .with(When.create()
                                        .set(Properties.NORTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upModel))
                        .with(When.create()
                                        .set(Properties.NORTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downModel))
                        .with(When.create()
                                        .set(Properties.NORTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, rightModel))

                        .with(When.create()
                                        .set(Properties.EAST, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.EAST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.EAST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.EAST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_EAST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, rightModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))

                        .with(When.create()
                                        .set(Properties.SOUTH, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseAltModel))
                        .with(When.create()
                                        .set(Properties.SOUTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upAltModel))
                        .with(When.create()
                                        .set(Properties.SOUTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downAltModel))
                        .with(When.create()
                                        .set(Properties.SOUTH, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, leftModel))

                        .with(When.create()
                                        .set(Properties.WEST, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.WEST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.WEST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.WEST, true)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, leftModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))

                        // no sides variants
                        .with(When.create()
                                        .set(Properties.NORTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseCenterModel))
                        .with(When.create()
                                        .set(Properties.NORTH, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upCenterModel))
                        .with(When.create()
                                        .set(Properties.NORTH, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downCenterModel))

                        .with(When.create().set(Properties.EAST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseCenterModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.EAST, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upCenterModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.EAST, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downCenterModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))

                        .with(When.create()
                                        .set(Properties.SOUTH, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseCenterAltModel))
                        .with(When.create()
                                        .set(Properties.SOUTH, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upCenterAltModel))
                        .with(When.create()
                                        .set(Properties.SOUTH, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downCenterAltModel))

                        .with(When.create()
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, baseCenterAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.WEST, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_UP, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, upCenterAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create()
                                        .set(Properties.WEST, false)
                                        .set(ConnectedGlassPaneBlock.TEXTURE_CONNECT_DOWN, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, downCenterAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
        );

        for (String edge : new String[] { "up", "down" }) {
            new Model(
                    Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_post_" + edge)),
                    Optional.empty(),
                    TextureKey.EDGE, TextureKey.PARTICLE
            ).upload(
                    new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_post_" + edge),
                    new TextureMap()
                            .put(TextureKey.EDGE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/pane_edge"))
                            .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                    gen.modelCollector
            );

            for (String alt : new String[]{"", "_alt"}) {
                new Model(
                        Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_side" + alt + "_" + edge)),
                        Optional.empty(),
                        TextureKey.EDGE, TextureKey.PARTICLE
                ).upload(
                        new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane" + alt + "_" + edge),
                        new TextureMap()
                                .put(TextureKey.EDGE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/pane_edge"))
                                .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                        gen.modelCollector
                );
            }
        }

        for (String alt : new String[]{"", "alt_"}) {
            for (String layer : new String[]{"base", "up", "down"}) {
                new Model(
                        alt.equals("alt_") ? Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_side_alt"))
                                : Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_side")),
                        Optional.empty(),
                        TextureKey.EDGE, TextureKey.PARTICLE, TextureKey.PANE
                ).upload(
                        new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_side_" + alt + layer),
                        new TextureMap()
                                .put(TextureKey.EDGE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/pane_edge"))
                                .put(TextureKey.PANE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + layer))
                                .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                        gen.modelCollector
                );

                new Model(
                        alt.equals("alt_") ? Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_center_alt"))
                                : Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_center")),
                        Optional.empty(),
                        TextureKey.PANE, TextureKey.PARTICLE
                ).upload(
                        new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_pane_center_" + alt + layer),
                        new TextureMap()
                                .put(TextureKey.PANE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/" + layer))
                                .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                        gen.modelCollector
                );
            }
        }

        new Model(
                Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_side")),
                Optional.empty(),
                TextureKey.EDGE, TextureKey.PANE, TextureKey.PARTICLE
        ).upload(
                rightModel,
                new TextureMap()
                        .put(TextureKey.EDGE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                        .put(TextureKey.PANE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/right"))
                        .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                gen.modelCollector
        );

        new Model(
                Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_connected_glass_pane_side_alt")),
                Optional.empty(),
                TextureKey.EDGE, TextureKey.PANE, TextureKey.PARTICLE
        ).upload(
                leftModel,
                new TextureMap()

                        .put(TextureKey.EDGE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/blank"))
                        .put(TextureKey.PANE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/left"))
                        .put(TextureKey.PARTICLE, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                gen.modelCollector
        );
    }

    private void registerPointedSpikeBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier upBaseModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_up_base");
        Identifier downBaseModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_down_base");
        Identifier upFrustumModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_up_frustum");
        Identifier downFrustumModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_down_frustum");
        Identifier upMiddleModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_up_middle");
        Identifier downMiddleModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_down_middle");
        Identifier upTipModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_up_tip");
        Identifier downTipModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_down_tip");
        Identifier upTipMergeModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_up_tip_merge");
        Identifier downTipMergeModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_down_tip_merge");

        gen.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, baseBlockId)))
                        .coordinate(BlockStateVariantMap.create(
                                Properties.VERTICAL_DIRECTION,
                                Properties.THICKNESS)
                                .register(Direction.UP, Thickness.BASE, BlockStateVariant.create().put(VariantSettings.MODEL, upBaseModel))
                                .register(Direction.DOWN, Thickness.BASE,  BlockStateVariant.create().put(VariantSettings.MODEL, downBaseModel))
                                .register(Direction.UP, Thickness.FRUSTUM, BlockStateVariant.create().put(VariantSettings.MODEL, upFrustumModel))
                                .register(Direction.DOWN, Thickness.FRUSTUM,  BlockStateVariant.create().put(VariantSettings.MODEL, downFrustumModel))
                                .register(Direction.UP, Thickness.MIDDLE, BlockStateVariant.create().put(VariantSettings.MODEL, upMiddleModel))
                                .register(Direction.DOWN, Thickness.MIDDLE,  BlockStateVariant.create().put(VariantSettings.MODEL, downMiddleModel))
                                .register(Direction.UP, Thickness.TIP, BlockStateVariant.create().put(VariantSettings.MODEL, upTipModel))
                                .register(Direction.DOWN, Thickness.TIP,  BlockStateVariant.create().put(VariantSettings.MODEL, downTipModel))
                                .register(Direction.UP, Thickness.TIP_MERGE, BlockStateVariant.create().put(VariantSettings.MODEL, upTipMergeModel))
                                .register(Direction.DOWN, Thickness.TIP_MERGE,  BlockStateVariant.create().put(VariantSettings.MODEL, downTipMergeModel))
                        )
        );

        for (String direction : new String[]{"up", "down"}) {
            for (String thickness : new String[]{"base", "frustum", "middle", "tip", "tip_merge"}) {
                new Model(
                        Optional.of(new Identifier("minecraft", "block/pointed_dripstone")),
                        Optional.empty(),
                        TextureKey.CROSS
                ).upload(
                        new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_" + direction + "_" + thickness),
                        new TextureMap()
                                .put(TextureKey.CROSS, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_" + direction + "_" + thickness)),
                        gen.modelCollector
                );
            }
        }
    }

    private void createOxidizableModelSet(String baseBlockId,
                                      Consumer<Block> register,
                                      String[] oxidizationStages,
                                      BlockStateModelGenerator blockStateModelGenerator){
        for (String oxidation : oxidizationStages) {
            register.accept(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, oxidation + baseBlockId)));

            if (baseBlockId.endsWith("bulb")) {
                registerWaxedBulbBlock(oxidation + baseBlockId, blockStateModelGenerator);
            } else if (baseBlockId.endsWith("_door")) {
                registerWaxedDoorBlock(oxidation + baseBlockId, blockStateModelGenerator);
            } else if (baseBlockId.endsWith("trapdoor")) {
                registerWaxedTrapdoorBlock(oxidation + baseBlockId, blockStateModelGenerator);
            } else if (baseBlockId.endsWith("bars")) {
                registerWaxedBarsBlock(oxidation + baseBlockId, blockStateModelGenerator);
            } else if (baseBlockId.endsWith("chain")) {
                registerWaxedChainBlock(oxidation + baseBlockId, blockStateModelGenerator);
            } else if (baseBlockId.endsWith("lantern")) {
                registerWaxedLanternBlock(oxidation + baseBlockId, blockStateModelGenerator);
            } else if (baseBlockId.endsWith("rod")) {
                if (!oxidation.equals("")){
                    registerWaxedLightningRodBlock(oxidation + baseBlockId, blockStateModelGenerator);
                }
            } else {
                blockStateModelGenerator.registerParented(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, oxidation + baseBlockId)),
                        Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + oxidation + baseBlockId)));
            }
        }
    }

    private Consumer<Block> registerBulbBlock(BlockStateModelGenerator gen) {
        return block -> {
            String baseBlockId = Registries.BLOCK.getId(block).getPath();

            Identifier offModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);
            Identifier poweredModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_powered");
            Identifier litModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_lit");
            Identifier litPoweredModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_lit_powered");

            Identifier offTexture = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);
            Identifier poweredTexture = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_powered");
            Identifier litTexture = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_lit");
            Identifier litPoweredTexture = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_lit_powered");

            TexturedModel.getCubeAll(offTexture).getModel()
                    .upload(offModel, TextureMap.all(offTexture), gen.modelCollector);
            TexturedModel.getCubeAll(poweredTexture).getModel()
                    .upload(poweredModel, TextureMap.all(poweredTexture), gen.modelCollector);
            TexturedModel.getCubeAll(litTexture).getModel()
                    .upload(litModel, TextureMap.all(litTexture), gen.modelCollector);
            TexturedModel.getCubeAll(litPoweredTexture).getModel()
                    .upload(litPoweredModel, TextureMap.all(litPoweredTexture), gen.modelCollector);

            gen.blockStateCollector.accept(
                    VariantsBlockStateSupplier.create(block)
                            .coordinate(BlockStateVariantMap.create(
                                            BulbBlock.LIT,
                                            BulbBlock.POWERED)
                                    .register(false, false, BlockStateVariant.create().put(VariantSettings.MODEL, offModel))
                                    .register(false, true,  BlockStateVariant.create().put(VariantSettings.MODEL, poweredModel))
                                    .register(true, false,  BlockStateVariant.create().put(VariantSettings.MODEL, litModel))
                                    .register(true, true,   BlockStateVariant.create().put(VariantSettings.MODEL, litPoweredModel))
                            )
            );
        };
    }

    private Consumer<Block> registerBarsBlock(BlockStateModelGenerator gen) {
        return block -> {
            String[] barFiles = {
                    "_post",
                    "_post_ends",
                    "_cap",
                    "_cap_alt",
                    "_side",
                    "_side_alt"
            };

            String baseBlockId = Registries.BLOCK.getId(block).getPath();

            Identifier postModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_post");
            Identifier postEndModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_post_ends");
            Identifier capModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_cap");
            Identifier capAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_cap_alt");
            Identifier sideModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_side");
            Identifier sideAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_side_alt");

            gen.blockStateCollector.accept(
                    MultipartBlockStateSupplier.create(block)
                        .with(BlockStateVariant.create().put(VariantSettings.MODEL, postEndModel))
                        .with(When.create()
                                        .set(Properties.NORTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.SOUTH, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, postModel))
                        .with(When.create().set(Properties.NORTH, true)
                                        .set(Properties.SOUTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, capModel))
                        .with(When.create().set(Properties.EAST, true)
                                        .set(Properties.NORTH, false)
                                        .set(Properties.SOUTH, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, capModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.SOUTH, true)
                                        .set(Properties.NORTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, capAltModel))
                        .with(When.create().set(Properties.WEST, true)
                                        .set(Properties.NORTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.SOUTH, false),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, capAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.NORTH, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, sideModel))
                        .with(When.create().set(Properties.EAST, true),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, sideModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.SOUTH, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, sideAltModel))
                        .with(When.create().set(Properties.WEST, true),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, sideAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)));

            for (String barFile : barFiles){
                new Model(
                        Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_bars" + barFile)),
                        Optional.empty(),
                        TextureKey.TEXTURE
                ).upload(
                        new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + barFile),
                        TextureMap.texture(new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId)),
                        gen.modelCollector
                );
            }
        };
    }

    private Consumer<Block> registerChainBlock(BlockStateModelGenerator gen){
        return block -> {
            String baseBlockId = Registries.BLOCK.getId(block).getPath();

            Identifier textureId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);

            gen.registerAxisRotated(block, textureId);

            new Model(
                    Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_chain")),
                    Optional.empty(),
                    TextureKey.TEXTURE
            ).upload(
                    textureId,
                    TextureMap.texture(textureId),
                    gen.modelCollector
            );
        };
    }

    private Consumer<Block> registerLightningRodBlock(BlockStateModelGenerator gen) {
        return block -> {
            String baseBlockId = Registries.BLOCK.getId(block).getPath();

            Identifier offModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);
            Identifier onModel = new Identifier("minecraft", "block/lightning_rod_on");

            gen.blockStateCollector.accept(
                    VariantsBlockStateSupplier.create(block)
                            .coordinate(BlockStateVariantMap.create(Properties.FACING, Properties.POWERED)
                                    .register(Direction.UP, false, BlockStateVariant.create().put(VariantSettings.MODEL, offModel))
                                    .register(Direction.UP, true,  BlockStateVariant.create().put(VariantSettings.MODEL, onModel))

                                    .register(Direction.DOWN, false, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, offModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R180))
                                    .register(Direction.DOWN, true, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, onModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R180))
                                    .register(Direction.NORTH, false, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, offModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90))
                                    .register(Direction.NORTH, true, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, onModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90))
                                    .register(Direction.SOUTH, false, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, offModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                            .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                    .register(Direction.SOUTH, true, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, onModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                            .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                    .register(Direction.EAST, false, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, offModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                            .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                    .register(Direction.EAST, true, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, onModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                            .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                    .register(Direction.WEST, false, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, offModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                            .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                    .register(Direction.WEST, true, BlockStateVariant.create()
                                            .put(VariantSettings.MODEL, onModel)
                                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                            .put(VariantSettings.Y, VariantSettings.Rotation.R270))));

            new Model(
                    Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_lightning_rod")),
                    Optional.empty(),
                    TextureKey.TEXTURE
            ).upload(
                    offModel,
                    TextureMap.texture(offModel),
                    gen.modelCollector
            );
            gen.registerParentedItemModel(block, offModel);
        };
    }

    private void registerWaxedBulbBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier offModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);
        Identifier poweredModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_powered");
        Identifier litModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_lit");
        Identifier litPoweredModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_lit_powered");

        gen.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)))
                        .coordinate(BlockStateVariantMap.create(
                                        BulbBlock.LIT,
                                        BulbBlock.POWERED)
                                .register(false, false, BlockStateVariant.create().put(VariantSettings.MODEL, offModel))
                                .register(false, true,  BlockStateVariant.create().put(VariantSettings.MODEL, poweredModel))
                                .register(true, false,  BlockStateVariant.create().put(VariantSettings.MODEL, litModel))
                                .register(true, true,   BlockStateVariant.create().put(VariantSettings.MODEL, litPoweredModel))
                        )
        );
    }

    private void registerWaxedDoorBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier bottomLeftHingeClosedModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_bottom_left");
        Identifier bottomLeftHingeOpenModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_bottom_left_open");
        Identifier bottomRightHingeClosedModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_bottom_right");
        Identifier bottomRightHingeOpenModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_bottom_right_open");
        Identifier topLeftHingeClosedModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_top_left");
        Identifier topLeftHingeOpenModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_top_left_open");
        Identifier topRightHingeClosedModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_top_right");
        Identifier topRightHingeOpenModelId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_top_right_open");

        gen.blockStateCollector.accept(
                BlockStateModelGenerator.createDoorBlockState(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)),
                bottomLeftHingeClosedModelId, bottomLeftHingeOpenModelId,
                bottomRightHingeClosedModelId, bottomRightHingeOpenModelId,
                topLeftHingeClosedModelId, topLeftHingeOpenModelId,
                topRightHingeClosedModelId, topRightHingeOpenModelId));
    }

    private void registerWaxedTrapdoorBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier topTrapdoorId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_top");
        Identifier bottomTrapdoorId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_bottom");
        Identifier openTrapdoorId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_open");

        gen.blockStateCollector.accept(
                BlockStateModelGenerator.createTrapdoorBlockState(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)),
                        topTrapdoorId, bottomTrapdoorId, openTrapdoorId));
    }

    private void registerWaxedChainBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Block block = Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId));

        Identifier textureId = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);

        gen.registerAxisRotated(block, textureId);
    }

    private void registerWaxedBarsBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier postModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_post");
        Identifier postEndModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_post_ends");
        Identifier capModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_cap");
        Identifier capAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_cap_alt");
        Identifier sideModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_side");
        Identifier sideAltModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_side_alt");

        gen.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)))
                        .with(BlockStateVariant.create().put(VariantSettings.MODEL, postEndModel))
                        .with(When.create()
                                        .set(Properties.NORTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.SOUTH, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, postModel))
                        .with(When.create().set(Properties.NORTH, true)
                                        .set(Properties.SOUTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, capModel))
                        .with(When.create().set(Properties.EAST, true)
                                        .set(Properties.NORTH, false)
                                        .set(Properties.SOUTH, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, capModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.SOUTH, true)
                                        .set(Properties.NORTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.WEST, false),
                                BlockStateVariant.create().put(VariantSettings.MODEL, capAltModel))
                        .with(When.create().set(Properties.WEST, true)
                                        .set(Properties.NORTH, false)
                                        .set(Properties.EAST, false)
                                        .set(Properties.SOUTH, false),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, capAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.NORTH, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, sideModel))
                        .with(When.create().set(Properties.EAST, true),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, sideModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.SOUTH, true),
                                BlockStateVariant.create().put(VariantSettings.MODEL, sideAltModel))
                        .with(When.create().set(Properties.WEST, true),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, sideAltModel)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)));
    }

    private void registerWaxedLightningRodBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier offModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);
        Identifier onModel = new Identifier("minecraft", "block/lightning_rod_on");

        gen.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)))
                        .coordinate(BlockStateVariantMap.create(Properties.FACING, Properties.POWERED)
                                .register(Direction.UP, false, BlockStateVariant.create().put(VariantSettings.MODEL, offModel))
                                .register(Direction.UP, true,  BlockStateVariant.create().put(VariantSettings.MODEL, onModel))

                                .register(Direction.DOWN, false, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, offModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R180))
                                .register(Direction.DOWN, true, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, onModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R180))
                                .register(Direction.NORTH, false, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, offModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90))
                                .register(Direction.NORTH, true, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, onModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90))
                                .register(Direction.SOUTH, false, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, offModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(Direction.SOUTH, true, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, onModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(Direction.EAST, false, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, offModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(Direction.EAST, true, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, onModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(Direction.WEST, false, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, offModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                .register(Direction.WEST, true, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, onModel)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))));
    }

    private void registerWaxedLanternBlock(String baseBlockId, BlockStateModelGenerator gen) {
        Identifier normalModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId);
        Identifier hangingModel = new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "_hanging");

        gen.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)))
                        .coordinate(BlockStateVariantMap.create(
                                        LanternBlock.HANGING)
                                .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, normalModel))
                                .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, hangingModel))
                        )
        );
    }

    private void registerShelfItem(String woodNamespace, String woodType, String woodSuffix, ItemModelGenerator gen) {
        new Model(
                Optional.of(new Identifier(ShuckleQOL.MOD_ID, "block/template_shelf_inventory")),
                Optional.empty(),
                TextureKey.ALL, TextureKey.PARTICLE
        ).upload(
                new Identifier(ShuckleQOL.MOD_ID, "item/" + woodType + "_shelf"),
                new TextureMap()
                        .put(TextureKey.ALL, new Identifier(ShuckleQOL.MOD_ID, "block/" + woodType + "_shelf"))
                        .put(TextureKey.PARTICLE, new Identifier(woodNamespace, "block/" + "stripped_" + woodType + woodSuffix)),
                gen.writer
        );
    }

    private <T> void registerAllOxidizableItems(String baseBlockId, String[] oxidizationStages, ItemModelGenerator gen) {
        for (String oxidation : oxidizationStages) {
            gen.register(Registries.ITEM.get(new Identifier(ShuckleQOL.MOD_ID, oxidation + baseBlockId)), Models.GENERATED);
            gen.register(Registries.ITEM.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + oxidation + baseBlockId)),
                    new Model(Optional.of(new Identifier(ShuckleQOL.MOD_ID, "item/" + oxidation + baseBlockId)),
                            Optional.empty()));
        }
    }

    private void registerWaxedOxidizableItems(String baseBlockId, String[] oxidizationStages, ItemModelGenerator gen) {
        for (String oxidation : oxidizationStages) {
            if (!(baseBlockId.endsWith("rod") && oxidation.equals(""))) {
                gen.register(Registries.ITEM.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + oxidation + baseBlockId)),
                        new Model(Optional.of(new Identifier(ShuckleQOL.MOD_ID, "item/" + oxidation + baseBlockId)),
                                Optional.empty()));
            }
        }
    }

    private void registerConnectedGlassPaneItem(String baseBlockId, ItemModelGenerator gen) {
        new Model(
                Optional.of(new Identifier("minecraft", "item/generated")),
                Optional.empty(),
                TextureKey.LAYER0
        ).upload(
                new Identifier(ShuckleQOL.MOD_ID, "item/" + baseBlockId + "_pane"),
                new TextureMap()
                        .put(TextureKey.LAYER0, new Identifier(ShuckleQOL.MOD_ID, "block/" + baseBlockId + "/all")),
                gen.writer
        );
    }
}
