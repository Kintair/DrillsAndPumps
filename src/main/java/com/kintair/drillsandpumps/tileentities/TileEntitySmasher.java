package com.kintair.drillsandpumps.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kintair.drillsandpumps.DrillsAndPumps;

public class TileEntitySmasher extends TileEntity{
	int tick = 0;
	public static final String publicName = "tileEntitySmasher";
	private String name = "tileEntitySmasher";
	private ItemStack[] inv;
	
	public String getName()	{
		return name;
	}
	

}
