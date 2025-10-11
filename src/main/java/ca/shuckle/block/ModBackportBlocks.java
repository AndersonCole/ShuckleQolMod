package ca.shuckle.block;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.custom.*;
import ca.shuckle.block.custom.copper.*;
import ca.shuckle.item.ModItemGroup;
import ca.shuckle.particle.ModParticles;
import ca.shuckle.util.ModSounds;
import ca.shuckle.world.feature.tree.CherrySaplingGenerator;
import ca.shuckle.world.feature.tree.PaleOakSaplingGenerator;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import static ca.shuckle.block.ModBlocks.registerBlock;
import static ca.shuckle.block.ModBlocks.registerBlockWithoutBlockItem;

public class ModBackportBlocks {
    //exists now, but this makes it actually usable
    public static final Block REINFORCED_DEEPSLATE = registerBlock("reinforced_deepslate",
            new TopBottomPillarBlock(FabricBlockSettings.copy(Blocks.DEEPSLATE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD_SLAB = registerBlock("packed_mud_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PACKED_MUD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD_STAIRS = registerBlock("packed_mud_stairs",
            new StairsBlock(Blocks.PACKED_MUD.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PACKED_MUD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PACKED_MUD_WALL = registerBlock("packed_mud_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.PACKED_MUD)), ModItemGroup.SHUCKLE_BACKPORT);
    //region Biome Sets
    //region Cherry
    public static final Block CHERRY_SAPLING = registerBlock("cherry_sapling",
            new SaplingBlock(new CherrySaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POTTED_CHERRY_SAPLING = registerBlockWithoutBlockItem("potted_cherry_sapling",
            new FlowerPotBlock(ModBackportBlocks.CHERRY_SAPLING,
                    FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));

    public static final Block CHERRY_LEAVES = registerBlock("cherry_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_LOG = registerBlock("cherry_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_WOOD = registerBlock("cherry_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_PLANKS = registerBlock("cherry_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_SLAB = registerBlock("cherry_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_STAIRS = registerBlock("cherry_stairs",
            new StairsBlock(ModBackportBlocks.CHERRY_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_DOOR = registerBlock("cherry_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).sounds(BlockSoundGroup.CHERRY_WOOD), BlockSetType.CHERRY), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.CHERRY_WOOD), BlockSetType.CHERRY), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_FENCE = registerBlock("cherry_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).sounds(BlockSoundGroup.CHERRY_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).sounds(BlockSoundGroup.CHERRY_WOOD), WoodType.CHERRY), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_BUTTON = registerBlock("cherry_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.CHERRY_WOOD).noCollision(), BlockSetType.CHERRY, 30, true), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque(), BlockSetType.CHERRY), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_SIGN = registerBlockWithoutBlockItem("cherry_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/cherry"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.CHERRY_WOOD)));

    public static final Block CHERRY_WALL_SIGN = registerBlockWithoutBlockItem("cherry_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/cherry"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.CHERRY_WOOD)
                            .dropsLike(CHERRY_SIGN)));

    public static final Block PINK_PETALS = registerBlock("pink_petals",
            new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.PINK)
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //region Bamboo
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
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).sounds(BlockSoundGroup.BAMBOO), BlockSetType.BAMBOO), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_TRAPDOOR = registerBlock("bamboo_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.BAMBOO), BlockSetType.BAMBOO), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_FENCE = registerBlock("bamboo_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_FENCE_GATE = registerBlock("bamboo_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).sounds(BlockSoundGroup.BAMBOO), WoodType.BAMBOO), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_BUTTON = registerBlock("bamboo_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.BAMBOO).noCollision(),
                    BlockSetType.BAMBOO, 30, true), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_PRESSURE_PLATE = registerBlock("bamboo_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.BAMBOO).nonOpaque(), BlockSetType.BAMBOO), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_SIGN = registerBlockWithoutBlockItem("bamboo_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/bamboo"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.BAMBOO)));

    public static final Block BAMBOO_WALL_SIGN = registerBlockWithoutBlockItem("bamboo_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/bamboo"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.BAMBOO)
                    .dropsLike(BAMBOO_SIGN)));

    public static final Block BAMBOO_MOSAIC = registerBlock("bamboo_mosaic",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_MOSAIC_SLAB = registerBlock("bamboo_mosaic_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_MOSAIC_STAIRS = registerBlock("bamboo_mosaic_stairs",
            new StairsBlock(ModBackportBlocks.BAMBOO_MOSAIC.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.BAMBOO)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //region Pale Garden
    public static final Block PALE_OAK_SAPLING = registerBlock("pale_oak_sapling",
            new SaplingBlock(new PaleOakSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POTTED_PALE_OAK_SAPLING = registerBlockWithoutBlockItem("potted_pale_oak_sapling",
            new FlowerPotBlock(ModBackportBlocks.PALE_OAK_SAPLING,
                    FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));

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
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), BlockSetType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_TRAPDOOR = registerBlock("pale_oak_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_FENCE = registerBlock("pale_oak_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_BUTTON = registerBlock("pale_oak_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).noCollision(),
                    BlockSetType.OAK, 30, true), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_PRESSURE_PLATE = registerBlock("pale_oak_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).nonOpaque(), BlockSetType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_SIGN = registerBlockWithoutBlockItem("pale_oak_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/pale_oak"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN)));

    public static final Block PALE_OAK_WALL_SIGN = registerBlockWithoutBlockItem("pale_oak_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/pale_oak"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN)
                            .dropsLike(PALE_OAK_SIGN)));


    public static final Block PALE_MOSS_BLOCK = registerBlock("pale_moss_block",
            new PaleMossBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(FabricBlockSettings.copy(Blocks.MOSS_CARPET)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_GRASS = registerBlock("pale_grass",
            new FernBlock(FabricBlockSettings.copy(Blocks.GRASS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_TALL_GRASS = registerBlock("pale_tall_grass",
            new TallPlantBlock(FabricBlockSettings.copy(Blocks.TALL_GRASS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block RESIN_CLUMP = registerBlock("resin_clump",
            new ResinBlock(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE)
                    .noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RESIN_BLOCK = registerBlock("resin_block",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CREAKING_HEART = registerBlock("creaking_heart",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.ORANGE).sounds(BlockSoundGroup.WOOD)
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
    //endregion
    //endregion
    //region Copper
    //chiseled
    public static final Block CHISELED_COPPER = registerBlock("chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_CHISELED_COPPER = registerBlock("exposed_chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_CHISELED_COPPER = registerBlock("weathered_chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_CHISELED_COPPER = registerBlock("oxidized_chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_CHISELED_COPPER = registerBlock("waxed_chiseled_copper",
            new Block(FabricBlockSettings.copyOf(CHISELED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_CHISELED_COPPER = registerBlock("waxed_exposed_chiseled_copper",
            new Block(FabricBlockSettings.copyOf(EXPOSED_CHISELED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_CHISELED_COPPER = registerBlock("waxed_weathered_chiseled_copper",
            new Block(FabricBlockSettings.copyOf(WEATHERED_CHISELED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_CHISELED_COPPER = registerBlock("waxed_oxidized_chiseled_copper",
            new Block(FabricBlockSettings.copyOf(OXIDIZED_CHISELED_COPPER)), ModItemGroup.SHUCKLE_BACKPORT);

    //grate
    public static final Block COPPER_GRATE = registerBlock("copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.of(Material.METAL)
                            .mapColor(Blocks.COPPER_BLOCK.getDefaultMapColor())
                            .strength(3.0F, 6.0F)
                            .sounds(ModSounds.COPPER_GRATE)
                            .nonOpaque().requiresTool()
                            .allowsSpawning(((state, world, pos, type) -> false))
                            .solidBlock(((state, world, pos) -> false))
                            .suffocates(((state, world, pos) -> false))
                            .blockVision(((state, world, pos) -> false))), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_GRATE = registerBlock("exposed_copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(COPPER_GRATE).mapColor(Blocks.EXPOSED_COPPER.getDefaultMapColor())),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_GRATE = registerBlock("weathered_copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(COPPER_GRATE).mapColor(Blocks.WEATHERED_COPPER.getDefaultMapColor())),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_GRATE = registerBlock("oxidized_copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(COPPER_GRATE).mapColor(Blocks.OXIDIZED_COPPER.getDefaultMapColor())),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_GRATE = registerBlock("waxed_copper_grate",
            new GrateBlock(FabricBlockSettings.copyOf(COPPER_GRATE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_GRATE = registerBlock("waxed_exposed_copper_grate",
            new GrateBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_GRATE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_GRATE = registerBlock("waxed_weathered_copper_grate",
            new GrateBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_GRATE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_GRATE = registerBlock("waxed_oxidized_copper_grate",
            new GrateBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_GRATE)), ModItemGroup.SHUCKLE_BACKPORT);

    //bulbs
    public static final Block COPPER_BULB = registerBlock("copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.of(Material.METAL)
                            .mapColor(Blocks.COPPER_BLOCK.getDefaultMapColor())
                            .strength(3.0F, 6.0F)
                            .sounds(ModSounds.COPPER_BULB)
                            .requiresTool()
                            .solidBlock(((state, world, pos) -> false))
                            .luminance((state) -> (Boolean)state.get(Properties.LIT) ? 15 : 0)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_BULB = registerBlock("exposed_copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(COPPER_BULB).mapColor(Blocks.EXPOSED_COPPER.getDefaultMapColor())
                            .luminance((state) -> (Boolean)state.get(Properties.LIT) ? 12 : 0)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_BULB = registerBlock("weathered_copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(COPPER_BULB).mapColor(Blocks.WEATHERED_COPPER.getDefaultMapColor())
                            .luminance((state) -> (Boolean)state.get(Properties.LIT) ? 8 : 0)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_BULB = registerBlock("oxidized_copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(COPPER_BULB).mapColor(Blocks.OXIDIZED_COPPER.getDefaultMapColor())
                            .luminance((state) -> (Boolean)state.get(Properties.LIT) ? 4 : 0)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_BULB = registerBlock("waxed_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(COPPER_BULB)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_BULB = registerBlock("waxed_exposed_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_BULB)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_BULB = registerBlock("waxed_weathered_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_BULB)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_BULB = registerBlock("waxed_oxidized_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_BULB)), ModItemGroup.SHUCKLE_BACKPORT);

    //doors
    public static final Block COPPER_DOOR = registerBlock("copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.of(Material.METAL)
                            .mapColor(Blocks.COPPER_BLOCK.getDefaultMapColor())
                            .strength(3.0F, 6.0F)
                            .nonOpaque().requiresTool()
                            .sounds(BlockSoundGroup.COPPER), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_DOOR = registerBlock("exposed_copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(COPPER_DOOR).mapColor(Blocks.EXPOSED_COPPER.getDefaultMapColor()),
            BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_DOOR = registerBlock("weathered_copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(COPPER_DOOR).mapColor(Blocks.WEATHERED_COPPER.getDefaultMapColor()),
                    BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_DOOR = registerBlock("oxidized_copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(COPPER_DOOR).mapColor(Blocks.OXIDIZED_COPPER.getDefaultMapColor()),
                    BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_DOOR = registerBlock("waxed_copper_door",
            new CopperDoorBlock(FabricBlockSettings.copyOf(COPPER_DOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_DOOR = registerBlock("waxed_exposed_copper_door",
            new CopperDoorBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_DOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_DOOR = registerBlock("waxed_weathered_copper_door",
            new CopperDoorBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_DOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_DOOR = registerBlock("waxed_oxidized_copper_door",
            new CopperDoorBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_DOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);

    //trapdoors
    public static final Block COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.of(Material.METAL)
                            .mapColor(Blocks.COPPER_BLOCK.getDefaultMapColor())
                            .strength(3.0F, 6.0F)
                            .nonOpaque().requiresTool()
                            .allowsSpawning(((state, world, pos, type) -> false))
                            .sounds(BlockSoundGroup.COPPER), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_TRAPDOOR = registerBlock("exposed_copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(COPPER_TRAPDOOR).mapColor(Blocks.EXPOSED_COPPER.getDefaultMapColor()),
                    BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_TRAPDOOR = registerBlock("weathered_copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(COPPER_TRAPDOOR).mapColor(Blocks.WEATHERED_COPPER.getDefaultMapColor()),
                    BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_TRAPDOOR = registerBlock("oxidized_copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(COPPER_TRAPDOOR).mapColor(Blocks.OXIDIZED_COPPER.getDefaultMapColor()),
                    BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_TRAPDOOR = registerBlock("waxed_copper_trapdoor",
            new CopperTrapdoorBlock(FabricBlockSettings.copyOf(COPPER_TRAPDOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_TRAPDOOR = registerBlock("waxed_exposed_copper_trapdoor",
            new CopperTrapdoorBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_TRAPDOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_TRAPDOOR = registerBlock("waxed_weathered_copper_trapdoor",
            new CopperTrapdoorBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_TRAPDOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_TRAPDOOR = registerBlock("waxed_oxidized_copper_trapdoor",
            new CopperTrapdoorBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_TRAPDOOR), BlockSetType.IRON), ModItemGroup.SHUCKLE_BACKPORT);

    //torch
    public static final Block COPPER_TORCH = registerBlockWithoutBlockItem("copper_torch",
            new TorchBlock(FabricBlockSettings.of(Material.DECORATION)
                    .noCollision().breakInstantly()
                    .luminance(state -> 14)
                    .sounds(BlockSoundGroup.WOOD), ModParticles.COPPER_FIRE_FLAME_PARTICLE));
    public static final Block COPPER_WALL_TORCH = registerBlockWithoutBlockItem("copper_wall_torch",
            new WallTorchBlock(FabricBlockSettings.copyOf(COPPER_TORCH).dropsLike(COPPER_TORCH),
                    ModParticles.COPPER_FIRE_FLAME_PARTICLE));

    //lanterns
    public static final Block COPPER_LANTERN = registerBlock("copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.of(Material.METAL)
                    .requiresTool().strength(3.5f)
                            .sounds(BlockSoundGroup.LANTERN)
                            .luminance(state -> 15).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_LANTERN = registerBlock("exposed_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(COPPER_LANTERN).luminance(state -> 12)),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_LANTERN = registerBlock("weathered_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(COPPER_LANTERN).luminance(state -> 8)),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_LANTERN = registerBlock("oxidized_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(COPPER_LANTERN).luminance(state -> 4)),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_LANTERN = registerBlock("waxed_copper_lantern",
            new LanternBlock(FabricBlockSettings.copyOf(COPPER_LANTERN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_LANTERN = registerBlock("waxed_exposed_copper_lantern",
            new LanternBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_LANTERN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_LANTERN = registerBlock("waxed_weathered_copper_lantern",
            new LanternBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_LANTERN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_LANTERN = registerBlock("waxed_oxidized_copper_lantern",
            new LanternBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_LANTERN)), ModItemGroup.SHUCKLE_BACKPORT);

    //endregion
    //region Tuff

    //endregion
    public static final Block WILDFLOWERS = registerBlock("wildflowers",
            new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW)
                    .sounds(BlockSoundGroup.GRASS).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LEAF_LITTER = registerBlock("leaf_litter",
            new FlatFlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static void registerModBlocks() {
        //called so the class loads
    }
}
