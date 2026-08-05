package ca.shuckle.block;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.custom.*;
import ca.shuckle.block.custom.copper.*;
import ca.shuckle.item.ModItemGroup;
import ca.shuckle.particle.ModParticles;
import ca.shuckle.util.ModSounds;
import ca.shuckle.world.feature.tree.CherrySaplingGenerator;
import ca.shuckle.world.feature.tree.PaleOakSaplingGenerator;
import ca.shuckle.world.feature.tree.PoplarSaplingGenerator;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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

    //region Hanging Signs
    public static final Block OAK_HANGING_SIGN = registerBlockWithoutBlockItem("oak_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/oak"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/oak"),
                    FabricBlockSettings.of(Material.WOOD).noCollision().strength(1.0f).sounds(BlockSoundGroup.HANGING_SIGN)));
    public static final Block OAK_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("oak_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/oak"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/oak"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.OAK_HANGING_SIGN)));

    public static final Block SPRUCE_HANGING_SIGN = registerBlockWithoutBlockItem("spruce_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/spruce"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/spruce"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block SPRUCE_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("spruce_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/spruce"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/spruce"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.SPRUCE_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.SPRUCE_HANGING_SIGN)));

    public static final Block BIRCH_HANGING_SIGN = registerBlockWithoutBlockItem("birch_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/birch"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/birch"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block BIRCH_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("birch_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/birch"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/birch"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.BIRCH_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.BIRCH_HANGING_SIGN)));

    public static final Block JUNGLE_HANGING_SIGN = registerBlockWithoutBlockItem("jungle_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/jungle"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/jungle"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block JUNGLE_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("jungle_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/jungle"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/jungle"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.JUNGLE_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.JUNGLE_HANGING_SIGN)));

    public static final Block ACACIA_HANGING_SIGN = registerBlockWithoutBlockItem("acacia_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/acacia"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/acacia"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block ACACIA_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("acacia_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/acacia"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/acacia"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.ACACIA_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.ACACIA_HANGING_SIGN)));

    public static final Block DARK_OAK_HANGING_SIGN = registerBlockWithoutBlockItem("dark_oak_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/dark_oak"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/dark_oak"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block DARK_OAK_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("dark_oak_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/dark_oak"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/dark_oak"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.DARK_OAK_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.DARK_OAK_HANGING_SIGN)));

    public static final Block MANGROVE_HANGING_SIGN = registerBlockWithoutBlockItem("mangrove_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/mangrove"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/mangrove"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block MANGROVE_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("mangrove_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/mangrove"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/mangrove"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.MANGROVE_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.MANGROVE_HANGING_SIGN)));

    public static final Block CRIMSON_HANGING_SIGN = registerBlockWithoutBlockItem("crimson_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/crimson"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/crimson"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN)));
    public static final Block CRIMSON_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("crimson_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/crimson"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/crimson"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.CRIMSON_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.CRIMSON_HANGING_SIGN)));

    public static final Block WARPED_HANGING_SIGN = registerBlockWithoutBlockItem("warped_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/warped"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/warped"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN)));
    public static final Block WARPED_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("warped_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/warped"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/warped"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.WARPED_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.WARPED_HANGING_SIGN)));
    //endregion
    //region Shelves
    public static final Block OAK_SHELF = registerBlock("oak_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SPRUCE_SHELF = registerBlock("spruce_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.SPRUCE_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BIRCH_SHELF = registerBlock("birch_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.BIRCH_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block JUNGLE_SHELF = registerBlock("jungle_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.JUNGLE_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block ACACIA_SHELF = registerBlock("acacia_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.ACACIA_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block DARK_OAK_SHELF = registerBlock("dark_oak_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.DARK_OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block MANGROVE_SHELF = registerBlock("mangrove_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.MANGROVE_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CRIMSON_SHELF = registerBlock("crimson_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.CRIMSON_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WARPED_SHELF = registerBlock("warped_shelf",
            new ShelfBlock(FabricBlockSettings.copy(Blocks.WARPED_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //region Dyed Blocks
    //region Wool
    public static final Block WHITE_WOOL_SLAB = registerBlock("white_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.WHITE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WHITE_WOOL_STAIRS = registerBlock("white_wool_stairs",
            new StairsBlock(Blocks.WHITE_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.WHITE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIGHT_GRAY_WOOL_SLAB = registerBlock("light_gray_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block LIGHT_GRAY_WOOL_STAIRS = registerBlock("light_gray_wool_stairs",
            new StairsBlock(Blocks.LIGHT_GRAY_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIGHT_GRAY_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block GRAY_WOOL_SLAB = registerBlock("gray_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GRAY_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block GRAY_WOOL_STAIRS = registerBlock("gray_wool_stairs",
            new StairsBlock(Blocks.GRAY_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.GRAY_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BLACK_WOOL_SLAB = registerBlock("black_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BLACK_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BLACK_WOOL_STAIRS = registerBlock("black_wool_stairs",
            new StairsBlock(Blocks.BLACK_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BLACK_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BROWN_WOOL_SLAB = registerBlock("brown_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BROWN_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BROWN_WOOL_STAIRS = registerBlock("brown_wool_stairs",
            new StairsBlock(Blocks.BROWN_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BROWN_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RED_WOOL_SLAB = registerBlock("red_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.RED_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block RED_WOOL_STAIRS = registerBlock("red_wool_stairs",
            new StairsBlock(Blocks.RED_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.RED_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block ORANGE_WOOL_SLAB = registerBlock("orange_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.ORANGE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block ORANGE_WOOL_STAIRS = registerBlock("orange_wool_stairs",
            new StairsBlock(Blocks.ORANGE_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.ORANGE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block YELLOW_WOOL_SLAB = registerBlock("yellow_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.YELLOW_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block YELLOW_WOOL_STAIRS = registerBlock("yellow_wool_stairs",
            new StairsBlock(Blocks.YELLOW_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.YELLOW_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIME_WOOL_SLAB = registerBlock("lime_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIME_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block LIME_WOOL_STAIRS = registerBlock("lime_wool_stairs",
            new StairsBlock(Blocks.LIME_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIME_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block GREEN_WOOL_SLAB = registerBlock("green_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GREEN_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block GREEN_WOOL_STAIRS = registerBlock("green_wool_stairs",
            new StairsBlock(Blocks.GREEN_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.GREEN_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CYAN_WOOL_SLAB = registerBlock("cyan_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.CYAN_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CYAN_WOOL_STAIRS = registerBlock("cyan_wool_stairs",
            new StairsBlock(Blocks.CYAN_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.CYAN_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIGHT_BLUE_WOOL_SLAB = registerBlock("light_blue_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block LIGHT_BLUE_WOOL_STAIRS = registerBlock("light_blue_wool_stairs",
            new StairsBlock(Blocks.LIGHT_BLUE_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIGHT_BLUE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BLUE_WOOL_SLAB = registerBlock("blue_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BLUE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BLUE_WOOL_STAIRS = registerBlock("blue_wool_stairs",
            new StairsBlock(Blocks.BLUE_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BLUE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PURPLE_WOOL_SLAB = registerBlock("purple_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PURPLE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block PURPLE_WOOL_STAIRS = registerBlock("purple_wool_stairs",
            new StairsBlock(Blocks.PURPLE_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PURPLE_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MAGENTA_WOOL_SLAB = registerBlock("magenta_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.MAGENTA_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block MAGENTA_WOOL_STAIRS = registerBlock("magenta_wool_stairs",
            new StairsBlock(Blocks.MAGENTA_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.MAGENTA_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PINK_WOOL_SLAB = registerBlock("pink_wool_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PINK_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block PINK_WOOL_STAIRS = registerBlock("pink_wool_stairs",
            new StairsBlock(Blocks.PINK_WOOL.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PINK_WOOL)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //region Concrete
    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            new StairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            new StairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            new StairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            new StairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.RED_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            new StairsBlock(Blocks.RED_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.RED_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            new StairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            new StairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            new StairsBlock(Blocks.LIME_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIME_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            new StairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            new StairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            new StairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            new StairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            new StairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            new StairsBlock(Blocks.PINK_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PINK_CONCRETE)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //endregion
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

    public static final Block CHERRY_SHELF = registerBlock("cherry_shelf",
            new ShelfBlock(FabricBlockSettings.copy(ModBackportBlocks.CHERRY_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHERRY_SIGN = registerBlockWithoutBlockItem("cherry_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/cherry"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.CHERRY_WOOD)));

    public static final Block CHERRY_WALL_SIGN = registerBlockWithoutBlockItem("cherry_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/cherry"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.CHERRY_WOOD)
                            .dropsLike(CHERRY_SIGN)));

    public static final Block CHERRY_HANGING_SIGN = registerBlockWithoutBlockItem("cherry_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/cherry"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/cherry"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.CHERRY_WOOD_HANGING_SIGN)));
    public static final Block CHERRY_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("cherry_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/cherry"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/cherry"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.CHERRY_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.CHERRY_HANGING_SIGN)));

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

    public static final Block BAMBOO_SHELF = registerBlock("bamboo_shelf",
            new ShelfBlock(FabricBlockSettings.copy(ModBackportBlocks.BAMBOO_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BAMBOO_SIGN = registerBlockWithoutBlockItem("bamboo_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/bamboo"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.BAMBOO)));

    public static final Block BAMBOO_WALL_SIGN = registerBlockWithoutBlockItem("bamboo_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/bamboo"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.BAMBOO)
                    .dropsLike(BAMBOO_SIGN)));

    public static final Block BAMBOO_HANGING_SIGN = registerBlockWithoutBlockItem("bamboo_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/bamboo"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/bamboo"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.BAMBOO_WOOD_HANGING_SIGN)));
    public static final Block BAMBOO_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("bamboo_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/bamboo"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/bamboo"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.BAMBOO_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.BAMBOO_HANGING_SIGN)));

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

    public static final Block PALE_OAK_SHELF = registerBlock("pale_oak_shelf",
            new ShelfBlock(FabricBlockSettings.copy(ModBackportBlocks.PALE_OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_OAK_SIGN = registerBlockWithoutBlockItem("pale_oak_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/pale_oak"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN)));

    public static final Block PALE_OAK_WALL_SIGN = registerBlockWithoutBlockItem("pale_oak_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/pale_oak"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN)
                            .dropsLike(PALE_OAK_SIGN)));

    public static final Block PALE_OAK_HANGING_SIGN = registerBlockWithoutBlockItem("pale_oak_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/pale_oak"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/pale_oak"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block PALE_OAK_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("pale_oak_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/pale_oak"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/pale_oak"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.PALE_OAK_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.PALE_OAK_HANGING_SIGN)));


    public static final Block PALE_MOSS_BLOCK = registerBlock("pale_moss_block",
            new PaleMossBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(FabricBlockSettings.copy(Blocks.MOSS_CARPET)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block PALE_HANGING_MOSS = registerBlock("pale_hanging_moss",
            new HangingMossBlock(FabricBlockSettings.copy(Blocks.HANGING_ROOTS)), ModItemGroup.SHUCKLE_BACKPORT);

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
    //region Poplar
    public static final Block POPLAR_SAPLING = registerBlock("poplar_sapling",
            new SaplingBlock(new PoplarSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POTTED_POPLAR_SAPLING = registerBlockWithoutBlockItem("potted_poplar_sapling",
            new FlowerPotBlock(ModBackportBlocks.POPLAR_SAPLING,
                    FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final Block RED_POPLAR_LEAVES = registerBlock("red_poplar_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block ORANGE_POPLAR_LEAVES = registerBlock("orange_poplar_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block YELLOW_POPLAR_LEAVES = registerBlock("yellow_poplar_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_LOG = registerBlock("poplar_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_WOOD = registerBlock("poplar_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_POPLAR_LOG = registerBlock("stripped_poplar_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block STRIPPED_POPLAR_WOOD = registerBlock("stripped_poplar_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_PLANKS = registerBlock("poplar_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_SLAB = registerBlock("poplar_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_STAIRS = registerBlock("poplar_stairs",
            new StairsBlock(ModBackportBlocks.POPLAR_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_DOOR = registerBlock("poplar_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), BlockSetType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_TRAPDOOR = registerBlock("poplar_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_FENCE = registerBlock("poplar_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_FENCE_GATE = registerBlock("poplar_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_BUTTON = registerBlock("poplar_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).noCollision(),
                    BlockSetType.OAK, 30, true), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_PRESSURE_PLATE = registerBlock("poplar_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).nonOpaque(), BlockSetType.OAK), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_SHELF = registerBlock("poplar_shelf",
            new ShelfBlock(FabricBlockSettings.copy(ModBackportBlocks.POPLAR_PLANKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POPLAR_SIGN = registerBlockWithoutBlockItem("poplar_sign",
            new TerraformSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/poplar"),
                    FabricBlockSettings.copy(Blocks.OAK_SIGN)));

    public static final Block POPLAR_WALL_SIGN = registerBlockWithoutBlockItem("poplar_wall_sign",
            new TerraformWallSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/poplar"),
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN)
                            .dropsLike(POPLAR_SIGN)));

    public static final Block POPLAR_HANGING_SIGN = registerBlockWithoutBlockItem("poplar_hanging_sign",
            new TerraformHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/poplar"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/poplar"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.OAK_HANGING_SIGN)));
    public static final Block POPLAR_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("poplar_wall_hanging_sign",
            new TerraformWallHangingSignBlock(new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/poplar"),
                    new Identifier(ShuckleQOL.MOD_ID, "textures/gui/hanging_signs/poplar"),
                    FabricBlockSettings.copyOf(ModBackportBlocks.POPLAR_HANGING_SIGN)
                            .dropsLike(ModBackportBlocks.POPLAR_HANGING_SIGN)));
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
                            .nonOpaque().requiresTool().ticksRandomly()
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

    //bars
    public static final Block COPPER_BARS = registerBlock("copper_bars",
            new OxidizablePaneBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.copyOf(Blocks.IRON_BARS).sounds(BlockSoundGroup.COPPER)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_BARS = registerBlock("exposed_copper_bars",
            new OxidizablePaneBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(ModBackportBlocks.COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_BARS = registerBlock("weathered_copper_bars",
            new OxidizablePaneBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(ModBackportBlocks.COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_BARS = registerBlock("oxidized_copper_bars",
            new OxidizablePaneBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(ModBackportBlocks.COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_BARS = registerBlock("waxed_copper_bars",
            new PaneBlock(FabricBlockSettings.copyOf(ModBackportBlocks.COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_BARS = registerBlock("waxed_exposed_copper_bars",
            new PaneBlock(FabricBlockSettings.copyOf(ModBackportBlocks.EXPOSED_COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_BARS = registerBlock("waxed_weathered_copper_bars",
            new PaneBlock(FabricBlockSettings.copyOf(ModBackportBlocks.WEATHERED_COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_BARS = registerBlock("waxed_oxidized_copper_bars",
            new PaneBlock(FabricBlockSettings.copyOf(ModBackportBlocks.OXIDIZED_COPPER_BARS)), ModItemGroup.SHUCKLE_BACKPORT);

    //chain
    public static final Block COPPER_CHAIN = registerBlock("copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.copyOf(Blocks.CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_COPPER_CHAIN = registerBlock("exposed_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(Blocks.CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_COPPER_CHAIN = registerBlock("weathered_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(Blocks.CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_COPPER_CHAIN = registerBlock("oxidized_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(Blocks.CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_COPPER_CHAIN = registerBlock("waxed_copper_chain",
            new ChainBlock(FabricBlockSettings.copyOf(ModBackportBlocks.COPPER_CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_COPPER_CHAIN = registerBlock("waxed_exposed_copper_chain",
            new ChainBlock(FabricBlockSettings.copyOf(ModBackportBlocks.EXPOSED_COPPER_CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_COPPER_CHAIN = registerBlock("waxed_weathered_copper_chain",
            new ChainBlock(FabricBlockSettings.copyOf(ModBackportBlocks.WEATHERED_COPPER_CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_COPPER_CHAIN = registerBlock("waxed_oxidized_copper_chain",
            new ChainBlock(FabricBlockSettings.copyOf(ModBackportBlocks.OXIDIZED_COPPER_CHAIN)), ModItemGroup.SHUCKLE_BACKPORT);

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

    //lightning rods
    public static final Block LIGHTNING_ROD = registerBlock("lightning_rod",
            new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                    FabricBlockSettings.copyOf(Blocks.LIGHTNING_ROD)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block EXPOSED_LIGHTNING_ROD = registerBlock("exposed_lightning_rod",
            new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.EXPOSED,
                    FabricBlockSettings.copyOf(Blocks.LIGHTNING_ROD).mapColor(Blocks.EXPOSED_COPPER.getDefaultMapColor())),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WEATHERED_LIGHTNING_ROD = registerBlock("weathered_lightning_rod",
            new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.WEATHERED,
                    FabricBlockSettings.copyOf(Blocks.LIGHTNING_ROD).mapColor(Blocks.WEATHERED_COPPER.getDefaultMapColor())),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block OXIDIZED_LIGHTNING_ROD = registerBlock("oxidized_lightning_rod",
            new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.OXIDIZED,
                    FabricBlockSettings.copyOf(Blocks.LIGHTNING_ROD).mapColor(Blocks.OXIDIZED_COPPER.getDefaultMapColor())),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_EXPOSED_LIGHTNING_ROD = registerBlock("waxed_exposed_lightning_rod",
            new LightningRodBlock(FabricBlockSettings.copyOf(ModBackportBlocks.EXPOSED_LIGHTNING_ROD)),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_WEATHERED_LIGHTNING_ROD = registerBlock("waxed_weathered_lightning_rod",
            new LightningRodBlock(FabricBlockSettings.copyOf(ModBackportBlocks.WEATHERED_LIGHTNING_ROD)),
            ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block WAXED_OXIDIZED_LIGHTNING_ROD = registerBlock("waxed_oxidized_lightning_rod",
            new LightningRodBlock(FabricBlockSettings.copyOf(ModBackportBlocks.OXIDIZED_LIGHTNING_ROD)),
            ModItemGroup.SHUCKLE_BACKPORT);

    //endregion
    //region Tuff
    public static final Block TUFF_SLAB = registerBlock("tuff_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block TUFF_STAIRS = registerBlock("tuff_stairs",
            new StairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block TUFF_WALL = registerBlock("tuff_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POLISHED_TUFF = registerBlock("polished_tuff",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF).sounds(ModSounds.POLISHED_TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_TUFF_SLAB = registerBlock("polished_tuff_slab",
            new SlabBlock(FabricBlockSettings.copyOf(POLISHED_TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_TUFF_STAIRS = registerBlock("polished_tuff_stairs",
            new StairsBlock(POLISHED_TUFF.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_TUFF_WALL = registerBlock("polished_tuff_wall",
            new WallBlock(FabricBlockSettings.copyOf(POLISHED_TUFF)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block TUFF_BRICKS = registerBlock("tuff_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF).sounds(ModSounds.TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block TUFF_BRICK_SLAB = registerBlock("tuff_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block TUFF_BRICK_STAIRS = registerBlock("tuff_brick_stairs",
            new StairsBlock(TUFF_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block TUFF_BRICK_WALL = registerBlock("tuff_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHISELED_TUFF = registerBlock("chiseled_tuff",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CHISELED_TUFF_BRICKS = registerBlock("chiseled_tuff_bricks",
            new Block(FabricBlockSettings.copyOf(TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //region Cinnabar
    public static final Block CINNABAR = registerBlock("cinnabar",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CINNABAR_SLAB = registerBlock("cinnabar_slab",
            new SlabBlock(FabricBlockSettings.copyOf(CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CINNABAR_STAIRS = registerBlock("cinnabar_stairs",
            new StairsBlock(CINNABAR.getDefaultState(), FabricBlockSettings.copyOf(CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CINNABAR_WALL = registerBlock("cinnabar_wall",
            new WallBlock(FabricBlockSettings.copyOf(CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POLISHED_CINNABAR = registerBlock("polished_cinnabar",
            new Block(FabricBlockSettings.copyOf(CINNABAR).sounds(ModSounds.POLISHED_TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_CINNABAR_SLAB = registerBlock("polished_cinnabar_slab",
            new SlabBlock(FabricBlockSettings.copyOf(POLISHED_CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_CINNABAR_STAIRS = registerBlock("polished_cinnabar_stairs",
            new StairsBlock(POLISHED_CINNABAR.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_CINNABAR_WALL = registerBlock("polished_cinnabar_wall",
            new WallBlock(FabricBlockSettings.copyOf(POLISHED_CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CINNABAR_BRICKS = registerBlock("cinnabar_bricks",
            new Block(FabricBlockSettings.copyOf(CINNABAR).sounds(ModSounds.TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CINNABAR_BRICK_SLAB = registerBlock("cinnabar_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(CINNABAR_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CINNABAR_BRICK_STAIRS = registerBlock("cinnabar_brick_stairs",
            new StairsBlock(CINNABAR_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(CINNABAR_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block CINNABAR_BRICK_WALL = registerBlock("cinnabar_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(CINNABAR_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHISELED_CINNABAR = registerBlock("chiseled_cinnabar",
            new Block(FabricBlockSettings.copyOf(CINNABAR).sounds(ModSounds.TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POTENT_CINNABAR = registerBlock("potent_cinnabar",
            new PotentCinnabarBlock(FabricBlockSettings.copyOf(CINNABAR)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    //region Sulfur
    public static final Block SULFUR = registerBlock("sulfur",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SULFUR_SLAB = registerBlock("sulfur_slab",
            new SlabBlock(FabricBlockSettings.copyOf(SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SULFUR_STAIRS = registerBlock("sulfur_stairs",
            new StairsBlock(SULFUR.getDefaultState(), FabricBlockSettings.copyOf(SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SULFUR_WALL = registerBlock("sulfur_wall",
            new WallBlock(FabricBlockSettings.copyOf(SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block POLISHED_SULFUR = registerBlock("polished_sulfur",
            new Block(FabricBlockSettings.copyOf(SULFUR).sounds(ModSounds.POLISHED_TUFF)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_SULFUR_SLAB = registerBlock("polished_sulfur_slab",
            new SlabBlock(FabricBlockSettings.copyOf(POLISHED_SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_SULFUR_STAIRS = registerBlock("polished_sulfur_stairs",
            new StairsBlock(POLISHED_SULFUR.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POLISHED_SULFUR_WALL = registerBlock("polished_sulfur_wall",
            new WallBlock(FabricBlockSettings.copyOf(POLISHED_SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block SULFUR_BRICKS = registerBlock("sulfur_bricks",
            new Block(FabricBlockSettings.copyOf(SULFUR).sounds(ModSounds.TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SULFUR_BRICK_SLAB = registerBlock("sulfur_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(SULFUR_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SULFUR_BRICK_STAIRS = registerBlock("sulfur_brick_stairs",
            new StairsBlock(SULFUR_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(SULFUR_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block SULFUR_BRICK_WALL = registerBlock("sulfur_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(SULFUR_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CHISELED_SULFUR = registerBlock("chiseled_sulfur",
            new Block(FabricBlockSettings.copyOf(SULFUR).sounds(ModSounds.TUFF_BRICKS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block POTENT_SULFUR = registerBlock("potent_sulfur",
            new PotentSulfurBlock(FabricBlockSettings.copyOf(SULFUR)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block SULFUR_SPIKE = registerBlock("sulfur_spike",
            new SulfurSpikeBlock(FabricBlockSettings.copyOf(Blocks.POINTED_DRIPSTONE)), ModItemGroup.SHUCKLE_BACKPORT);
    //endregion
    public static final Block WILDFLOWERS = registerBlock("wildflowers",
            new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW)
                    .sounds(BlockSoundGroup.GRASS).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LEAF_LITTER = registerBlock("leaf_litter",
            new FlatFlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).noCollision().nonOpaque()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block BUSH = registerBlock("bush",
            new ForestFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS)), ModItemGroup.SHUCKLE_BACKPORT);
    public static final Block RED_SHRUB = registerBlock("red_shrub",
            new ForestFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block FIREFLY_BUSH = registerBlock("firefly_bush",
            new ForestFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block LIT_FIREFLY_BUSH = registerBlock("lit_firefly_bush",
            new ForestFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block SHORT_DRY_GRASS = registerBlock("short_dry_grass",
            new DesertFernBlock(FabricBlockSettings.copy(Blocks.DEAD_BUSH)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block TALL_DRY_GRASS = registerBlock("tall_dry_grass",
            new DesertFernBlock(FabricBlockSettings.copy(Blocks.DEAD_BUSH)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CACTUS_FLOWER = registerBlock("cactus_flower",
            new CactusFlowerBlock(FabricBlockSettings.copy(Blocks.PEONY).sounds(BlockSoundGroup.AZALEA)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Block CRAFTER = registerBlock("crafter",
            new CrafterBlock(FabricBlockSettings.copy(Blocks.STONE)), ModItemGroup.SHUCKLE_BACKPORT);

    public static void registerModBlocks() {
        //called so the class loads
    }
}
