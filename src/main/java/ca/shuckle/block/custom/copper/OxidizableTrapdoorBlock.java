package ca.shuckle.block.custom.copper;

import ca.shuckle.util.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class OxidizableTrapdoorBlock extends TrapdoorBlock implements Oxidizable {

    private final OxidationLevel oxidationLevel;

    public OxidizableTrapdoorBlock(OxidationLevel oxidationLevel, Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.oxidationLevel = oxidationLevel;
    }


    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        state = state.cycle(OPEN);
        world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
        if (state.get(WATERLOGGED).booleanValue()) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        world.playSound(null, pos, state.get(OPEN) ? ModSounds.BLOCK_COPPER_TRAPDOOR_OPEN : ModSounds.BLOCK_COPPER_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1F, 1F);

        return ActionResult.success(world.isClient);
    }

    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
