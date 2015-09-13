package net.bloop.unnamed;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.bloop.unnamed.block.BlockRegistry;
import net.bloop.unnamed.craft.CraftingRegistry;
import net.bloop.unnamed.gui.GuiHandler;

@Mod(modid = "unnamed", version = "0.1")
public class UnnamedMod
{
    @Mod.Instance
    public static UnnamedMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockRegistry.registerThings();
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
