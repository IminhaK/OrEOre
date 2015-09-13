package net.bloop.unnamed.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.bloop.unnamed.tile.TileEntityOrEOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Bloop on 9/12/2015.
 */
public class GuiHandler implements IGuiHandler{

    @Override
    public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z){
        if(ID == 0)
            return new GUIOrEOre(player.inventory, (TileEntityOrEOre)world.getTileEntity(x, y, z));
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        if(ID == 0)
            return new ContainerOrEOre(player.inventory, (TileEntityOrEOre)world.getTileEntity(x, y, z));
        return null;
    }
}
