package net.fabricmc.oddblocks.world.gen.feature;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.oddblocks.OddBlocksMod;
import net.fabricmc.oddblocks.world.biome.AbyssBiome;
import net.minecraft.block.Block;
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

public class OddBlocksTier1Feature extends Feature<DefaultFeatureConfig> {
    public static final Feature<DefaultFeatureConfig> ODD_TIER1 = Registry.register(Registry.FEATURE, "odd_tier1", new OddBlocksTier1Feature(DefaultFeatureConfig.CODEC));  
    
    public OddBlocksTier1Feature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public static void registerFeature(){  
        ConfiguredFeature<?, ?> OVERWORLD_ODD_CONFIGURED_FEATURE = new ConfiguredFeature(ODD_TIER1, new DefaultFeatureConfig());
        PlacedFeature OVERWORLD_ODD_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_ODD_CONFIGURED_FEATURE),
            Arrays.asList(
              RarityFilterPlacementModifier.of(100), 
              PlacedFeatures.createCountExtraModifier(1, 0.25f, 0), 
              SquarePlacementModifier.of(), 
              HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(200))
            )
        );

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("oddblocks", "odd_tier1"), OVERWORLD_ODD_CONFIGURED_FEATURE);
    	Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("oddblocks", "odd_tier1"), OVERWORLD_ODD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(AbyssBiome.ABYSS_KEY), GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("oddblocks", "odd_tier1")));
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        
        Random random = new Random();
        Optional<Block> optional = Registry.BLOCK.getEntryList(OddBlocksMod.ODDBLOCKS_TIER1).flatMap(blocks -> blocks.getRandom(random)).map(RegistryEntry::value);
        if (optional.isEmpty()) {
            return false;
        }
        
        OddBlocksMod.LOGGER.info("MAKING: " + optional.get().toString());
        this.setBlockState(structureWorldAccess, blockPos.add(0,0,0), optional.get().getDefaultState());
     
        return true;
    }
}
