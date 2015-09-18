package net.bloop.oreore.item;

import net.bloop.oreore.OrEOreMod;
import net.minecraft.item.Item;

/**
 * Created by Bloop on 9/13/2015.
 */
public class itemOreCatalyst extends Item {

    public itemOreCatalyst(){
        this.setMaxDamage(0);
        this.setUnlocalizedName("orecatalyst");
        this.setCreativeTab(OrEOreMod.tab);
        this.setTextureName("oreore:orecatalyst");
    }
}
