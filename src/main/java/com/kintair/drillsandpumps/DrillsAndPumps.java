package com.kintair.drillsandpumps;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="DrillsAndPumps", name="Drills and Pumps", version="0.0.0")

public class DrillsAndPumps {
    // The instance of your mod that Forge uses.
    @Instance(value = "DrillsAndPumps")
    public static DrillsAndPumps instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.kintair.drillsandpumps.client.ClientProxy", serverSide="com.kintair.drillsandpumps.CommonProxy")
    public static CommonProxy proxy;
   
    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
   
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
    }
   
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}
