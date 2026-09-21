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

    public static final Item INFECTED_PLANKS = registerItem("infected_planks", Item::new);

    public static final Item WET_PLANKS = registerItem("wet_planks", Item::new);

    public static final Item DRIED_PLANKS = registerItem("dried_planks", Item::new);

    public static final Item DRIED_COBBLESTONE = registerItem("dried_cobblestone", Item::new);

    public static final Item DIRT_SWORD = registerItem("dirt_sword", DirtySword::new, new Item.Properties().stacksTo(1));

    public static final Item ICE_SWORD = registerItem("ice_sword", IceSword::new, new Item.Properties().stacksTo(1));

    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword", ObsidianSword::new, new Item.Properties().stacksTo(1));

    public static final Item TNT_SWORD = registerItem("tnt_sword", TNTSword::new, new Item.Properties().stacksTo(1));

    public static final Item NETHER_PERMIT = registerItem("nether_permit", Item::new, new Item.Properties().stacksTo(1));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return registerItem(name, function, new Item.Properties());
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, function.apply(properties.setId(key)));
    }

    public static void registerLongerItems() {
        Longer.LOGGER.info("Registering Longer Items for " + Longer.MOD_ID);
    }
}