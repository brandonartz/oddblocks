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
	public static final OddBlocksTier1 ODD_MEAT = new OddBlocksTier1(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(1.5f), 9);
	public static final OddBlocksTier1 ODD_SEAFOOD = new OddBlocksTier1(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(1.5f), 9);
	public static final OddBlocksTier1 ODD_MONSTER_MATS = new OddBlocksTier1(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(2.5f), 4);
	public static final OddBlocksTier1 ODD_FARM_SEED = new OddBlocksTier1(FabricBlockSettings.of(Material.PLANT).strength(0.5f), 9);
	public static final OddBlocksTier1 ODD_FOOD_SEED = new OddBlocksTier1(FabricBlockSettings.of(Material.PLANT).strength(0.5f), 9);
	public static final OddBlocksTier1 ODD_FLOWER = new OddBlocksTier1(FabricBlockSettings.of(Material.PLANT).strength(0.5f), 19);
	public static final OddBlocksTier1 ODD_SAPLING = new OddBlocksTier1(FabricBlockSettings.of(Material.PLANT).strength(1.5f), 4);
	public static final OddBlocksTier1 ODD_STONE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.0f, 20.0f).requiresTool(), 19);
	public static final OddBlocksTier1 ODD_EMERALD_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(3.0f, 20.0f).requiresTool(), 4);
	public static final OddBlocksTier1 ODD_DIAMOND_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(3.0f, 20.0f).requiresTool(), 4);
	public static final OddBlocksTier1 ODD_LAPIS_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.5f, 20.0f).requiresTool(), 6);
	public static final OddBlocksTier1 ODD_AMETHYST_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.5f, 20.0f).requiresTool(), 6);
	public static final OddBlocksTier1 ODD_COAL_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(1.5f, 20.0f).requiresTool(), 14);
	public static final OddBlocksTier1 ODD_REDSTONE_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.0f, 20.0f).requiresTool(), 6);
	public static final OddBlocksTier1 ODD_WOOD = new OddBlocksTier1(FabricBlockSettings.of(Material.WOOD).strength(1.5f, 20.0f), 19);
	public static final OddBlocksTier1 ODD_FARM_EGG = new OddBlocksTier1(FabricBlockSettings.of(Material.EGG).strength(1.0f, 20.0f), 9);
	public static final OddBlocksTier1 ODD_PET_EGG = new OddBlocksTier1(FabricBlockSettings.of(Material.EGG).strength(1.0f, 20.0f), 1);
	public static final OddBlocksTier1 ODD_MUSIC_DISC = new OddBlocksTier1(FabricBlockSettings.of(Material.DECORATION).strength(2.0f, 20.0f), 0);
	public static final OddBlocksTier1 ODD_RARE = new OddBlocksTier1(FabricBlockSettings.of(Material.DECORATION).strength(3.0f, 20.0f).requiresTool(), 0);
	public static final OddBlocksTier1 ODD_TOOL = new OddBlocksTier1(FabricBlockSettings.of(Material.DECORATION).strength(2.0f, 20.0f), 0);
	public static final OddBlocksTier1 ODD_COPPER_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.METAL).strength(2.5f, 20.0f).requiresTool(), 19);
	public static final OddBlocksTier1 ODD_IRON_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.METAL).strength(2.5f, 20.0f).requiresTool(), 19);
	public static final OddBlocksTier1 ODD_GOLD_ORE = new OddBlocksTier1(FabricBlockSettings.of(Material.METAL).strength(2.0f, 20.0f).requiresTool(), 19);

	
    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_dirt_block"), ODD_DIRT);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_meat_block"), ODD_MEAT);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_seafood_block"), ODD_SEAFOOD);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_monster_mats_block"), ODD_MONSTER_MATS);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_farm_seed_block"), ODD_FARM_SEED);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_food_seed_block"), ODD_FOOD_SEED);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_flower_block"), ODD_FLOWER);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_sapling_block"), ODD_SAPLING);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_stone_block"), ODD_STONE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_wood_block"), ODD_WOOD);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_farm_egg_block"), ODD_FARM_EGG);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_pet_egg_block"), ODD_PET_EGG);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_music_disc_block"), ODD_MUSIC_DISC);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_rare_block"), ODD_RARE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_tool_block"), ODD_TOOL);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_copper_ore_block"), ODD_COPPER_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_iron_ore_block"), ODD_IRON_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_gold_ore_block"), ODD_GOLD_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_emerald_ore_block"), ODD_EMERALD_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_diamond_ore_block"), ODD_DIAMOND_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_lapis_ore_block"), ODD_LAPIS_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_amethyst_ore_block"), ODD_AMETHYST_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_coal_ore_block"), ODD_COAL_ORE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_redstone_ore_block"), ODD_REDSTONE_ORE);
		
		
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_dirt_block"), new BlockItem(ODD_DIRT, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_meat_block"), new BlockItem(ODD_MEAT, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_seafood_block"), new BlockItem(ODD_SEAFOOD, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_monster_mats_block"), new BlockItem(ODD_MONSTER_MATS, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_farm_seed_block"), new BlockItem(ODD_FARM_SEED, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_food_seed_block"), new BlockItem(ODD_FOOD_SEED, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_flower_block"), new BlockItem(ODD_FLOWER, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_sapling_block"), new BlockItem(ODD_SAPLING, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_stone_block"), new BlockItem(ODD_STONE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_wood_block"), new BlockItem(ODD_WOOD, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_farm_egg_block"), new BlockItem(ODD_FARM_EGG, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_pet_egg_block"), new BlockItem(ODD_PET_EGG, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_music_disc_block"), new BlockItem(ODD_MUSIC_DISC, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_rare_block"), new BlockItem(ODD_RARE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_tool_block"), new BlockItem(ODD_TOOL, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_copper_ore_block"), new BlockItem(ODD_COPPER_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_iron_ore_block"), new BlockItem(ODD_IRON_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_gold_ore_block"), new BlockItem(ODD_GOLD_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_emerald_ore_block"), new BlockItem(ODD_EMERALD_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_diamond_ore_block"), new BlockItem(ODD_DIAMOND_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_lapis_ore_block"), new BlockItem(ODD_LAPIS_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_amethyst_ore_block"), new BlockItem(ODD_AMETHYST_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_coal_ore_block"), new BlockItem(ODD_COAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_redstone_ore_block"), new BlockItem(ODD_REDSTONE_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
	}
}
