package net.fabricmc.oddblocks.blocks;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;

import net.fabricmc.fabric.mixin.object.builder.AbstractBlockAccessor;
import net.fabricmc.oddblocks.OddBlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

@Mixin(Block.class)
public class OddBlocksTier1 extends Block {
        
    public OddBlocksTier1(Settings settings) {
        super(settings);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        OddBlocksMod.LOGGER.info("On Broken Called");
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
    }
}