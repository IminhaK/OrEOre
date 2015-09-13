package net.bloop.unnamed.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by Bloop on 9/13/2015.
 */
public class ItemRegistry {

    public static itemOreCatalyst orecatalyst;

    public static void oreThings(){
        orecatalyst = new itemOreCatalyst();
        GameRegistry.registerItem(orecatalyst, "orecatalyst");
    }
}
