package net.fabricmc.oddblocks.world.gen.feature;

import com.mojang.serialization.Codec;
import java.util.Random;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class OddDirtFeature extends Feature<DefaultFeatureConfig> {
    public OddDirtFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        this.setBlockState(structureWorldAccess, blockPos.add(0,0,0), OddBlocksMod.ODD_DIRT.getDefaultState());
        // Random random = context.getRandom();
        // BlockPos blockPos = context.getOrigin();
        // float f = (float)random.nextInt(3) + 4.0f;
        // //int i = 0;
        // while (f > 0.5f) {
        //     int j = MathHelper.floor(-f);
        //     int k = MathHelper.floor(-f);
        //     int i = MathHelper.floor(-f);
        //     this.setBlockState(structureWorldAccess, blockPos.add(j, i, k), OddBlocksMod.ODD_DIRT.getDefaultState());

        //     // for (int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
        //     //     // for (int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
        //     //     //     if (!((float)(j * j + k * k) <= (f + 1.0f) * (f + 1.0f))) continue;
        //     //     //     this.setBlockState(structureWorldAccess, blockPos.add(j, i, k), OddBlocksMod.ODD_DIRT.getDefaultState());
        //     //     // }
        //     // }
        //     f -= (float)random.nextInt(2) + 0.5f;
        //     //--i;
        // }
        return true;
    }
}
