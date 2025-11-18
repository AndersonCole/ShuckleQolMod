package ca.shuckle.datagen.tags;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.util.ModPointsOfInterest;
import ca.shuckle.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.PointOfInterestTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //region Vanilla Tags
        //region Mineable
        //region Copper Blocks
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBackportBlocks.CHISELED_COPPER)
                .add(ModBackportBlocks.CHISELED_COPPER)
                .add(ModBackportBlocks.EXPOSED_CHISELED_COPPER)
                .add(ModBackportBlocks.WEATHERED_CHISELED_COPPER)
                .add(ModBackportBlocks.OXIDIZED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER)
                .add(ModBackportBlocks.COPPER_GRATE)
                .add(ModBackportBlocks.EXPOSED_COPPER_GRATE)
                .add(ModBackportBlocks.WEATHERED_COPPER_GRATE)
                .add(ModBackportBlocks.OXIDIZED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE)
                .add(ModBackportBlocks.COPPER_BULB)
                .add(ModBackportBlocks.EXPOSED_COPPER_BULB)
                .add(ModBackportBlocks.WEATHERED_COPPER_BULB)
                .add(ModBackportBlocks.OXIDIZED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_BULB)
                .add(ModBackportBlocks.COPPER_DOOR)
                .add(ModBackportBlocks.EXPOSED_COPPER_DOOR)
                .add(ModBackportBlocks.WEATHERED_COPPER_DOOR)
                .add(ModBackportBlocks.OXIDIZED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR)
                .add(ModBackportBlocks.COPPER_TRAPDOOR)
                .add(ModBackportBlocks.EXPOSED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WEATHERED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.OXIDIZED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.COPPER_BARS)
                .add(ModBackportBlocks.EXPOSED_COPPER_BARS)
                .add(ModBackportBlocks.WEATHERED_COPPER_BARS)
                .add(ModBackportBlocks.OXIDIZED_COPPER_BARS)
                .add(ModBackportBlocks.WAXED_COPPER_BARS)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_BARS)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_BARS)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_BARS)
                .add(ModBackportBlocks.COPPER_CHAIN)
                .add(ModBackportBlocks.EXPOSED_COPPER_CHAIN)
                .add(ModBackportBlocks.WEATHERED_COPPER_CHAIN)
                .add(ModBackportBlocks.OXIDIZED_COPPER_CHAIN)
                .add(ModBackportBlocks.WAXED_COPPER_CHAIN)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_CHAIN)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_CHAIN)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_CHAIN)
                .add(ModBackportBlocks.LIGHTNING_ROD)
                .add(ModBackportBlocks.EXPOSED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WEATHERED_LIGHTNING_ROD)
                .add(ModBackportBlocks.OXIDIZED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WAXED_EXPOSED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WAXED_WEATHERED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WAXED_OXIDIZED_LIGHTNING_ROD)
                .add(ModBackportBlocks.COPPER_LANTERN)
                .add(ModBackportBlocks.EXPOSED_COPPER_LANTERN)
                .add(ModBackportBlocks.WEATHERED_COPPER_LANTERN)
                .add(ModBackportBlocks.OXIDIZED_COPPER_LANTERN)
                .add(ModBackportBlocks.WAXED_COPPER_LANTERN)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_LANTERN)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_LANTERN)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBackportBlocks.CHISELED_COPPER)
                .add(ModBackportBlocks.CHISELED_COPPER)
                .add(ModBackportBlocks.EXPOSED_CHISELED_COPPER)
                .add(ModBackportBlocks.WEATHERED_CHISELED_COPPER)
                .add(ModBackportBlocks.OXIDIZED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER)
                .add(ModBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER)
                .add(ModBackportBlocks.COPPER_GRATE)
                .add(ModBackportBlocks.EXPOSED_COPPER_GRATE)
                .add(ModBackportBlocks.WEATHERED_COPPER_GRATE)
                .add(ModBackportBlocks.OXIDIZED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_GRATE)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE)
                .add(ModBackportBlocks.COPPER_BULB)
                .add(ModBackportBlocks.EXPOSED_COPPER_BULB)
                .add(ModBackportBlocks.WEATHERED_COPPER_BULB)
                .add(ModBackportBlocks.OXIDIZED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_BULB)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_BULB)
                .add(ModBackportBlocks.LIGHTNING_ROD)
                .add(ModBackportBlocks.EXPOSED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WEATHERED_LIGHTNING_ROD)
                .add(ModBackportBlocks.OXIDIZED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WAXED_EXPOSED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WAXED_WEATHERED_LIGHTNING_ROD)
                .add(ModBackportBlocks.WAXED_OXIDIZED_LIGHTNING_ROD);
        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBackportBlocks.COPPER_DOOR)
                .add(ModBackportBlocks.EXPOSED_COPPER_DOOR)
                .add(ModBackportBlocks.WEATHERED_COPPER_DOOR)
                .add(ModBackportBlocks.OXIDIZED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_DOOR)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBackportBlocks.COPPER_TRAPDOOR)
                .add(ModBackportBlocks.EXPOSED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WEATHERED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.OXIDIZED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR)
                .add(ModBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
        //endregion
        //pickaxe
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SHUCKLE_ORE)
                .add(ModBlocks.CONDENSED_BLACK_ICE)
                .add(ModBackportBlocks.REINFORCED_DEEPSLATE)
                .add(ModBackportBlocks.PACKED_MUD_SLAB)
                .add(ModBackportBlocks.PACKED_MUD_STAIRS)
                .add(ModBackportBlocks.PACKED_MUD_WALL)
                .add(ModBackportBlocks.RESIN_BRICKS)
                .add(ModBackportBlocks.RESIN_BRICK_SLAB)
                .add(ModBackportBlocks.RESIN_BRICK_STAIRS)
                .add(ModBackportBlocks.RESIN_BRICK_WALL)
                .add(ModBackportBlocks.CHISELED_RESIN_BRICKS)
                .add(ModBackportBlocks.TUFF_SLAB)
                .add(ModBackportBlocks.TUFF_STAIRS)
                .add(ModBackportBlocks.TUFF_WALL)
                .add(ModBackportBlocks.POLISHED_TUFF)
                .add(ModBackportBlocks.POLISHED_TUFF_SLAB)
                .add(ModBackportBlocks.POLISHED_TUFF_STAIRS)
                .add(ModBackportBlocks.POLISHED_TUFF_WALL)
                .add(ModBackportBlocks.TUFF_BRICKS)
                .add(ModBackportBlocks.TUFF_BRICK_SLAB)
                .add(ModBackportBlocks.TUFF_BRICK_STAIRS)
                .add(ModBackportBlocks.TUFF_BRICK_WALL)
                .add(ModBackportBlocks.CHISELED_TUFF)
                .add(ModBackportBlocks.CHISELED_TUFF_BRICKS)
                .add(ModBlocks.ANCIENT_STONE_SLAB)
                .add(ModBlocks.ANCIENT_STONE_STAIRS)
                .add(ModBlocks.ANCIENT_STONE_WALL)
                .add(ModBlocks.BLACK_SANDSTONE_SLAB)
                .add(ModBlocks.BLACK_SANDSTONE_STAIRS)
                .add(ModBlocks.BLACK_SANDSTONE_WALL)
                .add(ModBlocks.BLACK_CUT_SANDSTONE_SLAB)
                .add(ModBlocks.BLACK_CUT_SANDSTONE_STAIRS)
                .add(ModBlocks.BLACK_CUT_SANDSTONE_WALL)
                .add(ModBlocks.INVIS_LIGHTNING_ROD)
                .add(ModBlocks.SHUCKLE_MYSTERY_BLOCK);
        //axe
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addTag(ModTags.Blocks.CEILING_HANGING_SIGNS)
                .addTag(ModTags.Blocks.WALL_HANGING_SIGNS)
                .addTag(ModTags.Blocks.SHELVES)
                .add(ModBackportBlocks.CREAKING_HEART)
                .add(ModBackportBlocks.ACTIVE_CREAKING_HEART)
                .add(ModBackportBlocks.CHERRY_DOOR)
                .add(ModBackportBlocks.CHERRY_TRAPDOOR)
                .add(ModBackportBlocks.BAMBOO_DOOR)
                .add(ModBackportBlocks.BAMBOO_TRAPDOOR)
                .add(ModBackportBlocks.BAMBOO_MOSAIC)
                .add(ModBackportBlocks.BAMBOO_MOSAIC_SLAB)
                .add(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS)
                .add(ModBackportBlocks.PALE_OAK_DOOR)
                .add(ModBackportBlocks.PALE_OAK_TRAPDOOR);
        //hoe
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBackportBlocks.CHERRY_LEAVES)
                .add(ModBackportBlocks.PALE_OAK_LEAVES)
                .add(ModBackportBlocks.PALE_MOSS_BLOCK)
                .add(ModBackportBlocks.PALE_MOSS_CARPET);
        //needs diamond tool
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SHUCKLE_ORE);
        //endregion
        //region Wood Set Tags
        //logs
        getOrCreateTagBuilder(BlockTags.LOGS)
                .addTag(ModTags.Blocks.CHERRY_LOGS)
                .addTag(ModTags.Blocks.PALE_OAK_LOGS);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.CHERRY_LOGS)
                .addTag(ModTags.Blocks.PALE_OAK_LOGS);
        //leaves
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBackportBlocks.CHERRY_LEAVES)
                .add(ModBackportBlocks.PALE_OAK_LEAVES);
        //saplings
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBackportBlocks.CHERRY_SAPLING)
                .add(ModBackportBlocks.PALE_OAK_SAPLING);
        //flower pots
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBackportBlocks.POTTED_CHERRY_SAPLING)
                .add(ModBackportBlocks.POTTED_PALE_OAK_SAPLING);
        //planks
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBackportBlocks.CHERRY_PLANKS)
                .add(ModBackportBlocks.BAMBOO_PLANKS)
                .add(ModBackportBlocks.PALE_OAK_PLANKS);
        //wood slabs
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBackportBlocks.CHERRY_SLAB)
                .add(ModBackportBlocks.BAMBOO_SLAB)
                .add(ModBackportBlocks.PALE_OAK_SLAB);
        //wood stairs
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBackportBlocks.CHERRY_STAIRS)
                .add(ModBackportBlocks.BAMBOO_STAIRS)
                .add(ModBackportBlocks.PALE_OAK_STAIRS);
        //wood doors
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBackportBlocks.CHERRY_DOOR)
                .add(ModBackportBlocks.BAMBOO_DOOR)
                .add(ModBackportBlocks.PALE_OAK_DOOR);
        //wood trapdoors
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBackportBlocks.CHERRY_TRAPDOOR)
                .add(ModBackportBlocks.BAMBOO_TRAPDOOR)
                .add(ModBackportBlocks.PALE_OAK_TRAPDOOR);
        //fences
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBackportBlocks.CHERRY_FENCE)
                .add(ModBackportBlocks.BAMBOO_FENCE)
                .add(ModBackportBlocks.PALE_OAK_FENCE);
        //fence gates
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBackportBlocks.CHERRY_FENCE_GATE)
                .add(ModBackportBlocks.BAMBOO_FENCE_GATE)
                .add(ModBackportBlocks.PALE_OAK_FENCE_GATE);
        //wooden buttons
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBackportBlocks.CHERRY_BUTTON)
                .add(ModBackportBlocks.BAMBOO_BUTTON)
                .add(ModBackportBlocks.PALE_OAK_BUTTON);
        //wooden pressure plates
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBackportBlocks.CHERRY_PRESSURE_PLATE)
                .add(ModBackportBlocks.BAMBOO_PRESSURE_PLATE)
                .add(ModBackportBlocks.PALE_OAK_PRESSURE_PLATE);
        //signs
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(ModBackportBlocks.CHERRY_SIGN)
                .add(ModBackportBlocks.BAMBOO_SIGN)
                .add(ModBackportBlocks.PALE_OAK_SIGN)
                .add(ModBlocks.INVIS_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(ModBackportBlocks.CHERRY_WALL_SIGN)
                .add(ModBackportBlocks.BAMBOO_WALL_SIGN)
                .add(ModBackportBlocks.PALE_OAK_WALL_SIGN)
                .add(ModBlocks.INVIS_WALL_SIGN);
        //hanging signs
        getOrCreateTagBuilder(ModTags.Blocks.CEILING_HANGING_SIGNS)
                .add(ModBackportBlocks.OAK_HANGING_SIGN)
                .add(ModBackportBlocks.SPRUCE_HANGING_SIGN)
                .add(ModBackportBlocks.BIRCH_HANGING_SIGN)
                .add(ModBackportBlocks.JUNGLE_HANGING_SIGN)
                .add(ModBackportBlocks.ACACIA_HANGING_SIGN)
                .add(ModBackportBlocks.DARK_OAK_HANGING_SIGN)
                .add(ModBackportBlocks.MANGROVE_HANGING_SIGN)
                .add(ModBackportBlocks.CHERRY_HANGING_SIGN)
                .add(ModBackportBlocks.BAMBOO_HANGING_SIGN)
                .add(ModBackportBlocks.PALE_OAK_HANGING_SIGN)
                .add(ModBackportBlocks.CRIMSON_HANGING_SIGN)
                .add(ModBackportBlocks.WARPED_HANGING_SIGN);

        getOrCreateTagBuilder(ModTags.Blocks.WALL_HANGING_SIGNS)
                .add(ModBackportBlocks.OAK_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.SPRUCE_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.BIRCH_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.JUNGLE_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.ACACIA_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.DARK_OAK_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.MANGROVE_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.CHERRY_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.BAMBOO_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.PALE_OAK_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.CRIMSON_WALL_HANGING_SIGN)
                .add(ModBackportBlocks.WARPED_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS)
                .addTag(ModTags.Blocks.CEILING_HANGING_SIGNS)
                .addTag(ModTags.Blocks.WALL_HANGING_SIGNS);

        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .addTag(ModTags.Blocks.CEILING_HANGING_SIGNS);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .addTag(ModTags.Blocks.WALL_HANGING_SIGNS);
        //shelves
        getOrCreateTagBuilder(ModTags.Blocks.SHELVES)
                .add(ModBackportBlocks.OAK_SHELF)
                .add(ModBackportBlocks.SPRUCE_SHELF)
                .add(ModBackportBlocks.BIRCH_SHELF)
                .add(ModBackportBlocks.JUNGLE_SHELF)
                .add(ModBackportBlocks.ACACIA_SHELF)
                .add(ModBackportBlocks.DARK_OAK_SHELF)
                .add(ModBackportBlocks.MANGROVE_SHELF)
                .add(ModBackportBlocks.CHERRY_SHELF)
                .add(ModBackportBlocks.BAMBOO_SHELF)
                .add(ModBackportBlocks.PALE_OAK_SHELF)
                .add(ModBackportBlocks.CRIMSON_SHELF)
                .add(ModBackportBlocks.WARPED_SHELF);
        //endregion
        //region Nature Block Tags
        //dirt
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBackportBlocks.PALE_MOSS_BLOCK);
        //flowers
        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .addTag(ModTags.Blocks.WILDFLOWERS)
                .add(ModBackportBlocks.CHERRY_LEAVES)
                .add(ModBackportBlocks.PINK_PETALS);
        //inside step sounds
        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
                .addTag(ModTags.Blocks.WILDFLOWERS)
                .addTag(ModTags.Blocks.LEAF_LITTER)
                .add(ModBackportBlocks.PINK_PETALS)
                .add(ModBlocks.ZYGARDE_CELL);
        //replaceable plants
        getOrCreateTagBuilder(BlockTags.REPLACEABLE_PLANTS)
                .add(ModBackportBlocks.PALE_GRASS)
                .add(ModBackportBlocks.PALE_TALL_GRASS);
        //big dripleaf placeable
        getOrCreateTagBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE)
                .add(ModBackportBlocks.PALE_MOSS_BLOCK);
        //endregion
        //slabs
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBackportBlocks.PACKED_MUD_SLAB)
                .add(ModBackportBlocks.BAMBOO_MOSAIC_SLAB)
                .add(ModBackportBlocks.RESIN_BRICK_SLAB)
                .add(ModBackportBlocks.TUFF_SLAB)
                .add(ModBackportBlocks.POLISHED_TUFF_SLAB)
                .add(ModBackportBlocks.TUFF_BRICK_SLAB)
                .add(ModBlocks.ANCIENT_STONE_SLAB)
                .add(ModBlocks.BLACK_SANDSTONE_SLAB)
                .add(ModBlocks.BLACK_CUT_SANDSTONE_SLAB)
                .add(ModBlocks.BLACK_SMOOTH_SANDSTONE_SLAB);
        //stairs
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBackportBlocks.PACKED_MUD_STAIRS)
                .add(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS)
                .add(ModBackportBlocks.RESIN_BRICK_STAIRS)
                .add(ModBackportBlocks.TUFF_STAIRS)
                .add(ModBackportBlocks.POLISHED_TUFF_STAIRS)
                .add(ModBackportBlocks.TUFF_BRICK_STAIRS)
                .add(ModBlocks.ANCIENT_STONE_STAIRS)
                .add(ModBlocks.BLACK_SANDSTONE_STAIRS)
                .add(ModBlocks.BLACK_CUT_SANDSTONE_STAIRS)
                .add(ModBlocks.BLACK_SMOOTH_SANDSTONE_STAIRS);
        //walls
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBackportBlocks.PACKED_MUD_WALL)
                .add(ModBackportBlocks.RESIN_BRICK_WALL)
                .add(ModBackportBlocks.TUFF_WALL)
                .add(ModBackportBlocks.POLISHED_TUFF_WALL)
                .add(ModBackportBlocks.TUFF_BRICK_WALL)
                .add(ModBlocks.ANCIENT_STONE_WALL)
                .add(ModBlocks.BLACK_SANDSTONE_WALL)
                .add(ModBlocks.BLACK_CUT_SANDSTONE_WALL)
                .add(ModBlocks.BLACK_SMOOTH_SANDSTONE_WALL);
        //prevent mob spawning
        getOrCreateTagBuilder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE)
                .add(ModBlocks.INVIS_CARPET);
        //endregion
        //region Shuckle Tags
        getOrCreateTagBuilder(ModTags.Blocks.CHERRY_LOGS)
                .add(ModBackportBlocks.CHERRY_LOG)
                .add(ModBackportBlocks.STRIPPED_CHERRY_LOG)
                .add(ModBackportBlocks.CHERRY_WOOD)
                .add(ModBackportBlocks.STRIPPED_CHERRY_WOOD);
        getOrCreateTagBuilder(ModTags.Blocks.BAMBOO_BLOCKS)
                .add(ModBackportBlocks.BAMBOO_BLOCK)
                .add(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.PALE_OAK_LOGS)
                .add(ModBackportBlocks.PALE_OAK_LOG)
                .add(ModBackportBlocks.STRIPPED_PALE_OAK_LOG)
                .add(ModBackportBlocks.PALE_OAK_WOOD)
                .add(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD);
        getOrCreateTagBuilder(ModTags.Blocks.WILDFLOWERS)
                .add(ModBackportBlocks.WILDFLOWERS)
                .add(ModBlocks.WILDFLOWERS_RED_BLUE);
        getOrCreateTagBuilder(ModTags.Blocks.LEAF_LITTER)
                .add(ModBackportBlocks.LEAF_LITTER)
                .add(ModBlocks.LEAF_LITTER_OAK);
        //endregion
    }
}
