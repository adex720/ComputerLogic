package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateXnor extends TwoInputLogicGate {

    public static final MapCodec<LogicGateXnor> CODEC = Block.createCodec(LogicGateXnor::new);

    public LogicGateXnor(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        return getInputLeft(state) == getInputRight(state);
    }

    @Override
    protected MapCodec<? extends LogicGateXnor> getCodec() {
        return CODEC;
    }
}
