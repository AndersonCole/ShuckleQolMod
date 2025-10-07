package ca.shuckle.datagen;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //region Backport Blocks
        //region Cherry
        addDrop(ModBackportBlocks.CHERRY_SAPLING);
        addDrop(ModBackportBlocks.POTTED_CHERRY_SAPLING, pottedPlantDrops(ModBackportBlocks.CHERRY_SAPLING));

        addDrop(ModBackportBlocks.CHERRY_LOG);
        addDrop(ModBackportBlocks.CHERRY_WOOD);
        addDrop(ModBackportBlocks.STRIPPED_CHERRY_LOG);
        addDrop(ModBackportBlocks.STRIPPED_CHERRY_WOOD);

        addDrop(ModBackportBlocks.CHERRY_PLANKS);
        addDrop(ModBackportBlocks.CHERRY_SLAB, slabDrops(ModBackportBlocks.CHERRY_SLAB));
        addDrop(ModBackportBlocks.CHERRY_STAIRS);
        addDrop(ModBackportBlocks.CHERRY_DOOR, doorDrops(ModBackportBlocks.CHERRY_DOOR));
        addDrop(ModBackportBlocks.CHERRY_TRAPDOOR);
        addDrop(ModBackportBlocks.CHERRY_FENCE);
        addDrop(ModBackportBlocks.CHERRY_FENCE_GATE);
        addDrop(ModBackportBlocks.CHERRY_BUTTON);
        addDrop(ModBackportBlocks.CHERRY_PRESSURE_PLATE);
        addDrop(ModBackportBlocks.CHERRY_SIGN);
        //endregion
        //region Bamboo

        //endregion
        addDrop(ModBackportBlocks.REINFORCED_DEEPSLATE);

        addDrop(ModBackportBlocks.PACKED_MUD_SLAB, slabDrops(ModBackportBlocks.PACKED_MUD_SLAB));
        addDrop(ModBackportBlocks.PACKED_MUD_STAIRS);
        addDrop(ModBackportBlocks.PACKED_MUD_WALL);
        //endregion
    }
}
