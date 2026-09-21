package rainy.longer.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import rainy.longer.Longer;

import java.util.function.Function;

public class LongerBlocks {

    public static final Block CLEANER_BLOCK = registerBlock("cleaner_block", CleanerBlock::new);

    public static final Block DRYING_STATION = registerBlock("drying_station", DryingStation::new);

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name),  toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name),
                new BlockItem(block , new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Longer.MOD_ID, name)))));

    }


    public static void registerLongerBlocks() {
        Longer.LOGGER.info("Registering Longer Blocks for " + Longer.MOD_ID);
    }
}
