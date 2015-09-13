package net.bloop.unnamed.gui;

import net.bloop.unnamed.tile.TileEntityOrEOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Iterator;

/**
 * Created by Bloop on 9/12/2015.
 */
public class ContainerOrEOre extends Container {

    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
    private TileEntityOrEOre oreore;

    public ContainerOrEOre(InventoryPlayer player, TileEntityOrEOre machine)
    {
        this.oreore = machine;
        this.addSlotToContainer(new Slot(oreore, 0, 56, 27));
        this.addSlotToContainer(new SlotOrEOre(player.player, machine, 1, 116, 27));
        //this.addSlotToContainer(new SlotFurnace(player.player, machine, 1, 116, 27));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }



    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return this.oreore.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotNumber);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotNumber == 1)
            {
                if (!this.mergeItemStack(itemstack1, 2, 38, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotNumber != 0)
            {
                if (itemstack1 != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (slotNumber >= 3 && slotNumber < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 29, 38, false))
                    {
                        return null;
                    }
                }
                else if (slotNumber >= 29 && slotNumber < 38 && !this.mergeItemStack(itemstack1, 2, 29, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 2, 38, false))
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
