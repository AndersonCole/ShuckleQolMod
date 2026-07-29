package ca.shuckle.particle.custom;

import ca.shuckle.particle.effect.GeyserParticleEffect;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;

public class GeyserPlumeParticle extends SpriteBillboardParticle {
    private final SpriteProvider sprites;
    private final boolean isLava;
    private final double startY;
    private final double maxY;
    private final float initialPropulsion;
    private final float horizontalSprayX;
    private final float horizontalSprayZ;
    private final float minSize;
    private final float maxSize;
    private boolean done;

    private GeyserPlumeParticle(ClientWorld world, double x, double y, double z,
                                double xd, double yd, double zd, GeyserParticleEffect options, SpriteProvider sprites) {
        super(world, x, y, z, xd, yd, zd);
        int plumeHeight = 5 * Math.max(1, options.getWaterBlocks());
        this.collidesWithWorld = true;
        this.maxAge = plumeHeight * 5;
        this.velocityY = 0.0;
        this.startY = y;
        this.maxY = this.startY + plumeHeight - 1.0;
        this.horizontalSprayX = (world.random.nextFloat() - 0.5f) * 0.2f;
        this.horizontalSprayZ = (world.random.nextFloat() - 0.5f) * 0.2f;
        this.velocityMultiplier = 1.0f;
        this.initialPropulsion = (options.getWaterBlocks() == 1 ? 1.5f : 1.0f) * plumeHeight * 1.45f;
        this.gravityStrength = -this.initialPropulsion;
        this.isLava = options.isLava();
        float initialSize = this.scale * 0.75f;
        this.minSize = initialSize * (2.0f + plumeHeight / 8.0f);
        this.maxSize = initialSize * (3.0f + plumeHeight / 8.0f);
        this.scale = this.minSize;
        this.sprites = sprites;
        this.setSpriteForAge(sprites);
        if (this.isLava){
            if (random.nextFloat() < 0.08F) {
                this.setColor(
                        0.34F + random.nextFloat() * 0.08F,
                        0.28F + random.nextFloat() * 0.05F,
                        0.22F + random.nextFloat() * 0.04F);
            } else {
                float smoke = 0.12F + random.nextFloat() * 0.18F;
                this.setColor(smoke, smoke, smoke);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.done && (this.velocityY < 0.0 || this.y > this.maxY || this.y == this.prevPosY)) {
            this.maxAge = Math.min(this.maxAge, this.age + 5);
            this.velocityMultiplier = 0.0f;
            this.done = true;
        }

        double yProgressLinear = Math.min(1.0, Math.max(0.0,
                (this.y - this.startY) / (this.maxY - this.startY)));
        double yProgressExponential = Math.pow(yProgressLinear, 3.0);
        this.gravityStrength = this.initialPropulsion * (float)yProgressExponential * 0.12f;
        this.velocityX = yProgressLinear * this.horizontalSprayX;
        this.velocityZ = yProgressLinear * this.horizontalSprayZ;
        this.setSpriteForAge(sprites);
        this.scale = this.minSize + (float)(yProgressLinear * (this.maxSize - this.minSize));
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<GeyserParticleEffect> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(GeyserParticleEffect effect, ClientWorld world, double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            double rx = x + (world.random.nextFloat() - 0.5f) * 0.2f;
            double ry = y + world.random.nextFloat();
            double rz = z + (world.random.nextFloat() - 0.5f) + 0.2f;
            return new GeyserPlumeParticle(world, x, y, z, velocityX, velocityY, velocityZ, effect, this.sprites);
        }
    }
}
