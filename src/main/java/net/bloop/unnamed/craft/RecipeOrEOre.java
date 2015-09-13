package net.bloop.unnamed.craft;

import fox.spiteful.avaritia.items.ItemFracturedOre;
import fox.spiteful.avaritia.items.LudicrousItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bloop on 9/13/2015.
 */
public class RecipeOrEOre {

    private static final RecipeOrEOre oreoreBase = new RecipeOrEOre();

    private Map oreoreList = new HashMap();

    public static final RecipeOrEOre oring(){
        return oreoreBase;
    }

    private RecipeOrEOre(){
        //addOring(new ItemStack(Blocks.iron_ore, 1), ((ItemFracturedOre)(LudicrousItems.fractured_ore)).getStackForOre(new ItemStack(Blocks.iron_ore), 1));
    }

    public void addOring(ItemStack input, ItemStack output){
        oreoreList.put(input, output);
    }

    public ItemStack getOringResult(ItemStack item){
        return (ItemStack)oreoreList.get(item);
    }

    public Map getOreoreList(){
        return oreoreList;
    }
}
