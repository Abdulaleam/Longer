package rainy.longer.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class IceSword extends Item {
    public IceSword(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (!(entity instanceof Player player))
            return;

        boolean held = player.getMainHandItem() == stack || player.getOffhandItem() == stack;

        if (!held)
            return;

        BlockPos pos = BlockPos.containing(player.getX(), player.getY() - 0.1, player.getZ());
        BlockState state = level.getBlockState(pos);

        if (state.isAir())
            return;

        if(state.is(Blocks.ICE))
            return;

        if (!state.getFluidState().isEmpty())
            return;

        if (state.getDestroySpeed(level, pos) < 0)
            return;

        if (level.getBlockEntity(pos) != null)
            return;

        level.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
    }
}
