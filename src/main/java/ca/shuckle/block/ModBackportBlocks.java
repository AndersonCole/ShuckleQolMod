package ca.shuckle.block;

import ca.shuckle.block.custom.*;
import ca.shuckle.block.entity.ModSignTypes;
import ca.shuckle.item.ModItemGroup;
import ca.shuckle.world.feature.tree.PaleOakSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

import static ca.shuckle.block.ModBlocks.registerBlock;
import static ca.shuckle.block.ModBlocks.registerBlockWithoutBlockItem;

public class ModBackportBlocks {
    public static final Block REINFORCED_DEEPSLATE = registerBlock("reinforced_deepslate",
            new TopBottomPillarBlock(FabricBlockSettings.copy(Blocks.DEEPSLATE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PEARLESCENT_FROGLIGHT = registerBlock("pearlescent_froglight",
            new PillarBlock(FabricBlockSettings.of(Material.PLANT, MapColor.PINK)
                    .strength(0.3f, 0.3f).luminance(15).sounds(BlockSoundGroup.SLIME)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block VERDANT_FROGLIGHT = registerBlock("verdant_froglight",
            new PillarBlock(FabricBlockSettings.copy(ModBackportBlocks.PEARLESCENT_FROGLIGHT)
                    .mapColor(MapColor.LICHEN_GREEN)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block OCHRE_FROGLIGHT = registerBlock("ochre_froglight",
            new PillarBlock(FabricBlockSettings.copy(ModBackportBlocks.PEARLESCENT_FROGLIGHT)
                    .mapColor(MapColor.PALE_YELLOW)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block SCULK = registerBlock("sculk",
            new SculkBlock(FabricBlockSettings.of(Material.SCULK)
                    .strength(0.2f).sounds(BlockSoundGroup.SCULK_SENSOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block SCULK_VEIN = registerBlock("sculk_vein",
            new SculkVeinBlock(FabricBlockSettings.of(Material.SCULK)
                    .strength(0.2f).sounds(BlockSoundGroup.SCULK_SENSOR).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block SCULK_CATALYST = registerBlock("sculk_catalyst",
            new Block(FabricBlockSettings.of(Material.SCULK)
                    .strength(3f, 3f).luminance(6).sounds(BlockSoundGroup.SCULK_SENSOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_LEAVES = registerBlock("mangrove_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_LOG = registerBlock("mangrove_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_WOOD = registerBlock("mangrove_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_MANGROVE_LOG = registerBlock("stripped_mangrove_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_MANGROVE_WOOD = registerBlock("stripped_mangrove_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_PLANKS = registerBlock("mangrove_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_SLAB = registerBlock("mangrove_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_STAIRS = registerBlock("mangrove_stairs",
            new StairsBlock(ModBackportBlocks.MANGROVE_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_DOOR = registerBlock("mangrove_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_TRAPDOOR = registerBlock("mangrove_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_FENCE = registerBlock("mangrove_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_FENCE_GATE = registerBlock("mangrove_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_BUTTON = registerBlock("mangrove_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).noCollision()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_PRESSURE_PLATE = registerBlock("mangrove_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MUD = registerBlock("mud",
            new NonFullBlock(FabricBlockSettings.of(Material.SOIL, MapColor.TERRACOTTA_CYAN).sounds(BlockSoundGroup.ROOTED_DIRT).strength(0.5f, 0.5f)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD = registerBlock("packed_mud",
            new Block(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(1f, 3f)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD_SLAB = registerBlock("packed_mud_slab",
            new SlabBlock(FabricBlockSettings.copy(ModBackportBlocks.PACKED_MUD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD_STAIRS = registerBlock("packed_mud_stairs",
            new StairsBlock(ModBackportBlocks.PACKED_MUD.getDefaultState(),
                    FabricBlockSettings.copy(ModBackportBlocks.PACKED_MUD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD_WALL = registerBlock("packed_mud_wall",
            new WallBlock(FabricBlockSettings.copy(ModBackportBlocks.PACKED_MUD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MUD_BRICKS = registerBlock("mud_bricks",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_GRAY)
                    .strength(1.5f, 3f).requiresTool()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MUD_BRICK_SLAB = registerBlock("mud_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(ModBackportBlocks.MUD_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MUD_BRICK_STAIRS = registerBlock("mud_brick_stairs",
            new StairsBlock(ModBackportBlocks.MUD_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(ModBackportBlocks.MUD_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MUD_BRICK_WALL = registerBlock("mud_brick_wall",
            new WallBlock(FabricBlockSettings.copy(ModBackportBlocks.MUD_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MANGROVE_ROOTS = registerBlock("mangrove_roots",
            new MangroveRootsBlock(FabricBlockSettings.of(Material.PLANT, MapColor.SPRUCE_BROWN)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).strength(0.7f, 0.7f).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MUDDY_MANGROVE_ROOTS = registerBlock("muddy_mangrove_roots",
            new PillarBlock(FabricBlockSettings.copy(ModBackportBlocks.MANGROVE_ROOTS)
                    .sounds(BlockSoundGroup.ROOTED_DIRT)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_BLOCK = registerBlock("bamboo_block",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_BAMBOO_BLOCK = registerBlock("stripped_bamboo_block",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_PLANKS = registerBlock("bamboo_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_SLAB = registerBlock("bamboo_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_STAIRS = registerBlock("bamboo_stairs",
            new StairsBlock(ModBackportBlocks.BAMBOO_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_DOOR = registerBlock("bamboo_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_TRAPDOOR = registerBlock("bamboo_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_FENCE = registerBlock("bamboo_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_FENCE_GATE = registerBlock("bamboo_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_BUTTON = registerBlock("bamboo_button",
            new WoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.BAMBOO).noCollision()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_PRESSURE_PLATE = registerBlock("bamboo_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.BAMBOO).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_SIGN = registerBlockWithoutBlockItem("bamboo_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.BAMBOO), ModSignTypes.BAMBOO), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_WALL_SIGN = registerBlockWithoutBlockItem("bamboo_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.BAMBOO)
                    .dropsLike(BAMBOO_SIGN), ModSignTypes.BAMBOO), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_MOSAIC = registerBlock("bamboo_mosaic",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_MOSAIC_SLAB = registerBlock("bamboo_mosaic_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_MOSAIC_STAIRS = registerBlock("bamboo_mosaic_stairs",
            new StairsBlock(ModBackportBlocks.BAMBOO_MOSAIC.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_LEAVES = registerBlock("cherry_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_LOG = registerBlock("cherry_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_WOOD = registerBlock("cherry_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_PLANKS = registerBlock("cherry_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_SLAB = registerBlock("cherry_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_STAIRS = registerBlock("cherry_stairs",
            new StairsBlock(ModBackportBlocks.CHERRY_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_DOOR = registerBlock("cherry_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_FENCE = registerBlock("cherry_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_BUTTON = registerBlock("cherry_button",
            new WoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).noCollision()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_SAPLING = registerBlock("pale_oak_sapling",
            new SaplingBlock(new PaleOakSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POTTED_PALE_OAK_SAPLING = registerBlockWithoutBlockItem("potted_pale_oak_sapling",
            new FlowerPotBlock(ModBackportBlocks.PALE_OAK_SAPLING,
                    FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_LEAVES = registerBlock("pale_oak_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_LOG = registerBlock("pale_oak_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_WOOD = registerBlock("pale_oak_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_PALE_OAK_LOG = registerBlock("stripped_pale_oak_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_PALE_OAK_WOOD = registerBlock("stripped_pale_oak_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_PLANKS = registerBlock("pale_oak_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_SLAB = registerBlock("pale_oak_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_STAIRS = registerBlock("pale_oak_stairs",
            new StairsBlock(ModBackportBlocks.PALE_OAK_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_DOOR = registerBlock("pale_oak_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_TRAPDOOR = registerBlock("pale_oak_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_FENCE = registerBlock("pale_oak_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_BUTTON = registerBlock("pale_oak_button",
            new WoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).noCollision()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_PRESSURE_PLATE = registerBlock("pale_oak_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_SIGN = registerBlockWithoutBlockItem("pale_oak_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.PALE_OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_WALL_SIGN = registerBlockWithoutBlockItem("pale_oak_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN)
                    .dropsLike(PALE_OAK_SIGN), ModSignTypes.PALE_OAK), ModItemGroup.SHUCKLE_BACKPORT);


    public static final Block PALE_MOSS_BLOCK = registerBlock("pale_moss_block",
            new PaleMossBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(FabricBlockSettings.copy(Blocks.MOSS_CARPET)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_GRASS = registerBlock("pale_grass",
            new FernBlock(FabricBlockSettings.copy(Blocks.GRASS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_TALL_GRASS = registerBlock("pale_tall_grass",
            new TallPlantBlock(FabricBlockSettings.copy(Blocks.TALL_GRASS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block RESIN_CLUMP = registerBlock("resin_clump",
            new MultifaceGrowthBlock(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE)
                    .noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RESIN_BLOCK = registerBlock("resin_block",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CREAKING_HEART = registerBlock("creaking_heart",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.ORANGE)
                    .strength(10f, 10f).requiresTool()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block ACTIVE_CREAKING_HEART = registerBlock("active_creaking_heart",
            new PillarBlock(FabricBlockSettings.copy(ModBackportBlocks.CREAKING_HEART)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RESIN_BRICKS = registerBlock("resin_bricks",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE)
                    .strength(1.5f, 6f).requiresTool()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHISELED_RESIN_BRICKS = registerBlock("chiseled_resin_bricks",
            new Block(FabricBlockSettings.copy(ModBackportBlocks.RESIN_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RESIN_BRICK_SLAB = registerBlock("resin_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(ModBackportBlocks.RESIN_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RESIN_BRICK_STAIRS = registerBlock("resin_brick_stairs",
            new StairsBlock(ModBackportBlocks.RESIN_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(ModBackportBlocks.RESIN_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RESIN_BRICK_WALL = registerBlock("resin_brick_wall",
            new WallBlock(FabricBlockSettings.copy(ModBackportBlocks.RESIN_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PINK_PETALS = registerBlock("pink_petals",
            new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.GRASS).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block WILDFLOWERS = registerBlock("wildflowers",
            new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.GRASS).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LEAF_LITTER = registerBlock("leaf_litter",
            new FlatFlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static void registerModBlocks() {
        //called so the class loads
    }
}
