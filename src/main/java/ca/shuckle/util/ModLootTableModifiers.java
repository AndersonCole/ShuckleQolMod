package ca.shuckle.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetNbtLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    public static void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            Identifier fishingTreasure = new Identifier("minecraft", "gameplay/fishing/treasure");

            if (id.equals(fishingTreasure)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 0.05f))
                        .with(ItemEntry.builder(Items.ENCHANTED_BOOK)
                                .apply(SetNbtLootFunction.builder(makeBookNbt("shuckle_qol:swift_sneak", 1)))
                                .weight(2)
                        )
                        .with(ItemEntry.builder(Items.ENCHANTED_BOOK)
                                .apply(SetNbtLootFunction.builder(makeBookNbt("shuckle_qol:swift_sneak", 2)))
                                .weight(1)
                        )
                        .with(ItemEntry.builder(Items.ENCHANTED_BOOK)
                                .apply(SetNbtLootFunction.builder(makeBookNbt("shuckle_qol:swift_sneak", 3)))
                                .weight(1)
                        );
                supplier.withPool(poolBuilder.build());
            }
        });
    }

    private static NbtCompound makeBookNbt(String enchantId, int level) {
        NbtCompound enchantTag = new NbtCompound();
        enchantTag.putString("id", enchantId);
        enchantTag.putShort("lvl", (short) level);

        NbtList enchantments = new NbtList();
        enchantments.add(enchantTag);

        NbtCompound bookNbt = new NbtCompound();
        bookNbt.put("StoredEnchantments", enchantments);

        return bookNbt;
    }
}
