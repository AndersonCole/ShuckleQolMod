package ca.shuckle.util;

import ca.shuckle.ShuckleQOL;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CHERRY_LOGS =
                createTag("cherry_logs");
        public static final TagKey<Block> BAMBOO_BLOCKS =
                createTag("bamboo_blocks");
        public static final TagKey<Block> PALE_OAK_LOGS =
                createTag("pale_oak_logs");
        public static final TagKey<Block> POPLAR_LOGS =
                createTag("poplar_logs");
        public static final TagKey<Block> CEILING_HANGING_SIGNS =
                createTag("ceiling_hanging_signs");
        public static final TagKey<Block> WALL_HANGING_SIGNS =
                createTag("wall_hanging_signs");
        public static final TagKey<Block> SHELVES =
                createTag("shelves");
        public static final TagKey<Block> WILDFLOWERS =
                createTag("wildflowers");
        public static final TagKey<Block> LEAF_LITTER =
                createTag("leaf_litter");
        public static final TagKey<Block> CAUSES_CONTINUOUS_GEYSER_ERUPTIONS =
                createTag("causes_continuous_geyser_eruptions");
        public static final TagKey<Block> CAUSES_PERIODIC_GEYSER_ERUPTIONS =
                createTag("causes_periodic_geyser_eruptions");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ShuckleQOL.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CHERRY_LOGS =
                createTag("cherry_logs");
        public static final TagKey<Item> BAMBOO_BLOCKS =
                createTag("bamboo_blocks");
        public static final TagKey<Item> PALE_OAK_LOGS =
                createTag("pale_oak_logs");
        public static final TagKey<Item> POPLAR_LOGS =
                createTag("poplar_logs");
        public static final TagKey<Item> WILDFLOWERS =
                createTag("wildflowers");
        public static final TagKey<Item> LEAF_LITTER =
                createTag("leaf_litter");
        public static final TagKey<Item> CONVERTIBLE_DIRT =
                createTag("convertible_dirt");
        public static final TagKey<Item> RAW_ORES =
                createTag("raw_ores");
        public static final TagKey<Item> METAL_NUGGETS =
                createTag("metal_nuggets");
        public static final TagKey<Item> FOSSIL_LOGS =
                createTag("fossil_logs");
        //region Universal Dyeing
        public static final TagKey<Item> DYEABLE_BEDS =
                createTag("dyeable_beds");
        public static final TagKey<Item> DYEABLE_CANDLES =
                createTag("dyeable_candles");
        public static final TagKey<Item> DYEABLE_CARPETS =
                createTag("dyeable_carpets");
        public static final TagKey<Item> DYEABLE_CONCRETE =
                createTag("dyeable_concrete");
        public static final TagKey<Item> DYEABLE_CONCRETE_POWDER =
                createTag("dyeable_concrete_powder");
        public static final TagKey<Item> DYEABLE_GLASS =
                createTag("dyeable_glass");
        public static final TagKey<Item> DYEABLE_GLASS_PANES =
                createTag("dyeable_glass_panes");
        public static final TagKey<Item> DYEABLE_TERRACOTTA =
                createTag("dyeable_terracotta");
        public static final TagKey<Item> DYEABLE_GLAZED_TERRACOTTA =
                createTag("dyeable_glazed_terracotta");
        public static final TagKey<Item> DYEABLE_WOOL =
                createTag("dyeable_wool");
        public static final TagKey<Item> DYEABLE_WOOL_SLABS =
                createTag("dyeable_wool_slabs");
        public static final TagKey<Item> DYEABLE_WOOL_STAIRS =
                createTag("dyeable_wool_stairs");
        //endregion

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ShuckleQOL.MOD_ID, name));
        }
    }
}
