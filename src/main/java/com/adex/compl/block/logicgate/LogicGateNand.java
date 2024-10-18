package com.adex.compl.block.logicgate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogicGateNand extends TwoInputLogicGate {

    public static final MapCodec<LogicGateNand> CODEC = Block.createCodec(LogicGateNand::new);

    public LogicGateNand(Settings settings) {
        super(settings);
    }

    @Override
    public boolean getOutput(BlockState state) {
        return !(getInputLeft(state) && getInputRight(state));
    }

    @Override
    protected MapCodec<? extends LogicGateNand> getCodec() {
        return CODEC;
    }
}
