package com.kintair.drillsandpumps.blocks;

import net.minecraft.block.Block;

//Class for holding/initializing all the blocks added in the mod
public final class ModBlocks {
	//Declaring the blocks
	public static Block orangeBlock;
	public static Block smasher;
	public static Block pump;
	
	//Initializing the blocks
	public static void init(){
		orangeBlock = new OrangeBlock();
		smasher = new Smasher();
		pump = new Pump();
	}
}
