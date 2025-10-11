package ca.shuckle.datagen.recipes.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class IdentifiersShapedRecipeJsonBuilder {
    private final RecipeCategory category;
    private final Identifier outputId;
    private final int count;
    private final List<String> pattern = new ArrayList<>();
    private final Map<Character, JsonElement> inputs = new LinkedHashMap<>();
    private final Advancement.Builder advancementBuilder = Advancement.Builder.create();

    @Nullable
    private String group;
    private boolean showNotification = true;

    public IdentifiersShapedRecipeJsonBuilder(RecipeCategory category, Identifier outputId, int count) {
        this.category = category;
        this.outputId = outputId;
        this.count = count;
    }

    public static IdentifiersShapedRecipeJsonBuilder create(RecipeCategory category, Identifier outputId, int count) {
        return new IdentifiersShapedRecipeJsonBuilder(category, outputId, count);
    }

    public IdentifiersShapedRecipeJsonBuilder pattern(String line) {
        if (!this.pattern.isEmpty() && line.length() != this.pattern.get(0).length()) {
            throw new IllegalArgumentException("Pattern must be consistent width per line!");
        }
        this.pattern.add(line);
        return this;
    }

    public IdentifiersShapedRecipeJsonBuilder inputItem(char symbol, Identifier itemId) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", itemId.toString());
        this.inputs.put(symbol, obj);
        return this;
    }

    public IdentifiersShapedRecipeJsonBuilder inputTag(char symbol, Identifier tagId) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tagId.toString());
        this.inputs.put(symbol, obj);
        return this;
    }

    public IdentifiersShapedRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public IdentifiersShapedRecipeJsonBuilder showNotification(boolean show) {
        this.showNotification = show;
        return this;
    }

    public IdentifiersShapedRecipeJsonBuilder criterion(String name, net.minecraft.advancement.criterion.CriterionConditions condition) {
        this.advancementBuilder.criterion(name, condition);
        return this;
    }

    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        if (this.pattern.isEmpty()) {
            throw new IllegalStateException("No pattern defined for " + recipeId);
        }
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No criteria for " + recipeId);
        }

        this.advancementBuilder.parent(ShapedRecipeJsonBuilder.ROOT)
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
            json.addProperty("type", "minecraft:crafting_shaped");
            json.addProperty("category", category.getName());
            if (group != null){
                json.addProperty("group", group);
            }

            JsonArray patternArray = new JsonArray();
            for (String row : pattern) patternArray.add(row);
            json.add("pattern", patternArray);

            JsonObject keyObj = new JsonObject();
            for (Map.Entry<Character, JsonElement> entry : inputs.entrySet()) {
                keyObj.add(String.valueOf(entry.getKey()), entry.getValue());
            }
            json.add("key", keyObj);

            JsonObject result = new JsonObject();
            result.addProperty("item", outputId.toString());
            if (count > 1) result.addProperty("count", count);
            json.add("result", result);

            json.addProperty("show_notification", showNotification);
        }

        @Override public Identifier getRecipeId() { return recipeId; }
        @Override public RecipeSerializer<?> getSerializer() { return RecipeSerializer.SHAPED; }
        @Override public JsonObject toAdvancementJson() { return advancementBuilder.toJson(); }
        @Override public Identifier getAdvancementId() {
            return recipeId.withPrefixedPath("recipes/" + category.getName() + "/");
        }
    }
}
