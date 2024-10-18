package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateXor extends TwoInputLogicGate {

    public static final MapCodec<LogicGateXor> CODEC = Block.createCodec(LogicGateXor::new);

    public LogicGateXor(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        boolean a = getInputLeft(state);
        boolean b = getInputRight(state);
        boolean out = a != b;
        return out;
    }

    @Override
    protected MapCodec<? extends LogicGateXor> getCodec() {
        return CODEC;
    }
}
