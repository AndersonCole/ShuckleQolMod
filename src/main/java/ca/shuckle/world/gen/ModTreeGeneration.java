package ca.shuckle.world.gen;

import ca.shuckle.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        RegistryKey<Biome> SWAMP = RegistryKey.of(Registry.BIOME_KEY, new Identifier("minecraft", "swamp"));
        RegistryKey<Biome> MEADOW = RegistryKey.of(Registry.BIOME_KEY, new Identifier("minecraft", "meadow"));
        RegistryKey<Biome> DARK_FOREST = RegistryKey.of(Registry.BIOME_KEY, new Identifier("minecraft", "dark_forest"));

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MANGROVE_PLACED.getKey().get());

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_MANGROVE_PLACED.getKey().get());

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHERRY_PLACED.getKey().get());

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PALE_OAK_PLACED.getKey().get());
    }
}
