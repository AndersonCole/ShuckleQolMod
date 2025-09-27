package ca.shuckle.block.custom;

import ca.shuckle.world.feature.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.block.MossBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class SculkBlock extends MossBlock {
    public SculkBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        ModConfiguredFeatures.SCULK_PATCH_BONEMEAL.value().generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up());
    }
}
