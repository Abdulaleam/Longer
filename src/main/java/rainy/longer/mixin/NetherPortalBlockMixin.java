package rainy.longer.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.portal.TeleportTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rainy.longer.item.LongerItems;

@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockMixin {

	@Inject(method = "getPortalDestination", at = @At("HEAD"), cancellable = true)
	private void longer$requireNetherPermit(ServerLevel level, Entity entity, BlockPos pos,
	                                        CallbackInfoReturnable<TeleportTransition> cir) {
		if (!(entity instanceof ServerPlayer player)) return;
		if (level.dimension() == Level.NETHER) return;

		if (!player.isHolding(LongerItems.NETHER_PERMIT)) {
			player.sendSystemMessage(Component.literal("You need a Nether Permit in your hand."), true);
			cir.setReturnValue(null);
		}
	}
}