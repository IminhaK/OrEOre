package net.bloop.unnamed.gui;

import net.bloop.unnamed.craft.RecipeOrEOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Bloop on 9/13/2015.
 */
public class SlotOrEOre extends Slot {

    private EntityPlayer player;
    private int field_75228_b;
    public SlotOrEOre(EntityPlayer par1EntityPlayer, IInventory par2IInventory, int par3, int par4, int par5){
        super(par2IInventory, par3, par4, par5);
        this.player = par1EntityPlayer;
    }

    public boolean isItemValid(ItemStack par1ItemStack){
        return false;
    }

    public ItemStack decrStackSize(int par1){
        if(this.getHasStack()){
            this.field_75228_b += Math.min(par1, this.getStack().stackSize);
        }
        return super.decrStackSize(par1);
    }
    //When an item is picked up from an inventory slot
    public void func_82870_a(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack){
        this.onCrafting(par2ItemStack);
        super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
    }

    protected void onCrafting(ItemStack par1ItemStack, int par2){
        this.field_75228_b += par2;
        this.onCrafting(par1ItemStack);
    }
}
