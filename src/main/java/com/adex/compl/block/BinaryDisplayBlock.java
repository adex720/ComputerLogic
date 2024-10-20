package com.adex.compl.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BinaryDisplayBlock extends HorizontalFacingBlock {

    public static final int FRONT_MULTIPLIER = 1;
    public static final int LEFT_MULTIPLIER = 2;
    public static final int RIGHT_MULTIPLIER = 4;
    public static final int BACK_MULTIPLIER = 8;

    public static final IntProperty VALUE = Properties.POWER;

    public static final MapCodec<BinaryDisplayBlock> CODEC = Block.createCodec(BinaryDisplayBlock::new);

    public BinaryDisplayBlock(Settings settings) {
        super(settings);
        setDefaultState(stateManager.getDefaultState().with(FACING, Direction.NORTH).with(VALUE, 0));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING, VALUE));
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        updateState(world, pos, state);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        updateState(world, pos, state);
    }

    public void updateState(World world, BlockPos pos, BlockState state) {
        int oldValue = state.get(VALUE);

        Direction frontDirection = state.get(FACING);
        Direction leftDirection = frontDirection.rotateYCounterclockwise();
        Direction RightDirection = frontDirection.rotateYClockwise();
        Direction backDirection = frontDirection.getOpposite();

        int frontValue = isReceivingPowerFrom(world, pos, frontDirection) ? FRONT_MULTIPLIER : 0;
        int leftValue = isReceivingPowerFrom(world, pos, leftDirection) ? LEFT_MULTIPLIER : 0;
        int rightValue = isReceivingPowerFrom(world, pos, RightDirection) ? RIGHT_MULTIPLIER : 0;
        int backValue = isReceivingPowerFrom(world, pos, backDirection) ? BACK_MULTIPLIER : 0;

        int newValue = frontValue + leftValue + rightValue + backValue;
        if (oldValue == newValue) return;
        world.setBlockState(pos, state.with(VALUE, newValue));
    }

    public boolean isReceivingPowerFrom(World world, BlockPos ownPos, Direction direction) {
        BlockPos sourcePos = ownPos.offset(direction);
        BlockState sourceState = world.getBlockState(sourcePos);

        return sourceState.getWeakRedstonePower(world, sourcePos, direction) > 0;
    }

}
