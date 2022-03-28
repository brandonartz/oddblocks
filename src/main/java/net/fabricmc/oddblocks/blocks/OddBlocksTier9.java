package net.fabricmc.oddblocks.blocks;

import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

@Mixin(Block.class)
public class OddBlocksTier9 extends Block {

    public static final IntProperty LIMIT = IntProperty.of("limit", 0, 2);
    
    public OddBlocksTier9(Settings settings, int max) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LIMIT, max));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIMIT);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.get(LIMIT) != -1 && state.get(LIMIT) >= 0) {
            world.setBlockState(pos, state.with(LIMIT, state.get(LIMIT) - 1), Block.NOTIFY_ALL);
        } else if (state.get(LIMIT) == -1) {
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
    }
}