package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateOr extends TwoInputLogicGate {

    public static final MapCodec<LogicGateOr> CODEC = Block.createCodec(LogicGateOr::new);

    public LogicGateOr(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        return getInputLeft(state) || getInputRight(state);
    }

    @Override
    protected MapCodec<? extends LogicGateOr> getCodec() {
        return CODEC;
    }
}
