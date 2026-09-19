package rainy.longer.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import rainy.longer.Longer;

import java.util.function.Function;

public class LongerItems {

    public static final Item CRUSHED_COBBLESTONE = registerItem("crushed_cobblestone", Item::new);

    public static final Item WASHED_COBBLEESTONE = registerItem("washeed_cobblestone", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name)))));
    }

     public static void registerLongerItems() {
         Longer.LOGGER.info("Registering Longer Items for " + Longer.MOD_ID);
     }
}
