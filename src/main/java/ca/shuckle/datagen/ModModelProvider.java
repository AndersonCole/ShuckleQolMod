package ca.shuckle.datagen;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;

public class ModModelProvider extends FabricModelProvider {
    //https://wiki.fabricmc.net/tutorial:datagen_model if i ever need to do more custom stuff
    public ModModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //region Backport Blocks
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

        blockStateModelGenerator.registerWoolAndCarpet(ModBackportBlocks.PALE_MOSS_BLOCK, ModBackportBlocks.PALE_MOSS_CARPET);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.PALE_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);

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
        blockStateModelGenerator.registerFlowerbed(ModBackportBlocks.PINK_PETALS);
        blockStateModelGenerator.registerFlowerbed(ModBackportBlocks.WILDFLOWERS);
        //endregion

        //region Shuckle Blocks
        registerExternalSlabTexture(blockStateModelGenerator,
                "minecraft", "packed_mud", null, null, null, ModBackportBlocks.PACKED_MUD_SLAB);
        registerExternalStairsTexture(blockStateModelGenerator,
                "minecraft", "packed_mud", null, null, ModBackportBlocks.PACKED_MUD_STAIRS);
        registerExternalWallTexture(blockStateModelGenerator,
                "minecraft", "packed_mud", ModBackportBlocks.PACKED_MUD_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_BLACK_ICE);
        blockStateModelGenerator.registerFlowerbed(ModBlocks.WILDFLOWERS_RED_BLUE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHUCKLE_MYSTERY_BLOCK);
        //endregion
        //region Other Mod Blocks
        //region BYG
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
}
