package rainy.longer.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import rainy.longer.Longer;
import rainy.longer.block.LongerBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<CleanerBlockEntity> CLEANER_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(Longer.MOD_ID, "cleaner_be"),
                    FabricBlockEntityTypeBuilder.create(CleanerBlockEntity::new, LongerBlocks.CLEANER_BLOCK).build());


    public static void registerBlockEntities() {    }
}
