package com.kintair.drillsandpumps.proxy;

import com.kintair.drillsandpumps.tileentities.TileEntitySmasher;

import cpw.mods.fml.common.registry.GameRegistry;

//Proxy class, for client/server stuff.
public class CommonProxy {
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySmasher.class, TileEntitySmasher.publicName);
	}

}
