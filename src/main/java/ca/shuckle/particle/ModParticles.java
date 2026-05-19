package ca.shuckle.particle;


import ca.shuckle.ShuckleQOL;
import ca.shuckle.particle.effect.GeyserBaseParticleEffect;
import ca.shuckle.particle.effect.GeyserParticleEffect;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType COPPER_FIRE_FLAME_PARTICLE = FabricParticleTypes.simple();
    public static final ParticleType<GeyserParticleEffect> GEYSER = FabricParticleTypes.complex(true, GeyserParticleEffect.FACTORY);
    public static final ParticleType<GeyserBaseParticleEffect> GEYSER_BASE = FabricParticleTypes.complex(true, GeyserBaseParticleEffect.FACTORY);
    public static final ParticleType<GeyserBaseParticleEffect> GEYSER_POOF = FabricParticleTypes.complex(true, GeyserBaseParticleEffect.FACTORY);
    public static final ParticleType<GeyserParticleEffect> GEYSER_PLUME = FabricParticleTypes.complex(true, GeyserParticleEffect.FACTORY);

    public static void registerParticles(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShuckleQOL.MOD_ID, "copper_fire_flame_particle"),
                COPPER_FIRE_FLAME_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShuckleQOL.MOD_ID, "geyser_particle"),
                GEYSER);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShuckleQOL.MOD_ID, "geyser_base_particle"),
                GEYSER_BASE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShuckleQOL.MOD_ID, "geyser_poof_particle"),
                GEYSER_POOF);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShuckleQOL.MOD_ID, "geyser_plume_particle"),
                GEYSER_PLUME);
    }
}
