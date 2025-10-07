package ca.shuckle.datagen;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //region Backport Blocks
        //region Cherry blocks
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.CHERRY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.CHERRY_LEAVES);

        blockStateModelGenerator.registerLog(ModBackportBlocks.CHERRY_LOG).log(ModBackportBlocks.CHERRY_LOG).wood(ModBackportBlocks.CHERRY_WOOD);
        blockStateModelGenerator.registerLog(ModBackportBlocks.STRIPPED_CHERRY_LOG).log(ModBackportBlocks.STRIPPED_CHERRY_LOG).wood(ModBackportBlocks.STRIPPED_CHERRY_WOOD);

        BlockStateModelGenerator.BlockTexturePool cherryPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.CHERRY_PLANKS);
        cherryPool.slab(ModBackportBlocks.CHERRY_SLAB);
        cherryPool.stairs(ModBackportBlocks.CHERRY_STAIRS);
        blockStateModelGenerator.registerDoor(ModBackportBlocks.CHERRY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBackportBlocks.CHERRY_TRAPDOOR);
        cherryPool.fence(ModBackportBlocks.CHERRY_FENCE);
        cherryPool.fenceGate(ModBackportBlocks.CHERRY_FENCE_GATE);
        cherryPool.button(ModBackportBlocks.CHERRY_BUTTON);
        cherryPool.pressurePlate(ModBackportBlocks.CHERRY_PRESSURE_PLATE);
        //endregion
        //region Bamboo
        blockStateModelGenerator.registerLog(ModBackportBlocks.BAMBOO_BLOCK).log(ModBackportBlocks.BAMBOO_BLOCK);
        blockStateModelGenerator.registerLog(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK).log(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK);

        BlockStateModelGenerator.BlockTexturePool bambooPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.BAMBOO_PLANKS);
        bambooPool.slab(ModBackportBlocks.BAMBOO_SLAB);
        bambooPool.stairs(ModBackportBlocks.BAMBOO_STAIRS);
        blockStateModelGenerator.registerDoor(ModBackportBlocks.BAMBOO_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBackportBlocks.BAMBOO_TRAPDOOR);
        bambooPool.fence(ModBackportBlocks.BAMBOO_FENCE);
        bambooPool.fenceGate(ModBackportBlocks.BAMBOO_FENCE_GATE);
        bambooPool.button(ModBackportBlocks.BAMBOO_BUTTON);
        bambooPool.pressurePlate(ModBackportBlocks.BAMBOO_PRESSURE_PLATE);

        BlockStateModelGenerator.BlockTexturePool bambooMosaicPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.BAMBOO_MOSAIC);
        bambooMosaicPool.slab(ModBackportBlocks.BAMBOO_MOSAIC_SLAB);
        bambooMosaicPool.stairs(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS);
        //endregion
        //region Pale Garden
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.PALE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.PALE_OAK_LEAVES);

        blockStateModelGenerator.registerLog(ModBackportBlocks.PALE_OAK_LOG).log(ModBackportBlocks.PALE_OAK_LOG).wood(ModBackportBlocks.PALE_OAK_WOOD);
        blockStateModelGenerator.registerLog(ModBackportBlocks.STRIPPED_PALE_OAK_LOG).log(ModBackportBlocks.STRIPPED_PALE_OAK_LOG).wood(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD);

        BlockStateModelGenerator.BlockTexturePool paleOakPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.PALE_OAK_PLANKS);
        paleOakPool.slab(ModBackportBlocks.PALE_OAK_SLAB);
        paleOakPool.stairs(ModBackportBlocks.PALE_OAK_STAIRS);
        blockStateModelGenerator.registerDoor(ModBackportBlocks.PALE_OAK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBackportBlocks.PALE_OAK_TRAPDOOR);
        paleOakPool.fence(ModBackportBlocks.PALE_OAK_FENCE);
        paleOakPool.fenceGate(ModBackportBlocks.PALE_OAK_FENCE_GATE);
        paleOakPool.button(ModBackportBlocks.PALE_OAK_BUTTON);
        paleOakPool.pressurePlate(ModBackportBlocks.PALE_OAK_PRESSURE_PLATE);

        blockStateModelGenerator.registerWoolAndCarpet(ModBackportBlocks.PALE_MOSS_BLOCK, ModBackportBlocks.PALE_MOSS_CARPET);
        blockStateModelGenerator.registerTintableCross(ModBackportBlocks.PALE_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBackportBlocks.CREAKING_HEART).log(ModBackportBlocks.CREAKING_HEART);
        blockStateModelGenerator.registerLog(ModBackportBlocks.ACTIVE_CREAKING_HEART).log(ModBackportBlocks.ACTIVE_CREAKING_HEART);

        blockStateModelGenerator.registerItemModel(ModBackportBlocks.RESIN_CLUMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.RESIN_BLOCK);
        BlockStateModelGenerator.BlockTexturePool resinBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBackportBlocks.RESIN_BRICKS);
        resinBrickPool.slab(ModBackportBlocks.RESIN_BRICK_SLAB);
        resinBrickPool.stairs(ModBackportBlocks.RESIN_BRICK_STAIRS);
        resinBrickPool.wall(ModBackportBlocks.RESIN_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBackportBlocks.CHISELED_RESIN_BRICKS);
        //endregion
        blockStateModelGenerator.registerFlowerbed(ModBackportBlocks.PINK_PETALS);
        blockStateModelGenerator.registerFlowerbed(ModBackportBlocks.WILDFLOWERS);
        //endregion

        //region Shuckle Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_BLACK_ICE);
        blockStateModelGenerator.registerFlowerbed(ModBlocks.WILDFLOWERS_RED_BLUE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHUCKLE_MYSTERY_BLOCK);
        //endregion
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.RESIN_BRICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.INVIS_ITEM_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.INVIS_GLOW_ITEM_FRAME, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLACK_ICE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_ICE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_FAMILIAR_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FAMILIAR_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEAK_SHUCKLE_DNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.NORMAL_SHUCKLE_DNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWOLE_SHUCKLE_DNA, Models.GENERATED);

        itemModelGenerator.register(ModItems.MANGROVE_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHERRY_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAMBOO_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALE_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BERRY_JUICE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ZYGARDE_CELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZYGARDE_CELL_FIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZYGARDE_CELL_TWENTY_FIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZYGARDE_CELL_HUNDRED_TWENTY_FIVE, Models.GENERATED);
    }
}
