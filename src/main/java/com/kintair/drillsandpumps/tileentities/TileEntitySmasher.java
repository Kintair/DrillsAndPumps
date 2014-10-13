package com.kintair.drillsandpumps.tileentities;

import com.kintair.drillsandpumps.DrillsAndPumps;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySmasher extends TileEntity{
	int tick = 0;
	public static final String publicName = "tileEntitySmasher";
	private String name = "tileEntitySmasher";
	private ItemStack[] inv;
	
	public String getName()	{
		return name;
	}
	
	
}
