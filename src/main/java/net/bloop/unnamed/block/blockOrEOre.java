package net.bloop.unnamed.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.Avaritia;
import net.bloop.unnamed.OrEOreMod;
import net.bloop.unnamed.tile.TileEntityOrEOre;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Bloop on 9/12/2015.
 */
public class blockOrEOre extends BlockContainer {

    private static IIcon top, sides, bottom;

    public blockOrEOre() {
        super(Material.iron);
        setStepSound(Block.soundTypeGlass);
        setHardness(50.0F);
        setResistance(2000.0F);
        setBlockName("ore_ore");
        setHarvestLevel("pickaxe", 3);
        setCreativeTab(OrEOreMod.tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        sides = iconRegister.registerIcon("oreore:oreore");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int metadata)
    {
        return sides;
    }

    @Override
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(world.isRemote)
        {
            return true;
        }
        else
        {
            player.openGui(OrEOreMod.instance, 0, world, x, y, z);
            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityOrEOre();
    }
}
