package com.kintair.drillsandpumps.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPump extends TileEntity
{
	public static final String publicName = "tileEntityPump";
	private String name = "tileEntityPump";
	
	public TileEntityPump()
	{
	}
	
	//Necessary functions, not doing much now but may get more complex once inventories are implemented
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
	}
	
	public String getName()
	{
		return name;
	}
}
