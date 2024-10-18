package com.adex.compl.block.logicgate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class TwoInputLogicGate extends LogicGate {

    public static final BooleanProperty INPUT_LEFT = Properties.POWERED;
    public static final BooleanProperty INPUT_RIGHT = Properties.LIT;

    public TwoInputLogicGate(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(INPUT_LEFT, INPUT_RIGHT));
    }

    @Override
    protected BlockState createDefaultState() {
        return super.createDefaultState().with(INPUT_LEFT, false).with(INPUT_RIGHT, false);
    }

    public boolean getInputLeft(BlockState state) {
        return state.get(INPUT_LEFT);
    }

    public boolean getInputRight(BlockState state) {
        return state.get(INPUT_RIGHT);
    }

    public BlockPos getLeftInputPos(BlockPos ownPos, BlockState state) {
        return ownPos.offset(state.get(FACING).rotateYCounterclockwise());
    }

    public BlockPos getRightInputPos(BlockPos ownPos, BlockState state) {
        return ownPos.offset(state.get(FACING).rotateYClockwise());
    }

    @Override
    public boolean updateState(World world, BlockState state, BlockPos pos) {
        boolean oldLeft = state.get(INPUT_LEFT);
        boolean oldRight = state.get(INPUT_RIGHT);

        BlockPos leftPos = getLeftInputPos(pos, state);
        BlockPos rightPos = getRightInputPos(pos, state);

        boolean newLeft = isReceivingPowerFrom(world, leftPos, world.getBlockState(leftPos), state.get(FACING).rotateYClockwise());
        boolean newRight = isReceivingPowerFrom(world, rightPos, world.getBlockState(rightPos), state.get(FACING).rotateYCounterclockwise());

        if (oldLeft == newLeft && oldRight == newRight) return false;

        world.setBlockState(pos, state.with(INPUT_LEFT, newLeft).with(INPUT_RIGHT, newRight));
        return true;
    }

}
