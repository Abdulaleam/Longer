package rainy.longer.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import rainy.longer.Longer;

public class LongerRecipes {
    public static final RecipeSerializer<CleanerRecipe> CLEANER_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(Longer.MOD_ID, "cleaning"),
            new RecipeSerializer<>(CleanerRecipe.CODEC, CleanerRecipe.STREAM_CODEC));

    public static final RecipeSerializer<DryingRecipe> DRYING_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(Longer.MOD_ID, "drying"),
            new RecipeSerializer<>(DryingRecipe.CODEC, DryingRecipe.STREAM_CODEC));


    public static final RecipeType<CleanerRecipe> CLEANER_TYPE = Registry.register(BuiltInRegistries.RECIPE_TYPE,
            Identifier.fromNamespaceAndPath(Longer.MOD_ID, "cleaning"),
            new RecipeType<CleanerRecipe>() {
                @Override
                public String toString() {
                    return "cleaning";
                }
            });

    public static final RecipeType<DryingRecipe> DRYING_TYPE = Registry.register(BuiltInRegistries.RECIPE_TYPE,
            Identifier.fromNamespaceAndPath(Longer.MOD_ID, "drying"),
            new RecipeType<DryingRecipe> () {
                @Override
                public String toString() {
                    return "drying";
                }
            });

    public static void registeRecipes() {}
}
