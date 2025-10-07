package ca.shuckle.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //region Backport

        //endregion
    }
}
