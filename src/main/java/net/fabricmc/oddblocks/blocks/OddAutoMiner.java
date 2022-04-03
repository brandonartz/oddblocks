package net.fabricmc.oddblocks.blocks;

import java.util.Random;
import javax.annotation.Nullable;
import net.fabricmc.oddblocks.OddBlocksMod;
import net.fabricmc.oddblocks.block_entity.OddAutoMinerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public abstract class OddAutoMiner extends BlockWithEntity {
    public OddAutoMiner(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OddAutoMinerBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }

    // @Override
    // @Nullable
    // public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    //     return OddAutoMiner.checkType(world, type, OddBlocksMod.AUTO_MINER_BLOCK_ENTITY);
    // }

    // @Nullable
    // protected static <T extends BlockEntity> BlockEntityTicker<T> checkType(World world, BlockEntityType<T> givenType, BlockEntityType<? extends OddAutoMinerBlockEntity> expectedType) {
    //     return world.isClient ? null : checkType(givenType, expectedType, OddAutoMinerBlockEntity::tick);
    // }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.createAndScheduleBlockTick(pos, this, 40);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Block placedBlock = world.getBlockState(pos.add(0, -1, 0)).getBlock();
        BlockState placedBlockState = world.getBlockState(pos.add(0, -1, 0));
       
        doMine(world, placedBlock, placedBlockState, pos.add(0, -1, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0f, 0f, 0.9f, 1f, 0.9f);
    }

    public abstract void doMine(ServerWorld world, Block targetBlock, BlockState targetBlockState, BlockPos pos);

    public void scheduleNextMine(ServerWorld world, BlockPos pos, int ticks){
        world.createAndScheduleBlockTick(pos.add(0, 1, 0), this, ticks);
    }
}
