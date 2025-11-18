package ca.shuckle.datagen;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBlocks;
import ca.shuckle.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    protected ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        //base advancement, entire tab
        Advancement shuckleBaseAdvancement = Advancement.Builder.create()
                .display(
                        ModBlocks.SHUCKLE_BLOCK,
                        Text.translatable("advancement.shuckle_qol.shuckle.title"),
                        Text.translatable("advancement.shuckle_qol.shuckle.description"),
                        new Identifier(ShuckleQOL.MOD_ID, "textures/gui/advancements/backgrounds/shuckle_mystery.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false)
                .criterion("has_crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .build(new Identifier(ShuckleQOL.MOD_ID, "shuckle"));
        consumer.accept(shuckleBaseAdvancement);

        //region berry juice
        Advancement berry = Advancement.Builder.create()
                .parent(shuckleBaseAdvancement)
                .display(
                        ModItems.PALE_BERRY,
                        Text.translatable("advancement.shuckle_qol.berry.title"),
                        Text.translatable("advancement.shuckle_qol.berry.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_mangrove_berry", InventoryChangedCriterion.Conditions.items(ModItems.MANGROVE_BERRY))
                .criterion("has_cherry_berry", InventoryChangedCriterion.Conditions.items(ModItems.CHERRY_BERRY))
                .criterion("has_bamboo_berry", InventoryChangedCriterion.Conditions.items(ModItems.BAMBOO_BERRY))
                .criterion("has_pale_berry", InventoryChangedCriterion.Conditions.items(ModItems.PALE_BERRY))
                .build(new Identifier(ShuckleQOL.MOD_ID, "all_berries"));
        consumer.accept(berry);

        Advancement berryJuice = Advancement.Builder.create()
                .parent(berry)
                .display(
                        ModItems.BERRY_JUICE,
                        Text.translatable("advancement.shuckle_qol.berry_juice.title"),
                        Text.translatable("advancement.shuckle_qol.berry_juice.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("has_berry_juice", InventoryChangedCriterion.Conditions.items(ModItems.BERRY_JUICE))
                .build(new Identifier(ShuckleQOL.MOD_ID, "berry_juice"));
        consumer.accept(berryJuice);
        //endregion

        //region zygarde cells
        Advancement zygardeCell1 = Advancement.Builder.create()
                .parent(shuckleBaseAdvancement)
                .display(
                        ModItems.ZYGARDE_CELL,
                        Text.translatable("advancement.shuckle_qol.zygarde_1.title"),
                        Text.translatable("advancement.shuckle_qol.zygarde_1.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_zygarde_cell", InventoryChangedCriterion.Conditions.items(ModItems.ZYGARDE_CELL))
                .build(new Identifier(ShuckleQOL.MOD_ID, "zygarde_cell"));
        consumer.accept(zygardeCell1);

        Advancement zygardeCell2 = Advancement.Builder.create()
                .parent(zygardeCell1)
                .display(
                        ModItems.ZYGARDE_CELL_FIVE,
                        Text.translatable("advancement.shuckle_qol.zygarde_2.title"),
                        Text.translatable("advancement.shuckle_qol.zygarde_2.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_zygarde_cell", InventoryChangedCriterion.Conditions.items(ModItems.ZYGARDE_CELL_FIVE))
                .build(new Identifier(ShuckleQOL.MOD_ID, "zygarde_cell_five"));
        consumer.accept(zygardeCell2);

        Advancement zygardeCell3 = Advancement.Builder.create()
                .parent(zygardeCell2)
                .display(
                        ModItems.ZYGARDE_CELL_TWENTY_FIVE,
                        Text.translatable("advancement.shuckle_qol.zygarde_3.title"),
                        Text.translatable("advancement.shuckle_qol.zygarde_3.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("has_zygarde_cell", InventoryChangedCriterion.Conditions.items(ModItems.ZYGARDE_CELL_TWENTY_FIVE))
                .build(new Identifier(ShuckleQOL.MOD_ID, "zygarde_cell_twenty_five"));
        consumer.accept(zygardeCell3);

        Advancement zygardeCell4 = Advancement.Builder.create()
                .parent(zygardeCell3)
                .display(
                        ModItems.ZYGARDE_CELL_HUNDRED_TWENTY_FIVE,
                        Text.translatable("advancement.shuckle_qol.zygarde_4.title"),
                        Text.translatable("advancement.shuckle_qol.zygarde_4.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false)
                .criterion("has_zygarde_cell", InventoryChangedCriterion.Conditions.items(ModItems.ZYGARDE_CELL_HUNDRED_TWENTY_FIVE))
                .build(new Identifier(ShuckleQOL.MOD_ID, "zygarde_cell_hundred_twenty_five"));
        consumer.accept(zygardeCell4);
        //endregion

        //region ice and stars
        Advancement blackIce1 = Advancement.Builder.create()
                .parent(shuckleBaseAdvancement)
                .display(
                        ModItems.BLACK_ICE_SHARD,
                        Text.translatable("advancement.shuckle_qol.black_ice_1.title"),
                        Text.translatable("advancement.shuckle_qol.black_ice_1.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_black_ice_shard", InventoryChangedCriterion.Conditions.items(ModItems.BLACK_ICE_SHARD))
                .build(new Identifier(ShuckleQOL.MOD_ID, "black_ice_shard"));
        consumer.accept(blackIce1);

        Advancement blackIce2 = Advancement.Builder.create()
                .parent(blackIce1)
                .display(
                        ModItems.BLACK_ICE_CRYSTAL,
                        Text.translatable("advancement.shuckle_qol.black_ice_2.title"),
                        Text.translatable("advancement.shuckle_qol.black_ice_2.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_black_ice_crystal", InventoryChangedCriterion.Conditions.items(ModItems.BLACK_ICE_CRYSTAL))
                .build(new Identifier(ShuckleQOL.MOD_ID, "black_ice_crystal"));
        consumer.accept(blackIce2);

        Advancement star1 = Advancement.Builder.create()
                .parent(blackIce2)
                .display(
                        ModItems.DARK_STAR,
                        Text.translatable("advancement.shuckle_qol.star_1.title"),
                        Text.translatable("advancement.shuckle_qol.star_1.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_dark_star", InventoryChangedCriterion.Conditions.items(ModItems.DARK_STAR))
                .build(new Identifier(ShuckleQOL.MOD_ID, "dark_star"));
        consumer.accept(star1);

        Advancement star2 = Advancement.Builder.create()
                .parent(star1)
                .display(
                        ModItems.CORRUPTED_STAR,
                        Text.translatable("advancement.shuckle_qol.star_2.title"),
                        Text.translatable("advancement.shuckle_qol.star_2.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("has_corrupted_star", InventoryChangedCriterion.Conditions.items(ModItems.CORRUPTED_STAR))
                .build(new Identifier(ShuckleQOL.MOD_ID, "corrupted_star"));
        consumer.accept(star2);

        Advancement star3 = Advancement.Builder.create()
                .parent(star2)
                .display(
                        ModItems.PURE_STAR,
                        Text.translatable("advancement.shuckle_qol.star_3.title"),
                        Text.translatable("advancement.shuckle_qol.star_3.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false)
                .criterion("has_pure_star", InventoryChangedCriterion.Conditions.items(ModItems.PURE_STAR))
                .build(new Identifier(ShuckleQOL.MOD_ID, "pure_star"));
        consumer.accept(star3);
        //endregion

        //region shuckle shell
        Advancement shell1 = Advancement.Builder.create()
                .parent(shuckleBaseAdvancement)
                .display(
                        ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD,
                        Text.translatable("advancement.shuckle_qol.shell_1.title"),
                        Text.translatable("advancement.shuckle_qol.shell_1.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_fossil_shell_shard", InventoryChangedCriterion.Conditions.items(ModItems.FOSSILIZED_FAMILIAR_SHELL_SHARD))
                .build(new Identifier(ShuckleQOL.MOD_ID, "fossil_shell_shard"));
        consumer.accept(shell1);

        Advancement shell2 = Advancement.Builder.create()
                .parent(shell1)
                .display(
                        ModItems.FOSSILIZED_FAMILIAR_SHELL,
                        Text.translatable("advancement.shuckle_qol.shell_2.title"),
                        Text.translatable("advancement.shuckle_qol.shell_2.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_fossil_shell", InventoryChangedCriterion.Conditions.items(ModItems.FOSSILIZED_FAMILIAR_SHELL))
                .build(new Identifier(ShuckleQOL.MOD_ID, "fossil_shell"));
        consumer.accept(shell2);

        Advancement shell3 = Advancement.Builder.create()
                .parent(shell2)
                .display(
                        ModItems.FAMILIAR_SHELL,
                        Text.translatable("advancement.shuckle_qol.shell_3.title"),
                        Text.translatable("advancement.shuckle_qol.shell_3.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("has_shuckle_shell", InventoryChangedCriterion.Conditions.items(ModItems.FAMILIAR_SHELL))
                .build(new Identifier(ShuckleQOL.MOD_ID, "shuckle_shell"));
        consumer.accept(shell3);
        //endregion

        //region dna
        Advancement dna1 = Advancement.Builder.create()
                .parent(shell3)
                .display(
                        ModItems.WEAK_SHUCKLE_DNA,
                        Text.translatable("advancement.shuckle_qol.dna_1.title"),
                        Text.translatable("advancement.shuckle_qol.dna_1.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("has_weak_dna", InventoryChangedCriterion.Conditions.items(ModItems.WEAK_SHUCKLE_DNA))
                .build(new Identifier(ShuckleQOL.MOD_ID, "weak_dna"));
        consumer.accept(dna1);

        Advancement dna2 = Advancement.Builder.create()
                .parent(dna1)
                .display(
                        ModItems.NORMAL_SHUCKLE_DNA,
                        Text.translatable("advancement.shuckle_qol.dna_2.title"),
                        Text.translatable("advancement.shuckle_qol.dna_2.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("has_normal_dna", InventoryChangedCriterion.Conditions.items(ModItems.NORMAL_SHUCKLE_DNA))
                .build(new Identifier(ShuckleQOL.MOD_ID, "normal_dna"));
        consumer.accept(dna2);

        Advancement dna3 = Advancement.Builder.create()
                .parent(dna2)
                .display(
                        ModItems.SWOLE_SHUCKLE_DNA,
                        Text.translatable("advancement.shuckle_qol.dna_3.title"),
                        Text.translatable("advancement.shuckle_qol.dna_3.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false)
                .criterion("has_swole_dna", InventoryChangedCriterion.Conditions.items(ModItems.SWOLE_SHUCKLE_DNA))
                .build(new Identifier(ShuckleQOL.MOD_ID, "swole_dna"));
        consumer.accept(dna3);
        //endregion

        //region Block
        Advancement block1 = Advancement.Builder.create()
                .parent(dna3)
                .display(
                        ModBlocks.SHUCKLE_MYSTERY_BLOCK,
                        Text.translatable("advancement.shuckle_qol.mystery_block.title"),
                        Text.translatable("advancement.shuckle_qol.mystery_block.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false)
                .criterion("has_mystery_block", InventoryChangedCriterion.Conditions.items(ModBlocks.SHUCKLE_MYSTERY_BLOCK))
                .build(new Identifier(ShuckleQOL.MOD_ID, "mystery_block"));
        consumer.accept(block1);

        Advancement block2 = Advancement.Builder.create()
                .parent(block1)
                .display(
                        ModBlocks.SHUCKLE_BLOCK,
                        Text.translatable("advancement.shuckle_qol.shuckle_block.title"),
                        Text.translatable("advancement.shuckle_qol.shuckle_block.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true)
                .criterion("has_shuckle_block", InventoryChangedCriterion.Conditions.items(ModBlocks.SHUCKLE_BLOCK))
                .build(new Identifier(ShuckleQOL.MOD_ID, "shuckle_block"));
        consumer.accept(block2);

        Advancement block3 = Advancement.Builder.create()
                .parent(block1)
                .display(
                        ModBlocks.SHINY_SHUCKLE_BLOCK,
                        Text.translatable("advancement.shuckle_qol.shiny_shuckle_block.title"),
                        Text.translatable("advancement.shuckle_qol.shiny_shuckle_block.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true)
                .criterion("has_shiny_shuckle_block", InventoryChangedCriterion.Conditions.items(ModBlocks.SHINY_SHUCKLE_BLOCK))
                .build(new Identifier(ShuckleQOL.MOD_ID, "shiny_shuckle_block"));
        consumer.accept(block3);
        //endregion

        //region
        Advancement gem1 = Advancement.Builder.create()
                .parent(shuckleBaseAdvancement)
                .display(
                        ModItems.DULL_SHUCKLE_GEM,
                        Text.translatable("advancement.shuckle_qol.gem_1.title"),
                        Text.translatable("advancement.shuckle_qol.gem_1.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true)
                .criterion("has_dull_gem", InventoryChangedCriterion.Conditions.items(ModItems.DULL_SHUCKLE_GEM))
                .build(new Identifier(ShuckleQOL.MOD_ID, "dull_gem"));
        consumer.accept(gem1);

        Advancement gem2 = Advancement.Builder.create()
                .parent(gem1)
                .display(
                        ModItems.SHUCKLE_GEM,
                        Text.translatable("advancement.shuckle_qol.gem_2.title"),
                        Text.translatable("advancement.shuckle_qol.gem_2.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true)
                .criterion("has_polished_gem", InventoryChangedCriterion.Conditions.items(ModItems.SHUCKLE_GEM))
                .build(new Identifier(ShuckleQOL.MOD_ID, "polished_gem"));
        consumer.accept(gem2);
        //endregion
    }
}
