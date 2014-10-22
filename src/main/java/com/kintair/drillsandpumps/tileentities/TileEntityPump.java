package com.kintair.drillsandpumps.tileentities;

import scala.Console;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityPump extends TileEntity
{
	public static final String publicName = "tileEntityPump";
	private String name = "tileEntityPump";
	private int discovered = 0;
	
	//Coords object for holding the x, z coordinates of fluid blocks in a certain y plane
	class Coords
	{
		int x, z;
		public Coords()
		{
			super();
		}
	}
	private Coords d = new Coords();
	private Coords[] dis = new Coords[9];
	
	//Constructor, initializes the array of Coords
	public TileEntityPump()
	{
		for(int i=0; i<dis.length; i++)
		{
			dis[i] = new Coords();
		}
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
	
	//Function for starting the pumping process
	public void pumpProc(World world, int x, int y, int z)
	{
		discover(world, x, y-1, z);
	}
	
	//Function to find all the fluid blocks in the top layer (Possibly broken?)
	private boolean discover(World world, int x, int y, int z)
	{
		while(world.getBlock(x, y, z) == Blocks.air)
			y--;
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			d.x = x;
			d.z = z;
			dis[0] = d;
			disRec(world, x+1, y, z);
			disRec(world, x, y, z+1);
			disRec(world, x-1, y, z);
			disRec(world, x, y, z-1);
			//Console.out().println(discovered);
			for(int i=0; i<discovered; i++)
			{
				Console.out().print(dis[i].x);
				Console.out().print(", ");
				Console.out().print(dis[i].z);
				Console.out().println();
			}
			discovered = 0;
			return true;
		}
		else
			return false;
	}
	
	//Recursive part of the discovery function (Broken, not sure what's wrong)
	private void disRec(World world, int x, int y, int z)
	{
		//Console.out().println(discovered);
		//Console.out().println("disRec Called");
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			//Console.out().println("Liquid Found");
			d.x = x;
			d.z = z;
			boolean found = false;
			for(int i=0; i<=discovered; i++)
			{
				//Console.out().print(dis[i].x);
				//Console.out().print(", ");
				//Console.out().print(dis[i].z);
				//Console.out().println();
				if(dis[i] == d)
				{
					found = true;
				}
			}
			if(!found)
			{
				discovered++;
				dis[discovered] = d;
				Console.out().println("Block added");
				
				disRec(world, x+1, y, z);
				disRec(world, x, y, z+1);
				disRec(world, x-1, y, z);
				disRec(world, x, y, z-1);
			}
		}
	}
}
