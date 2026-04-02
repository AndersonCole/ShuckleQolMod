package ca.shuckle.item;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.entity.ModEntities;
import ca.shuckle.item.custom.BerryJuiceItem;
import ca.shuckle.item.custom.BreakableMiningToolItem;
import ca.shuckle.item.custom.GlintItem;
import ca.shuckle.item.custom.InvisItemFrameItem;
import ca.shuckle.item.tools_armor.ModArmorMaterials;
import ca.shuckle.item.tools_armor.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {

    //region Backport
    //hanging signs
    public static final Item OAK_HANGING_SIGN = registerItemInGroup("oak_hanging_sign",
            new HangingSignItem(ModBackportBlocks.OAK_HANGING_SIGN, ModBackportBlocks.OAK_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item SPRUCE_HANGING_SIGN = registerItemInGroup("spruce_hanging_sign",
            new HangingSignItem(ModBackportBlocks.SPRUCE_HANGING_SIGN, ModBackportBlocks.SPRUCE_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item BIRCH_HANGING_SIGN = registerItemInGroup("birch_hanging_sign",
            new HangingSignItem(ModBackportBlocks.BIRCH_HANGING_SIGN, ModBackportBlocks.BIRCH_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item JUNGLE_HANGING_SIGN = registerItemInGroup("jungle_hanging_sign",
            new HangingSignItem(ModBackportBlocks.JUNGLE_HANGING_SIGN, ModBackportBlocks.JUNGLE_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item ACACIA_HANGING_SIGN = registerItemInGroup("acacia_hanging_sign",
            new HangingSignItem(ModBackportBlocks.ACACIA_HANGING_SIGN, ModBackportBlocks.ACACIA_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item DARK_OAK_HANGING_SIGN = registerItemInGroup("dark_oak_hanging_sign",
            new HangingSignItem(ModBackportBlocks.DARK_OAK_HANGING_SIGN, ModBackportBlocks.DARK_OAK_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item MANGROVE_HANGING_SIGN = registerItemInGroup("mangrove_hanging_sign",
            new HangingSignItem(ModBackportBlocks.MANGROVE_HANGING_SIGN, ModBackportBlocks.MANGROVE_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item CHERRY_HANGING_SIGN = registerItemInGroup("cherry_hanging_sign",
            new HangingSignItem(ModBackportBlocks.CHERRY_HANGING_SIGN, ModBackportBlocks.CHERRY_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item BAMBOO_HANGING_SIGN = registerItemInGroup("bamboo_hanging_sign",
            new HangingSignItem(ModBackportBlocks.BAMBOO_HANGING_SIGN, ModBackportBlocks.BAMBOO_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item PALE_OAK_HANGING_SIGN = registerItemInGroup("pale_oak_hanging_sign",
            new HangingSignItem(ModBackportBlocks.PALE_OAK_HANGING_SIGN, ModBackportBlocks.PALE_OAK_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item CRIMSON_HANGING_SIGN = registerItemInGroup("crimson_hanging_sign",
            new HangingSignItem(ModBackportBlocks.CRIMSON_HANGING_SIGN, ModBackportBlocks.CRIMSON_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item WARPED_HANGING_SIGN = registerItemInGroup("warped_hanging_sign",
            new HangingSignItem(ModBackportBlocks.WARPED_HANGING_SIGN, ModBackportBlocks.WARPED_WALL_HANGING_SIGN,
                    new FabricItemSettings().maxCount(16)), ModItemGroup.SHUCKLE_BACKPORT);
    //signs
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

    public static final Item RESIN_BRICK = registerItemInGroup("resin_brick",
            new Item(new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_NUGGET = registerItemInGroup("copper_nugget",
            new Item(new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_PICKAXE = registerItemInGroup("copper_pickaxe",
            new PickaxeItem(ModToolMaterial.COPPER, 1, -2.8f, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_AXE = registerItemInGroup("copper_axe",
            new AxeItem(ModToolMaterial.COPPER, 7, -3.2f, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_SHOVEL = registerItemInGroup("copper_shovel",
            new ShovelItem(ModToolMaterial.COPPER, 1, -3.0f, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_SWORD = registerItemInGroup("copper_sword",
            new SwordItem(ModToolMaterial.COPPER, 3, -2.4f, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_HOE = registerItemInGroup("copper_hoe",
            new HoeItem(ModToolMaterial.COPPER, -1, -2.0f, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_HELMET = registerItemInGroup("copper_helmet",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_CHESTPLATE = registerItemInGroup("copper_chestplate",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_LEGGINGS = registerItemInGroup("copper_leggings",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    public static final Item COPPER_BOOTS = registerItemInGroup("copper_boots",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()), ModItemGroup.SHUCKLE_BACKPORT);

    /** Netherite tools for future reference
     public static final Item NETHERITE_SWORD = register("netherite_sword",
     new Item.Settings().sword(ToolMaterial.NETHERITE, 3.0F, -2.4F).fireproof());
     public static final Item NETHERITE_SHOVEL = register("netherite_shovel",
     settings -> new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3.0F, settings), new Item.Settings().fireproof());
     public static final Item NETHERITE_PICKAXE = register("netherite_pickaxe",
     new Item.Settings().pickaxe(ToolMaterial.NETHERITE, 1.0F, -2.8F).fireproof());
     public static final Item NETHERITE_AXE = register("netherite_axe",
     settings -> new AxeItem(ToolMaterial.NETHERITE, 5.0F, -3.0F, settings), new Item.Settings().fireproof());
     public static final Item NETHERITE_HOE = register("netherite_hoe",
     settings -> new HoeItem(ToolMaterial.NETHERITE, -4.0F, 0.0F, settings), new Item.Settings().fireproof());
     */
    //endregion
    //region Shuckle Items
    public static final Item DULL_SHUCKLE_GEM = registerItemInGroup("dull_shuckle_gem",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(Text.translatable("tooltip.shuckle_qol.dull_shuckle_gem.line1"));
                    tooltip.add(Text.translatable("tooltip.shuckle_qol.dull_shuckle_gem.line2"));
                    super.appendTooltip(stack, world, tooltip, context);
                }
            }, ModItemGroup.SHUCKLE);

    public static final Item SHUCKLE_GEM = registerItemInGroup("shuckle_gem",
            new GlintItem(new FabricItemSettings().rarity(Rarity.EPIC)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(Text.translatable("tooltip.shuckle_qol.shuckle_gem.line1"));
                    tooltip.add(Text.translatable("tooltip.shuckle_qol.shuckle_gem.line2"));
                    tooltip.add(Text.translatable("tooltip.shuckle_qol.shuckle_gem.line3"));
                    super.appendTooltip(stack, world, tooltip, context);
                }
            }, ModItemGroup.SHUCKLE);

    public static final Item PICKAXE_TEMPLATE = registerItem("pickaxe_template",
            new Item(new FabricItemSettings()));

    public static final Item AXE_TEMPLATE = registerItem("axe_template",
            new Item(new FabricItemSettings()));

    public static final Item SHOVEL_TEMPLATE = registerItem("shovel_template",
            new Item(new FabricItemSettings()));

    public static final Item HOE_TEMPLATE = registerItem("hoe_template",
            new Item(new FabricItemSettings()));

    public static final Item SHUCKLE_PICKAXE = registerItemInGroup("shuckle_pickaxe",
            new BreakableMiningToolItem(1.0f, -2.8f, ModToolMaterial.SHUCKLE,
                    BlockTags.PICKAXE_MINEABLE, new FabricItemSettings()), ModItemGroup.SHUCKLE);

    public static final Item SHUCKLE_AXE = registerItemInGroup("shuckle_axe",
            new BreakableMiningToolItem(5.0f, -3.0f, ModToolMaterial.SHUCKLE,
                    BlockTags.AXE_MINEABLE, new FabricItemSettings()), ModItemGroup.SHUCKLE);

    public static final Item SHUCKLE_SHOVEL = registerItemInGroup("shuckle_shovel",
            new BreakableMiningToolItem(1.5f, -3.0f,ModToolMaterial.SHUCKLE,
                    BlockTags.SHOVEL_MINEABLE, new FabricItemSettings()), ModItemGroup.SHUCKLE);

    public static final Item SHUCKLE_HOE = registerItemInGroup("shuckle_hoe",
            new BreakableMiningToolItem(-4.0f, 0.0f,ModToolMaterial.SHUCKLE,
                    BlockTags.HOE_MINEABLE, new FabricItemSettings()), ModItemGroup.SHUCKLE);

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
    //endregion
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
        registerItemInGroup(INVIS_SIGN, ModItemGroup.SHUCKLE);
    }
}
