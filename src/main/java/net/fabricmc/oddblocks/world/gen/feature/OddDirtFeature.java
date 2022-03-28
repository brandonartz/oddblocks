package net.fabricmc.oddblocks.world.gen.feature;

import java.util.Arrays;

import com.mojang.serialization.Codec;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.oddblocks.OddBlocksMod;
import net.fabricmc.oddblocks.world.biome.AbyssBiome;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
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
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.GenerationStep;

public class OddDirtFeature extends Feature<DefaultFeatureConfig> {
    private static final BlockPos START_BLOCK = new BlockPos(8, 3, 8);
        
    public static void registerFeature(){  
        ConfiguredFeature<?, ?> OVERWORLD_ODD_DIRT_CONFIGURED_FEATURE = new ConfiguredFeature(OddBlocksFeature.ODD_DIRT, new DefaultFeatureConfig());
        PlacedFeature OVERWORLD_ODD_DIRT_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_ODD_DIRT_CONFIGURED_FEATURE),
            Arrays.asList(
              RarityFilterPlacementModifier.of(100), 
              PlacedFeatures.createCountExtraModifier(1, 0.25f, 0), 
              SquarePlacementModifier.of(), 
              HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(200))
            )
        );

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("oddblocks", "odd_dirt"), OVERWORLD_ODD_DIRT_CONFIGURED_FEATURE);
    	Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("oddblocks", "odd_dirt"), OVERWORLD_ODD_DIRT_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(AbyssBiome.ABYSS_KEY), GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("oddblocks", "odd_dirt")));
    }

    public OddDirtFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
                       
        if(blockPos.isWithinDistance(START_BLOCK, 100)){
            OddBlocksMod.LOGGER.info("Position is within 100 blocks of spawn");
        }else{
            OddBlocksMod.LOGGER.info("Position is NOT within 100 blocks of spawn");
        }
        
        this.setBlockState(structureWorldAccess, blockPos.add(0,0,0), OddBlocksMod.ODD_DIRT.getDefaultState());
     
        return true;
    }
}
