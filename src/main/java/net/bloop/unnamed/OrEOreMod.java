package net.bloop.unnamed;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import fox.spiteful.avaritia.items.ItemFracturedOre;
import fox.spiteful.avaritia.items.LudicrousItems;
import net.bloop.unnamed.block.BlockRegistry;
import net.bloop.unnamed.craft.CraftingRegistry;
import net.bloop.unnamed.gui.GuiHandler;
import net.bloop.unnamed.item.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "unnamed", version = "0.1")
public class OrEOreMod
{
    @Mod.Instance
    public static OrEOreMod instance;

    public static CreativeTabs tab = new CreativeTabs("oreore")
    {
        @Override
        public Item getTabIconItem() {
            return ItemRegistry.orecatalyst;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockRegistry.registerThings();
        ItemRegistry.oreThings();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        CraftingRegistry.nienbynien();
    }
}
