package rainy.longer.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record DryingRecipe (Ingredient inputItem, ItemStackTemplate output) implements Recipe<DryingRecipeInput> {

    public static final MapCodec<DryingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(DryingRecipe::inputItem),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(DryingRecipe::output)
            ).apply(instance, DryingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, DryingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    DryingRecipe::inputItem,
                    ItemStackTemplate.STREAM_CODEC,
                    DryingRecipe::output,
                    DryingRecipe::new
            );

    @Override
    public boolean matches(DryingRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        return inputItem.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(DryingRecipeInput input) {
        return output.create().copy();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "drying";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DryingRecipeInput>> getSerializer() {
        return LongerRecipes.DRYING_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<DryingRecipeInput>> getType() {
        return LongerRecipes.DRYING_TYPE;
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
