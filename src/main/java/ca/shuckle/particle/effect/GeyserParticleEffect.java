package ca.shuckle.particle.effect;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;


public class GeyserParticleEffect implements ParticleEffect {
    public static final ParticleEffect.Factory<GeyserParticleEffect> FACTORY =
            new ParticleEffect.Factory<>() {
                @Override
                public GeyserParticleEffect read(ParticleType<GeyserParticleEffect> type,
                                                 StringReader reader) throws CommandSyntaxException {
                    reader.expect(' ');
                    int waterBlocks = reader.readInt();
                    return new GeyserParticleEffect(type, waterBlocks);
                }

                @Override
                public GeyserParticleEffect read(ParticleType<GeyserParticleEffect> type,
                                                 PacketByteBuf buf) {
                    return new GeyserParticleEffect(type, buf.readInt());
                }
            };

    private final ParticleType<GeyserParticleEffect> type;
    private final int waterBlocks;

    public GeyserParticleEffect(ParticleType<GeyserParticleEffect> type, int waterBlocks) {
        this.type = type;
        this.waterBlocks = waterBlocks;
    }

    public int getWaterBlocks() {
        return this.waterBlocks;
    }

    @Override
    public ParticleType<GeyserParticleEffect> getType() {
        return this.type;
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeInt(this.waterBlocks);
    }

    @Override
    public String asString() {
        return Registries.PARTICLE_TYPE.getId(this.type) + " " + this.waterBlocks;
    }
}
