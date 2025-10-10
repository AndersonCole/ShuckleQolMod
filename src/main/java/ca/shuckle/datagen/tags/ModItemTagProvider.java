package ca.shuckle.datagen.tags;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //region Vanilla Tags
        //region Wood Set Tags
        //logs
        getOrCreateTagBuilder(ItemTags.LOGS)
                .addTag(ModTags.Items.CHERRY_LOGS)
                .addTag(ModTags.Items.PALE_OAK_LOGS);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(ModTags.Items.CHERRY_LOGS)
                .addTag(ModTags.Items.PALE_OAK_LOGS);
        //leaves
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBackportBlocks.CHERRY_LEAVES.asItem())
                .add(ModBackportBlocks.PALE_OAK_LEAVES.asItem());
        //saplings
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBackportBlocks.CHERRY_SAPLING.asItem())
                .add(ModBackportBlocks.PALE_OAK_SAPLING.asItem());
        //planks
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBackportBlocks.CHERRY_PLANKS.asItem())
                .add(ModBackportBlocks.BAMBOO_PLANKS.asItem())
                .add(ModBackportBlocks.PALE_OAK_PLANKS.asItem());
        //wood slabs
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBackportBlocks.CHERRY_SLAB.asItem())
                .add(ModBackportBlocks.BAMBOO_SLAB.asItem())
                .add(ModBackportBlocks.PALE_OAK_SLAB.asItem());
        //wood stairs
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBackportBlocks.CHERRY_STAIRS.asItem())
                .add(ModBackportBlocks.BAMBOO_STAIRS.asItem())
                .add(ModBackportBlocks.PALE_OAK_STAIRS.asItem());
        //fences
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBackportBlocks.CHERRY_FENCE.asItem())
                .add(ModBackportBlocks.BAMBOO_FENCE.asItem())
                .add(ModBackportBlocks.PALE_OAK_FENCE.asItem());
        //fence gates
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBackportBlocks.CHERRY_FENCE_GATE.asItem())
                .add(ModBackportBlocks.BAMBOO_FENCE_GATE.asItem())
                .add(ModBackportBlocks.PALE_OAK_FENCE_GATE.asItem());
        //wooden buttons
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBackportBlocks.CHERRY_BUTTON.asItem())
                .add(ModBackportBlocks.BAMBOO_BUTTON.asItem())
                .add(ModBackportBlocks.PALE_OAK_BUTTON.asItem());
        //wooden pressure plates
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBackportBlocks.CHERRY_PRESSURE_PLATE.asItem())
                .add(ModBackportBlocks.BAMBOO_PRESSURE_PLATE.asItem())
                .add(ModBackportBlocks.PALE_OAK_PRESSURE_PLATE.asItem());
        //signs
        getOrCreateTagBuilder(ItemTags.SIGNS)
                .add(ModItems.CHERRY_SIGN)
                .add(ModItems.BAMBOO_SIGN)
                .add(ModItems.PALE_OAK_SIGN)
                .add(ModItems.EBONY_SIGN)
                .add(ModItems.INVIS_SIGN);
        //endregion
        //region Nature Block Tags
        //dirt
        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(ModBackportBlocks.PALE_MOSS_BLOCK.asItem());
        //flowers
        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .addTag(ModTags.Items.WILDFLOWERS)
                .add(ModBackportBlocks.CHERRY_LEAVES.asItem())
                .add(ModBackportBlocks.PINK_PETALS.asItem());
        //endregion
        //slabs
        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBackportBlocks.PACKED_MUD_SLAB.asItem())
                .add(ModBackportBlocks.BAMBOO_MOSAIC_SLAB.asItem())
                .add(ModBackportBlocks.RESIN_BRICK_SLAB.asItem())
                .add(ModBlocks.ANCIENT_STONE_SLAB.asItem())
                .add(ModBlocks.BLACK_SANDSTONE_SLAB.asItem())
                .add(ModBlocks.BLACK_CUT_SANDSTONE_SLAB.asItem())
                .add(ModBlocks.BLACK_SMOOTH_SANDSTONE_SLAB.asItem());
        //stairs
        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBackportBlocks.PACKED_MUD_STAIRS.asItem())
                .add(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS.asItem())
                .add(ModBackportBlocks.RESIN_BRICK_STAIRS.asItem())
                .add(ModBlocks.ANCIENT_STONE_STAIRS.asItem())
                .add(ModBlocks.BLACK_SANDSTONE_STAIRS.asItem())
                .add(ModBlocks.BLACK_CUT_SANDSTONE_STAIRS.asItem())
                .add(ModBlocks.BLACK_SMOOTH_SANDSTONE_STAIRS.asItem());
        //walls
        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBackportBlocks.PACKED_MUD_WALL.asItem())
                .add(ModBackportBlocks.RESIN_BRICK_WALL.asItem())
                .add(ModBlocks.ANCIENT_STONE_WALL.asItem())
                .add(ModBlocks.BLACK_SANDSTONE_WALL.asItem())
                .add(ModBlocks.BLACK_CUT_SANDSTONE_WALL.asItem())
                .add(ModBlocks.BLACK_SMOOTH_SANDSTONE_WALL.asItem());
        //endregion
        //region Shuckle Tags
        //region Backport
        getOrCreateTagBuilder(ModTags.Items.CHERRY_LOGS)
                .add(ModBackportBlocks.CHERRY_LOG.asItem())
                .add(ModBackportBlocks.STRIPPED_CHERRY_LOG.asItem())
                .add(ModBackportBlocks.CHERRY_WOOD.asItem())
                .add(ModBackportBlocks.STRIPPED_CHERRY_WOOD.asItem());
        getOrCreateTagBuilder(ModTags.Items.BAMBOO_BLOCKS)
                .add(ModBackportBlocks.BAMBOO_BLOCK.asItem())
                .add(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.PALE_OAK_LOGS)
                .add(ModBackportBlocks.PALE_OAK_LOG.asItem())
                .add(ModBackportBlocks.STRIPPED_PALE_OAK_LOG.asItem())
                .add(ModBackportBlocks.PALE_OAK_WOOD.asItem())
                .add(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD.asItem());
        getOrCreateTagBuilder(ModTags.Items.WILDFLOWERS)
                .add(ModBackportBlocks.WILDFLOWERS.asItem())
                .add(ModBlocks.WILDFLOWERS_RED_BLUE.asItem());
        getOrCreateTagBuilder(ModTags.Items.LEAF_LITTER)
                .add(ModBackportBlocks.LEAF_LITTER.asItem())
                .add(ModBlocks.LEAF_LITTER_OAK.asItem());
        //endregion
        //region Shuckle
        getOrCreateTagBuilder(ModTags.Items.CONVERTIBLE_DIRT)
                .add(Blocks.DIRT.asItem())
                .add(Blocks.COARSE_DIRT.asItem())
                .add(Blocks.ROOTED_DIRT.asItem());
        getOrCreateTagBuilder(ModTags.Items.RAW_ORES)
                .add(Items.RAW_COPPER)
                .add(Items.RAW_IRON)
                .add(Items.RAW_GOLD);
        //endregion
        //region Other Mods
        getOrCreateTagBuilder(ModTags.Items.FOSSIL_LOGS)
                .addOptional(new Identifier("fossil", "calamites_log"))
                .addOptional(new Identifier("fossil", "stripped_calamites_log"))
                .addOptional(new Identifier("fossil", "cordaites_log"))
                .addOptional(new Identifier("fossil", "stripped_cordaites_log"))
                .addOptional(new Identifier("fossil", "palm_log"))
                .addOptional(new Identifier("fossil", "stripped_palm_log"))
                .addOptional(new Identifier("fossil", "sigillaria_log"))
                .addOptional(new Identifier("fossil", "stripped_sigillaria_log"))
                .addOptional(new Identifier("fossil", "tempskya_log"))
                .addOptional(new Identifier("fossil", "stripped_tempskya_log"));
        //endregion
        //region Universal Dyeing
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_BEDS)
                .add(Items.BLACK_BED)
                .add(Items.BLUE_BED)
                .add(Items.BROWN_BED)
                .add(Items.CYAN_BED)
                .add(Items.GRAY_BED)
                .add(Items.GREEN_BED)
                .add(Items.LIGHT_BLUE_BED)
                .add(Items.LIGHT_GRAY_BED)
                .add(Items.LIME_BED)
                .add(Items.MAGENTA_BED)
                .add(Items.ORANGE_BED)
                .add(Items.PINK_BED)
                .add(Items.PURPLE_BED)
                .add(Items.RED_BED)
                .add(Items.WHITE_BED)
                .add(Items.YELLOW_BED);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_CANDLES)
                .add(Items.CANDLE)
                .add(Items.BLACK_CANDLE)
                .add(Items.BLUE_CANDLE)
                .add(Items.BROWN_CANDLE)
                .add(Items.CYAN_CANDLE)
                .add(Items.GRAY_CANDLE)
                .add(Items.GREEN_CANDLE)
                .add(Items.LIGHT_BLUE_CANDLE)
                .add(Items.LIGHT_GRAY_CANDLE)
                .add(Items.LIME_CANDLE)
                .add(Items.MAGENTA_CANDLE)
                .add(Items.ORANGE_CANDLE)
                .add(Items.PINK_CANDLE)
                .add(Items.PURPLE_CANDLE)
                .add(Items.RED_CANDLE)
                .add(Items.WHITE_CANDLE)
                .add(Items.YELLOW_CANDLE);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_CARPETS)
                .add(Items.BLACK_CARPET)
                .add(Items.BLUE_CARPET)
                .add(Items.BROWN_CARPET)
                .add(Items.CYAN_CARPET)
                .add(Items.GRAY_CARPET)
                .add(Items.GREEN_CARPET)
                .add(Items.LIGHT_BLUE_CARPET)
                .add(Items.LIGHT_GRAY_CARPET)
                .add(Items.LIME_CARPET)
                .add(Items.MAGENTA_CARPET)
                .add(Items.ORANGE_CARPET)
                .add(Items.PINK_CARPET)
                .add(Items.PURPLE_CARPET)
                .add(Items.RED_CARPET)
                .add(Items.WHITE_CARPET)
                .add(Items.YELLOW_CARPET);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_CONCRETE)
                .add(Items.BLACK_CONCRETE)
                .add(Items.BLUE_CONCRETE)
                .add(Items.BROWN_CONCRETE)
                .add(Items.CYAN_CONCRETE)
                .add(Items.GRAY_CONCRETE)
                .add(Items.GREEN_CONCRETE)
                .add(Items.LIGHT_BLUE_CONCRETE)
                .add(Items.LIGHT_GRAY_CONCRETE)
                .add(Items.LIME_CONCRETE)
                .add(Items.MAGENTA_CONCRETE)
                .add(Items.ORANGE_CONCRETE)
                .add(Items.PINK_CONCRETE)
                .add(Items.PURPLE_CONCRETE)
                .add(Items.RED_CONCRETE)
                .add(Items.WHITE_CONCRETE)
                .add(Items.YELLOW_CONCRETE);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_CONCRETE_POWDER)
                .add(Items.BLACK_CONCRETE_POWDER)
                .add(Items.BLUE_CONCRETE_POWDER)
                .add(Items.BROWN_CONCRETE_POWDER)
                .add(Items.CYAN_CONCRETE_POWDER)
                .add(Items.GRAY_CONCRETE_POWDER)
                .add(Items.GREEN_CONCRETE_POWDER)
                .add(Items.LIGHT_BLUE_CONCRETE_POWDER)
                .add(Items.LIGHT_GRAY_CONCRETE_POWDER)
                .add(Items.LIME_CONCRETE_POWDER)
                .add(Items.MAGENTA_CONCRETE_POWDER)
                .add(Items.ORANGE_CONCRETE_POWDER)
                .add(Items.PINK_CONCRETE_POWDER)
                .add(Items.PURPLE_CONCRETE_POWDER)
                .add(Items.RED_CONCRETE_POWDER)
                .add(Items.WHITE_CONCRETE_POWDER)
                .add(Items.YELLOW_CONCRETE_POWDER);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_GLASS)
                .add(Items.GLASS)
                .add(Items.BLACK_STAINED_GLASS)
                .add(Items.BLUE_STAINED_GLASS)
                .add(Items.BROWN_STAINED_GLASS)
                .add(Items.CYAN_STAINED_GLASS)
                .add(Items.GRAY_STAINED_GLASS)
                .add(Items.GREEN_STAINED_GLASS)
                .add(Items.LIGHT_BLUE_STAINED_GLASS)
                .add(Items.LIGHT_GRAY_STAINED_GLASS)
                .add(Items.LIME_STAINED_GLASS)
                .add(Items.MAGENTA_STAINED_GLASS)
                .add(Items.ORANGE_STAINED_GLASS)
                .add(Items.PINK_STAINED_GLASS)
                .add(Items.PURPLE_STAINED_GLASS)
                .add(Items.RED_STAINED_GLASS)
                .add(Items.WHITE_STAINED_GLASS)
                .add(Items.YELLOW_STAINED_GLASS);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_GLASS_PANES)
                .add(Items.GLASS_PANE)
                .add(Items.BLACK_STAINED_GLASS_PANE)
                .add(Items.BLUE_STAINED_GLASS_PANE)
                .add(Items.BROWN_STAINED_GLASS_PANE)
                .add(Items.CYAN_STAINED_GLASS_PANE)
                .add(Items.GRAY_STAINED_GLASS_PANE)
                .add(Items.GREEN_STAINED_GLASS_PANE)
                .add(Items.LIGHT_BLUE_STAINED_GLASS_PANE)
                .add(Items.LIGHT_GRAY_STAINED_GLASS_PANE)
                .add(Items.LIME_STAINED_GLASS_PANE)
                .add(Items.MAGENTA_STAINED_GLASS_PANE)
                .add(Items.ORANGE_STAINED_GLASS_PANE)
                .add(Items.PINK_STAINED_GLASS_PANE)
                .add(Items.PURPLE_STAINED_GLASS_PANE)
                .add(Items.RED_STAINED_GLASS_PANE)
                .add(Items.WHITE_STAINED_GLASS_PANE)
                .add(Items.YELLOW_STAINED_GLASS_PANE);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_TERRACOTTA)
                .add(Items.TERRACOTTA)
                .add(Items.BLACK_TERRACOTTA)
                .add(Items.BLUE_TERRACOTTA)
                .add(Items.BROWN_TERRACOTTA)
                .add(Items.CYAN_TERRACOTTA)
                .add(Items.GRAY_TERRACOTTA)
                .add(Items.GREEN_TERRACOTTA)
                .add(Items.LIGHT_BLUE_TERRACOTTA)
                .add(Items.LIGHT_GRAY_TERRACOTTA)
                .add(Items.LIME_TERRACOTTA)
                .add(Items.MAGENTA_TERRACOTTA)
                .add(Items.ORANGE_TERRACOTTA)
                .add(Items.PINK_TERRACOTTA)
                .add(Items.PURPLE_TERRACOTTA)
                .add(Items.RED_TERRACOTTA)
                .add(Items.WHITE_TERRACOTTA)
                .add(Items.YELLOW_TERRACOTTA);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_GLAZED_TERRACOTTA)
                .add(Items.BLACK_GLAZED_TERRACOTTA)
                .add(Items.BLUE_GLAZED_TERRACOTTA)
                .add(Items.BROWN_GLAZED_TERRACOTTA)
                .add(Items.CYAN_GLAZED_TERRACOTTA)
                .add(Items.GRAY_GLAZED_TERRACOTTA)
                .add(Items.GREEN_GLAZED_TERRACOTTA)
                .add(Items.LIGHT_BLUE_GLAZED_TERRACOTTA)
                .add(Items.LIGHT_GRAY_GLAZED_TERRACOTTA)
                .add(Items.LIME_GLAZED_TERRACOTTA)
                .add(Items.MAGENTA_GLAZED_TERRACOTTA)
                .add(Items.ORANGE_GLAZED_TERRACOTTA)
                .add(Items.PINK_GLAZED_TERRACOTTA)
                .add(Items.PURPLE_GLAZED_TERRACOTTA)
                .add(Items.RED_GLAZED_TERRACOTTA)
                .add(Items.WHITE_GLAZED_TERRACOTTA)
                .add(Items.YELLOW_GLAZED_TERRACOTTA);
        getOrCreateTagBuilder(ModTags.Items.DYEABLE_WOOL)
                .add(Items.BLACK_WOOL)
                .add(Items.BLUE_WOOL)
                .add(Items.BROWN_WOOL)
                .add(Items.CYAN_WOOL)
                .add(Items.GRAY_WOOL)
                .add(Items.GREEN_WOOL)
                .add(Items.LIGHT_BLUE_WOOL)
                .add(Items.LIGHT_GRAY_WOOL)
                .add(Items.LIME_WOOL)
                .add(Items.MAGENTA_WOOL)
                .add(Items.ORANGE_WOOL)
                .add(Items.PINK_WOOL)
                .add(Items.PURPLE_WOOL)
                .add(Items.RED_WOOL)
                .add(Items.WHITE_WOOL)
                .add(Items.YELLOW_WOOL);
        //endregion
        //endregion
    }
}
