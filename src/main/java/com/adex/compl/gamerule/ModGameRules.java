package com.adex.compl.gamerule;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {

    public static final GameRules.Key<GameRules.IntRule> LOGIC_GATE_DELAY = GameRuleRegistry.register("logicGateDelay", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(2, 1, 20));

    public static void registerGameRules() {
    }

}
