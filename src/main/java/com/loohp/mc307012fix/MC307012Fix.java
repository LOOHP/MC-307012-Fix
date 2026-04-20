package com.loohp.mc307012fix;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MC307012Fix implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("mc-307012-fix");
    public static MC307012Fix MOD;

    @Override
    public void onInitialize() {
        MOD = this;
        LOGGER.info("Fixing MC-307012...");
    }

}
