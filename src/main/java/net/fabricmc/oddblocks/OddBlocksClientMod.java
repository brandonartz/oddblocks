package net.fabricmc.oddblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.oddblocks.screens.OddAutoMinerScreen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class OddBlocksClientMod implements ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("oddblocks");
	
	@Override
	public void onInitializeClient() {
		LOGGER.info("Hello Client!");	

		ScreenRegistry.register(OddBlocksMod.ODD_AUTO_MINER_SCREEN_HANDLER, OddAutoMinerScreen::new);
	}
}
