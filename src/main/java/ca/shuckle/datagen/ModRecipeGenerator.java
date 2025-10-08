package ca.shuckle.datagen;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //region Backport
        //cherry wood set
        createWoodItemSetRecipes(exporter, ModTags.Items.CHERRY_LOGS,
                ModBackportBlocks.CHERRY_LOG, ModBackportBlocks.STRIPPED_CHERRY_LOG,
                ModBackportBlocks.CHERRY_WOOD, ModBackportBlocks.STRIPPED_CHERRY_WOOD,
                ModBackportBlocks.CHERRY_PLANKS, 4,
                ModBackportBlocks.CHERRY_SLAB, ModBackportBlocks.CHERRY_STAIRS,
                ModBackportBlocks.CHERRY_DOOR, ModBackportBlocks.CHERRY_TRAPDOOR,
                ModBackportBlocks.CHERRY_FENCE, ModBackportBlocks.CHERRY_FENCE_GATE,
                ModBackportBlocks.CHERRY_BUTTON, ModBackportBlocks.CHERRY_PRESSURE_PLATE,
                ModItems.CHERRY_SIGN);
        //region Bamboo
        //bamboo wood set
        createWoodItemSetRecipes(exporter, ModTags.Items.BAMBOO_BLOCKS,
                ModBackportBlocks.BAMBOO_BLOCK, ModBackportBlocks.STRIPPED_BAMBOO_BLOCK,
                null, null,
                ModBackportBlocks.BAMBOO_PLANKS, 2,
                ModBackportBlocks.BAMBOO_SLAB, ModBackportBlocks.BAMBOO_STAIRS,
                ModBackportBlocks.BAMBOO_DOOR, ModBackportBlocks.BAMBOO_TRAPDOOR,
                ModBackportBlocks.BAMBOO_FENCE, ModBackportBlocks.BAMBOO_FENCE_GATE,
                ModBackportBlocks.BAMBOO_BUTTON, ModBackportBlocks.BAMBOO_PRESSURE_PLATE,
                ModItems.BAMBOO_SIGN);
        //bamboo mosaic
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.BAMBOO_MOSAIC,1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBackportBlocks.BAMBOO_SLAB)
                .criterion(hasItem(ModBackportBlocks.BAMBOO_PLANKS),
                        conditionsFromItem(ModBackportBlocks.BAMBOO_PLANKS)).offerTo(exporter);
        //bamboo mosaic slab recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.BAMBOO_MOSAIC_SLAB, 6)
                .pattern("###")
                .input('#', ModBackportBlocks.BAMBOO_MOSAIC)
                .criterion(hasItem(ModBackportBlocks.BAMBOO_MOSAIC),
                        conditionsFromItem(ModBackportBlocks.BAMBOO_MOSAIC)).offerTo(exporter);
        //bamboo mosaic stairs recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.BAMBOO_MOSAIC_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBackportBlocks.BAMBOO_MOSAIC)
                .criterion(hasItem(ModBackportBlocks.BAMBOO_MOSAIC),
                        conditionsFromItem(ModBackportBlocks.BAMBOO_MOSAIC)).offerTo(exporter);
        //endregion
        //region Pale Garden
        //pale oak wood set
        createWoodItemSetRecipes(exporter, ModTags.Items.PALE_OAK_LOGS,
                ModBackportBlocks.PALE_OAK_LOG, ModBackportBlocks.STRIPPED_PALE_OAK_LOG,
                ModBackportBlocks.PALE_OAK_WOOD, ModBackportBlocks.STRIPPED_PALE_OAK_WOOD,
                ModBackportBlocks.PALE_OAK_PLANKS, 4,
                ModBackportBlocks.PALE_OAK_SLAB, ModBackportBlocks.PALE_OAK_STAIRS,
                ModBackportBlocks.PALE_OAK_DOOR, ModBackportBlocks.PALE_OAK_TRAPDOOR,
                ModBackportBlocks.PALE_OAK_FENCE, ModBackportBlocks.PALE_OAK_FENCE_GATE,
                ModBackportBlocks.PALE_OAK_BUTTON, ModBackportBlocks.PALE_OAK_PRESSURE_PLATE,
                ModItems.PALE_OAK_SIGN);
        //pale moss carpet
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.PALE_MOSS_CARPET, 3)
                .pattern("##")
                .input('#', ModBackportBlocks.PALE_MOSS_BLOCK)
                .criterion(hasItem(ModBackportBlocks.PALE_MOSS_BLOCK),
                        conditionsFromItem(ModBackportBlocks.PALE_MOSS_BLOCK)).offerTo(exporter);
        //creaking heart
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.CREAKING_HEART, 1)
                .pattern("#")
                .pattern("R")
                .pattern("#")
                .input('#', ModBackportBlocks.PALE_OAK_LOG)
                .input('R', ModBackportBlocks.RESIN_BLOCK)
                .criterion(hasItem(ModBackportBlocks.PALE_OAK_LOG),
                        conditionsFromItem(ModBackportBlocks.PALE_OAK_LOG))
                .criterion(hasItem(ModBackportBlocks.RESIN_BLOCK),
                        conditionsFromItem(ModBackportBlocks.RESIN_BLOCK)).offerTo(exporter);
        //active creaking heart
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.ACTIVE_CREAKING_HEART, 1)
                .pattern("C#C")
                .pattern("CRC")
                .pattern("C#C")
                .input('#', ModBackportBlocks.PALE_OAK_LOG)
                .input('R', ModBackportBlocks.RESIN_BLOCK)
                .input('C', ModBackportBlocks.RESIN_CLUMP)
                .criterion(hasItem(ModBackportBlocks.PALE_OAK_LOG),
                        conditionsFromItem(ModBackportBlocks.PALE_OAK_LOG))
                .criterion(hasItem(ModBackportBlocks.RESIN_BLOCK),
                        conditionsFromItem(ModBackportBlocks.RESIN_BLOCK)).offerTo(exporter);
        //resin clump
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.RESIN_CLUMP, 8)
                .pattern("C#C")
                .pattern("#O#")
                .pattern("C#C")
                .input('#', ModTags.Items.RAW_ORES)
                .input('O', Items.ORANGE_DYE)
                .input('C', Items.CLAY_BALL)
                .criterion(hasItem(Items.CLAY_BALL),
                        conditionsFromItem(Items.CLAY_BALL)).offerTo(exporter);
        //resin brick
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModBackportBlocks.RESIN_CLUMP),
                        RecipeCategory.MISC, ModItems.RESIN_BRICK,
                        0.1f,200)
                .criterion(hasItem(ModBackportBlocks.RESIN_CLUMP),
                        conditionsFromItem(ModBackportBlocks.RESIN_CLUMP)).offerTo(exporter);
        //resin block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.RESIN_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModBackportBlocks.RESIN_CLUMP)
                .criterion(hasItem(ModBackportBlocks.RESIN_CLUMP),
                        conditionsFromItem(ModBackportBlocks.RESIN_CLUMP)).offerTo(exporter);
        //resin block decraft
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.RESIN_CLUMP, 9)
                .input(ModBackportBlocks.RESIN_BLOCK)
                .criterion(hasItem(ModBackportBlocks.RESIN_BLOCK),
                        conditionsFromItem(ModBackportBlocks.RESIN_BLOCK)).offerTo(exporter);
        //resin bricks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.RESIN_BRICKS, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.RESIN_BRICK)
                .criterion(hasItem(ModItems.RESIN_BRICK),
                        conditionsFromItem(ModItems.RESIN_BRICK)).offerTo(exporter);
        //resin bricks set
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "resin_bricks",
                ModBackportBlocks.RESIN_BRICK_SLAB, ModBackportBlocks.RESIN_BRICK_STAIRS,
                ModBackportBlocks.RESIN_BRICK_WALL, true);
        //chiseled resin bricks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CHISELED_RESIN_BRICKS,1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBackportBlocks.RESIN_BRICK_SLAB)
                .criterion(hasItem(ModBackportBlocks.RESIN_BRICK_SLAB),
                        conditionsFromItem(ModBackportBlocks.RESIN_BRICK_SLAB)).offerTo(exporter);
        //chiseled resin bricks stonecutter
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.RESIN_BRICKS),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_RESIN_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.RESIN_BRICKS),
                        conditionsFromItem(ModBackportBlocks.RESIN_BRICKS)).offerTo(exporter);
        //endregion
        //endregion
        //region Shuckle
        //reinforced deepslate
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.REINFORCED_DEEPSLATE, 8)
                .pattern("DBD")
                .pattern("BDB")
                .pattern("DBD")
                .input('D', Blocks.DEEPSLATE)
                .input('B', Blocks.BONE_BLOCK)
                .criterion(hasItem(Blocks.DEEPSLATE),
                        conditionsFromItem(Blocks.DEEPSLATE))
                .criterion(hasItem(Blocks.BONE_BLOCK),
                        conditionsFromItem(Blocks.BONE_BLOCK)).offerTo(exporter);
        //packed mud set
        createSlabStairWallItemSetRecipes(exporter,
                "minecraft", "packed_mud",
                ModBackportBlocks.PACKED_MUD_SLAB, ModBackportBlocks.PACKED_MUD_STAIRS,
                ModBackportBlocks.PACKED_MUD_WALL, true);
        //endregion
        //region Other Mods
        //region BYG

        //endregion
        //region Fossils

        //endregion
        //endregion
        //region Universal Dyeing

        //endregion
    }

    private void createWoodItemSetRecipes(Consumer<RecipeJsonProvider> exporter,
                                          TagKey<Item> logsTag,
                                          Block logBlock,
                                          @Nullable Block woodBlock,
                                          Block strippedLogBlock,
                                          @Nullable Block strippedWoodBlock,
                                          Block planksBlock,
                                          int planksCount,
                                          Block slabBlock,
                                          Block stairsBlock,
                                          Block doorBlock,
                                          Block trapdoorBlock,
                                          Block fenceBlock,
                                          Block fenceGateBlock,
                                          Block buttonBlock,
                                          Block pressurePlateBlock,
                                          Item signItem
                                          ){
        if(woodBlock != null && strippedWoodBlock != null){
            //charcoal recipe
            CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(logsTag),
                    RecipeCategory.MISC, Items.CHARCOAL,
                    0.15f,200)
                    .criterion(hasItem(logBlock),
                        conditionsFromItem(logBlock)).offerTo(exporter);
            //full bark block recipe
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                            woodBlock,3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', logBlock)
                    .criterion(hasItem(logBlock),
                            conditionsFromItem(logBlock)).offerTo(exporter);
            //full bark stripped block recipe
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                            strippedWoodBlock,3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', strippedLogBlock)
                    .criterion(hasItem(strippedLogBlock),
                            conditionsFromItem(strippedLogBlock)).offerTo(exporter);
        }
        //planks recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, planksBlock, planksCount)
                .input(logsTag)
                .criterion("has_logs",
                        conditionsFromTag(logsTag)).offerTo(exporter);
        //slab recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, slabBlock, 6)
                .pattern("###")
                .input('#', planksBlock)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //stairs recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, stairsBlock, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', planksBlock)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //door recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, doorBlock, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', planksBlock)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //trapdoor recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, trapdoorBlock, 2)
                .pattern("###")
                .pattern("###")
                .input('#', planksBlock)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //fence recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, fenceBlock, 3)
                .pattern("#S#")
                .pattern("#S#")
                .input('#', planksBlock)
                .input('S', Items.STICK)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //fence gate recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, fenceGateBlock, 1)
                .pattern("S#S")
                .pattern("S#S")
                .input('#', planksBlock)
                .input('S', Items.STICK)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //button recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, buttonBlock, 1)
                .input(planksBlock)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //pressure plate
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, pressurePlateBlock, 1)
                .pattern("##")
                .input('#', planksBlock)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //sign
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, signItem, 3)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .input('#', planksBlock)
                .input('S', Items.STICK)
                .criterion(hasItem(planksBlock),
                        conditionsFromItem(planksBlock)).offerTo(exporter);
        //hanging sign
        /**
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hangingSignItem, 1)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .input('#', strippedLogBlock)
                .input('C', Items.CHAIN)
                .criterion(hasItem(strippedLogBlock),
                        conditionsFromItem(strippedLogBlock)).offerTo(exporter);
         **/
    }

    private void createSlabStairWallItemSetRecipes(Consumer<RecipeJsonProvider> exporter,
                                                   String namespace,
                                                   String baseBlockId,
                                                   Block slabBlock,
                                                   Block stairsBlock,
                                                   Block wallBlock,
                                                   boolean addStonecutterRecipes){
        ItemConvertible baseItem = Registries.ITEM.get(new Identifier(namespace, baseBlockId));
        Ingredient baseIngredient = Ingredient.ofItems(baseItem);
        //slab recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, slabBlock, 6)
                .pattern("###")
                .input('#', baseIngredient)
                .criterion(hasItem(baseItem),
                        conditionsFromItem(baseItem)).offerTo(exporter);
        //stairs recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, stairsBlock, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', baseIngredient)
                .criterion(hasItem(baseItem),
                        conditionsFromItem(baseItem)).offerTo(exporter);
        //wall recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, wallBlock, 6)
                .pattern("###")
                .pattern("###")
                .input('#', baseIngredient)
                .criterion(hasItem(baseItem),
                        conditionsFromItem(baseItem)).offerTo(exporter);

        if(addStonecutterRecipes){
            //slab stonecutting
            SingleItemRecipeJsonBuilder.createStonecutting(baseIngredient,
                    RecipeCategory.MISC, slabBlock, 2)
                    .criterion(hasItem(baseItem),
                            conditionsFromItem(baseItem)).offerTo(exporter);
            //stairs stonecutting
            SingleItemRecipeJsonBuilder.createStonecutting(baseIngredient,
                            RecipeCategory.MISC, stairsBlock, 1)
                    .criterion(hasItem(baseItem),
                            conditionsFromItem(baseItem)).offerTo(exporter);
            //wall stonecutting
            SingleItemRecipeJsonBuilder.createStonecutting(baseIngredient,
                            RecipeCategory.MISC, wallBlock, 1)
                    .criterion(hasItem(baseItem),
                            conditionsFromItem(baseItem)).offerTo(exporter);
        }
    }
}
