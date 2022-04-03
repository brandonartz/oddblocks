package net.fabricmc.oddblocks.blocks;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public final class OddBlocksMinerMK1 extends OddAutoMiner {

    public OddBlocksMinerMK1(Settings settings) {
        super(settings);
    }

    @Override
    public void doMine(ServerWorld world, Block targetBlock, BlockState targetBlockState, BlockPos targetPos) {
        if(targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER1)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T1 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            scheduleNextMine(world, targetPos, 40);    
        }
    }
}
