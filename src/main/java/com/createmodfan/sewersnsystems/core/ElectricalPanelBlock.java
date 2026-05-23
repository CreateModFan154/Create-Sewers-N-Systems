package com.createmodfan.sewersnsystems.core;

import com.createmodfan.sewersnsystems.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ElectricalPanelBlock extends Block {
    public static final EnumProperty<Half> HALF = EnumProperty.create("half", Half.class);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // 2px thick panel mounted to wall
    private static final VoxelShape NORTH_SHAPE = Block.box(2, 1, 12, 14, 15, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(2, 1, 0, 14, 15, 4);
    private static final VoxelShape WEST_SHAPE  = Block.box(12, 1, 2, 16, 15, 14);
    private static final VoxelShape EAST_SHAPE  = Block.box(0, 1, 2, 4, 15, 14);

    public ElectricalPanelBlock(Properties properties) {
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
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);

        return switch (facing) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction playerFacing = context.getHorizontalDirection().getOpposite();
        boolean placeTop = context.getClickLocation().y - context.getClickedPos().getY() > 0.5;
        return this.defaultBlockState()
                .setValue(FACING, playerFacing)
                .setValue(HALF, placeTop ? Half.TOP : Half.BOTTOM);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, net.minecraft.core.BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getItemInHand(hand).is(ModItems.SCREWDRIVER.get())) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            level.setBlock(pos, state.setValue(FACING, state.getValue(FACING).getClockWise()), Block.UPDATE_ALL);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }


    public enum Half implements StringRepresentable {
        TOP, BOTTOM;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase();
        }
    }
}