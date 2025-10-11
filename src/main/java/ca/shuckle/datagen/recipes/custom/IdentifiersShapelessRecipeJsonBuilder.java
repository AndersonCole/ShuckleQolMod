package ca.shuckle.datagen.recipes.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IdentifiersShapelessRecipeJsonBuilder {
    private final RecipeCategory category;
    private final Identifier outputId;
    private final int count;
    private final List<JsonObject> ingredients = new ArrayList<>();
    private final Advancement.Builder advancementBuilder = Advancement.Builder.create();

    @Nullable
    private String group;

    public IdentifiersShapelessRecipeJsonBuilder(RecipeCategory category, Identifier outputId, int count) {
        this.category = category;
        this.outputId = outputId;
        this.count = count;
    }

    public static IdentifiersShapelessRecipeJsonBuilder create(RecipeCategory category, Identifier outputId) {
        return new IdentifiersShapelessRecipeJsonBuilder(category, outputId, 1);
    }

    public static IdentifiersShapelessRecipeJsonBuilder create(RecipeCategory category, Identifier outputId, int count) {
        return new IdentifiersShapelessRecipeJsonBuilder(category, outputId, count);
    }

    public IdentifiersShapelessRecipeJsonBuilder inputItem(Identifier itemId) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", itemId.toString());
        this.ingredients.add(obj);
        return this;
    }

    public IdentifiersShapelessRecipeJsonBuilder inputTag(Identifier tagId) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tagId.toString());
        this.ingredients.add(obj);
        return this;
    }

    public IdentifiersShapelessRecipeJsonBuilder criterion(String name, CriterionConditions conditions) {
        this.advancementBuilder.criterion(name, conditions);
        return this;
    }

    public IdentifiersShapelessRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        if (ingredients.isEmpty()) {
            throw new IllegalStateException("No ingredients defined for shapeless recipe " + recipeId);
        }
        if (advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No unlocking criteria defined for recipe " + recipeId);
        }

        advancementBuilder
                .parent(ShapelessRecipeJsonBuilder.ROOT)
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
                .rewards(net.minecraft.advancement.AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(CriterionMerger.OR);

        exporter.accept(new Provider(recipeId));
    }

    private class Provider implements RecipeJsonProvider {
        private final Identifier recipeId;

        private Provider(Identifier recipeId) {
            this.recipeId = recipeId;
        }

        @Override
        public void serialize(JsonObject json) {
            json.addProperty("type", "minecraft:crafting_shapeless");
            json.addProperty("category", category.getName());
            if (group != null){
                json.addProperty("group", group);
            }

            JsonArray ingredientArray = new JsonArray();
            for (JsonObject ingredient : ingredients) {
                ingredientArray.add(ingredient);
            }
            json.add("ingredients", ingredientArray);

            JsonObject result = new JsonObject();
            result.addProperty("item", outputId.toString());
            if (count > 1) result.addProperty("count", count);
            json.add("result", result);
        }

        @Override
        public Identifier getRecipeId() {
            return recipeId;
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return RecipeSerializer.SHAPELESS;
        }

        @Override
        public JsonObject toAdvancementJson() {
            return advancementBuilder.toJson();
        }

        @Override
        public Identifier getAdvancementId() {
            return recipeId.withPrefixedPath("recipes/" + category.getName() + "/");
        }
    }
}
