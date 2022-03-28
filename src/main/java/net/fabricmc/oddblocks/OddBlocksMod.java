package net.fabricmc.oddblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.oddblocks.blocks.OddBlocksTier1;
<<<<<<< HEAD
import net.fabricmc.oddblocks.world.AbyssGeneratorType;
import net.fabricmc.oddblocks.world.biome.AbyssBiome;
import net.fabricmc.oddblocks.world.gen.chunk.AbyssChunkGeneratorSettings;
import net.fabricmc.oddblocks.world.gen.feature.OddDirtFeature;
import net.fabricmc.oddblocks.world.gen.feature.OddSpawnFeature;
=======
import net.fabricmc.oddblocks.mixin.GeneratorTypeAccessorMixin;
import net.fabricmc.oddblocks.world.gen.feature.OddBlocksFeature;
import net.minecraft.block.Blocks;
>>>>>>> a6dbbb5 (Cleanup of world gen)
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
<<<<<<< HEAD
=======
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.biome.source.util.VanillaTerrainParametersCreator;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.chunk.NoiseSamplingConfig;
import net.minecraft.world.gen.chunk.SlideConfig;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.noise.SimpleNoiseRouter;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import java.util.Arrays;
>>>>>>> a6dbbb5 (Cleanup of world gen)
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
	public static final OddBlocksTier1 ODD_DIORITE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.0f, 20.0f).requiresTool(), 14);
	public static final OddBlocksTier1 ODD_ANDESITE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.0f, 20.0f).requiresTool(), 14);
	public static final OddBlocksTier1 ODD_GRANITE = new OddBlocksTier1(FabricBlockSettings.of(Material.STONE).strength(2.0f, 20.0f).requiresTool(), 14);
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

<<<<<<< HEAD
=======
	private static final Biome OBSILAND = createObsiland();
	public static final RegistryKey<Biome> OBSILAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("tutorial", "obsiland"));

	private static Biome createObsiland() {	 
		return OverworldBiomeCreator.createNormalOcean(true);
	}
	

	private static final GeneratorType ABYSS = new GeneratorType("abyss") {
		protected ChunkGenerator getChunkGenerator(DynamicRegistryManager registryManager, long seed) {
			Registry<Biome> registry = registryManager.get(Registry.BIOME_KEY);
        	Registry<StructureSet> registry2 = registryManager.get(Registry.STRUCTURE_SET_KEY);
        	Registry<DoublePerlinNoiseSampler.NoiseParameters> registry3 = registryManager.get(Registry.NOISE_WORLDGEN);
			Registry<ChunkGeneratorSettings> registry4 = registryManager.get(Registry.CHUNK_GENERATOR_SETTINGS_KEY);
		
			return new NoiseChunkGenerator(registry2, registry3, (BiomeSource)new FixedBiomeSource(registry.getOrCreateEntry(OBSILAND_KEY)), seed, registry4.getOrCreateEntry(THE_ABYSS));
		}
	};

	public static final RegistryKey<ChunkGeneratorSettings> THE_ABYSS = RegistryKey.of(Registry.CHUNK_GENERATOR_SETTINGS_KEY, new Identifier("the_abyss"));
	
	private static ConfiguredFeature<?, ?> OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature(OddBlocksFeature.ODD_DIRT, new DefaultFeatureConfig());
	private static ConfiguredFeature<?, ?> OVERWORLD_ODD_SPAWN_CONFIGURED_FEATURE = new ConfiguredFeature(OddBlocksFeature.ODD_SPAWN, new DefaultFeatureConfig());
	

 
	private static ChunkGeneratorSettings createTheAbyss(){
		GenerationShapeConfig gShapeConfig = GenerationShapeConfig.create(0, 256, new NoiseSamplingConfig(2.0, 1.0, 80.0, 160.0), new SlideConfig(-23.4375, 64, -46), new SlideConfig(-0.234375, 7, 1), 2, 1, VanillaTerrainParametersCreator.createEndParameters());
		SimpleNoiseRouter simpleNoiseRouter = new SimpleNoiseRouter(DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero());
		return new ChunkGeneratorSettings(gShapeConfig, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), simpleNoiseRouter, VanillaSurfaceRules.getEndStoneRule(), 0, true, false, false, true);
	}

	public static PlacedFeature OVERWORLD_ODD_SPAWN_PLACED_FEATURE = new PlacedFeature(
		RegistryEntry.of(OVERWORLD_ODD_SPAWN_CONFIGURED_FEATURE),
		Arrays.asList(
		  //RarityFilterPlacementModifier.of(1), 
		  PlacedFeatures.createCountExtraModifier(1, 0.01f, 0), 
		  SquarePlacementModifier.of(), 
		  HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(1))	
	));

  	public static PlacedFeature OVERWORLD_WOOL_ORE_PLACED_FEATURE = new PlacedFeature(
      RegistryEntry.of(OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE),
      Arrays.asList(
		RarityFilterPlacementModifier.of(100), 
		PlacedFeatures.createCountExtraModifier(1, 0.25f, 0), 
		SquarePlacementModifier.of(), 
		HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(200))
	));

>>>>>>> a6dbbb5 (Cleanup of world gen)
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
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_diorite_block"), ODD_DIORITE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_andesite_block"), ODD_ANDESITE);
		Registry.register(Registry.BLOCK, new Identifier("oddblocks", "odd_granite_block"), ODD_GRANITE);
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
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_diorite_block"), new BlockItem(ODD_DIORITE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_andesite_block"), new BlockItem(ODD_ANDESITE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("oddblocks", "odd_granite_block"), new BlockItem(ODD_GRANITE, new FabricItemSettings().group(ItemGroup.MISC)));
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
	
		//Features ass the OddBlocks to the world in various ways
		OddSpawnFeature.registerFeature();
		OddDirtFeature.registerFeature();

<<<<<<< HEAD
		//These 3 methods control world generations
		AbyssChunkGeneratorSettings.registerSettings();
		AbyssBiome.registerBiome();		
		AbyssGeneratorType.registerGeneratorType();
			
=======
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("oddblocks", "oddblocks_spawn"), OVERWORLD_ODD_SPAWN_CONFIGURED_FEATURE);
    	Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("oddblocks", "oddblocks_spawn"), OVERWORLD_ODD_SPAWN_PLACED_FEATURE);

		Registry.register(BuiltinRegistries.BIOME, OBSILAND_KEY.getValue(), OBSILAND);

		Registry.register(BuiltinRegistries.CHUNK_GENERATOR_SETTINGS, new Identifier("the_abyss"), createTheAbyss());
		
		GeneratorTypeAccessorMixin.getValues().add(ABYSS);

		BiomeModifications.addFeature(BiomeSelectors.includeByKey(OBSILAND_KEY), GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("tutorial", "overworld_wool_ore")));
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(OBSILAND_KEY), GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("oddblocks", "oddblocks_spawn")));
>>>>>>> a6dbbb5 (Cleanup of world gen)
	}
}
