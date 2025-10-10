package ca.shuckle.datagen.recipes.custom;

import com.google.gson.JsonObject;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.SingleItemRecipeJsonBuilder;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class IdentifiersSingleItemRecipeJsonBuilder {
    private final RecipeCategory category;
    private final RecipeSerializer<?> serializer;
    private final JsonObject inputJson;
    private final Identifier outputId;
    private final int count;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.create();
    @Nullable
    private String group;

    public IdentifiersSingleItemRecipeJsonBuilder(
            RecipeCategory category,
            RecipeSerializer<?> serializer,
            JsonObject inputJson,
            Identifier outputId,
            int count
    ) {
        this.category = category;
        this.serializer = serializer;
        this.inputJson = inputJson;
        this.outputId = outputId;
        this.count = count;
    }

    public static IdentifiersSingleItemRecipeJsonBuilder createStonecuttingFromItem(Identifier inputItemId, RecipeCategory category, Identifier outputItemId, int count) {
        JsonObject input = new JsonObject();
        input.addProperty("item", inputItemId.toString());
        return new IdentifiersSingleItemRecipeJsonBuilder(category, RecipeSerializer.STONECUTTING, input, new Identifier(outputItemId.toString()), count);
    }

    public static IdentifiersSingleItemRecipeJsonBuilder createStonecuttingFromTag(Identifier inputTagId, RecipeCategory category, Identifier outputItemId, int count) {
        JsonObject input = new JsonObject();
        input.addProperty("tag", inputTagId.toString());
        return new IdentifiersSingleItemRecipeJsonBuilder(category, RecipeSerializer.STONECUTTING, input, new Identifier(outputItemId.toString()), count);
    }

    public IdentifiersSingleItemRecipeJsonBuilder criterion(String name, CriterionConditions conditions) {
        this.advancementBuilder.criterion(name, conditions);
        return this;
    }

    public IdentifiersSingleItemRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        validate(recipeId);

        advancementBuilder.parent(SingleItemRecipeJsonBuilder.ROOT)
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
                .rewards(net.minecraft.advancement.AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(CriterionMerger.OR);

        exporter.accept(new Provider(
                recipeId,
                serializer,
                group == null ? "" : group,
                inputJson,
                outputId,
                count,
                advancementBuilder,
                recipeId.withPrefixedPath("recipes/" + category.getName() + "/")
        ));
    }

    private void validate(Identifier recipeId) {
        if (advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }

    private class Provider implements RecipeJsonProvider {
        private final Identifier recipeId;
        private final RecipeSerializer<?> serializer;
        private final String group;
        private final JsonObject inputJson;
        private final Identifier outputId;
        private final int count;
        private final Advancement.Builder advancementBuilder;
        private final Identifier advancementId;

        public Provider(
                Identifier recipeId,
                RecipeSerializer<?> serializer,
                String group,
                JsonObject inputJson,
                Identifier outputId,
                int count,
                Advancement.Builder advancementBuilder,
                Identifier advancementId
        ) {
            this.recipeId = recipeId;
            this.serializer = serializer;
            this.group = group;
            this.inputJson = inputJson;
            this.outputId = outputId;
            this.count = count;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }

        @Override
        public void serialize(JsonObject json) {
            if (group != null) {
                json.addProperty("group", group);
            }

            json.add("ingredient", inputJson);
            json.addProperty("result", outputId.toString());
            json.addProperty("count", count);
        }

        public Identifier getRecipeId() {
            return this.recipeId;
        }

        public RecipeSerializer<?> getSerializer() {
            return this.serializer;
        }

        @Nullable
        public JsonObject toAdvancementJson() {
            return this.advancementBuilder.toJson();
        }

        @Nullable
        public Identifier getAdvancementId() {
            return this.advancementId;
        }
    }
}
