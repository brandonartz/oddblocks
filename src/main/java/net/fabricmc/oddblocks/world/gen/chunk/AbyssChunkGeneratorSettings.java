package net.fabricmc.oddblocks.world.gen.chunk;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.source.util.VanillaTerrainParametersCreator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.chunk.NoiseSamplingConfig;
import net.minecraft.world.gen.chunk.SlideConfig;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;
import net.minecraft.world.gen.noise.SimpleNoiseRouter;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;

public class AbyssChunkGeneratorSettings {
    public static final RegistryKey<ChunkGeneratorSettings> ABYSS_CHUNK_GENERATOR_SETTINGS = RegistryKey.of(Registry.CHUNK_GENERATOR_SETTINGS_KEY, new Identifier("the_abyss"));

    public static void registerSettings(){
        Registry.register(BuiltinRegistries.CHUNK_GENERATOR_SETTINGS, new Identifier("the_abyss"), getSettings());
	}

    private static ChunkGeneratorSettings getSettings(){
        GenerationShapeConfig gShapeConfig = GenerationShapeConfig.create(0, 256, new NoiseSamplingConfig(2.0, 1.0, 80.0, 160.0), new SlideConfig(-23.4375, 64, -46), new SlideConfig(-0.234375, 7, 1), 2, 1, VanillaTerrainParametersCreator.createEndParameters());
		SimpleNoiseRouter simpleNoiseRouter = new SimpleNoiseRouter(DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero(), DensityFunctionTypes.zero());
		return new ChunkGeneratorSettings(gShapeConfig, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), simpleNoiseRouter, VanillaSurfaceRules.getEndStoneRule(), 0, true, false, false, true);
    }
}
