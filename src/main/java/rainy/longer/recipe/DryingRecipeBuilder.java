package rainy.longer.recipe;

import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.Nullable;

public class DryingRecipeBuilder implements RecipeBuilder {

    private final RecipeCategory category;
    private final ItemStackTemplate result;
    private final Ingredient ingredient;
    private final RecipeUnlockAdvancementBuilder advancementBuilder = new RecipeUnlockAdvancementBuilder();
    private @Nullable String group;

    private DryingRecipeBuilder(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result) {

        this.category = category;
        this.result = result;
        this.ingredient = ingredient;
    }

    public static DryingRecipeBuilder dryingRecipe(RecipeCategory category, Ingredient ingredient, ItemLike item, int count) {

        return new DryingRecipeBuilder(category, ingredient, new ItemStackTemplate(item.asItem(), count));

    }
    public static DryingRecipeBuilder dryingRecipe(RecipeCategory category, Ingredient ingredient, ItemLike item) {
        return new DryingRecipeBuilder(category, ingredient, new ItemStackTemplate(item.asItem()));
    }
    @Override
    public DryingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.advancementBuilder.unlockedBy(name, criterion);
        return this;
    }
    @Override
    public DryingRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(this.result);
    }
    @Override
    public void save (RecipeOutput output, ResourceKey<Recipe<?>> id) {
        DryingRecipe recipe = new DryingRecipe(this.ingredient,this.result);
        output.accept(id, recipe, this.advancementBuilder.build(output, id, this.category));
    }
}