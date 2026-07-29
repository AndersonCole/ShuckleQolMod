package ca.shuckle.particle.custom;

import ca.shuckle.particle.effect.GeyserBaseParticleEffect;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;

public class GeyserBaseParticle extends AscendingParticle {

    private GeyserBaseParticle(ClientWorld world, double x, double y, double z,
                               double xd, double yd, double zd, int waterBlocks,
                               boolean isLava, float burstImpulseBase, SpriteProvider sprites) {
        super(world, x, y, z,
                burstImpulseBase + 0.25f * waterBlocks,
                burstImpulseBase + 0.25f * waterBlocks,
                burstImpulseBase + 0.25f * waterBlocks,
                xd, yd, zd, 2.0f + 0.125f + waterBlocks, sprites,
                0.0f, 0, 0.0f, true);
        this.velocityMultiplier = 0.725f;
        if (isLava){
            if (random.nextFloat() < 0.08F) {
                this.setColor(
                        0.34F + random.nextFloat() * 0.08F,
                        0.28F + random.nextFloat() * 0.05F,
                        0.22F + random.nextFloat() * 0.04F);
            } else {
                float smoke = 0.12F + random.nextFloat() * 0.18F;
                this.setColor(smoke, smoke, smoke);
            }
        }else{
            this.setColor(1.0f, 1.0f, 1.0f);
        }
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
                    effect.getWaterBlocks(), effect.isLava(), effect.getBurstImpluseBase(), sprites);
        }
    }
}
