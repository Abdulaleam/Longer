package rainy.longer.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TNTSword extends Item {

    private static final float RADIUS = 4.0f;
    private static final int COOLDOWN = 40;

    public TNTSword(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level instanceof ServerLevel serverLevel) {
            serverLevel.explode(
                    player, player.getX(), player.getY(), player.getZ(), RADIUS, Level.ExplosionInteraction.TNT
            );
            player.getCooldowns().addCooldown(stack, COOLDOWN);
            stack.hurtAndBreak(1, player, hand);
        }
        return InteractionResult.SUCCESS;
    }
}
