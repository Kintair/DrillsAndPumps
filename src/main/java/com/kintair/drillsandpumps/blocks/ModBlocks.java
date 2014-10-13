package com.kintair.drillsandpumps.blocks;

import net.minecraft.block.Block;

public final class ModBlocks {
	
	public static Block orangeBlock;
	public static Block smasher;
	
	public static void init(){
		orangeBlock = new OrangeBlock();
		smasher = new Smasher();
	}
}
