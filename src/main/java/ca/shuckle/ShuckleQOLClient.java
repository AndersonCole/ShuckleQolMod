package ca.shuckle;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.entity.ModEntities;
import ca.shuckle.entity.client.InvisibleItemFrameRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class ShuckleQOLClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.MANGROVE_PROPAGULE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.POTTED_MANGROVE_PROPAGULE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.MANGROVE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.MANGROVE_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.MANGROVE_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.CHERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.POTTED_CHERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.CHERRY_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.CHERRY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.CHERRY_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.BAMBOO_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.BAMBOO_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.POTTED_PALE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_OAK_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_TALL_GRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PINK_PETALS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILDFLOWERS_RED_BLUE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAF_LITTER_OAK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.SCULK_VEIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.RESIN_CLUMP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INVIS_LIGHTNING_ROD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INVIS_CARPET, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHUCKLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHINY_SHUCKLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZYGARDE_CELL, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.INVIS_ITEM_FRAME, InvisibleItemFrameRenderer::new);
        EntityRendererRegistry.register(ModEntities.INVIS_GLOW_ITEM_FRAME, InvisibleItemFrameRenderer::new);
    }
}
