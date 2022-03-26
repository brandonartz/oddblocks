package net.fabricmc.oddblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.oddblocks.blocks.OddBlocksTier1;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.http.impl.io.IdentityInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OddBlocksMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final OddBlocksTier1 ODD_DIRT = new OddBlocksTier1(FabricBlockSettings.of(Material.SOIL).strength(0.5f), 19);
	public static final OddBlocksTier1 ODD_STONE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.0f, 20.0f).requiresTool(), 19);
	public static final OddBlocksTier1 ODD_WOOD = new OddBlocksTier1(FabricBlockSettings.of(Material.WOOD).strength(1.5f, 20.0f), 19);
	
    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_dirt_block"), ODD_DIRT);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_stone_block"), ODD_STONE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_wood_block"), ODD_WOOD);
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_dirt_block"), new BlockItem(ODD_DIRT, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_stone_block"), new BlockItem(ODD_STONE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_wood_block"), new BlockItem(ODD_WOOD, new FabricItemSettings().group(ItemGroup.MISC)));
	}
}
