package net.fabricmc.oddblocks.blocks;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

@Mixin(Block.class)
public class OddBlocksTier3 extends Block {

    public OddBlocksTier3(Settings settings) {
        super(settings);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
    }
}