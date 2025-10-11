package ca.shuckle.datagen.recipes;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.datagen.recipes.custom.IdentifiersShapedRecipeJsonBuilder;
import ca.shuckle.datagen.recipes.custom.IdentifiersShapelessRecipeJsonBuilder;
import ca.shuckle.datagen.recipes.custom.IdentifiersSingleItemRecipeJsonBuilder;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.jetbrains.annotations.Nullable;

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
        createWoodItemSetRecipes(exporter, "cherry", ModTags.Items.CHERRY_LOGS,
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
        createWoodItemSetRecipes(exporter, "bamboo", ModTags.Items.BAMBOO_BLOCKS,
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
        createWoodItemSetRecipes(exporter, "pale_oak", ModTags.Items.PALE_OAK_LOGS,
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
                        conditionsFromItem(ModBackportBlocks.RESIN_BLOCK))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "resin_clump_from_resin_block"));
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
                        conditionsFromItem(ModBackportBlocks.RESIN_BRICKS))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_resin_bricks_stonecutting"));
        //endregion
        //endregion
        //region Shuckle
        //region Invisible Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INVIS_CATALYST, 64)
                .pattern("SEG")
                .pattern("E#E")
                .pattern("GES")
                .input('#', Items.NETHER_STAR)
                .input('E', Items.ECHO_SHARD)
                .input('S', Items.FERMENTED_SPIDER_EYE)
                .input('G', Items.GOLDEN_CARROT)
                .criterion(hasItem(Items.ECHO_SHARD),
                        conditionsFromItem(Items.ECHO_SHARD)).offerTo(exporter);
        //invis carpets
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.INVIS_CARPET, 16)
                .pattern(" C ")
                .pattern("C#C")
                .pattern(" C ")
                .input('#', ModItems.INVIS_CATALYST)
                .input('C', TagKey.of(RegistryKeys.ITEM, new Identifier("minecraft", "carpets")))
                .criterion(hasItem(ModItems.INVIS_CATALYST),
                        conditionsFromItem(ModItems.INVIS_CATALYST))
                .offerTo(exporter);
        //invis sign
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INVIS_SIGN, 4)
                .pattern(" S ")
                .pattern("S#S")
                .pattern(" S ")
                .input('#', ModItems.INVIS_CATALYST)
                .input('S', TagKey.of(RegistryKeys.ITEM, new Identifier("minecraft", "signs")))
                .criterion(hasItem(ModItems.INVIS_CATALYST),
                        conditionsFromItem(ModItems.INVIS_CATALYST)).offerTo(exporter);
        //invis item frame
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INVIS_ITEM_FRAME, 4)
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .input('#', ModItems.INVIS_CATALYST)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.INVIS_CATALYST),
                        conditionsFromItem(ModItems.INVIS_CATALYST)).offerTo(exporter);
        //invis glow item frame
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INVIS_GLOW_ITEM_FRAME, 1)
                .input(ModItems.INVIS_ITEM_FRAME)
                .input(Items.GLOW_INK_SAC)
                .criterion(hasItem(ModItems.INVIS_CATALYST),
                        conditionsFromItem(ModItems.INVIS_CATALYST)).offerTo(exporter);
        //invis lightning rod
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.INVIS_LIGHTNING_ROD, 2)
                .pattern("C C")
                .pattern("C#C")
                .pattern("C C")
                .input('#', ModItems.INVIS_CATALYST)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(ModItems.INVIS_CATALYST),
                        conditionsFromItem(ModItems.INVIS_CATALYST)).offerTo(exporter);
        //endregion
        //region Shuckle Misc
        //region Shuckle Block Quest
        //black ice crystal
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLACK_ICE_CRYSTAL, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.BLACK_ICE_SHARD)
                .criterion(hasItem(ModItems.BLACK_ICE_SHARD),
                        conditionsFromItem(ModItems.BLACK_ICE_SHARD)).offerTo(exporter);
        //dark star
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARK_STAR, 1)
                .pattern(" # ")
                .pattern("#S#")
                .pattern(" # ")
                .input('#', ModItems.BLACK_ICE_CRYSTAL)
                .input('S', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.BLACK_ICE_CRYSTAL),
                        conditionsFromItem(ModItems.BLACK_ICE_CRYSTAL)).offerTo(exporter);
        //corrupted star
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CORRUPTED_STAR, 1)
                .pattern("V#V")
                .pattern("#S#")
                .pattern("V#V")
                .input('#', Items.SCULK_CATALYST)
                .input('V', Items.SCULK_VEIN)
                .input('S', ModItems.DARK_STAR)
                .criterion(hasItem(ModItems.DARK_STAR),
                        conditionsFromItem(ModItems.DARK_STAR)).offerTo(exporter);
        //pure star
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(ModItems.CORRUPTED_STAR),
                        RecipeCategory.MISC, ModItems.PURE_STAR,
                        500f,100000)
                .criterion(hasItem(ModItems.CORRUPTED_STAR),
                        conditionsFromItem(ModItems.CORRUPTED_STAR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "pure_star_blasting"));
        //familiar shell fossil
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FOSSILIZED_FAMILIAR_SHELL, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#', ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD)
                .criterion(hasItem(ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD),
                        conditionsFromItem(ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD)).offerTo(exporter);
        //normal shuckle dna
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NORMAL_SHUCKLE_DNA, 1)
                .pattern("BSB")
                .pattern("S#S")
                .pattern("BSB")
                .input('#', ModItems.WEAK_SHUCKLE_DNA)
                .input('S', ModItems.PURE_STAR)
                .input('B', ModItems.BERRY_JUICE)
                .criterion(hasItem(ModItems.WEAK_SHUCKLE_DNA),
                        conditionsFromItem(ModItems.WEAK_SHUCKLE_DNA)).offerTo(exporter);
        //swole shuckle dna
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.getId(ModItems.SWOLE_SHUCKLE_DNA), 1)
                .pattern("ZLT")
                .pattern("B#B")
                .pattern("PMZ")
                .inputItem('#', Registries.ITEM.getId(ModItems.NORMAL_SHUCKLE_DNA))
                .inputItem('B', Registries.ITEM.getId(ModItems.BERRY_JUICE))
                .inputItem('Z', Registries.ITEM.getId(ModItems.ZYGARDE_CELL_HUNDRED_TWENTY_FIVE))
                .inputItem('P', new Identifier("fossil", "cooked_spinosaurus"))
                .inputItem('T', new Identifier("fossil", "cooked_tyrannosaurus"))
                .inputItem('M', new Identifier("fossil", "cooked_mosasaurus"))
                .inputItem('L', new Identifier("fossil", "cooked_megalodon"))
                .criterion(hasItem(ModItems.NORMAL_SHUCKLE_DNA),
                        conditionsFromItem(ModItems.NORMAL_SHUCKLE_DNA))
                .offerTo(exporter, Registries.ITEM.getId(ModItems.SWOLE_SHUCKLE_DNA));
        //region Berry Juice
        //mangrove berry
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MANGROVE_BERRY, 4)
                .pattern("R#R")
                .pattern("#S#")
                .pattern("R#R")
                .input('#', Items.MANGROVE_LEAVES)
                .input('S', Items.MANGROVE_PROPAGULE)
                .input('R', Items.MANGROVE_ROOTS)
                .criterion(hasItem(Items.MANGROVE_LOG),
                        conditionsFromItem(Items.MANGROVE_LOG)).offerTo(exporter);
        //cherry berry
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHERRY_BERRY, 4)
                .pattern("P#P")
                .pattern("#S#")
                .pattern("P#P")
                .input('#', ModBackportBlocks.CHERRY_LEAVES)
                .input('S', ModBackportBlocks.CHERRY_SAPLING)
                .input('P', ModBackportBlocks.PINK_PETALS)
                .criterion(hasItem(ModBackportBlocks.CHERRY_LOG),
                        conditionsFromItem(ModBackportBlocks.CHERRY_LOG)).offerTo(exporter);
        //bamboo berry
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BAMBOO_BERRY, 4)
                .pattern("B#B")
                .pattern("#S#")
                .pattern("B#B")
                .input('#', Items.JUNGLE_LEAVES)
                .input('S', Items.JUNGLE_SAPLING)
                .input('B', Items.BAMBOO)
                .criterion(hasItem(Items.BAMBOO),
                        conditionsFromItem(Items.BAMBOO)).offerTo(exporter);
        //pale berry
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PALE_BERRY, 4)
                .pattern("R#R")
                .pattern("#S#")
                .pattern("R#R")
                .input('#', ModBackportBlocks.PALE_OAK_LEAVES)
                .input('S', ModBackportBlocks.PALE_OAK_SAPLING)
                .input('R', ModBackportBlocks.RESIN_CLUMP)
                .criterion(hasItem(ModBackportBlocks.PALE_OAK_LOG),
                        conditionsFromItem(ModBackportBlocks.PALE_OAK_LOG)).offerTo(exporter);
        //berry juice
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BERRY_JUICE, 1)
                .input(ModItems.MANGROVE_BERRY)
                .input(ModItems.CHERRY_BERRY)
                .input(ModItems.BAMBOO_BERRY)
                .input(ModItems.PALE_BERRY)
                .criterion(hasItem(ModItems.MANGROVE_BERRY),
                        conditionsFromItem(ModItems.MANGROVE_BERRY))
                .criterion(hasItem(ModItems.CHERRY_BERRY),
                        conditionsFromItem(ModItems.CHERRY_BERRY))
                .criterion(hasItem(ModItems.BAMBOO_BERRY),
                        conditionsFromItem(ModItems.BAMBOO_BERRY))
                .criterion(hasItem(ModItems.PALE_BERRY),
                        conditionsFromItem(ModItems.PALE_BERRY)).offerTo(exporter);
        //endregion
        //region Zygarde Cells
        //Ground Cells
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ZYGARDE_CELL, 4)
                .input(ModItems.ZYGARDE_CELL_FIVE)
                .criterion(hasItem(ModItems.ZYGARDE_CELL),
                        conditionsFromItem(ModItems.ZYGARDE_CELL)).offerTo(exporter);
        //Five Cells
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZYGARDE_CELL_FIVE, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#', ModItems.ZYGARDE_CELL)
                .criterion(hasItem(ModItems.ZYGARDE_CELL),
                        conditionsFromItem(ModItems.ZYGARDE_CELL)).offerTo(exporter);
        //Twenty Five Cells
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZYGARDE_CELL_TWENTY_FIVE, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#', ModItems.ZYGARDE_CELL_FIVE)
                .criterion(hasItem(ModItems.ZYGARDE_CELL_FIVE),
                        conditionsFromItem(ModItems.ZYGARDE_CELL_FIVE)).offerTo(exporter);
        //Hundred Twenty Five Cells
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZYGARDE_CELL_HUNDRED_TWENTY_FIVE, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#', ModItems.ZYGARDE_CELL_TWENTY_FIVE)
                .criterion(hasItem(ModItems.ZYGARDE_CELL_TWENTY_FIVE),
                        conditionsFromItem(ModItems.ZYGARDE_CELL_TWENTY_FIVE)).offerTo(exporter);
        //endregion
        //endregion
        //region Flowerbeds
        //pink petals
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.PINK_PETALS, 4)
                .input(ModBackportBlocks.CHERRY_LEAVES)
                .criterion(hasItem(ModBackportBlocks.CHERRY_LEAVES),
                        conditionsFromItem(ModBackportBlocks.CHERRY_LEAVES)).offerTo(exporter);
        //pink dye from petals
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PINK_DYE, 1)
                .input(ModBackportBlocks.PINK_PETALS)
                .criterion(hasItem(ModBackportBlocks.PINK_PETALS),
                        conditionsFromItem(ModBackportBlocks.PINK_PETALS))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "pink_dye_from_petals"));
        //wildflowers
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBackportBlocks.WILDFLOWERS, 4)
                .input(Items.DANDELION)
                .input(Items.DANDELION)
                .input(Items.OXEYE_DAISY)
                .input(Items.AZURE_BLUET)
                .criterion(hasItem(Items.DANDELION),
                        conditionsFromItem(Items.DANDELION)).offerTo(exporter);
        //yellow dye from wildflowers
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
                .input(ModBackportBlocks.WILDFLOWERS)
                .criterion(hasItem(ModBackportBlocks.WILDFLOWERS),
                        conditionsFromItem(ModBackportBlocks.WILDFLOWERS))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "yellow_dye_from_wildflowers"));
        //red blue wildflowers
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WILDFLOWERS_RED_BLUE, 4)
                .input(Items.POPPY)
                .input(Items.CORNFLOWER)
                .input(Items.POPPY)
                .input(Items.CORNFLOWER)
                .criterion(hasItem(Items.POPPY),
                        conditionsFromItem(Items.POPPY))
                .criterion(hasItem(Items.CORNFLOWER),
                        conditionsFromItem(Items.CORNFLOWER)).offerTo(exporter);
        //red dye from wildflowers
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RED_DYE, 1)
                .input(ModBlocks.WILDFLOWERS_RED_BLUE)
                .criterion(hasItem(ModBlocks.WILDFLOWERS_RED_BLUE),
                        conditionsFromItem(ModBlocks.WILDFLOWERS_RED_BLUE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "red_dye_from_wildflowers"));
        //leaf litter from smelting
        CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(ItemTags.LEAVES),
                        RecipeCategory.MISC, ModBackportBlocks.LEAF_LITTER,
                        0.15f,200)
                .criterion("has_leaves",
                        conditionsFromTag(ItemTags.LEAVES))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "leaf_litter_from_smelting"));
        //leaf litter oak
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LEAF_LITTER_OAK, 4)
                .pattern(" # ")
                .pattern("#O#")
                .pattern(" # ")
                .input('#', ModBackportBlocks.LEAF_LITTER)
                .input('O', Items.OAK_LEAVES)
                .criterion(hasItem(ModBackportBlocks.LEAF_LITTER),
                        conditionsFromItem(ModBackportBlocks.LEAF_LITTER)).offerTo(exporter);
        //endregion
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
        //shapeless glowstone
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GLOWSTONE, 1)
                .input(Items.GLOWSTONE_DUST)
                .input(Items.GLOWSTONE_DUST)
                .input(Items.GLOWSTONE_DUST)
                .input(Items.GLOWSTONE_DUST)
                .criterion(hasItem(Items.GLOWSTONE_DUST),
                        conditionsFromItem(Items.GLOWSTONE_DUST)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GLOWSTONE_DUST, 4)
                .input(Items.GLOWSTONE)
                .criterion(hasItem(Items.GLOWSTONE),
                        conditionsFromItem(Items.GLOWSTONE)).offerTo(exporter);
        //shapeless honey
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.HONEY_BLOCK, 1)
                .input(Items.HONEY_BOTTLE)
                .input(Items.HONEY_BOTTLE)
                .input(Items.HONEY_BOTTLE)
                .input(Items.HONEY_BOTTLE)
                .criterion(hasItem(Items.HONEY_BOTTLE),
                        conditionsFromItem(Items.HONEY_BOTTLE)).offerTo(exporter);
        //endregion
        //endregion
        //region Other Mods
        //region Copper Backport
        /** Gotta fix this by adding all the copper blocks myself later
        //door recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, (ItemConvertible) new Identifier("copperandtuffbackport", "copper_door"), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
        //trapdoor recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, (ItemConvertible) new Identifier("copperandtuffbackport", "copper_trapdoor"), 2)
                .pattern("###")
                .pattern("###")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        //cheaper stonecutter recipes
        createCopperStagesStonecutterRecipes(exporter,
                "copperandtuffbackport", "copper_door", 1);
        createCopperStagesStonecutterRecipes(exporter,
                "copperandtuffbackport", "copper_trapdoor", 2);
         **/
        //endregion
        //region BYG
        //ebony sign
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(ModBlocks.EBONY_SIGN), 3)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .inputItem('#', new Identifier("byg", "ebony_planks"))
                .inputItem('S', new Identifier("minecraft", "stick"))
                .criterion(hasItem(Items.STICK),
                        conditionsFromItem(Items.STICK))
                .offerTo(exporter, Registries.BLOCK.getId(ModBlocks.EBONY_SIGN));
        //winter cyclamen
        IdentifiersShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("byg", "winter_cyclamen"), 1)
                .inputItem(new Identifier("byg", "winter_succulent"))
                .inputItem(Registries.ITEM.getId(Items.CYAN_DYE))
                .criterion(hasItem(Items.QUARTZ),
                        conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "winter_cyclamen"));
        //raw quartz block
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("byg", "raw_quartz_block"), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .inputItem('#', Registries.ITEM.getId(Items.QUARTZ))
                .criterion(hasItem(Items.QUARTZ),
                        conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "raw_quartz_block"));
        //quartz from raw quartz
        IdentifiersShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.getId(Items.QUARTZ), 9)
                .inputItem(new Identifier("byg", "raw_quartz_block"))
                .criterion(hasItem(Items.QUARTZ),
                        conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "quartz_from_raw_quartz"));
        //black ice from ice
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("byg", "black_ice"), 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .inputItem('#', Registries.ITEM.getId(Items.ICE))
                .inputItem('D', Registries.ITEM.getId(Items.BLACK_DYE))
                .criterion(hasItem(Items.ICE),
                        conditionsFromItem(Items.ICE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "black_ice_from_ice"));
        //black packed ice from packed ice
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("byg", "black_packed_ice"), 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .inputItem('#', Registries.ITEM.getId(Items.PACKED_ICE))
                .inputItem('D', Registries.ITEM.getId(Items.BLACK_DYE))
                .criterion(hasItem(Items.PACKED_ICE),
                        conditionsFromItem(Items.PACKED_ICE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "black_packed_ice_from_packed_ice"));
        //condensed black ice from blue ice
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_BLACK_ICE, 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .input('#', Items.BLUE_ICE)
                .input('D', Items.BLACK_DYE)
                .criterion(hasItem(Items.BLUE_ICE),
                        conditionsFromItem(Items.BLUE_ICE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "condensed_black_ice_from_blue_ice"));
        //condensed black ice
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(ModBlocks.CONDENSED_BLACK_ICE), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .inputItem('#', new Identifier("byg", "packed_black_ice"))
                .criterion(hasItem(Items.PACKED_ICE),
                        conditionsFromItem(Items.PACKED_ICE))
                .offerTo(exporter, Registries.BLOCK.getId(ModBlocks.CONDENSED_BLACK_ICE));
        //black sand sets
        createSlabStairWallItemSetRecipes(exporter,
                "byg", "black_sandstone",
                ModBlocks.BLACK_SANDSTONE_SLAB, ModBlocks.BLACK_SANDSTONE_STAIRS,
                ModBlocks.BLACK_SANDSTONE_WALL, true);
        createSlabStairWallItemSetRecipes(exporter,
                "byg", "black_cut_sandstone",
                ModBlocks.BLACK_CUT_SANDSTONE_SLAB, ModBlocks.BLACK_CUT_SANDSTONE_STAIRS,
                ModBlocks.BLACK_CUT_SANDSTONE_WALL, true);
        createSlabStairWallItemSetRecipes(exporter,
                "byg", "black_smooth_sandstone",
                ModBlocks.BLACK_SMOOTH_SANDSTONE_SLAB, ModBlocks.BLACK_SMOOTH_SANDSTONE_STAIRS,
                ModBlocks.BLACK_SMOOTH_SANDSTONE_WALL, true);
        //endregion
        //region Fossils
        //nautilus shell from magic conch
        IdentifiersShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.getId(Items.NAUTILUS_SHELL), 1)
                .inputItem(new Identifier("fossil", "magic_conch"))
                .criterion(hasItem(Items.NAUTILUS_SHELL),
                        conditionsFromItem(Items.NAUTILUS_SHELL))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "nautilus_shell_from_magic_conch"));
        //ancient stone
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("fossil", "ancient_stone"), 4)
                .pattern("#D")
                .pattern("D#")
                .inputItem('#', new Identifier("fossil", "volcanic_rock"))
                .inputItem('D', new Identifier("fossil", "dense_sand"))
                .criterion(hasItem(Items.STONE),
                        conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "ancient_stone"));
        createSlabStairWallItemSetRecipes(exporter,
                "fossil", "ancient_stone",
                ModBlocks.ANCIENT_STONE_SLAB, ModBlocks.ANCIENT_STONE_STAIRS,
                ModBlocks.ANCIENT_STONE_WALL, true);
        //ancient glass
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("fossil", "ancient_glass"), 8)
                .pattern("G#G")
                .pattern("#R#")
                .pattern("G#G")
                .inputItem('#', new Identifier("fossil", "reinforced_glass"))
                .inputItem('R', new Identifier("fossil", "relic_scrap"))
                .inputItem('G', Registries.ITEM.getId(Items.RAW_GOLD))
                .criterion(hasItem(Items.STONE),
                        conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "ancient_glass"));
        //ancient wood
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("fossil", "ancient_wood_log"), 8)
                .pattern("P#P")
                .pattern("#S#")
                .pattern("P#P")
                .inputTag('#', ModTags.Items.FOSSIL_LOGS.id())
                .inputTag('S', new Identifier("fossil", "fossil_saplings"))
                .inputItem('P', new Identifier("fossil", "fossil_plant"))
                .criterion(hasItem(Items.STONE),
                        conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "ancient_wood"));
        //tar bucket
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("fossil", "tar_bucket"), 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" B ")
                .inputItem('#', new Identifier("fossil", "tar_drop"))
                .inputItem('B', Registries.ITEM.getId(Items.BUCKET))
                .criterion(hasItem(Items.BUCKET),
                        conditionsFromItem(Items.BUCKET))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "tar_bucket"));
        //tarred dirt
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("fossil", "tarred_dirt"), 4)
                .pattern(" # ")
                .pattern("#T#")
                .pattern(" # ")
                .inputTag('#', ModTags.Items.CONVERTIBLE_DIRT.id())
                .inputItem('T', new Identifier("fossil", "tar_drop"))
                .criterion(hasItem(Items.DIRT),
                        conditionsFromItem(Items.DIRT))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "tarred_dirt"));
        //endregion
        //endregion
        //region Universal Dyeing
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "candle", ModTags.Items.DYEABLE_CANDLES,
                null, true);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "wool", ModTags.Items.DYEABLE_WOOL,
                null, false);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "carpet", ModTags.Items.DYEABLE_CARPETS,
                null, false);
        createShapelessDyableItemSetRecipes(exporter,
                "minecraft", "bed", ModTags.Items.DYEABLE_BEDS,
                null, false);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "stained_glass", ModTags.Items.DYEABLE_GLASS,
                "glass", true);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "stained_glass_pane", ModTags.Items.DYEABLE_GLASS_PANES,
                "glass_pane", true);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "terracotta", ModTags.Items.DYEABLE_TERRACOTTA,
                null, true);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "glazed_terracotta", ModTags.Items.DYEABLE_GLAZED_TERRACOTTA,
                null, false);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "concrete", ModTags.Items.DYEABLE_CONCRETE,
                null, false);
        createShapedDyableItemSetRecipes(exporter,
                "minecraft", "concrete_powder", ModTags.Items.DYEABLE_CONCRETE_POWDER,
                null, false);
        //endregion
    }

    private void createWoodItemSetRecipes(Consumer<RecipeJsonProvider> exporter,
                                          String woodSetName,
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
                    .criterion("has_logs",
                            conditionsFromTag(logsTag))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "charcoal_from_" + woodSetName));
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
        Identifier baseItem = new Identifier(namespace, baseBlockId);
        //slab recipe
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(slabBlock), 6)
                .pattern("###")
                .inputItem('#', baseItem)
                .criterion(hasItem(slabBlock),
                        conditionsFromItem(slabBlock))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_slab"));
        //stairs recipe
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(stairsBlock), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .inputItem('#', baseItem)
                .criterion(hasItem(stairsBlock),
                        conditionsFromItem(stairsBlock))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_stairs"));
        //wall recipe
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(wallBlock), 6)
                .pattern("###")
                .pattern("###")
                .inputItem('#', baseItem)
                .criterion(hasItem(wallBlock),
                        conditionsFromItem(wallBlock))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_wall"));

        if(addStonecutterRecipes){
            //slab stonecutting
            IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(baseItem,
                    RecipeCategory.MISC, Registries.BLOCK.getId(slabBlock), 2)
                    .criterion(hasItem(slabBlock),
                            conditionsFromItem(slabBlock))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_slab_stonecutting"));
            //stairs stonecutting
            IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(baseItem,
                            RecipeCategory.MISC, Registries.BLOCK.getId(stairsBlock), 1)
                    .criterion(hasItem(stairsBlock),
                            conditionsFromItem(stairsBlock))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_stairs_stonecutting"));
            //wall stonecutting
            IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(baseItem,
                            RecipeCategory.MISC, Registries.BLOCK.getId(wallBlock), 1)
                    .criterion(hasItem(wallBlock),
                            conditionsFromItem(wallBlock))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_wall_stonecutting"));
        }
    }

    private void createCopperStagesStonecutterRecipes(Consumer<RecipeJsonProvider> exporter,
                                                      String namespace,
                                                      String baseBlockId,
                                                      int stonecutterOutputCount){
        //Identifier baseItem = new Identifier(namespace, baseBlockId);
        //from copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.COPPER_BLOCK),
                        RecipeCategory.MISC, new Identifier(namespace, baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.COPPER_BLOCK),
                        conditionsFromItem(Items.COPPER_BLOCK))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_stonecutting"));
        //from exposed copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.EXPOSED_COPPER),
                        RecipeCategory.MISC, new Identifier(namespace, "exposed_" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.EXPOSED_COPPER),
                        conditionsFromItem(Items.EXPOSED_COPPER))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "exposed_" + baseBlockId + "_stonecutting"));
        //from weathered copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.WEATHERED_COPPER),
                        RecipeCategory.MISC, new Identifier(namespace, "weathered_" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.WEATHERED_COPPER),
                        conditionsFromItem(Items.WEATHERED_COPPER))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "weathered_" + baseBlockId + "_stonecutting"));
        //from oxidized copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.OXIDIZED_COPPER),
                        RecipeCategory.MISC, new Identifier(namespace, "oxidized_" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.OXIDIZED_COPPER),
                        conditionsFromItem(Items.OXIDIZED_COPPER))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "oxidized_" + baseBlockId + "_stonecutting"));
        //from waxed copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.WAXED_COPPER_BLOCK),
                        RecipeCategory.MISC, new Identifier(namespace, "waxed_" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.WAXED_COPPER_BLOCK),
                        conditionsFromItem(Items.WAXED_COPPER_BLOCK))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId + "_stonecutting"));
        //from waxed exposed copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.WAXED_EXPOSED_COPPER),
                        RecipeCategory.MISC, new Identifier(namespace, "waxed_exposed" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.WAXED_EXPOSED_COPPER),
                        conditionsFromItem(Items.WAXED_EXPOSED_COPPER))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "waxed_exposed_" + baseBlockId + "_stonecutting"));
        //from waxed weathered copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.WAXED_WEATHERED_COPPER),
                        RecipeCategory.MISC, new Identifier(namespace, "waxed_weathered_" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.WAXED_WEATHERED_COPPER),
                        conditionsFromItem(Items.WAXED_WEATHERED_COPPER))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "waxed_weathered_" + baseBlockId + "_stonecutting"));
        //from waxed oxidized copper block
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(Registries.ITEM.getId(Items.WAXED_OXIDIZED_COPPER),
                        RecipeCategory.MISC, new Identifier(namespace, "waxed_oxidized_" + baseBlockId), stonecutterOutputCount)
                .criterion(hasItem(Items.WAXED_OXIDIZED_COPPER),
                        conditionsFromItem(Items.WAXED_OXIDIZED_COPPER))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "waxed_oxidized_" + baseBlockId + "_stonecutting"));
    }

    private void createShapedDyableItemSetRecipes(Consumer<RecipeJsonProvider> exporter,
                                                  String namespace,
                                                  String dyedBaseItemId,
                                                  TagKey<Item> dyeableItemsTag,
                                                  @Nullable String unDyedItemId,
                                                  boolean addIceRecipe){
        List<DyeColor> dyeColours = List.of(DyeColor.values());

        if(addIceRecipe){
            //removing dye
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(new Identifier(namespace, (unDyedItemId != null ? unDyedItemId : dyedBaseItemId))), 8)
                    .pattern("###")
                    .pattern("#I#")
                    .pattern("###")
                    .input('#', dyeableItemsTag)
                    .input('I', Items.ICE)
                    .criterion("has_dyable_items",
                            conditionsFromTag(dyeableItemsTag))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, dyedBaseItemId + "_dye_removal"));
        }

        //all dye colours
        for(DyeColor dyeColour : dyeColours){
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(new Identifier(namespace, dyeColour.getName() + "_" + dyedBaseItemId)), 8)
                    .pattern("###")
                    .pattern("#D#")
                    .pattern("###")
                    .input('#', dyeableItemsTag)
                    .input('D', Ingredient.fromJson(JsonHelper.deserialize("{\"item\":\"minecraft:" + dyeColour.getName() + "_dye\"}")))
                    .criterion("has_dyable_items",
                            conditionsFromTag(dyeableItemsTag))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, dyeColour.getName() + "_" + dyedBaseItemId));
        }
    }

    private void createShapelessDyableItemSetRecipes(Consumer<RecipeJsonProvider> exporter,
                                                    String namespace,
                                                    String dyedBaseItemId,
                                                    TagKey<Item> dyeableItemsTag,
                                                    @Nullable String unDyedItemId,
                                                    boolean addIceRecipe){
        List<DyeColor> dyeColours = List.of(DyeColor.values());

        if(addIceRecipe){
            //removing dye
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(new Identifier(namespace, (unDyedItemId != null ? unDyedItemId : dyedBaseItemId))), 1)
                    .input(dyeableItemsTag)
                    .input(Items.ICE)
                    .criterion("has_dyable_items",
                            conditionsFromTag(dyeableItemsTag))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, dyedBaseItemId + "_dye_removal"));
        }

        //all dye colours
        for(DyeColor dyeColour : dyeColours){
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(new Identifier(namespace, dyeColour.getName() + "_" + dyedBaseItemId)), 1)
                    .input(dyeableItemsTag)
                    .input(Ingredient.fromJson(JsonHelper.deserialize("{\"item\":\"minecraft:" + dyeColour.getName() + "_dye\"}")))
                            .criterion("has_dyable_items",
                            conditionsFromTag(dyeableItemsTag))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, dyeColour.getName() + "_" + dyedBaseItemId));
        }
    }
}
