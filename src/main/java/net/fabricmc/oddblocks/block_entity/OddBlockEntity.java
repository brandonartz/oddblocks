// package net.fabricmc.oddblocks.block_entity;

// import javax.annotation.Nullable;

// import net.fabricmc.oddblocks.OddBlocksMod;
// import net.minecraft.block.BlockState;
// import net.minecraft.block.entity.BlockEntity;
// import net.minecraft.nbt.NbtCompound;
// import net.minecraft.network.Packet;
// import net.minecraft.network.listener.ClientPlayPacketListener;
// import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
// import net.minecraft.util.math.BlockPos;

// public class OddBlockEntity extends BlockEntity {
//     int _limit = 200;
    
//     public OddBlockEntity(BlockPos pos, BlockState state, int limit) {
//         super(OddBlocksMod.ODD_BLOCK_ENTITY, pos, state);
//         _limit = limit;
//     }

//     @Override
//     public void writeNbt(NbtCompound tag) {
//         // Save the current value of the number to the tag
//         tag.putInt("limit", _limit);
//         super.writeNbt(tag);
//     }

//     @Override
//     public void readNbt(NbtCompound tag) {
//         super.readNbt(tag);  
//         _limit = tag.getInt("limit");
//     }
    
//     @Nullable
//     @Override
//     public Packet<ClientPlayPacketListener> toUpdatePacket() {
//       return BlockEntityUpdateS2CPacket.create(this);
//     }
   
//     @Override
//     public NbtCompound toInitialChunkDataNbt() {
//       return createNbt();
//     }
// }
