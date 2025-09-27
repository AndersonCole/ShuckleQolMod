package ca.shuckle.world.feature;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?,?>> PALE_OAK_TREE_KEY = registerKey("pale_oak_tree");
    public static RegistryKey<ConfiguredFeature<?,?>> PALE_OAK_TREE_SPAWN_KEY = registerKey("pale_oak_tree_spawn");

    public static RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_KEY = registerKey("pale_moss");
    public static RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_VEGETATION_KEY = registerKey("pale_moss_vegetation");
    public static RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_PATCH_KEY = registerKey("pale_moss_patch");
    public static RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_BONEMEAL_KEY = registerKey("pale_moss_bonemeal");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PALE_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBackportBlocks.PALE_OAK_LOG),
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.of(ModBackportBlocks.PALE_OAK_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());

        register(context, PALE_OAK_TREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PALE_OAK_TREE_PLACED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PALE_OAK_TREE_PLACED_KEY)));

        register(context, PALE_MOSS_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(ModBackportBlocks.PALE_MOSS_CARPET.getDefaultState(), 25)
                                .add(ModBackportBlocks.PALE_GRASS.getDefaultState(), 50)
                                .add(ModBackportBlocks.PALE_TALL_GRASS.getDefaultState(), 10))));

        register(context, PALE_MOSS_VEGETATION_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(ModBackportBlocks.PALE_MOSS_CARPET.getDefaultState(), 25)
                                .add(ModBackportBlocks.PALE_GRASS.getDefaultState(), 50)
                                .add(ModBackportBlocks.PALE_TALL_GRASS.getDefaultState(), 10))));

        register(context, PALE_MOSS_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(ModBackportBlocks.PALE_MOSS_BLOCK),
                        PlacedFeatures.createEntry(configuredFeatureRegistryEntryLookup.getOrThrow(PALE_MOSS_VEGETATION_KEY),
                                new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.0f, 5, 0.8f,
                        UniformIntProvider.create(4, 7), 0.3f));

        register(context, PALE_MOSS_BONEMEAL_KEY, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                BlockStateProvider.of(ModBackportBlocks.PALE_MOSS_BLOCK),
                PlacedFeatures.createEntry(configuredFeatureRegistryEntryLookup.getOrThrow(PALE_MOSS_VEGETATION_KEY),
                new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                ConstantIntProvider.create(1), 0.0f, 5, 0.6f,
                UniformIntProvider.create(1, 2), 0.75f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ShuckleQOL.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
