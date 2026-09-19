package rainy.longer.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;
import rainy.longer.entity.CleanerBlockEntity;
import rainy.longer.entity.ModBlockEntities;

public class CleanerBlock extends BaseEntityBlock {
    public static final MapCodec<CleanerBlock> CODEC = simpleCodec(CleanerBlock::new);
    protected CleanerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new CleanerBlockEntity(worldPosition, blockState);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity,
                              ItemStack destroyedWith) {
        if (level.getBlockEntity(pos) instanceof CleanerBlockEntity cleanerBlockEntity) {
            cleanerBlockEntity.drop();
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
                                               BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if(level.getBlockEntity(pos) instanceof CleanerBlockEntity cleanerBlockEntity) {
                player.openMenu(cleanerBlockEntity);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState
            , BlockEntityType<T> type) {

        if (level.isClientSide()) {
            return null;
        }
        return createTickerHelper(type, ModBlockEntities.CLEANER_BE, (level1, pos, state, entity) ->
                entity.tick(level1, pos, state));
    }
}
