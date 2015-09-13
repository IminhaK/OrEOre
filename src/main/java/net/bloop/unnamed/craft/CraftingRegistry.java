package net.bloop.unnamed.craft;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.Config;
import fox.spiteful.avaritia.blocks.LudicrousBlocks;
import fox.spiteful.avaritia.compat.Compat;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import fox.spiteful.avaritia.crafting.ExtremeShapedRecipe;
import fox.spiteful.avaritia.items.LudicrousItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingRegistry {

   public static void nienbynien(){
       ExtremeCraftingManager.getInstance().addRecipe(new ItemStack(LudicrousItems.skull_sword, 1),
               "        a",
               "       a ",
               "      a  ",
               "     a   ",
               "    a    ",
               "   a     ",
               "  a      ",
               " a       ",
               "a        ",
               'a', new ItemStack(Items.apple, 1));
   }
}
