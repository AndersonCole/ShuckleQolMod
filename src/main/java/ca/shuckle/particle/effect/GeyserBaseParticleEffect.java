package ca.shuckle.particle.effect;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.particle.CampfireSmokeParticle;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;

public class GeyserBaseParticleEffect implements ParticleEffect {
    public static final ParticleEffect.Factory<GeyserBaseParticleEffect> FACTORY =
            new ParticleEffect.Factory<>() {
                @Override
                public GeyserBaseParticleEffect read(ParticleType<GeyserBaseParticleEffect> type,
                                                 StringReader reader) throws CommandSyntaxException {
                    reader.expect(' ');
                    int waterBlocks = reader.readInt();
                    boolean isLava = reader.readBoolean();
                    float burstImpluseBase = reader.readFloat();
                    return new GeyserBaseParticleEffect(type, waterBlocks, isLava, burstImpluseBase);
                }

                @Override
                public GeyserBaseParticleEffect read(ParticleType<GeyserBaseParticleEffect> type,
                                                 PacketByteBuf buf) {
                    return new GeyserBaseParticleEffect(type, buf.readInt(), buf.readBoolean(), buf.readFloat());
                }
            };

    private final ParticleType<GeyserBaseParticleEffect> type;
    private final int waterBlocks;
    private final boolean isLava;
    private final float burstImpluseBase;

    public GeyserBaseParticleEffect(ParticleType<GeyserBaseParticleEffect> type, int waterBlocks, boolean isLava, float burstImpluseBase) {
        this.type = type;
        this.waterBlocks = waterBlocks;
        this.isLava = isLava;
        this.burstImpluseBase = burstImpluseBase;
    }

    public int getWaterBlocks() {
        return this.waterBlocks;
    }

    public boolean isLava() {
        return this.isLava;
    }

    public float getBurstImpluseBase() {
        return this.burstImpluseBase;
    }

    @Override
    public ParticleType<GeyserBaseParticleEffect> getType() {
        return this.type;
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeInt(this.waterBlocks);
        buf.writeBoolean(this.isLava);
        buf.writeFloat(this.burstImpluseBase);
    }

    @Override
    public String asString() {
        return Registries.PARTICLE_TYPE.getId(this.type) + " " + this.waterBlocks + " " + this.isLava;
    }
}
