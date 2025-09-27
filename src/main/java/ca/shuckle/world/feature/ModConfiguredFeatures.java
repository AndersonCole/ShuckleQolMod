package ca.shuckle.world.feature;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.*;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MANGROVE_TREE =
            ConfiguredFeatures.register("mangrove_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBackportBlocks.MANGROVE_LOG),
                    new ForkingTrunkPlacer(6, 3, 2),
                    BlockStateProvider.of(ModBackportBlocks.MANGROVE_LEAVES),
                    new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 3),
                    new ThreeLayersFeatureSize(1, 2, 1, 2, 2, OptionalInt.empty()))
                    .decorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> MANGROVE_CHECKED =
            PlacedFeatures.register("mangrove_checked", MANGROVE_TREE,
                    PlacedFeatures.wouldSurvive(ModBackportBlocks.MANGROVE_PROPAGULE));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MANGROVE_SPAWN =
            ConfiguredFeatures.register("mangrove_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(MANGROVE_CHECKED, 0.5f)),
                            MANGROVE_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> LARGE_MANGROVE_TREE =
            ConfiguredFeatures.register("large_mangrove_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBackportBlocks.MANGROVE_LOG),
                    new MegaJungleTrunkPlacer(10, 2, 12),
                    BlockStateProvider.of(ModBackportBlocks.MANGROVE_LEAVES),
                    new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 1, 2, OptionalInt.empty()))
                    .decorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> LARGE_MANGROVE_CHECKED =
            PlacedFeatures.register("large_mangrove_checked", LARGE_MANGROVE_TREE,
                    PlacedFeatures.wouldSurvive(ModBackportBlocks.MANGROVE_PROPAGULE));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> LARGE_MANGROVE_SPAWN =
            ConfiguredFeatures.register("large_mangrove_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(LARGE_MANGROVE_CHECKED, 0.5f)),
                            LARGE_MANGROVE_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CHERRY_TREE =
            ConfiguredFeatures.register("cherry_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBackportBlocks.CHERRY_LOG),
                    new ForkingTrunkPlacer(6, 3, 2),
                    BlockStateProvider.of(ModBackportBlocks.CHERRY_LEAVES),
                    new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 3),
                    new ThreeLayersFeatureSize(1, 2, 1, 2, 2, OptionalInt.empty())).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> CHERRY_CHECKED =
            PlacedFeatures.register("cherry_checked", CHERRY_TREE,
                    PlacedFeatures.wouldSurvive(ModBackportBlocks.CHERRY_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CHERRY_SPAWN =
            ConfiguredFeatures.register("cherry_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CHERRY_CHECKED, 0.5f)),
                            CHERRY_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> PALE_OAK_TREE =
            ConfiguredFeatures.register("pale_oak_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBackportBlocks.PALE_OAK_LOG),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    BlockStateProvider.of(ModBackportBlocks.PALE_OAK_LEAVES),
                    new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> PALE_OAK_CHECKED =
            PlacedFeatures.register("pale_oak_checked", PALE_OAK_TREE,
                    PlacedFeatures.wouldSurvive(ModBackportBlocks.PALE_OAK_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> PALE_OAK_SPAWN =
            ConfiguredFeatures.register("pale_oak_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(PALE_OAK_CHECKED, 0.5f)),
                            PALE_OAK_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> PALE_MOSS_VEGETATION =
            ConfiguredFeatures.register("pale_moss_vegetation", Feature.SIMPLE_BLOCK,
                    new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                            DataPool.<BlockState>builder()
                                    .add(ModBackportBlocks.PALE_MOSS_CARPET.getDefaultState(), 25)
                                    .add(ModBackportBlocks.PALE_GRASS.getDefaultState(), 50)
                                    .add(ModBackportBlocks.PALE_TALL_GRASS.getDefaultState(), 10))));

    public static final RegistryEntry<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> PALE_MOSS_PATCH =
            ConfiguredFeatures.register("pale_moss_patch", Feature.VEGETATION_PATCH,
                    new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                            BlockStateProvider.of(ModBackportBlocks.PALE_MOSS_BLOCK),
                            PlacedFeatures.createEntry(PALE_MOSS_VEGETATION,
                                new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.0f, 5, 0.8f,
                        UniformIntProvider.create(4, 7), 0.3f));

    public static final RegistryEntry<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> PALE_MOSS_PATCH_BONEMEAL =
            ConfiguredFeatures.register("pale_moss_patch_bonemeal",
                    Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                            BlockStateProvider.of(ModBackportBlocks.PALE_MOSS_BLOCK), PlacedFeatures.createEntry(PALE_MOSS_VEGETATION,
                            new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                            ConstantIntProvider.create(1), 0.0f, 5, 0.6f,
                            UniformIntProvider.create(1, 2), 0.75f));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> SCULK_VEGETATION =
            ConfiguredFeatures.register("sculk_vegetation", Feature.SIMPLE_BLOCK,
                    new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                            DataPool.<BlockState>builder()
                                    .add(ModBackportBlocks.SCULK_VEIN.getStateManager().getStates().get(63), 25)
                                    .add(ModBackportBlocks.SCULK_CATALYST.getDefaultState(), 2)
                                    .add(Blocks.SCULK_SENSOR.getDefaultState(), 2))));

    public static final RegistryEntry<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> SCULK_PATCH_BONEMEAL =
            ConfiguredFeatures.register("sculk_patch_bonemeal",
                    Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                            BlockStateProvider.of(ModBackportBlocks.SCULK), PlacedFeatures.createEntry(SCULK_VEGETATION,
                            new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                            ConstantIntProvider.create(1), 1.0f, 5, 0.4f,
                            UniformIntProvider.create(3, 4), 0.75f));

    public static void registerConfiguredFeatures() {ShuckleQOL.LOGGER.info("Registering ModConfiguredFeatures for " + ShuckleQOL.MOD_ID);}
}
