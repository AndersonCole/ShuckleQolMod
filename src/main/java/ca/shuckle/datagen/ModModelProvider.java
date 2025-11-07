package ca.shuckle.datagen;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.block.custom.copper.BulbBlock;
import ca.shuckle.block.custom.copper.CopperDoorBlock;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModOxidizationHelpers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.html.Option;
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

        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);

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
        //endregion

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
}
