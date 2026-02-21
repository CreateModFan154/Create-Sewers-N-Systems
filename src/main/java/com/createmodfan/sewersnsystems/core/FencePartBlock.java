package com.createmodfan.sewersnsystems.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import com.createmodfan.sewersnsystems.util.ModTags;

public class FencePartBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty HAS_POLE = BooleanProperty.create("has_pole");{
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)

        );

    };
    @Override
    public BlockState updateShape(@NotNull BlockState state, @NotNull Direction dir, @NotNull BlockState neighborState,
                                  @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        return super.updateShape(state, dir, neighborState, level, pos, neighborPos);
    }

    public FencePartBlock(Properties props) {
        super(props);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}