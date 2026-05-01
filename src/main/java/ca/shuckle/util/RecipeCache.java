package ca.shuckle.util;

import ca.shuckle.mixin.CraftingInventoryMixin;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RecipeCache {
    private final CachedRecipe[] cache;
    private WeakReference<RecipeManager> recipeManagerRef = new WeakReference<>(null);

    public RecipeCache(int size) {
        this.cache = new CachedRecipe[size];
    }

    public Optional<CraftingRecipe> getRecipe(World world, CraftingInventory inventory) {
        if (inventory.isEmpty()) {
            return Optional.empty();
        } else {
            this.validateRecipeManager(world);

            for(int i = 0; i < this.cache.length; ++i) {
                CachedRecipe cachedRecipe = this.cache[i];
                if (cachedRecipe != null && cachedRecipe.matches(((CraftingInventoryMixin)inventory).getInventory())) {
                    this.sendToFront(i);
                    return Optional.ofNullable(cachedRecipe.craftingRecipe());
                }
            }

            return this.getAndCacheRecipe(inventory, world);
        }
    }

    private void validateRecipeManager(World world) {
        RecipeManager recipeManager = world.getRecipeManager();
        if (recipeManager != this.recipeManagerRef.get()) {
            this.recipeManagerRef = new WeakReference<>(recipeManager);
            Arrays.fill(this.cache, null);
        }

    }

    private Optional<CraftingRecipe> getAndCacheRecipe(CraftingInventory inventory, World world) {
        Optional<CraftingRecipe> optional = world.getRecipeManager().getFirstMatch(RecipeType.CRAFTING, inventory, world);
        this.cache(((CraftingInventoryMixin)inventory).getInventory(), optional.orElse(null));
        return optional;
    }

    private void sendToFront(int index) {
        if (index > 0) {
            CachedRecipe cachedRecipe = this.cache[index];
            System.arraycopy(this.cache, 0, this.cache, 1, index);
            this.cache[0] = cachedRecipe;
        }

    }

    private void cache(List<ItemStack> inputStacks, @Nullable CraftingRecipe recipe) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inputStacks.size(), ItemStack.EMPTY);

        for(int i = 0; i < inputStacks.size(); ++i) {
            defaultedList.set(i, inputStacks.get(i).copyWithCount(1));
        }

        System.arraycopy(this.cache, 0, this.cache, 1, this.cache.length - 1);
        this.cache[0] = new CachedRecipe(defaultedList, recipe);
    }

    record CachedRecipe(DefaultedList<ItemStack> defaultedList, @Nullable CraftingRecipe craftingRecipe) {

        public boolean matches(List<ItemStack> inputs) {
            if (this.defaultedList.size() != inputs.size()) {
                return false;
            } else {
                for(int i = 0; i < this.defaultedList.size(); ++i) {
                    if (!ItemStack.canCombine(this.defaultedList.get(i), inputs.get(i))) {
                        return false;
                    }
                }

                return true;
            }
        }

        public DefaultedList<ItemStack> defaultedList() {
            return this.defaultedList;
        }

        @Nullable
        public CraftingRecipe craftingRecipe() {
            return this.craftingRecipe;
        }
    }
}
