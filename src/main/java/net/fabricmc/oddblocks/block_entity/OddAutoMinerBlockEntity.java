package net.fabricmc.oddblocks.block_entity;

import javax.annotation.Nullable;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.fabricmc.oddblocks.blocks.OddAutoMiner;
import net.fabricmc.oddblocks.blocks.OddBlocksTier1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock.AbstractBlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry.Type;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class OddAutoMinerBlockEntity extends BlockEntity {
    private int fuel = 0;
    private int ticks = 0;


    public OddAutoMinerBlockEntity(BlockPos pos, BlockState state) {
        super(OddBlocksMod.AUTO_MINER_BLOCK_ENTITY, pos, state);
    }

    // Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        // Save the current value of the number to the tag
        tag.putInt("fuel", fuel);
 
        super.writeNbt(tag);
    }   

    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
    
        fuel = tag.getInt("fuel");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
      return BlockEntityUpdateS2CPacket.create(this);
    }
   
    @Override
    public NbtCompound toInitialChunkDataNbt() {
      return createNbt();
    }

    public static void tick(World world, BlockPos pos, BlockState state, OddAutoMinerBlockEntity blockEntity) {
        
    }
}
