package ca.shuckle.mixin;

import ca.shuckle.block.custom.copper.*;
import ca.shuckle.state.ModStateManager;
import ca.shuckle.util.ModOxidizationHelpers;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({
        OxidizableBlock.class,
        OxidizableSlabBlock.class,
        OxidizableStairsBlock.class,
        OxidizableBulbBlock.class,
        OxidizableGrateBlock.class,
        OxidizableDoorBlock.class,
        OxidizableTrapdoorBlock.class,
        OxidizablePaneBlock.class,
        OxidizableChainBlock.class,
        OxidizableLanternBlock.class,
        OxidizableLightningRodBlock.class
})
public abstract class OxidizableBlockFamilyMixin extends Block implements Oxidizable {

    public OxidizableBlockFamilyMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void injected(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        boolean oxidizeFaster = ModStateManager.getServerState(world.getServer()).getOxidizeFaster();

        if (oxidizeFaster) {
            if(ModOxidizationHelpers.touchingWater(state, world, pos)){
                world.setBlockState(pos,ModOxidizationHelpers.tryDegrade(this,state));
                ci.cancel();
            }
        }
    }
}
