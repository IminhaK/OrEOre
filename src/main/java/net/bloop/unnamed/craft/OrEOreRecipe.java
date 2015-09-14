package net.bloop.unnamed.craft;

import net.minecraft.item.ItemStack;

/**
 * Created by Bloop on 9/13/2015.
 */
public class OrEOreRecipe {

    private ItemStack product;
    private int cost;
    private ItemStack input;
    private boolean specific;

    public OrEOreRecipe(ItemStack output, int amount, ItemStack ingredient, boolean exact){
        product = output;
        cost = amount;
        input = ingredient;
        specific = exact;
    }

    public OrEOreRecipe(ItemStack output, int amount, ItemStack ingredient){
        this(output, amount, ingredient, false);
    }

    public ItemStack getOutput(){
        return product.copy();
    }

    public int getCost(){
        return cost;
    }

    public boolean validInput(ItemStack ingredient){
        return ingredient.isItemEqual(input);
    }

    public String getIngredientName(){
        return input.getDisplayName();
    }

    public Object getIngredient(){
        return input;
    }
}
