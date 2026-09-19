package rainy.longer.screen;

import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.MenuType;
import rainy.longer.Longer;

public class ModMenuTypes {
    public static final MenuType<CleanerMenu> CLEANER_MENU =
            Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(Longer.MOD_ID, "cleaner_menu"),
                    new ExtendedMenuType<>(CleanerMenu::new, BlockPos.STREAM_CODEC));

    public static void registerModMenuTypes() {}
}
