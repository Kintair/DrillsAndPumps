package com.kintair.drillsandpumps.proxy;

import net.minecraft.client.gui.GuiScreen;

//Basic GUI handling class. Not sure how to use it yet.
public class GuiBasic extends GuiScreen{
	public static final int GUI_ID = 20;
	
	public GuiBasic (){
		
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3){
		this.drawDefaultBackground();
	}
}
