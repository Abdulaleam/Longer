package rainy.longer.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.portal.TeleportTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rainy.longer.item.LongerItems;
@Mixin(EndPortalBlock.class)
public abstract class EndPortalBlockMixin {

	@Inject(method = "getPortalDestination", at = @At("HEAD"), cancellable = true)
	private void longer$requireEndPermit(ServerLevel level, Entity entity, BlockPos pos,
	                                     CallbackInfoReturnable<TeleportTransition> cir) {
		if (!(entity instanceof ServerPlayer player)) return;
		if (level.dimension() == Level.END) return; // always let players leave the End

		if (!player.isHolding(LongerItems.END_PERMIT)) {
			player.sendSystemMessage(Component.literal("You need an End Permit in your hand."), true);
			cir.setReturnValue(null);
		}
	}
}