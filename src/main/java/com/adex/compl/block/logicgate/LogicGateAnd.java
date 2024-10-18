package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateAnd extends TwoInputLogicGate {

    public static final MapCodec<LogicGateAnd> CODEC = Block.createCodec(LogicGateAnd::new);

    public LogicGateAnd(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        return getInputLeft(state) && getInputRight(state);
    }

    @Override
    protected MapCodec<? extends LogicGateAnd> getCodec() {
        return CODEC;
    }
}
