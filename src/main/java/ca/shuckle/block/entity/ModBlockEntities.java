package ca.shuckle.block.entity;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.entity.custom.CrafterBlockEntity;
import ca.shuckle.block.entity.custom.PotentCinnabarBlockEntity;
import ca.shuckle.block.entity.custom.PotentSulfurBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<CrafterBlockEntity> CRAFTER = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("crafter"),
            FabricBlockEntityTypeBuilder.create(CrafterBlockEntity::new, ModBackportBlocks.CRAFTER).build()
    );
    public static final BlockEntityType<PotentSulfurBlockEntity> POTENT_SULFUR = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("potent_sulfur"),
            FabricBlockEntityTypeBuilder.create(PotentSulfurBlockEntity::new, ModBackportBlocks.POTENT_SULFUR).build()
    );
    public static final BlockEntityType<PotentCinnabarBlockEntity> POTENT_CINNABAR = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("potent_cinnabar"),
            FabricBlockEntityTypeBuilder.create(PotentCinnabarBlockEntity::new, ModBackportBlocks.POTENT_CINNABAR).build()
    );

    public static void registerBlockEntities() {}
}
