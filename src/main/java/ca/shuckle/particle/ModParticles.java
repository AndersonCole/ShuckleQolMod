package ca.shuckle.particle;


import ca.shuckle.ShuckleQOL;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType COPPER_FIRE_FLAME_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShuckleQOL.MOD_ID, "copper_fire_flame_particle"),
                COPPER_FIRE_FLAME_PARTICLE);
    }
}
