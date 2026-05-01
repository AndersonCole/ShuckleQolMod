package ca.shuckle.block.entity;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.entity.custom.CrafterBlockEntity;
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

    public static void registerBlockEntities() {}
}
