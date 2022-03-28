package net.fabricmc.oddblocks.world;

import net.fabricmc.oddblocks.mixin.GeneratorTypeAccessorMixin;
import net.fabricmc.oddblocks.world.biome.AbyssBiome;
import net.fabricmc.oddblocks.world.gen.chunk.AbyssChunkGeneratorSettings;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

public class AbyssGeneratorType{
  private static final GeneratorType ABYSS_GENERATOR_TYPE = new GeneratorType("abyss") {
		protected ChunkGenerator getChunkGenerator(DynamicRegistryManager registryManager, long seed) {
		  Registry<Biome> registry = registryManager.get(Registry.BIOME_KEY);
      Registry<StructureSet> registry2 = registryManager.get(Registry.STRUCTURE_SET_KEY);
      Registry<DoublePerlinNoiseSampler.NoiseParameters> registry3 = registryManager.get(Registry.NOISE_WORLDGEN);
			Registry<ChunkGeneratorSettings> registry4 = registryManager.get(Registry.CHUNK_GENERATOR_SETTINGS_KEY);
		
			return new NoiseChunkGenerator(registry2, registry3, (BiomeSource)new FixedBiomeSource(registry.getOrCreateEntry(AbyssBiome.ABYSS_KEY)), seed, registry4.getOrCreateEntry(AbyssChunkGeneratorSettings.ABYSS_CHUNK_GENERATOR_SETTINGS));
		}
	};

  public static void registerGeneratorType(){
    //Add "The Abyss" to list of generation otions available
		GeneratorTypeAccessorMixin.getValues().add(ABYSS_GENERATOR_TYPE);	
  }
}