package com.adex.compl.init;

import net.fabricmc.api.ClientModInitializer;

public class ComputerLogicClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ComputerLogic.LOGGER.info("Starting to initialize {} for client", ComputerLogic.MOD_NAME);


        ComputerLogic.LOGGER.info("Finished to initializing {} for client", ComputerLogic.MOD_NAME);
    }
}
