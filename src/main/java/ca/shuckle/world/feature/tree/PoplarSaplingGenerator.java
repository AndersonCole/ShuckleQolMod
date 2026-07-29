package ca.shuckle.world.feature.tree;

import ca.shuckle.world.feature.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class PoplarSaplingGenerator extends SaplingGenerator {

    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        int randInt = random.nextInt(3);
        if (randInt == 0) {
            return ModConfiguredFeatures.RED_POPLAR_TREE_KEY;
        } else if (randInt == 1) {
            return ModConfiguredFeatures.ORANGE_POPLAR_TREE_KEY;
        }
        return ModConfiguredFeatures.YELLOW_POPLAR_TREE_KEY;
    }
}
