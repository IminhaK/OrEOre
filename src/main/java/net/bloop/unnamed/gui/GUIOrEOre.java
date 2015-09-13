package net.bloop.unnamed.gui;

import net.bloop.unnamed.tile.TileEntityOrEOre;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by Bloop on 9/12/2015.
 */
public class GUIOrEOre extends GuiContainer {

    private static final ResourceLocation tex = new ResourceLocation("oreore:textures/gui/oreoregui.png");
    private TileEntityOrEOre oreore;

    public GUIOrEOre(InventoryPlayer player, TileEntityOrEOre machine)
    {
        super(new ContainerOrEOre(player, machine));
        oreore = machine;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        //this.fontRendererObj.drawString(StatCollector.translateToLocal("container.oreore"), 28, 6, 4210752);
       // this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        String s = StatCollector.translateToLocal("container.oreore");
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex);
        int foo = (this.width - this.xSize) / 2;
        int bar = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(foo, bar, 0, 0, this.xSize, this.ySize);
    }
}
