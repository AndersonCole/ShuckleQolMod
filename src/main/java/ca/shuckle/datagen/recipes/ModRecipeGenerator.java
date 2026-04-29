package ca.shuckle.datagen.recipes;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.datagen.recipes.custom.IdentifiersShapedRecipeJsonBuilder;
import ca.shuckle.datagen.recipes.custom.IdentifiersShapelessRecipeJsonBuilder;
import ca.shuckle.datagen.recipes.custom.IdentifiersSingleItemRecipeJsonBuilder;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModOxidizationHelpers;
import ca.shuckle.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SmithingTableBlock;
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
import java.util.Map;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @SuppressWarnings("removal")
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //region Backport
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        Items.SADDLE,1)
                .pattern(" # ")
                .pattern("#I#")
                .input('#', Items.LEATHER)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.LEATHER),
                        conditionsFromItem(Items.LEATHER)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        Items.NAME_TAG,1)
                .pattern(" #")
                .pattern("P ")
                .input('#', TagKey.of(RegistryKeys.ITEM, new Identifier(ShuckleQOL.MOD_ID, "metal_nuggets")))
                .input('P', Items.PAPER)
                .criterion(hasItem(Items.PAPER),
                        conditionsFromItem(Items.PAPER)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        Items.LODESTONE,1)
                .pattern("###")
                .pattern("#I#")
                .pattern("###")
                .input('#', Items.CHISELED_STONE_BRICKS)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.CHISELED_STONE_BRICKS),
                        conditionsFromItem(Items.CHISELED_STONE_BRICKS)).offerTo(exporter);
        //hanging signs
        createHangingSignRecipe(exporter, "minecraft", "stripped_oak_log", "oak_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_spruce_log", "spruce_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_birch_log", "birch_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_jungle_log", "jungle_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_acacia_log", "acacia_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_dark_oak_log", "dark_oak_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_mangrove_log", "mangrove_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_crimson_stem", "crimson_hanging_sign");
        createHangingSignRecipe(exporter, "minecraft", "stripped_warped_stem", "warped_hanging_sign");
        //shelves
        createShelfRecipe(exporter, "minecraft", "stripped_oak_log", "oak_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_spruce_log", "spruce_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_birch_log", "birch_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_jungle_log", "jungle_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_acacia_log", "acacia_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_dark_oak_log", "dark_oak_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_mangrove_log", "mangrove_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_crimson_stem", "crimson_shelf");
        createShelfRecipe(exporter, "minecraft", "stripped_warped_stem", "warped_shelf");
        //cherry wood set
        createWoodItemSetRecipes(exporter, "cherry", ModTags.Items.CHERRY_LOGS,
                ModBackportBlocks.CHERRY_LOG, ModBackportBlocks.CHERRY_WOOD,
                ModBackportBlocks.STRIPPED_CHERRY_LOG, ModBackportBlocks.STRIPPED_CHERRY_WOOD,
                ModBackportBlocks.CHERRY_PLANKS, 4,
                ModBackportBlocks.CHERRY_SLAB, ModBackportBlocks.CHERRY_STAIRS,
                ModBackportBlocks.CHERRY_DOOR, ModBackportBlocks.CHERRY_TRAPDOOR,
                ModBackportBlocks.CHERRY_FENCE, ModBackportBlocks.CHERRY_FENCE_GATE,
                ModBackportBlocks.CHERRY_BUTTON, ModBackportBlocks.CHERRY_PRESSURE_PLATE,
                ModBackportBlocks.CHERRY_SHELF, ModItems.CHERRY_SIGN, ModItems.CHERRY_HANGING_SIGN);
        //region Bamboo
        //bamboo wood set
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.BAMBOO_BLOCK,1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Items.BAMBOO)
                .criterion(hasItem(Items.BAMBOO),
                        conditionsFromItem(Items.BAMBOO)).offerTo(exporter);

        createWoodItemSetRecipes(exporter, "bamboo", ModTags.Items.BAMBOO_BLOCKS,
                ModBackportBlocks.BAMBOO_BLOCK, null,
                ModBackportBlocks.STRIPPED_BAMBOO_BLOCK, null,
                ModBackportBlocks.BAMBOO_PLANKS, 2,
                ModBackportBlocks.BAMBOO_SLAB, ModBackportBlocks.BAMBOO_STAIRS,
                ModBackportBlocks.BAMBOO_DOOR, ModBackportBlocks.BAMBOO_TRAPDOOR,
                ModBackportBlocks.BAMBOO_FENCE, ModBackportBlocks.BAMBOO_FENCE_GATE,
                ModBackportBlocks.BAMBOO_BUTTON, ModBackportBlocks.BAMBOO_PRESSURE_PLATE,
                ModBackportBlocks.BAMBOO_SHELF, ModItems.BAMBOO_SIGN, ModItems.BAMBOO_HANGING_SIGN);
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
                ModBackportBlocks.PALE_OAK_LOG, ModBackportBlocks.PALE_OAK_WOOD,
                ModBackportBlocks.STRIPPED_PALE_OAK_LOG, ModBackportBlocks.STRIPPED_PALE_OAK_WOOD,
                ModBackportBlocks.PALE_OAK_PLANKS, 4,
                ModBackportBlocks.PALE_OAK_SLAB, ModBackportBlocks.PALE_OAK_STAIRS,
                ModBackportBlocks.PALE_OAK_DOOR, ModBackportBlocks.PALE_OAK_TRAPDOOR,
                ModBackportBlocks.PALE_OAK_FENCE, ModBackportBlocks.PALE_OAK_FENCE_GATE,
                ModBackportBlocks.PALE_OAK_BUTTON, ModBackportBlocks.PALE_OAK_PRESSURE_PLATE,
                ModBackportBlocks.PALE_OAK_SHELF, ModItems.PALE_OAK_SIGN, ModItems.PALE_OAK_HANGING_SIGN);
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
        //region Copper
        //nuggets
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        Items.COPPER_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.COPPER_NUGGET)
                .criterion(hasItem(ModItems.COPPER_NUGGET),
                        conditionsFromItem(ModItems.COPPER_NUGGET))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "copper_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_NUGGET, 9)
                .input(Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
        //chiseled recipe
        createOxidizableRecipes(exporter,
                "minecraft", "cut_copper_slab",
                ShuckleQOL.MOD_ID, "chiseled_copper",
                List.of("#",
                        "#"),
                null,
                Blocks.CUT_COPPER.asItem(),
                ModOxidizationHelpers.getCopperOxidizationStages(), 1);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "chiseled_copper",
                ModBackportBlocks.CHISELED_COPPER.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //grate recipe
        createOxidizableRecipes(exporter,
                "minecraft", "copper_block",
                ShuckleQOL.MOD_ID, "copper_grate",
                List.of(" # ",
                        "# #",
                        " # "),
                null,
                Blocks.COPPER_BLOCK.asItem(),
                ModOxidizationHelpers.getCopperOxidizationStages(), 4);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_grate",
                ModBackportBlocks.COPPER_GRATE.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //bulb recipe
        createOxidizableRecipes(exporter,
                "minecraft", "copper_block",
                ShuckleQOL.MOD_ID, "copper_bulb",
                List.of(" # ",
                        "#B#",
                        " R "),
                Map.of('B', new Identifier("minecraft", "blaze_rod"),
                        'R', new Identifier("minecraft", "redstone")),
                Blocks.COPPER_BLOCK.asItem(),
                ModOxidizationHelpers.getCopperOxidizationStages(), 4);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_bulb",
                ModBackportBlocks.COPPER_BULB.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //door recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.COPPER_DOOR, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_door",
                ModBackportBlocks.COPPER_DOOR.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //trapdoor recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.COPPER_TRAPDOOR, 1)
                .pattern("##")
                .pattern("##")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_trapdoor",
                ModBackportBlocks.COPPER_TRAPDOOR.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //bars recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.COPPER_BARS, 16)
                .pattern("###")
                .pattern("###")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_bars",
                ModBackportBlocks.COPPER_BARS.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //chain recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.COPPER_CHAIN, 1)
                .pattern("C")
                .pattern("#")
                .pattern("C")
                .input('#', Items.COPPER_INGOT)
                .input('C', ModItems.COPPER_NUGGET)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_chain",
                ModBackportBlocks.COPPER_CHAIN.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //lightning rod recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                        Blocks.LIGHTNING_ROD, 1)
                .input(ModBackportBlocks.LIGHTNING_ROD)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Blocks.LIGHTNING_ROD),
                        conditionsFromItem(Blocks.LIGHTNING_ROD)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.WAXED_EXPOSED_LIGHTNING_ROD, 1)
                .input(ModBackportBlocks.EXPOSED_LIGHTNING_ROD)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Blocks.LIGHTNING_ROD),
                        conditionsFromItem(Blocks.LIGHTNING_ROD)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.WAXED_WEATHERED_LIGHTNING_ROD, 1)
                .input(ModBackportBlocks.WEATHERED_LIGHTNING_ROD)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Blocks.LIGHTNING_ROD),
                        conditionsFromItem(Blocks.LIGHTNING_ROD)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.WAXED_OXIDIZED_LIGHTNING_ROD, 1)
                .input(ModBackportBlocks.OXIDIZED_LIGHTNING_ROD)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Blocks.LIGHTNING_ROD),
                        conditionsFromItem(Blocks.LIGHTNING_ROD)).offerTo(exporter);
        //torch recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_TORCH, 4)
                .pattern("C")
                .pattern("#")
                .pattern("S")
                .input('#', Items.COAL)
                .input('S', Items.STICK)
                .input('C', ModItems.COPPER_NUGGET)
                .criterion(hasItem(ModItems.COPPER_NUGGET),
                        conditionsFromItem(ModItems.COPPER_NUGGET))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "copper_torch_from_coal"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_TORCH, 4)
                .pattern("C")
                .pattern("#")
                .pattern("S")
                .input('#', Items.CHARCOAL)
                .input('S', Items.STICK)
                .input('C', ModItems.COPPER_NUGGET)
                .criterion(hasItem(ModItems.COPPER_NUGGET),
                        conditionsFromItem(ModItems.COPPER_NUGGET))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "copper_torch_from_charcoal"));
        //lantern recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.COPPER_LANTERN, 1)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .input('#', ModItems.COPPER_NUGGET)
                .input('T', ModItems.COPPER_TORCH)
                .criterion(hasItem(ModItems.COPPER_NUGGET),
                        conditionsFromItem(ModItems.COPPER_NUGGET)).offerTo(exporter);
        createWaxedOxidizableRecipes(exporter,
                ShuckleQOL.MOD_ID, "copper_lantern",
                ModBackportBlocks.COPPER_LANTERN.asItem(), ModOxidizationHelpers.getCopperOxidizationStages());
        //stonecutter recipes
        createOxidizableStonecutterRecipes(exporter,
                "minecraft", "copper_block",
                ShuckleQOL.MOD_ID, "copper_grate",
                Blocks.COPPER_BLOCK.asItem(), ModOxidizationHelpers.getCopperOxidizationStages(), 4);
        createOxidizableStonecutterRecipes(exporter,
                "minecraft", "copper_block",
                ShuckleQOL.MOD_ID, "chiseled_copper",
                Blocks.COPPER_BLOCK.asItem(), ModOxidizationHelpers.getCopperOxidizationStages(), 4);
        createOxidizableStonecutterRecipes(exporter,
                "minecraft", "cut_copper",
                ShuckleQOL.MOD_ID, "chiseled_copper",
                Blocks.COPPER_BLOCK.asItem(), ModOxidizationHelpers.getCopperOxidizationStages(), 1);

        //tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_PICKAXE, 1)
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .input('#', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_AXE, 1)
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .input('#', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_SHOVEL, 1)
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .input('#', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_SWORD, 1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .input('#', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_HOE, 1)
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .input('#', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        //armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModItems.COPPER_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

        //smelting
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE,
                                ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD, ModItems.COPPER_HOE,
                                ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS),
                        RecipeCategory.MISC, ModItems.COPPER_NUGGET,
                        0.1f,200)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "copper_nuggets_from_tools_armor_smelting"));

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE,
                                ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD, ModItems.COPPER_HOE,
                                ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS),
                        RecipeCategory.MISC, ModItems.COPPER_NUGGET,
                        0.1f,100)
                .criterion(hasItem(Items.COPPER_INGOT),
                        conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "copper_nuggets_from_tools_armor_blasting"));
        //endregion
        //region Tuff
        //tuff
        createSlabStairWallItemSetRecipes(exporter,
                "minecraft", "tuff",
                ModBackportBlocks.TUFF_SLAB, ModBackportBlocks.TUFF_STAIRS,
                ModBackportBlocks.TUFF_WALL, true);

        //polished tuff
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.POLISHED_TUFF, 4)
                .pattern("##")
                .pattern("##")
                .input('#', Items.TUFF)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "polished_tuff",
                ModBackportBlocks.POLISHED_TUFF_SLAB, ModBackportBlocks.POLISHED_TUFF_STAIRS,
                ModBackportBlocks.POLISHED_TUFF_WALL, true);

        //tuff bricks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.TUFF_BRICKS, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBackportBlocks.POLISHED_TUFF)
                .criterion(hasItem(ModBackportBlocks.POLISHED_TUFF),
                        conditionsFromItem(ModBackportBlocks.POLISHED_TUFF)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "tuff_bricks",
                ModBackportBlocks.TUFF_BRICK_SLAB, ModBackportBlocks.TUFF_BRICK_STAIRS,
                ModBackportBlocks.TUFF_BRICK_WALL, true);

        //chiseled tuff
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CHISELED_TUFF, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBackportBlocks.TUFF_SLAB)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CHISELED_TUFF_BRICKS, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBackportBlocks.TUFF_BRICK_SLAB)
                .criterion(hasItem(ModBackportBlocks.TUFF_BRICKS),
                        conditionsFromItem(ModBackportBlocks.TUFF_BRICKS)).offerTo(exporter);

        //stonecutter recipes
        //from tuff
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.TUFF),
                        RecipeCategory.MISC, ModBackportBlocks.POLISHED_TUFF, 1)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "polished_tuff_from_tuff_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier("minecraft", "tuff"), "polished_tuff", "from_tuff_",
                ModBackportBlocks.POLISHED_TUFF_SLAB, ModBackportBlocks.POLISHED_TUFF_STAIRS,
                ModBackportBlocks.POLISHED_TUFF_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.TUFF),
                        RecipeCategory.MISC, ModBackportBlocks.TUFF_BRICKS, 1)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "tuff_bricks_from_tuff_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier("minecraft", "tuff"), "tuff_brick", "from_tuff_",
                ModBackportBlocks.TUFF_BRICK_SLAB, ModBackportBlocks.TUFF_BRICK_STAIRS,
                ModBackportBlocks.TUFF_BRICK_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.TUFF),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_TUFF, 1)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_tuff_from_tuff_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.TUFF),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_TUFF_BRICKS, 1)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_tuff_bricks_from_tuff_stonecutting"));

        //from polished tuff
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.POLISHED_TUFF),
                        RecipeCategory.MISC, ModBackportBlocks.TUFF_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.POLISHED_TUFF),
                        conditionsFromItem(ModBackportBlocks.POLISHED_TUFF))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "tuff_bricks_from_polished_tuff_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "polished_tuff"), "tuff_brick", "from_polished_tuff_",
                ModBackportBlocks.TUFF_BRICK_SLAB, ModBackportBlocks.TUFF_BRICK_STAIRS,
                ModBackportBlocks.TUFF_BRICK_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.POLISHED_TUFF),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_TUFF_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.POLISHED_TUFF),
                        conditionsFromItem(ModBackportBlocks.POLISHED_TUFF))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_tuff_bricks_from_polished_tuff_stonecutting"));

        //from tuff bricks
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.TUFF_BRICKS),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_TUFF_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.TUFF_BRICKS),
                        conditionsFromItem(ModBackportBlocks.TUFF_BRICKS))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_tuff_bricks_from_tuff_bricks_stonecutting"));
        //endregion
        //region Cinnabar
        //cinnabar
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CINNABAR, 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .input('#', Items.TUFF)
                .input('D', Items.RED_DYE)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "cinnabar",
                ModBackportBlocks.CINNABAR_SLAB, ModBackportBlocks.CINNABAR_STAIRS,
                ModBackportBlocks.CINNABAR_WALL, true);

        //polished cinnabar
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.POLISHED_CINNABAR, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBackportBlocks.CINNABAR)
                .criterion(hasItem(ModBackportBlocks.CINNABAR),
                        conditionsFromItem(ModBackportBlocks.CINNABAR)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "polished_cinnabar",
                ModBackportBlocks.POLISHED_CINNABAR_SLAB, ModBackportBlocks.POLISHED_CINNABAR_STAIRS,
                ModBackportBlocks.POLISHED_CINNABAR_WALL, true);

        //cinnabar bricks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CINNABAR_BRICKS, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBackportBlocks.POLISHED_CINNABAR)
                .criterion(hasItem(ModBackportBlocks.POLISHED_CINNABAR),
                        conditionsFromItem(ModBackportBlocks.POLISHED_CINNABAR)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "cinnabar_bricks",
                ModBackportBlocks.CINNABAR_BRICK_SLAB, ModBackportBlocks.CINNABAR_BRICK_STAIRS,
                ModBackportBlocks.CINNABAR_BRICK_WALL, true);

        //chiseled cinnabar
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CHISELED_CINNABAR, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBackportBlocks.CINNABAR_SLAB)
                .criterion(hasItem(ModBackportBlocks.CINNABAR),
                        conditionsFromItem(ModBackportBlocks.CINNABAR)).offerTo(exporter);

        //stonecutter recipes
        //from cinnabar
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.CINNABAR),
                        RecipeCategory.MISC, ModBackportBlocks.POLISHED_CINNABAR, 1)
                .criterion(hasItem(ModBackportBlocks.CINNABAR),
                        conditionsFromItem(ModBackportBlocks.CINNABAR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "polished_cinnabar_from_cinnabar_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "cinnabar"), "polished_cinnabar", "from_cinnabar_",
                ModBackportBlocks.POLISHED_CINNABAR_SLAB, ModBackportBlocks.POLISHED_CINNABAR_STAIRS,
                ModBackportBlocks.POLISHED_CINNABAR_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.CINNABAR),
                        RecipeCategory.MISC, ModBackportBlocks.CINNABAR_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.CINNABAR),
                        conditionsFromItem(ModBackportBlocks.CINNABAR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "cinnabar_bricks_from_cinnabar_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "cinnabar"), "cinnabar_brick", "from_cinnabar_",
                ModBackportBlocks.CINNABAR_BRICK_SLAB, ModBackportBlocks.CINNABAR_BRICK_STAIRS,
                ModBackportBlocks.CINNABAR_BRICK_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.CINNABAR),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_CINNABAR, 1)
                .criterion(hasItem(ModBackportBlocks.CINNABAR),
                        conditionsFromItem(ModBackportBlocks.CINNABAR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_cinnabar_from_cinnabar_stonecutting"));

        //from polished cinnabar
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.POLISHED_CINNABAR),
                        RecipeCategory.MISC, ModBackportBlocks.CINNABAR_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.POLISHED_CINNABAR),
                        conditionsFromItem(ModBackportBlocks.POLISHED_CINNABAR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "cinnabar_bricks_from_polished_cinnabar_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "polished_cinnabar"), "cinnabar_brick", "from_polished_cinnabar_",
                ModBackportBlocks.CINNABAR_BRICK_SLAB, ModBackportBlocks.CINNABAR_BRICK_STAIRS,
                ModBackportBlocks.CINNABAR_BRICK_WALL);
        //endregion
        //region Sulfur
        //sulfur
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.SULFUR, 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .input('#', Items.TUFF)
                .input('D', Items.YELLOW_DYE)
                .criterion(hasItem(Items.TUFF),
                        conditionsFromItem(Items.TUFF)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "sulfur",
                ModBackportBlocks.SULFUR_SLAB, ModBackportBlocks.SULFUR_STAIRS,
                ModBackportBlocks.SULFUR_WALL, true);

        //polished sulfur
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.POLISHED_SULFUR, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBackportBlocks.SULFUR)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "polished_sulfur",
                ModBackportBlocks.POLISHED_SULFUR_SLAB, ModBackportBlocks.POLISHED_SULFUR_STAIRS,
                ModBackportBlocks.POLISHED_SULFUR_WALL, true);

        //sulfur bricks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.SULFUR_BRICKS, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBackportBlocks.POLISHED_SULFUR)
                .criterion(hasItem(ModBackportBlocks.POLISHED_SULFUR),
                        conditionsFromItem(ModBackportBlocks.POLISHED_SULFUR)).offerTo(exporter);
        createSlabStairWallItemSetRecipes(exporter,
                ShuckleQOL.MOD_ID, "sulfur_bricks",
                ModBackportBlocks.SULFUR_BRICK_SLAB, ModBackportBlocks.SULFUR_BRICK_STAIRS,
                ModBackportBlocks.SULFUR_BRICK_WALL, true);

        //chiseled sulfur
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.CHISELED_SULFUR, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBackportBlocks.SULFUR_SLAB)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.POTENT_SULFUR, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModBackportBlocks.SULFUR)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR)).offerTo(exporter);

        //sulfur spike
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.SULFUR_SPIKE, 4)
                .input(ModBackportBlocks.SULFUR)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        ModBackportBlocks.SULFUR, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModBackportBlocks.SULFUR_SPIKE)
                .criterion(hasItem(ModBackportBlocks.SULFUR_SPIKE),
                        conditionsFromItem(ModBackportBlocks.SULFUR_SPIKE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "sulfur_from_sulfur_spike"));

        //stonecutter recipes
        //from sulfur
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.SULFUR),
                        RecipeCategory.MISC, ModBackportBlocks.POLISHED_SULFUR, 1)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "polished_sulfur_from_sulfur_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "sulfur"), "polished_sulfur", "from_sulfur_",
                ModBackportBlocks.POLISHED_SULFUR_SLAB, ModBackportBlocks.POLISHED_SULFUR_STAIRS,
                ModBackportBlocks.POLISHED_SULFUR_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.SULFUR),
                        RecipeCategory.MISC, ModBackportBlocks.SULFUR_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "sulfur_bricks_from_sulfur_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "sulfur"), "sulfur_brick", "from_sulfur_",
                ModBackportBlocks.SULFUR_BRICK_SLAB, ModBackportBlocks.SULFUR_BRICK_STAIRS,
                ModBackportBlocks.SULFUR_BRICK_WALL);

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.SULFUR),
                        RecipeCategory.MISC, ModBackportBlocks.CHISELED_SULFUR, 1)
                .criterion(hasItem(ModBackportBlocks.SULFUR),
                        conditionsFromItem(ModBackportBlocks.SULFUR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "chiseled_sulfur_from_sulfur_stonecutting"));

        //from polished sulfur
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBackportBlocks.POLISHED_SULFUR),
                        RecipeCategory.MISC, ModBackportBlocks.SULFUR_BRICKS, 1)
                .criterion(hasItem(ModBackportBlocks.POLISHED_SULFUR),
                        conditionsFromItem(ModBackportBlocks.POLISHED_SULFUR))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "sulfur_bricks_from_polished_sulfur_stonecutting"));
        createSlabStairWallItemSetStonecutterRecipes(exporter,
                new Identifier(ShuckleQOL.MOD_ID, "polished_sulfur"), "sulfur_brick", "from_polished_sulfur_",
                ModBackportBlocks.SULFUR_BRICK_SLAB, ModBackportBlocks.SULFUR_BRICK_STAIRS,
                ModBackportBlocks.SULFUR_BRICK_WALL);
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
                .input('C', TagKey.of(RegistryKeys.ITEM, new Identifier("minecraft", "wool_carpets")))
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
                .pattern("SLS")
                .pattern("L#L")
                .pattern("SLS")
                .input('#', ModItems.INVIS_CATALYST)
                .input('S', Items.STICK)
                .input('L', Items.LEATHER)
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
                .input('V', Items.ECHO_SHARD)
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
        //region Shuckle Tools
        LegacySmithingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PICKAXE_TEMPLATE),
                        Ingredient.ofItems(ModItems.SWOLE_SHUCKLE_DNA),
                        RecipeCategory.MISC, ModItems.SHUCKLE_PICKAXE)
                .criterion(hasItem(ModItems.SWOLE_SHUCKLE_DNA),
                        conditionsFromItem(ModItems.SWOLE_SHUCKLE_DNA))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "shuckle_pickaxe_smithing"));

        LegacySmithingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.AXE_TEMPLATE),
                        Ingredient.ofItems(ModItems.SWOLE_SHUCKLE_DNA),
                        RecipeCategory.MISC, ModItems.SHUCKLE_AXE)
                .criterion(hasItem(ModItems.SWOLE_SHUCKLE_DNA),
                        conditionsFromItem(ModItems.SWOLE_SHUCKLE_DNA))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "shuckle_axe_smithing"));

        LegacySmithingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.SHOVEL_TEMPLATE),
                        Ingredient.ofItems(ModItems.SWOLE_SHUCKLE_DNA),
                        RecipeCategory.MISC, ModItems.SHUCKLE_SHOVEL)
                .criterion(hasItem(ModItems.SWOLE_SHUCKLE_DNA),
                        conditionsFromItem(ModItems.SWOLE_SHUCKLE_DNA))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "shuckle_shovel_smithing"));

        LegacySmithingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.HOE_TEMPLATE),
                        Ingredient.ofItems(ModItems.SWOLE_SHUCKLE_DNA),
                        RecipeCategory.MISC, ModItems.SHUCKLE_HOE)
                .criterion(hasItem(ModItems.SWOLE_SHUCKLE_DNA),
                        conditionsFromItem(ModItems.SWOLE_SHUCKLE_DNA))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "shuckle_hoe_smithing"));
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
        //tinted glass pane
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TINTED_GLASS_PANE, 16)
                .pattern("###")
                .pattern("###")
                .input('#', Blocks.TINTED_GLASS)
                .criterion(hasItem(Blocks.TINTED_GLASS),
                        conditionsFromItem(Blocks.TINTED_GLASS)).offerTo(exporter);
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
        //region BYG
        //blue therium
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        new Identifier(ShuckleQOL.MOD_ID, "therium_glass"), 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .inputItem('#', new Identifier("byg", "therium_glass"))
                .inputItem('D', new Identifier("minecraft", "light_blue_dye"))
                .criterion(hasItem(Items.LIGHT_BLUE_DYE),
                        conditionsFromItem(Items.LIGHT_BLUE_DYE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "therium_glass_dyeing"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.THERIUM_GLASS_PANE, 16)
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.THERIUM_GLASS)
                .criterion(hasItem(ModBlocks.THERIUM_GLASS),
                        conditionsFromItem(ModBlocks.THERIUM_GLASS)).offerTo(exporter);
        //winter cyclamen
        IdentifiersShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("byg", "winter_cyclamen"), 1)
                .inputItem(new Identifier("byg", "winter_succulent"))
                .inputItem(Registries.ITEM.getId(Items.CYAN_DYE))
                .criterion(hasItem(Items.CYAN_DYE),
                        conditionsFromItem(Items.CYAN_DYE))
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
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, new Identifier("byg", "packed_black_ice"), 8)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .inputItem('#', Registries.ITEM.getId(Items.PACKED_ICE))
                .inputItem('D', Registries.ITEM.getId(Items.BLACK_DYE))
                .criterion(hasItem(Items.PACKED_ICE),
                        conditionsFromItem(Items.PACKED_ICE))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "packed_black_ice_from_packed_ice"));
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
                                          Block shelfItem,
                                          Item signItem,
                                          Item hangingSignItem
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

        //shelf
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, shelfItem, 6)
                .pattern("###")
                .pattern("   ")
                .pattern("###")
                .input('#', strippedLogBlock)
                .criterion(hasItem(strippedLogBlock),
                        conditionsFromItem(strippedLogBlock)).offerTo(exporter);

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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hangingSignItem, 6)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .input('#', strippedLogBlock)
                .input('C', Items.CHAIN)
                .criterion(hasItem(strippedLogBlock),
                        conditionsFromItem(strippedLogBlock)).offerTo(exporter);
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
                .criterion(hasItem(Registries.BLOCK.get(baseItem)),
                        conditionsFromItem(Registries.BLOCK.get(baseItem)))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_slab"));
        //stairs recipe
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(stairsBlock), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .inputItem('#', baseItem)
                .criterion(hasItem(Registries.BLOCK.get(baseItem)),
                        conditionsFromItem(Registries.BLOCK.get(baseItem)))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_stairs"));
        //wall recipe
        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.BLOCK.getId(wallBlock), 6)
                .pattern("###")
                .pattern("###")
                .inputItem('#', baseItem)
                .criterion(hasItem(Registries.BLOCK.get(baseItem)),
                        conditionsFromItem(Registries.BLOCK.get(baseItem)))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, baseBlockId + "_wall"));

        if(addStonecutterRecipes){
            createSlabStairWallItemSetStonecutterRecipes(exporter,
                    baseItem, baseBlockId, "",
                    slabBlock, stairsBlock, wallBlock);
        }
    }

    private void createSlabStairWallItemSetStonecutterRecipes(Consumer<RecipeJsonProvider> exporter,
                                                   Identifier baseItem,
                                                   String baseBlockId,
                                                   String extraIdText,
                                                   Block slabBlock,
                                                   Block stairsBlock,
                                                   Block wallBlock) {
        //slab stonecutting
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(baseItem,
                        RecipeCategory.MISC, Registries.BLOCK.getId(slabBlock), 2)
                .criterion(hasItem(Registries.BLOCK.get(baseItem)),
                        conditionsFromItem(Registries.BLOCK.get(baseItem)))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID,
                        baseBlockId + "_slab_" + extraIdText + "stonecutting"));
        //stairs stonecutting
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(baseItem,
                        RecipeCategory.MISC, Registries.BLOCK.getId(stairsBlock), 1)
                .criterion(hasItem(Registries.BLOCK.get(baseItem)),
                        conditionsFromItem(Registries.BLOCK.get(baseItem)))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID,
                        baseBlockId + "_stairs_" + extraIdText + "stonecutting"));
        //wall stonecutting
        IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(baseItem,
                        RecipeCategory.MISC, Registries.BLOCK.getId(wallBlock), 1)
                .criterion(hasItem(Registries.BLOCK.get(baseItem)),
                        conditionsFromItem(Registries.BLOCK.get(baseItem)))
                .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID,
                        baseBlockId + "_wall_" + extraIdText + "stonecutting"));
    }

    private void createShelfRecipe(Consumer<RecipeJsonProvider> exporter,
                                   String inputNamespace,
                                   String inputBlock,
                                   String outputBlock) {
        Identifier shelfItem = new Identifier(ShuckleQOL.MOD_ID, outputBlock);

        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, shelfItem, 6)
                .pattern("###")
                .pattern("   ")
                .pattern("###")
                .inputItem('#', new Identifier(inputNamespace, inputBlock))
                .criterion(hasItem(Registries.BLOCK.get(shelfItem)),
                        conditionsFromItem(Registries.BLOCK.get(shelfItem)))
                .offerTo(exporter, shelfItem);
    }

    private void createHangingSignRecipe(Consumer<RecipeJsonProvider> exporter,
                                   String inputNamespace,
                                   String inputBlock,
                                   String outputBlock) {
        Identifier hangingSignItem = new Identifier(ShuckleQOL.MOD_ID, outputBlock);

        IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hangingSignItem, 6)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .inputItem('#', new Identifier(inputNamespace, inputBlock))
                .inputItem('C', new Identifier("minecraft", "chain"))
                .criterion(hasItem(Registries.BLOCK.get(hangingSignItem)),
                        conditionsFromItem(Registries.BLOCK.get(hangingSignItem)))
                .offerTo(exporter, hangingSignItem);
    }

    private void createOxidizableRecipes(Consumer<RecipeJsonProvider> exporter,
                                         String inputNamespace,
                                         String inputBaseBlockId,
                                         String outputNamespace,
                                         String outputBaseBlockId,
                                         List<String> pattern,
                                         @Nullable Map<Character, Identifier> itemInputs,
                                         Item recipeUnlockItem,
                                         String[] oxidizationStages,
                                         int outputCount) {
        String[] WAX_STAGES = {
                "", "waxed_"
        };

        IdentifiersShapedRecipeJsonBuilder recipeBuilder;

        for (String oxidation : oxidizationStages) {
            for (String wax : WAX_STAGES) {
                recipeBuilder = IdentifiersShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        new Identifier(outputNamespace, wax + oxidation + outputBaseBlockId), outputCount);

                for (String line : pattern) {
                    recipeBuilder.pattern(line);
                }

                recipeBuilder.inputItem('#', new Identifier(inputNamespace, wax + oxidation + inputBaseBlockId));

                if (itemInputs != null){
                    for (Map.Entry<Character, Identifier> item : itemInputs.entrySet()) {
                        recipeBuilder.inputItem(item.getKey(), item.getValue());
                    }
                }

                recipeBuilder.criterion(hasItem(recipeUnlockItem), conditionsFromItem(recipeUnlockItem));
                recipeBuilder.offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, wax + oxidation + outputBaseBlockId));
            }

            if (inputBaseBlockId.equals("copper_block") && oxidation.isEmpty()){
                inputBaseBlockId = "copper";
            }
        }
    }

    private void createWaxedOxidizableRecipes(Consumer<RecipeJsonProvider> exporter,
                                              String namespace,
                                              String baseBlockId,
                                              Item recipeUnlockItem,
                                              String[] oxidizationStages) {
        for (String oxidation : oxidizationStages) {
            IdentifiersShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                    new Identifier(namespace, "waxed_" + oxidation + baseBlockId), 1)
                    .inputItem(new Identifier(namespace, oxidation + baseBlockId))
                    .inputItem(new Identifier("minecraft", "honeycomb"))
                    .criterion(hasItem(recipeUnlockItem),
                            conditionsFromItem(recipeUnlockItem))
                    .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, "waxed_" + oxidation + baseBlockId + "_with_honeycomb"));
        }
    }

    private void createOxidizableStonecutterRecipes(Consumer<RecipeJsonProvider> exporter,
                                                          String inputNamespace,
                                                          String inputBaseBlockId,
                                                          String outputNamespace,
                                                          String outputBaseBlockId,
                                                          Item recipeUnlockItem,
                                                          String[] oxidizationStages,
                                                          int stonecutterOutputCount) {
        String[] WAX_STAGES = {
                "", "waxed_"
        };

        for (String oxidation : oxidizationStages) {
            for (String wax : WAX_STAGES) {
                IdentifiersSingleItemRecipeJsonBuilder.createStonecuttingFromItem(new Identifier(inputNamespace, wax + oxidation + inputBaseBlockId),
                                RecipeCategory.MISC,
                                new Identifier(outputNamespace, wax + oxidation + outputBaseBlockId), stonecutterOutputCount)
                        .criterion(hasItem(recipeUnlockItem),
                                conditionsFromItem(recipeUnlockItem))
                        .offerTo(exporter, new Identifier(ShuckleQOL.MOD_ID, wax + oxidation + outputBaseBlockId + "_from_" + inputBaseBlockId + "_stonecutting"));
            }

            if (inputBaseBlockId.equals("copper_block") && oxidation.isEmpty()){
                inputBaseBlockId = "copper";
            }
        }
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
