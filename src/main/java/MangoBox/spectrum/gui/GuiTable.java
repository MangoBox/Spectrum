package MangoBox.spectrum.gui;

import MangoBox.spectrum.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiTable extends GuiScreen{
	private int x, y, z;
	private EntityPlayer player;
	private World world;
	private int xSize, ySize;
	private ResourceLocation backgroundimage = new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/client/gui/GuiTable.png");
	
	
	public GuiTable(EntityPlayer player, World world, int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.player = player;
		this.world = world;
		xSize = 176;
		ySize = 214;
		
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTicks) {
		this.mc.getTextureManager().bindTexture(backgroundimage);
		int x = (this.width - xSize) / 2;
		int y = (this.height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
