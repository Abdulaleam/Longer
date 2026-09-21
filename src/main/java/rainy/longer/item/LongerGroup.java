package rainy.longer.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import rainy.longer.Longer;
import rainy.longer.block.LongerBlocks;

public class LongerGroup {

    public static CreativeModeTab LONGER_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Longer.MOD_ID, "longer_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(LongerItems.CRUSHED_COBBLESTONE))
                    .title(Component.translatable("creativemodtab.longer.longer_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(LongerItems.DIRT_SWORD);
                        output.accept(LongerItems.ICE_SWORD);
                        output.accept(LongerItems.OBSIDIAN_SWORD);
                        output.accept(LongerItems.TNT_SWORD);
                        output.accept(LongerItems.CRUSHED_COBBLESTONE);
                        output.accept(LongerItems.WASHED_COBBLEESTONE);
                        output.accept(LongerItems.INFECTED_PLANKS);
                        output.accept(LongerItems.WET_PLANKS);
                        output.accept(LongerItems.DRIED_COBBLESTONE);
                        output.accept(LongerItems.DRIED_PLANKS);
                        output.accept(LongerBlocks.CLEANER_BLOCK);
                        output.accept(LongerBlocks.DRYING_STATION);
                        output.accept(LongerItems.NETHER_PERMIT);


                    }).build());


    public static void registerCustomTabs() {}
}
