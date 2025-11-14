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

    public static final VillagerProfession SHUCKLE_VILLAGER = registerProfession("shuckle",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(ShuckleQOL.MOD_ID, "shuckle_villager_poi")),
            ModSounds.SHUCKLE_CRY);
    public static final VillagerProfession SHINY_SHUCKLE_VILLAGER = registerProfession("shiny_shuckle",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(ShuckleQOL.MOD_ID, "shiny_shuckle_villager_poi")),
            ModSounds.SHUCKLE_CRY);

    public static void registerShuckleTrades() {
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            4, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.ZYGARDE_CELL, 3),
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            3, 2, 0f
                    )));
                });
        //level 2 trades
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.BLACK_ICE_SHARD, 3),
                            2, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.DIAMOND, 64),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            16, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.NETHERITE_SCRAP, 4),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            16, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.IRON_BLOCK, 64),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            4, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_BLOCK, 64),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            4, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK, 64),
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.DULL_SHUCKLE_GEM, 2),
                            4, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.MANGROVE_BERRY, 8),
                            2, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.CHERRY_BERRY, 8),
                            2, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.BAMBOO_BERRY, 8),
                            2, 2, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.PALE_BERRY, 8),
                            2, 2, 0f
                    )));
                });

        //level 3 trades
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 2),
                            new ItemStack(ModItems.ZYGARDE_CELL_TWENTY_FIVE, 1),
                            1, 5, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD, 1),
                            1, 5, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.MANGROVE_BERRY, 1),
                            new ItemStack(ModItems.BERRY_JUICE, 1),
                            2, 5, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.CHERRY_BERRY, 1),
                            new ItemStack(ModItems.BERRY_JUICE, 1),
                            2, 5, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.BAMBOO_BERRY, 1),
                            new ItemStack(ModItems.BERRY_JUICE, 1),
                            2, 5, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 1),
                            new ItemStack(ModItems.PALE_BERRY, 1),
                            new ItemStack(ModItems.BERRY_JUICE, 1),
                            2, 5, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 4),
                            new ItemStack(ModItems.CORRUPTED_STAR, 1),
                            2, 10, 0f
                    )));
                });

        //level 4 trades
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 16),
                            new ItemStack(ModItems.WEAK_SHUCKLE_DNA, 1),
                            1, 30, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 16),
                            new ItemStack(ModItems.CORRUPTED_STAR, 1),
                            new ItemStack(ModItems.PURE_STAR, 1),
                            1, 20, 0f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 16),
                            new ItemStack(ModItems.WEAK_SHUCKLE_DNA, 1),
                            1, 30, 0f
                    )));
                });

        //level 5 trades
        TradeOfferHelper.registerVillagerOffers(SHUCKLE_VILLAGER, 5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SHUCKLE_GEM, 64),
                            new ItemStack(ModItems.NORMAL_SHUCKLE_DNA, 1),
                            new ItemStack(ModItems.SWOLE_SHUCKLE_DNA, 1),
                            1, 50, 0f
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
                            16, 2, 0f
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
