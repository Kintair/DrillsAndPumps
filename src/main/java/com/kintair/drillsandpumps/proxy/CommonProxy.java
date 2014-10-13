package com.kintair.drillsandpumps.proxy;

import com.kintair.drillsandpumps.tileentities.TileEntitySmasher;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySmasher.class, TileEntitySmasher.publicName);
	}

}
