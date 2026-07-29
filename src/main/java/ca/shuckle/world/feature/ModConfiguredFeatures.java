package ca.shuckle.world.feature;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> CHERRY_TREE_KEY = registerKey("cherry_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PALE_OAK_TREE_KEY = registerKey("pale_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_POPLAR_TREE_KEY = registerKey("red_poplar_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORANGE_POPLAR_TREE_KEY = registerKey("orange_poplar_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> YELLOW_POPLAR_TREE_KEY = registerKey("yellow_poplar_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_VEGETATION_KEY = registerKey("pale_moss_vegetation");
    public static final RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_PATCH_KEY = registerKey("pale_moss_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> PALE_MOSS_BONEMEAL_KEY = registerKey("pale_moss_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?,?>> BUSH_VEGETATION_KEY = registerKey("bush_vegetation");
    public static final RegistryKey<ConfiguredFeature<?,?>> BUSH_PATCH_KEY = registerKey("bush_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_SHRUB_VEGETATION_KEY = registerKey("red_shrub_vegetation");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_SHRUB_PATCH_KEY = registerKey("red_shrub_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> DRY_GRASS_VEGETATION_KEY = registerKey("dry_grass_vegetation");
    public static final RegistryKey<ConfiguredFeature<?,?>> DRY_GRASS_PATCH_KEY = registerKey("dry_grass_patch");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SHUCKLE_ORE_KEY = registerKey("shuckle_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CHERRY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBackportBlocks.CHERRY_LOG),
                new CherryTrunkPlacer(7, 1, 0,
                        UniformIntProvider.create(1, 3), UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)),
                BlockStateProvider.of(ModBackportBlocks.CHERRY_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5),
                        0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, PALE_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBackportBlocks.PALE_OAK_LOG),
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.of(ModBackportBlocks.PALE_OAK_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                .decorators(List.of(new AttachedToLeavesTreeDecorator(0.14f, 1, 0,
                                BlockStateProvider.of((BlockState)ModBackportBlocks.PALE_HANGING_MOSS.getDefaultState()),
                                2, List.of(Direction.DOWN)))).ignoreVines().build());

        register(context, RED_POPLAR_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBackportBlocks.POPLAR_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(ModBackportBlocks.RED_POPLAR_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, ORANGE_POPLAR_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBackportBlocks.POPLAR_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(ModBackportBlocks.ORANGE_POPLAR_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, YELLOW_POPLAR_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBackportBlocks.POPLAR_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(ModBackportBlocks.YELLOW_POPLAR_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

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

        register(context, BUSH_VEGETATION_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(Blocks.AIR.getDefaultState(), 25)
                                .add(Blocks.GRASS.getDefaultState(), 25)
                                .add(ModBackportBlocks.BUSH.getDefaultState(), 20)
                                .add(ModBackportBlocks.FIREFLY_BUSH.getDefaultState(), 10)
                                .add(ModBackportBlocks.LIT_FIREFLY_BUSH.getDefaultState(), 5)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 1), 5)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 2), 10)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 3), 10)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 4), 5))));

        register(context, BUSH_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(Blocks.GRASS_BLOCK),
                        PlacedFeatures.createEntry(configuredFeatureRegistryEntryLookup.getOrThrow(BUSH_VEGETATION_KEY),
                                new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.0f, 2, 0.8f,
                        UniformIntProvider.create(2, 5), 0.3f));

        register(context, RED_SHRUB_VEGETATION_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(Blocks.AIR.getDefaultState(), 25)
                                .add(Blocks.GRASS.getDefaultState(), 25)
                                .add(ModBackportBlocks.RED_SHRUB.getDefaultState(), 20)
                                .add(ModBackportBlocks.FIREFLY_BUSH.getDefaultState(), 10)
                                .add(ModBackportBlocks.LIT_FIREFLY_BUSH.getDefaultState(), 5)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 1), 5)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 2), 10)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 3), 10)
                                .add(ModBackportBlocks.LEAF_LITTER.getDefaultState().with(Properties.FLOWER_AMOUNT, 4), 5))));

        register(context, RED_SHRUB_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(Blocks.GRASS_BLOCK),
                        PlacedFeatures.createEntry(configuredFeatureRegistryEntryLookup.getOrThrow(RED_SHRUB_VEGETATION_KEY),
                                new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.0f, 2, 0.8f,
                        UniformIntProvider.create(2, 5), 0.3f));

        register(context, DRY_GRASS_VEGETATION_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(Blocks.AIR.getDefaultState(), 75)
                                .add(Blocks.DEAD_BUSH.getDefaultState(), 5)
                                .add(Blocks.CACTUS.getDefaultState(), 5)
                                .add(ModBackportBlocks.CACTUS_FLOWER.getDefaultState(), 1)
                                .add(ModBackportBlocks.SHORT_DRY_GRASS.getDefaultState(), 20)
                                .add(ModBackportBlocks.TALL_DRY_GRASS.getDefaultState(), 10))));

        register(context, DRY_GRASS_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.DEAD_BUSH_MAY_PLACE_ON,
                        BlockStateProvider.of(Blocks.SAND),
                        PlacedFeatures.createEntry(configuredFeatureRegistryEntryLookup.getOrThrow(DRY_GRASS_VEGETATION_KEY),
                                new PlacementModifier[0]), VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.0f, 2, 0.5f,
                        UniformIntProvider.create(4, 7), 0.3f));

        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> shuckleOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.SHUCKLE_ORE.getDefaultState()));

        register(context, SHUCKLE_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(shuckleOre, 2, 1.0f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ShuckleQOL.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
