package rainy.longer.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record DryingRecipeInput (ItemStack input)implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return input;
    }

    @Override
    public int size() {
        return 2;
    }
}
