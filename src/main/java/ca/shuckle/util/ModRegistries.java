package ca.shuckle.util;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModRegistries {
    public static void registerModStuff(){
        registerFuels();
        registerStrippables();
        registerCompostables();
        registerFlammableBlock();
    }

    private static int getSmeltTime(double itemsSmelted){
        return (int)(itemsSmelted * 200);
    }
    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBackportBlocks.MANGROVE_PROPAGULE, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.MANGROVE_LOG, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_WOOD, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_MANGROVE_LOG, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_MANGROVE_WOOD, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_PLANKS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_SLAB, getSmeltTime(0.75));
        registry.add(ModBackportBlocks.MANGROVE_STAIRS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_DOOR, getSmeltTime(1));
        registry.add(ModBackportBlocks.MANGROVE_TRAPDOOR, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_FENCE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_FENCE_GATE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_BUTTON, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.MANGROVE_PRESSURE_PLATE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.MANGROVE_ROOTS, getSmeltTime(1.5));

        registry.add(ModBackportBlocks.CHERRY_SAPLING, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.CHERRY_LOG, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_WOOD, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_CHERRY_LOG, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_CHERRY_WOOD, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_PLANKS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_SLAB, getSmeltTime(0.75));
        registry.add(ModBackportBlocks.CHERRY_STAIRS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_DOOR, getSmeltTime(1));
        registry.add(ModBackportBlocks.CHERRY_TRAPDOOR, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_FENCE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_FENCE_GATE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.CHERRY_BUTTON, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.CHERRY_PRESSURE_PLATE, getSmeltTime(1.5));

        registry.add(ModBackportBlocks.BAMBOO_BLOCK, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_PLANKS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_SLAB, getSmeltTime(0.75));
        registry.add(ModBackportBlocks.BAMBOO_STAIRS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_DOOR, getSmeltTime(1));
        registry.add(ModBackportBlocks.BAMBOO_TRAPDOOR, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_FENCE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_FENCE_GATE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_BUTTON, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.BAMBOO_PRESSURE_PLATE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_MOSAIC, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.BAMBOO_MOSAIC_SLAB, getSmeltTime(0.75));
        registry.add(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS, getSmeltTime(1.5));

        registry.add(ModBackportBlocks.PALE_OAK_SAPLING, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.PALE_OAK_LOG, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_WOOD, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_PALE_OAK_LOG, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_PLANKS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_SLAB, getSmeltTime(0.75));
        registry.add(ModBackportBlocks.PALE_OAK_STAIRS, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_DOOR, getSmeltTime(1));
        registry.add(ModBackportBlocks.PALE_OAK_TRAPDOOR, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_FENCE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_FENCE_GATE, getSmeltTime(1.5));
        registry.add(ModBackportBlocks.PALE_OAK_BUTTON, getSmeltTime(0.5));
        registry.add(ModBackportBlocks.PALE_OAK_PRESSURE_PLATE, getSmeltTime(1.5));

        registry.add(ModBackportBlocks.LEAF_LITTER, getSmeltTime(0.5));
        registry.add(ModBlocks.LEAF_LITTER_OAK, getSmeltTime(0.5));
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBackportBlocks.MANGROVE_LOG, ModBackportBlocks.STRIPPED_MANGROVE_LOG);
        StrippableBlockRegistry.register(ModBackportBlocks.MANGROVE_WOOD, ModBackportBlocks.STRIPPED_MANGROVE_WOOD);

        StrippableBlockRegistry.register(ModBackportBlocks.CHERRY_LOG, ModBackportBlocks.STRIPPED_CHERRY_LOG);
        StrippableBlockRegistry.register(ModBackportBlocks.CHERRY_WOOD, ModBackportBlocks.STRIPPED_CHERRY_WOOD);

        StrippableBlockRegistry.register(ModBackportBlocks.BAMBOO_BLOCK, ModBackportBlocks.STRIPPED_BAMBOO_BLOCK);

        StrippableBlockRegistry.register(ModBackportBlocks.PALE_OAK_LOG, ModBackportBlocks.STRIPPED_PALE_OAK_LOG);
        StrippableBlockRegistry.register(ModBackportBlocks.PALE_OAK_WOOD, ModBackportBlocks.STRIPPED_PALE_OAK_WOOD);
    }

    private static void registerCompostables(){
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;

        registry.add(ModBackportBlocks.MANGROVE_PROPAGULE, 0.3f);
        registry.add(ModBackportBlocks.MANGROVE_LEAVES, 0.3f);
        registry.add(ModBackportBlocks.MANGROVE_ROOTS, 0.3f);

        registry.add(ModBackportBlocks.CHERRY_SAPLING, 0.3f);
        registry.add(ModBackportBlocks.CHERRY_LEAVES, 0.3f);

        registry.add(ModBackportBlocks.PALE_OAK_SAPLING, 0.3f);
        registry.add(ModBackportBlocks.PALE_OAK_LEAVES, 0.3f);

        registry.add(ModBackportBlocks.PALE_MOSS_BLOCK, 0.65f);
        registry.add(ModBackportBlocks.PALE_MOSS_CARPET, 0.3f);
        registry.add(ModBackportBlocks.PALE_GRASS, 0.3f);
        registry.add(ModBackportBlocks.PALE_TALL_GRASS, 0.5f);

        registry.add(ModBackportBlocks.PINK_PETALS, 0.3f);
        registry.add(ModBackportBlocks.WILDFLOWERS, 0.3f);
        registry.add(ModBlocks.WILDFLOWERS_RED_BLUE, 0.3f);

        registry.add(ModBackportBlocks.LEAF_LITTER, 0.3f);
        registry.add(ModBlocks.LEAF_LITTER_OAK, 0.3f);
    }

    private static void registerFlammableBlock() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBackportBlocks.MANGROVE_LEAVES, 30, 60);
        instance.add(ModBackportBlocks.MANGROVE_LOG, 5, 5);
        instance.add(ModBackportBlocks.MANGROVE_WOOD, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_MANGROVE_LOG, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_MANGROVE_WOOD, 5, 5);
        instance.add(ModBackportBlocks.MANGROVE_PLANKS, 5, 20);
        instance.add(ModBackportBlocks.MANGROVE_SLAB, 5, 20);
        instance.add(ModBackportBlocks.MANGROVE_STAIRS, 5, 20);
        instance.add(ModBackportBlocks.MANGROVE_FENCE, 5, 20);
        instance.add(ModBackportBlocks.MANGROVE_FENCE_GATE, 5, 20);
        instance.add(ModBackportBlocks.MANGROVE_ROOTS, 30, 60);

        instance.add(ModBackportBlocks.CHERRY_LEAVES, 30, 60);
        instance.add(ModBackportBlocks.CHERRY_LOG, 5, 5);
        instance.add(ModBackportBlocks.CHERRY_WOOD, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_CHERRY_LOG, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_CHERRY_WOOD, 5, 5);
        instance.add(ModBackportBlocks.CHERRY_PLANKS, 5, 20);
        instance.add(ModBackportBlocks.CHERRY_SLAB, 5, 20);
        instance.add(ModBackportBlocks.CHERRY_STAIRS, 5, 20);
        instance.add(ModBackportBlocks.CHERRY_FENCE, 5, 20);
        instance.add(ModBackportBlocks.CHERRY_FENCE_GATE, 5, 20);

        instance.add(ModBackportBlocks.BAMBOO_BLOCK, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_BAMBOO_BLOCK, 5, 5);
        instance.add(ModBackportBlocks.BAMBOO_PLANKS, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_SLAB, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_STAIRS, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_FENCE, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_FENCE_GATE, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_MOSAIC, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_MOSAIC_SLAB, 5, 20);
        instance.add(ModBackportBlocks.BAMBOO_MOSAIC_STAIRS, 5, 20);

        instance.add(ModBackportBlocks.PALE_OAK_LEAVES, 30, 60);
        instance.add(ModBackportBlocks.PALE_OAK_LOG, 5, 5);
        instance.add(ModBackportBlocks.PALE_OAK_WOOD, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_PALE_OAK_LOG, 5, 5);
        instance.add(ModBackportBlocks.STRIPPED_PALE_OAK_WOOD, 5, 5);
        instance.add(ModBackportBlocks.PALE_OAK_PLANKS, 5, 20);
        instance.add(ModBackportBlocks.PALE_OAK_SLAB, 5, 20);
        instance.add(ModBackportBlocks.PALE_OAK_STAIRS, 5, 20);
        instance.add(ModBackportBlocks.PALE_OAK_FENCE, 5, 20);
        instance.add(ModBackportBlocks.PALE_OAK_FENCE_GATE, 5, 20);

        instance.add(ModBackportBlocks.PINK_PETALS, 30, 60);
        instance.add(ModBackportBlocks.WILDFLOWERS, 30, 60);
        instance.add(ModBlocks.WILDFLOWERS_RED_BLUE, 30, 60);

        instance.add(ModBackportBlocks.LEAF_LITTER, 30, 60);
        instance.add(ModBlocks.LEAF_LITTER_OAK, 30, 60);
    }
}
