package com.adex.compl.block.logicgate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class OneInputLogicGate extends LogicGate {

    public static final BooleanProperty INPUT = Properties.POWERED;

    public OneInputLogicGate(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(INPUT));
    }

    @Override
    protected BlockState createDefaultState() {
        return super.createDefaultState().with(INPUT, false);
    }

    public boolean getInput(BlockState state) {
        return state.get(INPUT);
    }

    public BlockPos getInputPos(BlockPos ownPos, BlockState state) {
        return ownPos.offset(state.get(FACING).getOpposite());
    }

    @Override
    public boolean updateState(World world, BlockState state, BlockPos pos) {
        BlockPos inputPos = getInputPos(pos, state);
        boolean newValue = isReceivingPowerFrom(world, inputPos, world.getBlockState(inputPos), state.get(FACING));

        if (newValue == state.get(INPUT)) return false;

        world.setBlockState(pos, state.with(INPUT, newValue));
        return true;
    }
}
