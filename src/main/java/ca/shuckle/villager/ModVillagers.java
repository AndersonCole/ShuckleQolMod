package ca.shuckle.villager;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModSounds;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final VillagerProfession SHUCKLE_VILLAGER = registerProfession("shuckle_villager",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(ShuckleQOL.MOD_ID, "shuckle_villager_poi")),
            ModSounds.SHUCKLE_CRY);
    public static final VillagerProfession SHINY_SHUCKLE_VILLAGER = registerProfession("shiny_shuckle_villager",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(ShuckleQOL.MOD_ID, "shiny_shuckle_villager_poi")),
            ModSounds.SHUCKLE_CRY);

    public static void registerShuckleTrades() {
        //
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            4, 2, 0.1f
                    )));
                });
    }

    public static void registerShinyShuckleTrades() {
        TradeOfferHelper.registerVillagerOffers(SHINY_SHUCKLE_VILLAGER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            16, 2, 0.05f
                    )));
                });
    }

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent workSound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(ShuckleQOL.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(ShuckleQOL.MOD_ID, name)).workstation(type)
                        .workSound(workSound).build());
    }

    public static void registerVillagers() {
        registerShuckleTrades();
        registerShinyShuckleTrades();
    }
}
