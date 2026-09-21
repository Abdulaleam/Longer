package rainy.longer.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import rainy.longer.block.LongerBlocks;
import rainy.longer.item.LongerItems;

public class LongerModelProvider extends FabricModelProvider {
    public LongerModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(LongerItems.CRUSHED_COBBLESTONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(LongerItems.WASHED_COBBLEESTONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(LongerItems.INFECTED_PLANKS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(LongerItems.WET_PLANKS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(LongerItems.DIRT_SWORD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(LongerItems.DRIED_COBBLESTONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(LongerItems.DRIED_PLANKS, ModelTemplates.FLAT_ITEM);




    }
}
