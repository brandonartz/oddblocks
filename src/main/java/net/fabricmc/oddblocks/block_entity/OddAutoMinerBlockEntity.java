package net.fabricmc.oddblocks.block_entity;

import java.util.Map;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.fabricmc.oddblocks.OddBlocksMod;
import net.fabricmc.oddblocks.screen_handlers.OddAutoMinerScreenHandler;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class OddAutoMinerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal;
	  public boolean isBurning;
	  public boolean lastTickBurning;
    public boolean isOnValidGround;
	  ItemStack burnItem;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    
    public OddAutoMinerBlockEntity(BlockPos pos, BlockState state) {
        super(OddBlocksMod.AUTO_MINER_BLOCK_ENTITY, pos, state);
    } 

    //From the ImplementedInventory Interface

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
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

    //These Methods are from the NamedScreenHandlerFactory Interface
    //createMenu creates the ScreenHandler itself
    //getDisplayName will Provide its name which is normally shown at the top
 
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        //We provide *this* to the screenHandler as our class Implements Inventory
        //Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
        return new OddAutoMinerScreenHandler(syncId, playerInventory, this);
    }
 
    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
 
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
        this.burnTime = nbt.getShort("BurnTime");
        this.cookTime = nbt.getShort("CookTime");
        this.cookTimeTotal = nbt.getShort("CookTimeTotal");
        this.fuelTime = this.getFuelTime(this.inventory.get(1));
    }
 
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putShort("BurnTime", (short)this.burnTime);
        nbt.putShort("CookTime", (short)this.cookTime);
        nbt.putShort("CookTimeTotal", (short)this.cookTimeTotal);
        Inventories.writeNbt(nbt, this.inventory);
    }

    //Fuel consumption
    
    public static void tick(World world, BlockPos pos, BlockState state, OddAutoMinerBlockEntity blockEntity) {
      //super.tick(world, pos, state, blockEntity);
      if (world == null || world.isClient){
        return;
      }

      boolean bl = blockEntity.isBurning();
      boolean bl2 = false;
      if (blockEntity.isBurning()) {
          --blockEntity.burnTime;
      }
      ItemStack itemStack = blockEntity.inventory.get(0);
      //Probably should also check to make sure it's on valid ground here
      if (blockEntity.isBurning() || !itemStack.isEmpty()) {
        int i = blockEntity.getMaxCountPerStack();
        if (!blockEntity.isBurning()) {
            blockEntity.fuelTime = blockEntity.burnTime = blockEntity.getFuelTime(itemStack);
            if (blockEntity.isBurning()) {
                bl2 = true;
                if (!itemStack.isEmpty()) {
                    Item item = itemStack.getItem();
                    itemStack.decrement(1);
                    if (itemStack.isEmpty()) {
                        Item item2 = item.getRecipeRemainder();
                        blockEntity.inventory.set(1, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                    }
                }
            }
        }
        if (blockEntity.isBurning()) {
            ++blockEntity.cookTime;
            if (blockEntity.cookTime == blockEntity.cookTimeTotal) {
                blockEntity.cookTime = 0;
                blockEntity.cookTimeTotal = 200; //AbstractFurnaceBlockEntity.getCookTime(world, blockEntity.recipeType, blockEntity);
                bl2 = true;
            }
        } else {
            blockEntity.cookTime = 0;
        }
    } else if (!blockEntity.isBurning() && blockEntity.cookTime > 0) {
        blockEntity.cookTime = MathHelper.clamp(blockEntity.cookTime - 2, 0, blockEntity.cookTimeTotal);
    }
    if (bl != blockEntity.isBurning()) {
        bl2 = true;
        //state = (BlockState)state.with(AbstractFurnaceBlock.LIT, blockEntity.isBurning());
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
    }
    if (bl2) {
        AbstractFurnaceBlockEntity.markDirty(world, pos, state);
    }
  }

  public static int getItemBurnTime(@NotNull ItemStack stack) {
    if (stack.isEmpty()) {
      return 0;
    }
    Map<Item, Integer> burnMap = AbstractFurnaceBlockEntity.createFuelTimeMap();
    if (burnMap.containsKey(stack.getItem())) {
      return burnMap.get(stack.getItem()) / 4;
    }
    return 0;
  }

  public boolean isBurning() {
    return this.burnTime > 0;
  }

  protected int getFuelTime(ItemStack fuel) {
    if (fuel.isEmpty()) {
        return 0;
    }
    Item item = fuel.getItem();
    return AbstractFurnaceBlockEntity.createFuelTimeMap().getOrDefault(item, 0);
  }

  public static boolean canUseAsFuel(ItemStack stack) {
      return AbstractFurnaceBlockEntity.createFuelTimeMap().containsKey(stack.getItem());
  }
}
