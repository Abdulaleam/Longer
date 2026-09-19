package rainy.longer.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record CleanerRecipe (Ingredient inputItem, ItemStackTemplate output) implements Recipe<CleanerRecipeInput> {
    public static final MapCodec<CleanerRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(CleanerRecipe::inputItem),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(CleanerRecipe::output)
            ).apply(instance, CleanerRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CleanerRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    CleanerRecipe::inputItem,
                    ItemStackTemplate.STREAM_CODEC,
                    CleanerRecipe::output,
                    CleanerRecipe::new
            );



    @Override
    public boolean matches(CleanerRecipeInput input, Level level) {
        if(level.isClientSide()) {
            return false;

        }
        return inputItem.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(CleanerRecipeInput input) {
        return output.create().copy();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "cleaning";
    }

    @Override
    public RecipeSerializer<? extends Recipe<CleanerRecipeInput>> getSerializer() {
        return LongerRecipes.CLEANER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<CleanerRecipeInput>> getType() {
        return LongerRecipes.CLEANER_TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
}
