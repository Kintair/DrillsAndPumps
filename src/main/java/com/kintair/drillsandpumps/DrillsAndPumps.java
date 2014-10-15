package com.kintair.drillsandpumps;

import com.kintair.drillsandpumps.blocks.ModBlocks;
import com.kintair.drillsandpumps.lib.Constants;
import com.kintair.drillsandpumps.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid=Constants.MODID, name=Constants.MODNAME, version=Constants.VERSION)

//Main Modfile
public class DrillsAndPumps {
	//Proxy declarations, for server/client communication
	@SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	//Initializers, for Forge to load various parts of the mod
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	ModBlocks.init();
    	//FMLCommonHandler.instance().bus().register(new SkcEvent()); //Loads UI requisite of some sort. Commented out because incomplete
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.registerTileEntities();
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}
