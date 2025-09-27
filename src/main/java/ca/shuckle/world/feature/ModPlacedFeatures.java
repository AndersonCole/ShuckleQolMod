package ca.shuckle.world.feature;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> MANGROVE_PLACED = PlacedFeatures.register("mangrove_placed",
            ModConfiguredFeatures.MANGROVE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.25f, 1)));

    public static final RegistryEntry<PlacedFeature> LARGE_MANGROVE_PLACED = PlacedFeatures.register("large_mangrove_placed",
            ModConfiguredFeatures.LARGE_MANGROVE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.01f, 1)));
    public static final RegistryEntry<PlacedFeature> CHERRY_PLACED = PlacedFeatures.register("cherry_placed",
            ModConfiguredFeatures.CHERRY_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));
    public static final RegistryEntry<PlacedFeature> PALE_OAK_PLACED = PlacedFeatures.register("pale_oak_placed",
            ModConfiguredFeatures.PALE_OAK_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

    public static final RegistryEntry<PlacedFeature> PALE_MOSS_PLACED = PlacedFeatures.register("pale_moss_placed",
            ModConfiguredFeatures.PALE_MOSS_PATCH, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.05f, 2)));
}
