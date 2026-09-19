package rainy.longer;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import rainy.longer.datagen.LongerBlockLootTableProvider;
import rainy.longer.datagen.LongerModelProvider;
import rainy.longer.datagen.LongerRecipeProvider;

public class LongerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		var pack = fabricDataGenerator.createPack();

		pack.addProvider(LongerModelProvider::new);

		pack.addProvider(LongerBlockLootTableProvider::new);

		pack.addProvider(LongerRecipeProvider::new);

	}
}
