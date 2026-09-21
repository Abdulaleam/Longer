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
import rainy.longer.recipe.DryingRecipeBuilder;

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
                        .unlockedBy(getHasName(Items.SAND), has(Items.SAND))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerBlocks.DRYING_STATION)
                        .pattern("RRR")
                        .pattern("RXR")
                        .pattern("RRR")
                        .define('R', LongerItems.WET_PLANKS)
                        .define('X', LongerItems.INFECTED_PLANKS)
                        .unlockedBy(getHasName(LongerItems.WET_PLANKS), has(LongerItems.WET_PLANKS))
                        .save(output);

                shaped(RecipeCategory.MISC, Items.OAK_PLANKS)
                        .pattern("RXR")
                        .pattern("RXR")
                        .define('R', LongerItems.DRIED_PLANKS)
                        .define('X', Items.SUGAR_CANE)
                        .unlockedBy(getHasName(LongerItems.DRIED_PLANKS), has(LongerItems.DRIED_PLANKS))
                        .save(output);

                shaped(RecipeCategory.MISC, Items.COBBLESTONE)
                        .pattern("RXR")
                        .pattern("RXR")
                        .define('R', LongerItems.DRIED_COBBLESTONE)
                        .define('X', Items.SUGAR_CANE)
                        .unlockedBy(getHasName(LongerItems.DRIED_COBBLESTONE), has(LongerItems.DRIED_COBBLESTONE))
                        .save(output);

                shaped(RecipeCategory.COMBAT, LongerItems.DIRT_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" X ")
                        .define('R', Items.DIRT)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DIRT), has(Items.DIRT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, LongerItems.ICE_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" X ")
                        .define('R', Items.ICE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ICE), has(Items.ICE))
                        .save(output);

                shaped(RecipeCategory.COMBAT, LongerItems.OBSIDIAN_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" X ")
                        .define('R', Items.OBSIDIAN)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                        .save(output);

                shaped(RecipeCategory.COMBAT, LongerItems.TNT_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" X ")
                        .define('R', Items.TNT)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.TNT), has(Items.TNT))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.NETHER_PERMIT)
                        .pattern("PPP")
                        .pattern("OFO")
                        .pattern("PPP")
                        .define('P', Items.PAPER)
                        .define('O', Items.OBSIDIAN)
                        .define('F', Items.FLINT_AND_STEEL)
                        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.END_PERMIT)
                        .pattern(" R ")
                        .pattern("RXR")
                        .pattern(" R ")
                        .define('R', Items.ENDER_EYE)
                        .define('X', LongerItems.NETHER_PERMIT)
                        .unlockedBy(getHasName(LongerItems.NETHER_PERMIT), has(LongerItems.NETHER_PERMIT))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.PICKAXE_HANDLE)
                        .pattern("R")
                        .pattern("X")
                        .pattern("R")
                        .define('R', Items.STICK)
                        .define('X', LongerItems.DRIED_PLANKS)
                        .unlockedBy(getHasName(LongerItems.DRIED_PLANKS), has(LongerItems.DRIED_PLANKS))
                        .save(output);

                shapeless(RecipeCategory.MISC, LongerItems.PICKAXE_BINDING)
                        .requires(Items.STRING, 3)
                        .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.STONE_PICKAXE_HEAD)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', LongerItems.DRIED_COBBLESTONE)
                        .unlockedBy(getHasName(LongerItems.DRIED_COBBLESTONE), has(LongerItems.DRIED_COBBLESTONE))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.IRON_PICKAXE_HEAD)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.GOLD_PICKAXE_HEAD)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output);

                shaped(RecipeCategory.MISC, LongerItems.DIAMOND_PICKAXE_HEAD)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output);

                shapeless(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                        .requires(LongerItems.STONE_PICKAXE_HEAD)
                        .requires(LongerItems.PICKAXE_HANDLE)
                        .requires(LongerItems.PICKAXE_BINDING)
                        .unlockedBy(getHasName(LongerItems.STONE_PICKAXE_HEAD), has(LongerItems.STONE_PICKAXE_HEAD))
                        .save(output, "longer:stone_pickaxe_from_parts");

                shapeless(RecipeCategory.TOOLS, Items.IRON_PICKAXE)
                        .requires(LongerItems.IRON_PICKAXE_HEAD)
                        .requires(LongerItems.PICKAXE_HANDLE)
                        .requires(LongerItems.PICKAXE_BINDING)
                        .unlockedBy(getHasName(LongerItems.IRON_PICKAXE_HEAD), has(LongerItems.IRON_PICKAXE_HEAD))
                        .save(output, "longer:iron_pickaxe_from_parts");

                shapeless(RecipeCategory.TOOLS, Items.GOLDEN_PICKAXE)
                        .requires(LongerItems.GOLD_PICKAXE_HEAD)
                        .requires(LongerItems.PICKAXE_HANDLE)
                        .requires(LongerItems.PICKAXE_BINDING)
                        .unlockedBy(getHasName(LongerItems.GOLD_PICKAXE_HEAD), has(LongerItems.GOLD_PICKAXE_HEAD))
                        .save(output, "longer:golden_pickaxe_from_parts");

                shapeless(RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE)
                        .requires(LongerItems.DIAMOND_PICKAXE_HEAD)
                        .requires(LongerItems.PICKAXE_HANDLE)
                        .requires(LongerItems.PICKAXE_BINDING)
                        .unlockedBy(getHasName(LongerItems.DIAMOND_PICKAXE_HEAD), has(LongerItems.DIAMOND_PICKAXE_HEAD))
                        .save(output, "longer:diamond_pickaxe_from_parts");

                CleanerRecipeBuilder.cleanerRecipe(RecipeCategory.MISC, Ingredient.of(LongerItems.CRUSHED_COBBLESTONE),
                                LongerItems.WASHED_COBBLEESTONE, 1)
                        .unlockedBy(getHasName(LongerItems.CRUSHED_COBBLESTONE), has(LongerItems.CRUSHED_COBBLESTONE))
                        .save(output, "longer:washeed_cobblestone_from_cleaning");

                CleanerRecipeBuilder.cleanerRecipe(RecipeCategory.MISC, Ingredient.of(LongerItems.INFECTED_PLANKS),
                                LongerItems.WET_PLANKS, 1)
                        .unlockedBy(getHasName(LongerItems.INFECTED_PLANKS), has(LongerItems.INFECTED_PLANKS))
                        .save(output, "longer:wet_planks_from_cleaning");

                DryingRecipeBuilder.dryingRecipe(RecipeCategory.MISC, Ingredient.of(LongerItems.WASHED_COBBLEESTONE),
                                LongerItems.DRIED_COBBLESTONE, 1)
                        .unlockedBy(getHasName(LongerItems.WASHED_COBBLEESTONE), has(LongerItems.WASHED_COBBLEESTONE))
                        .save(output, "longer:dried_cobblestone_from_drying");

                DryingRecipeBuilder.dryingRecipe(RecipeCategory.MISC, Ingredient.of(LongerItems.WET_PLANKS),
                                LongerItems.DRIED_PLANKS, 1)
                        .unlockedBy(getHasName(LongerItems.WET_PLANKS), has(LongerItems.WET_PLANKS))
                        .save(output, "longer:dried_planks_from_drying");
            }
        };
    }

    @Override
    public String getName() {
        return "LongerMod Recipes";
    }
}