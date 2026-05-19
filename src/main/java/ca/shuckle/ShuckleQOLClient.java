package ca.shuckle;

import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.entity.ModEntities;
import ca.shuckle.entity.client.InvisibleItemFrameRenderer;
import ca.shuckle.particle.ModParticles;
import ca.shuckle.particle.custom.CopperFireFlame;
import ca.shuckle.particle.custom.GeyserBaseParticle;
import ca.shuckle.particle.custom.GeyserEruptionParticle;
import ca.shuckle.particle.custom.GeyserPlumeParticle;
import ca.shuckle.particle.effect.GeyserBaseParticleEffect;
import ca.shuckle.particle.effect.GeyserParticleEffect;
import ca.shuckle.screen.ModScreenHandlers;
import ca.shuckle.screen.custom.CrafterScreen;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ShuckleQOLClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.CRAFTER_3X3, CrafterScreen::new);

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

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_HANGING_MOSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PALE_TALL_GRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.PINK_PETALS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILDFLOWERS_RED_BLUE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAF_LITTER_OAK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.FIREFLY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.LIT_FIREFLY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.CACTUS_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.RESIN_CLUMP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.SULFUR_SPIKE, RenderLayer.getCutout());

        getCopperBlockCutouts("copper_grate");
        getCopperBlockCutouts("copper_door");
        getCopperBlockCutouts("copper_trapdoor");
        getCopperBlockCutouts("copper_bars");
        getCopperBlockCutouts("copper_chain");
        getCopperBlockCutouts("copper_lantern");

        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.COPPER_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBackportBlocks.COPPER_WALL_TORCH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.THERIUM_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.THERIUM_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TINTED_GLASS_PANE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INVIS_LIGHTNING_ROD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INVIS_CARPET, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHUCKLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHINY_SHUCKLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZYGARDE_CELL, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.INVIS_ITEM_FRAME, InvisibleItemFrameRenderer::new);
        EntityRendererRegistry.register(ModEntities.INVIS_GLOW_ITEM_FRAME, InvisibleItemFrameRenderer::new);

        //hanging signs
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/oak")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/spruce")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/birch")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/jungle")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/acacia")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/dark_oak")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/mangrove")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/cherry")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/bamboo")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/pale_oak")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/crimson")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/hanging/warped")));
        //signs
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/cherry")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/bamboo")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/pale_oak")));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                new Identifier(ShuckleQOL.MOD_ID, "entity/signs/invisible")));

        ParticleFactoryRegistry.getInstance().register(ModParticles.COPPER_FIRE_FLAME_PARTICLE, CopperFireFlame.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GEYSER, GeyserEruptionParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GEYSER_PLUME, GeyserPlumeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GEYSER_BASE, GeyserBaseParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GEYSER_POOF, GeyserBaseParticle.Factory::new);
    }

    private void getCopperBlockCutouts(String baseBlockId){
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, baseBlockId)),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "exposed_" + baseBlockId)),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "weathered_" + baseBlockId)),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "oxidized_" + baseBlockId)),
                RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_" + baseBlockId)),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_exposed_" + baseBlockId)),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_weathered_" + baseBlockId)),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(ShuckleQOL.MOD_ID, "waxed_oxidized_" + baseBlockId)),
                RenderLayer.getCutout());
    }
}
