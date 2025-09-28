package ca.shuckle.mixin;

import ca.shuckle.ShuckleQOL;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.datafixer.Schemas;
import net.minecraft.datafixer.fix.BlockNameFix;
import net.minecraft.datafixer.fix.ItemNameFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.UnaryOperator;

@Mixin(Schemas.class)
abstract class SchemasMixin {

    @Shadow
    protected abstract UnaryOperator<String> replacing(String old, String current);

    private String[] backportedIds119 = {
            "pearlescent_froglight",
            "ochre_froglight",
            "verdant_froglight",
            "sculk",
            "sculk_vein",
            "sculk_catalyst",
            "mud",
            "packed_mud",
            "mud_bricks",
            "mud_brick_slab",
            "mud_brick_stairs",
            "mud_brick_wall",
            "mangrove_roots",
            "muddy_mangrove_roots",
            "mangrove_propagule",
            "mangrove_leaves",
            "mangrove_log",
            "mangrove_wood",
            "stripped_mangrove_log",
            "stripped_mangrove_wood",
            "mangrove_planks",
            "mangrove_slab",
            "mangrove_stairs",
            "mangrove_door",
            "mangrove_trapdoor",
            "mangrove_fence",
            "mangrove_fence_gate",
            "mangrove_button",
            "mangrove_pressure_plate",
    };

    @Inject(
            method = "build",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=minecraft:update_1_19")),
            at = @At(
                    value = "INVOKE", ordinal = 0, shift = At.Shift.AFTER,
                    target = "Lcom/mojang/datafixers/DataFixerBuilder;addFixer(Lcom/mojang/datafixers/DataFix;)V"
            )
    )
    private void replaceBackportBlocksWithVanillaBlocks(
            DataFixerBuilder builder,
            CallbackInfo ci,
            Schema schema
    ) {
        //most simple blocks with their items
        for(String id: backportedIds119) {
            UnaryOperator<String> replacer = makeReplacer(id);

            builder.addFixer(BlockNameFix.create(schema, "Rename " + id + " block", replacer));
            builder.addFixer(ItemNameFix.create(schema, "Rename " + id + " item", replacer));
        }
    }

    private UnaryOperator<String> makeReplacer(String id){
        return replacing(ShuckleQOL.MOD_ID + ":" + id, "minecraft:" + id);
    }
}
