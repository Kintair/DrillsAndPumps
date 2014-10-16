package com.kintair.drillsandpumps.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.kintair.drillsandpumps.tileentities.TileEntitySmasher;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

//Proxy class, for client/server stuff.
public class CommonProxy implements IGuiHandler {
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySmasher.class, TileEntitySmasher.publicName);
	}
	
	//Couple GUI functions, not sure how to use them
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		if(ID == GuiBasic.GUI_ID)
			return new GuiBasic();
		return null;
	}
}
