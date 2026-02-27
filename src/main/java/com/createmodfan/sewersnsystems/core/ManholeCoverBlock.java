package com.createmodfan.sewersnsystems.core;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ManholeCoverBlock extends Block {
    public static final EnumProperty<Half> HALF = EnumProperty.create("half", Half.class);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ManholeCoverBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HALF, Half.BOTTOM)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction playerFacing = context.getHorizontalDirection().getOpposite();
        boolean placeTop = context.getClickLocation().y - context.getClickedPos().getY() > 0.5;
        return this.defaultBlockState()
                .setValue(FACING, playerFacing)
                .setValue(HALF, placeTop ? Half.TOP : Half.BOTTOM);
    }

    public enum Half implements StringRepresentable {
        TOP, BOTTOM;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase();
        }
    }
}

