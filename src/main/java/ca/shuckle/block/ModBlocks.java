package ca.shuckle.block;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.custom.*;
import ca.shuckle.block.entity.ModSignTypes;
import ca.shuckle.item.ModItemGroup;
import ca.shuckle.world.feature.tree.CherrySaplingGenerator;
import ca.shuckle.world.feature.tree.MangrovePropaguleGenerator;
import ca.shuckle.world.feature.tree.PaleOakSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.decoration.GlowItemFrameEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block CONDENSED_BLACK_ICE = registerBlock("condensed_black_ice",
            new Block(FabricBlockSettings.of(Material.DENSE_ICE)
                    .strength(2.8f)
                    .slipperiness(0.99f)
                    .sounds(BlockSoundGroup.GLASS)
                    .allowsSpawning(((state, world, pos, type) -> false))), ModItemGroup.SHUCKLE);

    public static final Block ANCIENT_STONE_SLAB = registerBlock("ancient_stone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.STONE)), ModItemGroup.SHUCKLE);

    public static final Block ANCIENT_STONE_STAIRS = registerBlock("ancient_stone_stairs",
            new StairsBlock(Blocks.STONE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.STONE)), ModItemGroup.SHUCKLE);

    public static final Block ANCIENT_STONE_WALL = registerBlock("ancient_stone_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.STONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_SANDSTONE_SLAB = registerBlock("black_sandstone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_SANDSTONE_STAIRS = registerBlock("black_sandstone_stairs",
            new StairsBlock(Blocks.SANDSTONE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_SANDSTONE_WALL = registerBlock("black_sandstone_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_CUT_SANDSTONE_SLAB = registerBlock("black_cut_sandstone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_CUT_SANDSTONE_STAIRS = registerBlock("black_cut_sandstone_stairs",
            new StairsBlock(Blocks.CUT_SANDSTONE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.CUT_SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_CUT_SANDSTONE_WALL = registerBlock("black_cut_sandstone_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_SMOOTH_SANDSTONE_SLAB = registerBlock("black_smooth_sandstone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_SMOOTH_SANDSTONE_STAIRS = registerBlock("black_smooth_sandstone_stairs",
            new StairsBlock(Blocks.SMOOTH_SANDSTONE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block BLACK_SMOOTH_SANDSTONE_WALL = registerBlock("black_smooth_sandstone_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE)), ModItemGroup.SHUCKLE);

    public static final Block EBONY_SIGN = registerBlockWithoutBlockItem("ebony_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.EBONY), ModItemGroup.SHUCKLE);

    public static final Block EBONY_WALL_SIGN = registerBlockWithoutBlockItem("ebony_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN)
                    .dropsLike(EBONY_SIGN), ModSignTypes.EBONY), ModItemGroup.SHUCKLE);

    public static final Block WILDFLOWERS_RED_BLUE = registerBlock("wildflowers_red_blue",
            new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.GRASS).noCollision().nonOpaque()), ModItemGroup.SHUCKLE);

    public static final Block LEAF_LITTER_OAK = registerBlock("leaf_litter_oak",
            new FlatFlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).noCollision().nonOpaque()), ModItemGroup.SHUCKLE);

    public static final Block INVIS_LIGHTNING_ROD = registerBlock("invisible_lightning_rod",
            new LightningRodBlock(FabricBlockSettings.of(Material.METAL, MapColor.CLEAR)
                    .requiresTool()
                    .strength(3.0f, 6.0f)
                    .nonOpaque()), ModItemGroup.SHUCKLE);

    public static final Block INVIS_CARPET = registerBlock("invisible_carpet",
            new CarpetBlock(FabricBlockSettings.of(Material.PLANT, MapColor.CLEAR)
                    .strength(0.1f)
                    .sounds(BlockSoundGroup.MOSS_CARPET)
                    .nonOpaque().noCollision()), ModItemGroup.SHUCKLE);

    public static final Block INVIS_SIGN = registerBlockWithoutBlockItem("invisible_sign",
            new SignBlock(FabricBlockSettings.of(Material.WOOD, MapColor.CLEAR)
                    .noCollision()
                    .strength(1.0f)
                    .sounds(BlockSoundGroup.WOOD), ModSignTypes.INVIS), ModItemGroup.SHUCKLE);

    public static final Block INVIS_WALL_SIGN = registerBlockWithoutBlockItem("invisible_wall_sign",
            new WallSignBlock(FabricBlockSettings.of(Material.WOOD, MapColor.CLEAR)
                    .noCollision()
                    .strength(1.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .dropsLike(INVIS_SIGN), ModSignTypes.INVIS), ModItemGroup.SHUCKLE);

    public static final Block SHUCKLE_MYSTERY_BLOCK = registerBlock("shuckle_mystery_block",
            new Block(FabricBlockSettings.of(Material.SCULK, MapColor.BLACK)
                    .sounds(BlockSoundGroup.SCULK_SENSOR)
                    .strength(10, 10)), ModItemGroup.SHUCKLE);

    public static final Block SHUCKLE_BLOCK = registerBlock("shuckle_block",
            new ShuckleBlock(FabricBlockSettings.copy(Blocks.GLASS)
                    .nonOpaque().strength(3, 10)), ModItemGroup.SHUCKLE);

    public static final Block SHINY_SHUCKLE_BLOCK = registerBlock("shiny_shuckle_block",
            new ShuckleBlock(FabricBlockSettings.copy(Blocks.GLASS)
                    .nonOpaque().strength(3, 10)), ModItemGroup.SHUCKLE);

    public static final Block ZYGARDE_CELL = registerBlock("zygarde_cell_ground",
            new FlatFlowerbedBlock(FabricBlockSettings.of(Material.SCULK, MapColor.GREEN)
                    .sounds(BlockSoundGroup.SCULK_SENSOR).noCollision().nonOpaque()), ModItemGroup.SHUCKLE);


    public static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.BLOCK, new Identifier(ShuckleQOL.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ShuckleQOL.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(ShuckleQOL.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        ShuckleQOL.LOGGER.info("Registering ModBlocks for " + ShuckleQOL.MOD_ID);
        ModBackportBlocks.registerModBlocks();
    }

}
