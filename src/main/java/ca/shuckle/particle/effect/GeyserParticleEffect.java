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
                    boolean isLava = reader.readBoolean();
                    return new GeyserParticleEffect(type, waterBlocks, isLava);
                }

                @Override
                public GeyserParticleEffect read(ParticleType<GeyserParticleEffect> type,
                                                 PacketByteBuf buf) {
                    return new GeyserParticleEffect(type, buf.readInt(), buf.readBoolean());
                }
            };

    private final ParticleType<GeyserParticleEffect> type;
    private final int waterBlocks;
    private final boolean isLava;

    public GeyserParticleEffect(ParticleType<GeyserParticleEffect> type, int waterBlocks, boolean isLava) {
        this.type = type;
        this.waterBlocks = waterBlocks;
        this.isLava = isLava;
    }

    public int getWaterBlocks() {
        return this.waterBlocks;
    }

    public boolean isLava() {
        return this.isLava;
    }

    @Override
    public ParticleType<GeyserParticleEffect> getType() {
        return this.type;
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeInt(this.waterBlocks);
        buf.writeBoolean(this.isLava);
    }

    @Override
    public String asString() {
        return Registries.PARTICLE_TYPE.getId(this.type) + " " + this.waterBlocks + " " + this.isLava;
    }
}
