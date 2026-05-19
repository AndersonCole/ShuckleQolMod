package ca.shuckle.particle.custom;

import ca.shuckle.particle.effect.GeyserBaseParticleEffect;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;

public class GeyserBaseParticle extends AscendingParticle {

    private GeyserBaseParticle(ClientWorld world, double x, double y, double z,
                               double xd, double yd, double zd, int waterBlocks,
                               float burstImpulseBase, SpriteProvider sprites) {
        super(world, x, y, z,
                burstImpulseBase + 0.25f * waterBlocks,
                burstImpulseBase + 0.25f * waterBlocks,
                burstImpulseBase + 0.25f * waterBlocks,
                xd, yd, zd, 2.0f + 0.125f + waterBlocks, sprites,
                0.0f, 0, 0.0f, true);
        this.velocityMultiplier = 0.725f;
        this.red = 1.0f;
        this.blue = 1.0f;
        this.green = 1.0f;
        this.velocityY = Math.abs(this.velocityY);
        this.maxAge = (int)(25.0f * (0.8f + 0.2f * world.random.nextFloat()));
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<GeyserBaseParticleEffect> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(GeyserBaseParticleEffect effect, ClientWorld world, double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            double rx = x + (world.random.nextFloat() - 0.5f) * 0.5f;
            double ry = y + (world.random.nextFloat() - 0.5f) * 0.5f + 0.2f;
            double rz = z + (world.random.nextFloat() - 0.5f) * 0.5f;
            return new GeyserBaseParticle(world, rx, ry, rz, velocityX, velocityY, velocityZ,
                    effect.getWaterBlocks(), effect.getBurstImpluseBase(), sprites);
        }
    }
}
