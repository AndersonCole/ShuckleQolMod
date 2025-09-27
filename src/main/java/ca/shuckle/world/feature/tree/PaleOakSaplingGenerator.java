package ca.shuckle.world.feature.tree;

import ca.shuckle.world.feature.ModConfiguredFeatures;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PaleOakSaplingGenerator extends LargeTreeSaplingGenerator {

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return null;
    }

    @Override
    @Nullable
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return ModConfiguredFeatures.PALE_OAK_TREE;
    }
}
