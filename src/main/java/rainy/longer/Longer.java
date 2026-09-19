package rainy.longer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rainy.longer.block.LongerBlocks;
import rainy.longer.entity.ModBlockEntities;
import rainy.longer.item.LongerGroup;
import rainy.longer.item.LongerItems;
import rainy.longer.screen.ModMenuTypes;

public class Longer implements ModInitializer {
	public static final String MOD_ID = "longer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LongerItems.registerLongerItems();
		LongerGroup.registerCustomTabs();
		LongerBlocks.registerLongerBlocks();
		ModBlockEntities.registerBlockEntities();
		ModMenuTypes.registerModMenuTypes();


	}
}
