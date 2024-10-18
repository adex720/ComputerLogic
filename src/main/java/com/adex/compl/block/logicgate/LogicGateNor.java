package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateNor extends TwoInputLogicGate {

    public static final MapCodec<LogicGateNor> CODEC = Block.createCodec(LogicGateNor::new);

    public LogicGateNor(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        return !(getInputLeft(state) || getInputRight(state));
    }

    @Override
    protected MapCodec<? extends LogicGateNor> getCodec() {
        return CODEC;
    }
}
