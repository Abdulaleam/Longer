package rainy.longer;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import rainy.longer.screen.CleanerScreen;
import rainy.longer.screen.DryingScreen;
import rainy.longer.screen.ModMenuTypes;

public class LongeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        MenuScreens.register(ModMenuTypes.DRYING_MENU, DryingScreen::new);

        MenuScreens.register(ModMenuTypes.CLEANER_MENU, CleanerScreen::new);


    }
}
