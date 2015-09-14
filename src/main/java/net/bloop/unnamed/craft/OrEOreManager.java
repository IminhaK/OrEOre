package net.bloop.unnamed.craft;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by Bloop on 9/13/2015.
 */
public class OrEOreManager {

    private static ArrayList<OrEOreRecipe> recipes = new ArrayList<OrEOreRecipe>();

    public static void addRecipe(ItemStack output, int amount, ItemStack input){
        recipes.add(new OrEOreRecipe(output, amount, input));
    }

    public static void addOreRecipe(ItemStack output, int amount, String ore){
        recipes.add(new OrEOreOreRecipe(output, amount, ore));
    }

    public static ItemStack getOutput(ItemStack input){
        for(OrEOreRecipe recipe : recipes){
            if(recipe.validInput(input))
                return recipe.getOutput();
        }
        return null;
    }

    public static int getCost(ItemStack input){
        if(input == null)
            return 0;

        for(OrEOreRecipe recipe : recipes){
            if(recipe.validInput(input))
                return recipe.getCost();
        }
        return 0;
    }

    public static int getPrice(ItemStack output){
        if(output == null)
            return 0;

        for(OrEOreRecipe recipe : recipes){
            if(recipe.getOutput().isItemEqual(output))
                return recipe.getCost();
        }
        return 0;
    }

    public static String getName(ItemStack input){
        for(OrEOreRecipe recipe : recipes){
            if(recipe.validInput(input))
                return recipe.getIngredientName();
        }
        return null;
    }

    public static ArrayList<OrEOreRecipe> getRecipes(){
        return recipes;
    }
}
