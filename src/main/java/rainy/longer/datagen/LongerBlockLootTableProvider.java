package rainy.longer.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import rainy.longer.block.CleanerBlock;
import rainy.longer.block.LongerBlocks;
import rainy.longer.item.LongerItems;

import java.util.concurrent.CompletableFuture;

public class LongerBlockLootTableProvider extends FabricBlockLootSubProvider {
    public LongerBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(LongerBlocks.CLEANER_BLOCK);

        add(Blocks.STONE, createMultipleOreDrops(Blocks.STONE, LongerItems.CRUSHED_COBBLESTONE, 3, 7));

        add(Blocks.OAK_LOG, createMultipleOreDrops(Blocks.OAK_LOG,LongerItems.INFECTED_PLANKS, 3 , 5));

        add(Blocks.BIRCH_LOG, createMultipleOreDrops(Blocks.BIRCH_LOG,LongerItems.INFECTED_PLANKS, 3 , 5));

        add(Blocks.SPRUCE_LOG, createMultipleOreDrops(Blocks.SPRUCE_LOG,LongerItems.INFECTED_PLANKS, 3 , 5));




    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);


            return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
        ));
    }
}