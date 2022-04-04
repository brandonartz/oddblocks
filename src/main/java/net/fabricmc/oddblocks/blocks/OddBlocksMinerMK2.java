package net.fabricmc.oddblocks.blocks;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public final class OddBlocksMinerMK2 extends OddAutoMiner {

    public OddBlocksMinerMK2(Settings settings) {
        super(settings);
    }

    @Override
    public int doMine(ServerWorld world, Block targetBlock, BlockState targetBlockState, BlockPos targetPos) {
        if(targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER1)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T1 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            return 30; 
        }
        else if (targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER2)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T2 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            return 50;   
        }
        else if (targetBlockState.isIn(OddBlocksMod.ODDBLOCKS_TIER3)){
            OddBlocksMod.LOGGER.info("AUTO MINER IS ON T3 Block!");
            world.breakBlock(targetPos, true);
            targetBlock.onBroken(world, targetPos, targetBlockState);

            return 70;  
        }
        else{
            //Not on valid block
            return 0;
        }
    }
}
