package net.fabricmc.oddblocks.blocks;

import org.spongepowered.asm.mixin.Mixin;

//import net.fabricmc.oddblocks.block_entity.OddBlockEntity;
//import org.spongepowered.asm.mixin.Overwrite;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

@Mixin(Block.class)
public class OddBlocksTier2 extends Block { //implements BlockEntityProvider {
    private int limit = 200;

    public OddBlocksTier2(Settings settings) {
        super(settings);
    }

    // @Override
    // public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    //     return new OddBlockEntity(pos, state, limit);
    // }

    // @Override
    // public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
    //     world.setBlockState(pos, state, Block.NOTIFY_ALL);
    // }
}