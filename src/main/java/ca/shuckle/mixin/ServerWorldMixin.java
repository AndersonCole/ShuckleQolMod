package ca.shuckle.mixin;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.Heightmap;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.function.Supplier;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World {
    protected ServerWorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef, DynamicRegistryManager registryManager, RegistryEntry<DimensionType> dimensionEntry, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Shadow
    protected abstract PointOfInterestStorage getPointOfInterestStorage();

    @Shadow
    public abstract ServerWorld toServerWorld();

    @Inject(method = "getLightningRodPos", at=@At("HEAD"), cancellable = true)
    private void getLightningRodPos(BlockPos pos, CallbackInfoReturnable<Optional<BlockPos>> info) {
        Optional<BlockPos> optional = this.getPointOfInterestStorage().getNearestPosition((poiType) -> {
            return poiType.matchesKey(PointOfInterestTypes.LIGHTNING_ROD) ||
                    poiType.matchesKey(RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(ShuckleQOL.MOD_ID, "invisible_lightning_rod_poi")));
        }, (posx) -> {
            return posx.getY() == this.getTopY(Heightmap.Type.WORLD_SURFACE, posx.getX(), posx.getZ()) - 1;
        }, pos, 128, PointOfInterestStorage.OccupationStatus.ANY);
        info.setReturnValue(optional.map((posx) -> {
            return posx.up(1);
        }));
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
                    target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I"
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
