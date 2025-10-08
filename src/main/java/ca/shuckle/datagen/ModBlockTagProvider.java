package ca.shuckle.datagen;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
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
    }
}
