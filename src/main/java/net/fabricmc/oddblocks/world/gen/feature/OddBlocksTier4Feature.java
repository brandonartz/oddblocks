package net.fabricmc.oddblocks.world.gen.feature;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
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

public class OddBlocksTier4Feature extends Feature<DefaultFeatureConfig> {
    private static final BlockPos START_BLOCK = new BlockPos(0, 68, 0);
    private static String identifier = "odd_tier4"; 
    
    public OddBlocksTier4Feature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public static void registerFeature(){  
        Feature<DefaultFeatureConfig> ODD_FEATURE = Registry.register(Registry.FEATURE, identifier, new OddBlocksTier4Feature(DefaultFeatureConfig.CODEC));  
        ConfiguredFeature<?, ?> OVERWORLD_ODD_CONFIGURED_FEATURE = new ConfiguredFeature(ODD_FEATURE, new DefaultFeatureConfig());
        PlacedFeature OVERWORLD_ODD_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_ODD_CONFIGURED_FEATURE),
            Arrays.asList(
              RarityFilterPlacementModifier.of(100), 
              PlacedFeatures.createCountExtraModifier(1, 0.25f, 0), 
              SquarePlacementModifier.of(), 
              HeightRangePlacementModifier.uniform(YOffset.fixed(68), YOffset.fixed(108))
            )
        );

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("oddblocks", identifier), OVERWORLD_ODD_CONFIGURED_FEATURE);
    	Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("oddblocks", identifier), OVERWORLD_ODD_PLACED_FEATURE);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        
        if(blockPos.isWithinDistance(START_BLOCK, 400)){
            return true;
        }

        Random random = new Random();
        Optional<Block> optional = Registry.BLOCK.getEntryList(OddBlocksMod.ODDBLOCKS_TIER4).flatMap(blocks -> blocks.getRandom(random)).map(RegistryEntry::value);
        if (optional.isEmpty()) {
            return false;
        }
        
        OddBlocksMod.LOGGER.info("MAKING: " + optional.get().toString());
        this.setBlockState(structureWorldAccess, blockPos.add(0,0,0), optional.get().getDefaultState());
     
        return true;
    }
}
