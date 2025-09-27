package ca.shuckle.block.custom;

import ca.shuckle.world.feature.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.MossBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class PaleMossBlock extends MossBlock {
    public PaleMossBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.getRegistryManager().getOptional(RegistryKeys.CONFIGURED_FEATURE).flatMap((registry) -> {
            return registry.getEntry(ModConfiguredFeatures.PALE_MOSS_BONEMEAL_KEY);
        }).ifPresent((reference) -> {
            ((ConfiguredFeature)reference.value()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up());
        });
    }
}
