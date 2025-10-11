package ca.shuckle.item;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.entity.ModEntities;
import ca.shuckle.item.custom.BerryJuiceItem;
import ca.shuckle.item.custom.GlintItem;
import ca.shuckle.item.custom.InvisItemFrameItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

public class ModItems {

    public static final Item CHERRY_SIGN = registerItemInGroup("cherry_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBackportBlocks.CHERRY_SIGN, ModBackportBlocks.CHERRY_WALL_SIGN), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item BAMBOO_SIGN = registerItemInGroup("bamboo_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBackportBlocks.BAMBOO_SIGN, ModBackportBlocks.BAMBOO_WALL_SIGN), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item PALE_OAK_SIGN = registerItemInGroup("pale_oak_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBackportBlocks.PALE_OAK_SIGN, ModBackportBlocks.PALE_OAK_WALL_SIGN), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_TORCH = registerItemInGroup("copper_torch",
            new VerticallyAttachableBlockItem(ModBackportBlocks.COPPER_TORCH, ModBackportBlocks.COPPER_WALL_TORCH,
                    new FabricItemSettings(), Direction.DOWN), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item EBONY_SIGN = registerItemInGroup("ebony_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.EBONY_SIGN, ModBlocks.EBONY_WALL_SIGN), ModItemGroup.SHUCKLE);

    public static final Item INVIS_SIGN = registerItemInGroup("invisible_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.INVIS_SIGN, ModBlocks.INVIS_WALL_SIGN), ModItemGroup.SHUCKLE);

    public static final Item INVIS_ITEM_FRAME = registerItemInGroup("invisible_item_frame",
            new InvisItemFrameItem(ModEntities.INVIS_ITEM_FRAME,
                    new FabricItemSettings()), ModItemGroup.SHUCKLE);

    public static final Item INVIS_GLOW_ITEM_FRAME = registerItemInGroup("invisible_glow_item_frame",
            new InvisItemFrameItem(ModEntities.INVIS_GLOW_ITEM_FRAME,
                    new FabricItemSettings()), ModItemGroup.SHUCKLE);

    public static final Item INVIS_CATALYST = registerItemInGroup("invisible_catalyst",
            new GlintItem(new FabricItemSettings().rarity(Rarity.EPIC)), ModItemGroup.SHUCKLE);

    public static final Item RESIN_BRICK = registerItemInGroup("resin_brick",
            new Item(new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_NUGGET = registerItemInGroup("copper_nugget",
            new Item(new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item BLACK_ICE_SHARD = registerItem("black_ice_shard",
            new Item(new FabricItemSettings()));

    public static final Item BLACK_ICE_CRYSTAL = registerItem("black_ice_crystal",
            new Item(new FabricItemSettings()));

    public static final Item DARK_STAR = registerItem("dark_star",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item CORRUPTED_STAR = registerItem("corrupted_star",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item PURE_STAR = registerItem("pure_star",
            new GlintItem(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item FOSSILIZED_FAMILIAR_SHELL_SHARD = registerItem("familiar_shell_shard_fossil",
            new Item(new FabricItemSettings()));

    public static final Item FOSSILIZED_FAMILIAR_SHELL = registerItem("familiar_shell_fossil",
            new Item(new FabricItemSettings()));

    public static final Item FAMILIAR_SHELL = registerItem("familiar_shell",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item WEAK_SHUCKLE_DNA = registerItem("shuckle_dna_weak",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item NORMAL_SHUCKLE_DNA = registerItem("shuckle_dna_normal",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item SWOLE_SHUCKLE_DNA = registerItem("shuckle_dna_swole",
            new GlintItem(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item MANGROVE_BERRY = registerItemInGroup("mangrove_berry",
            new Item(new FabricItemSettings().food(ModFoodComponents.MANGROVE_BERRY)), ModItemGroup.SHUCKLE);

    public static final Item CHERRY_BERRY = registerItemInGroup("cherry_berry",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHERRY_BERRY)), ModItemGroup.SHUCKLE);

    public static final Item BAMBOO_BERRY = registerItemInGroup("bamboo_berry",
            new Item(new FabricItemSettings().food(ModFoodComponents.BAMBOO_BERRY)), ModItemGroup.SHUCKLE);

    public static final Item PALE_BERRY = registerItemInGroup("pale_berry",
            new Item(new FabricItemSettings().food(ModFoodComponents.PALE_BERRY)), ModItemGroup.SHUCKLE);

    public static final Item BERRY_JUICE = registerItemInGroup("berry_juice",
            new BerryJuiceItem(new FabricItemSettings().rarity(Rarity.RARE).food(ModFoodComponents.BERRY_JUICE)), ModItemGroup.SHUCKLE);

    public static final Item ZYGARDE_CELL = registerItem("zygarde_cell",
            new Item(new FabricItemSettings()));

    public static final Item ZYGARDE_CELL_FIVE = registerItem("zygarde_cell_five",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    public static final Item ZYGARDE_CELL_TWENTY_FIVE = registerItem("zygarde_cell_twenty_five",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item ZYGARDE_CELL_HUNDRED_TWENTY_FIVE = registerItem("zygarde_cell_hundred_twenty_five",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ShuckleQOL.MOD_ID, name), item);
    }

    private static Item registerItemInGroup(String name, Item item, ItemGroup group){
        Item newItem = Registry.register(Registries.ITEM, new Identifier(ShuckleQOL.MOD_ID, name), item);
        registerItemInGroup(newItem, group);
        return newItem;
    }

    private static void registerItemInGroup(Item item, ItemGroup group){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        ShuckleQOL.LOGGER.info("Registering ModBlocks for " + ShuckleQOL.MOD_ID);

        registerItemInGroup(CHERRY_SIGN, ModItemGroup.SHUCKLE_BACKPORT);
        registerItemInGroup(BAMBOO_SIGN, ModItemGroup.SHUCKLE_BACKPORT);
        registerItemInGroup(PALE_OAK_SIGN, ModItemGroup.SHUCKLE_BACKPORT);
        registerItemInGroup(EBONY_SIGN, ModItemGroup.SHUCKLE);
        registerItemInGroup(INVIS_SIGN, ModItemGroup.SHUCKLE);
    }
}
