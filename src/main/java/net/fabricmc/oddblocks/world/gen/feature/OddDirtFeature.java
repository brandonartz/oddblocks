package net.fabricmc.oddblocks.world.gen.feature;

import com.mojang.serialization.Codec;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class OddDirtFeature extends Feature<DefaultFeatureConfig> {
    private static final BlockPos START_BLOCK = new BlockPos(8, 3, 8);
    
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
