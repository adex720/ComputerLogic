package com.adex.compl.init;

import com.adex.compl.block.ModBlocks;
import com.adex.compl.gamerule.ModGameRules;
import com.adex.compl.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputerLogic implements ModInitializer {

    public static final String MOD_ID = "compl";
    public static final String MOD_NAME = "Computer Logic";


    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Starting to initialize {}", MOD_NAME);

        ModItems.registerItems();

        ModBlocks.registerBlocks();

        ModGameRules.registerGameRules();

        LOGGER.info("Finished to initializing {}", MOD_NAME);
    }
}
