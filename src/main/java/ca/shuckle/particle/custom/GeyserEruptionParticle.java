package ca.shuckle.particle.custom;

import ca.shuckle.particle.ModParticles;
import ca.shuckle.particle.effect.GeyserBaseParticleEffect;
import ca.shuckle.particle.effect.GeyserParticleEffect;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.block.entity.CampfireBlockEntityRenderer;
import net.minecraft.client.world.ClientWorld;

public class GeyserEruptionParticle extends NoRenderParticle {
    private final int waterBlocks;
    private final double xd, yd, zd;
    private final GeyserParticleEffect plumeParticle;
    private final GeyserBaseParticleEffect baseParticle;
    private final GeyserBaseParticleEffect poofParticle;

    protected GeyserEruptionParticle (ClientWorld clientWorld, double x, double y, double z,
        double xd, double yd, double zd, GeyserParticleEffect options) {
        super(clientWorld, x, y, z, xd, yd, zd);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.waterBlocks = options.getWaterBlocks();
        this.maxAge = 20;
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.velocityZ = 0.0f;
        this.plumeParticle = new GeyserParticleEffect(ModParticles.GEYSER_PLUME, this.waterBlocks);
        this.baseParticle = new GeyserBaseParticleEffect(ModParticles.GEYSER_BASE, this.waterBlocks, 1.5f);
        this.poofParticle = new GeyserBaseParticleEffect(ModParticles.GEYSER_POOF, this.waterBlocks, 2.0f);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age % 2 == 0) {
            for (int i = 0; i < 2; i++) {
                this.world.addParticle(this.baseParticle, this.x, this.y, this.z, this.zd, this.yd, this.xd);
            }
        }

        for (int i = 0; i < this.waterBlocks + 2; i++) {
            this.world.addParticle(this.plumeParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
        }

        if (this.age % 10 == 0) {
            for (int i = 0; i < 20; i++) {
                this.world.addParticle(this.poofParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<GeyserParticleEffect> {
        public Factory(SpriteProvider sprites) {}

        @Override
        public Particle createParticle(GeyserParticleEffect effect, ClientWorld world, double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            return new GeyserEruptionParticle(world, x, y, z, velocityX, velocityY, velocityZ, effect);
        }
    }
}
