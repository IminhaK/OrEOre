package net.bloop.oreore.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.bloop.oreore.tile.TileEntityOrEOre;
import net.minecraft.block.Block;

/**
 * Created by Bloop on 9/12/2015.
 */
public class BlockRegistry {

    public static Block blockOrEOre;

    public static void registerThings(){
        blockOrEOre = GameRegistry.registerBlock(new blockOrEOre(), "oreore");

        GameRegistry.registerTileEntity(TileEntityOrEOre.class, "oreore");
    }
}
