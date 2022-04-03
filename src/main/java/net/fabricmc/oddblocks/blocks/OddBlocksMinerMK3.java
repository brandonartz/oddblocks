package net.fabricmc.oddblocks.blocks;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public final class OddBlocksMinerMK3 extends OddAutoMiner {

    public OddBlocksMinerMK3(Settings settings) {
        super(settings);
    }

    @Override
    public void doMine(ServerWorld world, Block targetBlock, BlockState targetBlockState, BlockPos targetPos) {
        if(targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER1)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T1 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            scheduleNextMine(world, targetPos, 20); 
        }
        else if (targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER2)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T2 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            scheduleNextMine(world, targetPos, 30);   
        }
        else if (targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER3)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T3 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            scheduleNextMine(world, targetPos, 50); 
        }
        else if (targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER4)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T4 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            scheduleNextMine(world, targetPos, 70);  
        }
        else{
            OddBlocksMod.LOGGER.info("AUTO MINER IS NOT ON ANY VALID BLOCK!");
        }
    }
}
