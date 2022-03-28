package net.fabricmc.oddblocks.world.gen.feature;

import com.mojang.serialization.Codec;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class OddSpawnFeature extends Feature<DefaultFeatureConfig> {
    private static final BlockPos START_BLOCK = new BlockPos(8, 3, 8);
    private static final ChunkPos START_CHUNK = new ChunkPos(START_BLOCK);
    
    public OddSpawnFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
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
