package ca.shuckle.mixin;

import ca.shuckle.block.ModBlocks;
import ca.shuckle.util.ModPointsOfInterest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.Random;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
    @Shadow
    protected abstract PointOfInterestStorage getPointOfInterestStorage();

    @Shadow
    public abstract ServerWorld toServerWorld();

    @Inject(method = "getLightningRodPos", at=@At("HEAD"), cancellable = true)
    private void getLightningRodPos(BlockPos pos2, CallbackInfoReturnable<Optional<BlockPos>> info) {
        Optional<BlockPos> optional = this.getPointOfInterestStorage()
                .getNearestPosition(poiType ->
                        poiType == PointOfInterestType.LIGHTNING_ROD || poiType == ModPointsOfInterest.INVIS_LIGHTNING_ROD,
                        pos -> pos.getY() == this.toServerWorld().getTopY(Heightmap.Type.WORLD_SURFACE, pos.getX(), pos.getZ()) - 1,
                        pos2, 128, PointOfInterestStorage.OccupationStatus.ANY);
        info.setReturnValue(optional.map(pos -> pos.up(1)));
    }

    @Redirect(
            method = "tickChunk",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
            )
    )
    private boolean stopSkeletonHorseSpawnsOnLightningRods(BlockState state, Block block) {
        if (block == Blocks.LIGHTNING_ROD) {
            return state.isOf(Blocks.LIGHTNING_ROD) || state.isOf(ModBlocks.INVIS_LIGHTNING_ROD);
        }
        return state.isOf(block);
    }

    /**
    @Redirect(
            method = "tickChunk",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextDouble()D"
            )
    )
    private double alwaysTriggerSkeletonTrap(Random random) {
        return 0.0;
    }


    @Redirect(
            method = "tickChunk",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextInt(I)I"
            )
    )
    private int alwaysTriggerLightning(Random random, int bound) {
        if (bound == 100_000) {
            return 0;
        }
        return random.nextInt(bound);
    }
    **/
}
