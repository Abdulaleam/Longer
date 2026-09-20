package rainy.longer.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import rainy.longer.block.LongerBlocks;
import rainy.longer.item.LongerItems;
import rainy.longer.recipe.CleanerRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class LongerRecipeProvider extends FabricRecipeProvider {
    public LongerRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {

                shaped(RecipeCategory.MISC, LongerBlocks.CLEANER_BLOCK)
                        .pattern("RRR")
                        .pattern("RXR")
                        .pattern("RRR")
                        .define('R', Items.SAND)
                        .define('X', Blocks.OAK_PLANKS)
                        .unlockedBy(getHasName(LongerItems.CRUSHED_COBBLESTONE), has(LongerItems.CRUSHED_COBBLESTONE))
                        .group("longer")
                        .save(output);

                CleanerRecipeBuilder.cleanerRecipe(RecipeCategory.MISC, Ingredient.of(LongerItems.CRUSHED_COBBLESTONE),
                        LongerItems.WASHED_COBBLEESTONE, 1)
                        .unlockedBy(getHasName(LongerItems.CRUSHED_COBBLESTONE), has(LongerItems.CRUSHED_COBBLESTONE))
                        .save(output, "longer:washeed_cobblestone_from_cleaning");

                CleanerRecipeBuilder.cleanerRecipe(RecipeCategory.MISC, Ingredient.of(LongerItems.INFECTED_PLANKS),
                                LongerItems.WET_PLANKS, 1)
                        .unlockedBy(getHasName(LongerItems.INFECTED_PLANKS), has(LongerItems.INFECTED_PLANKS))
                        .save(output, "longer:wet_planks_from_cleaning");





            }
        };
    }

    @Override
    public String getName() {
        return "LongerMod Recipes";
    }
}
