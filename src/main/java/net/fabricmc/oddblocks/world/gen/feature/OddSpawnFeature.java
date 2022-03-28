package net.fabricmc.oddblocks.world.gen.feature;

import java.util.Arrays;

import com.mojang.serialization.Codec;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.oddblocks.OddBlocksMod;
import net.fabricmc.oddblocks.world.biome.AbyssBiome;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.GenerationStep;

public class OddSpawnFeature extends Feature<DefaultFeatureConfig> {
    private static final BlockPos START_BLOCK = new BlockPos(8, 3, 8);
    private static final ChunkPos START_CHUNK = new ChunkPos(START_BLOCK);
    
    public OddSpawnFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public static void registerFeature(){
        ConfiguredFeature<?, ?> OVERWORLD_ODD_SPAWN_CONFIGURED_FEATURE = new ConfiguredFeature(OddBlocksFeature.ODD_SPAWN, new DefaultFeatureConfig());
        PlacedFeature OVERWORLD_ODD_SPAWN_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_ODD_SPAWN_CONFIGURED_FEATURE),
            Arrays.asList(
              PlacedFeatures.createCountExtraModifier(1, 0.01f, 0), 
              SquarePlacementModifier.of(), 
              HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(1))	
            )
        );

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("oddblocks", "oddblocks_spawn"), OVERWORLD_ODD_SPAWN_CONFIGURED_FEATURE);
    	Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("oddblocks", "oddblocks_spawn"), OVERWORLD_ODD_SPAWN_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(AbyssBiome.ABYSS_KEY), GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("oddblocks", "oddblocks_spawn")));
    }

    private static int getDistance(int x1, int z1, int x2, int z2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(z1 - z2));
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {      
        ChunkPos chunkPos = new ChunkPos(context.getOrigin());
        int chunkDistance = OddSpawnFeature.getDistance(chunkPos.x, chunkPos.z, OddSpawnFeature.START_CHUNK.x, OddSpawnFeature.START_CHUNK.z);
        if (chunkDistance > 0) {
            return true;
        }
        else
        {
            OddBlocksMod.LOGGER.info("MAKING SPAWN BLOCK");
            StructureWorldAccess structureWorldAccess = context.getWorld();
            this.setBlockState(structureWorldAccess, START_BLOCK, OddBlocksMod.ODD_DIRT.getDefaultState());
            return true;
        }
    }
}
