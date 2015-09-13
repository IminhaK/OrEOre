package net.bloop.unnamed.gui;

import net.bloop.unnamed.block.BlockRegistry;
import net.bloop.unnamed.tile.TileEntityOrEOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Bloop on 9/12/2015.
 */
public class ContainerOrEOre extends Container {

    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerOrEOre(InventoryPlayer player, World world, int x, int y, int z, TileEntityOrEOre table)
    {

    }

    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotNumber);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotNumber == 0)
            {
                if (!this.mergeItemStack(itemstack1, 82, 118, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotNumber >= 82 && slotNumber < 109)
            {
                if (!this.mergeItemStack(itemstack1, 109, 118, false))
                {
                    return null;
                }
            }
            else if (slotNumber >= 109 && slotNumber < 118)
            {
                if (!this.mergeItemStack(itemstack1, 82, 109, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 82, 118, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
