package com.adex.compl.init;

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


        LOGGER.info("Finished to initializing {}", MOD_NAME);
    }
}
