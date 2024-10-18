package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateNot extends OneInputLogicGate {

    public static final MapCodec<LogicGateNot> CODEC = Block.createCodec(LogicGateNot::new);

    public LogicGateNot(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        return !getInput(state);
    }

    @Override
    protected MapCodec<? extends LogicGateNot> getCodec() {
        return CODEC;
    }
}
