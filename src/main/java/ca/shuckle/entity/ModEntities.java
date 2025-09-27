package ca.shuckle.entity;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.entity.custom.InvisGlowItemFrameEntity;
import ca.shuckle.entity.custom.InvisItemFrameEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<InvisItemFrameEntity> INVIS_ITEM_FRAME = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShuckleQOL.MOD_ID, "invisible_item_frame"),
            FabricEntityTypeBuilder.<InvisItemFrameEntity>create(SpawnGroup.MISC, InvisItemFrameEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeChunks(10).build());

    public static final EntityType<InvisGlowItemFrameEntity> INVIS_GLOW_ITEM_FRAME = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShuckleQOL.MOD_ID, "invisible_glow_item_frame"),
            FabricEntityTypeBuilder.<InvisGlowItemFrameEntity>create(SpawnGroup.MISC, InvisGlowItemFrameEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeChunks(10).build());
}
