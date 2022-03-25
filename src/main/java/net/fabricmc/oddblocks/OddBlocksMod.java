package net.fabricmc.oddblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.blocks.OddBlocksTier1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OddBlocksMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_dirt_block"), OddBlocksTier1.ODD_DIRT);
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_dirt_block"), new BlockItem(OddBlocksTier1.ODD_DIRT, new FabricItemSettings().group(ItemGroup.MISC)));
	}
}
