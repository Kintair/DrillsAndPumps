package com.kintair.drillsandpumps.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kintair.drillsandpumps.DrillsAndPumps;

//Tile entity for the "smasher" block. Will be updated to proper name later.
public class TileEntitySmasher extends TileEntity{
	int tick = 0; //Part of Tutorial, unused at the moment, may toy with it later.
	public static final String publicName = "tileEntitySmasher";
	private String name = "tileEntitySmasher";
	private ItemStack[] inv;
	
	public TileEntitySmasher(){
		
	}
	
	//Necessary functions, not doing much now but may get more complex once inventories are implemented
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
	}
	
	//Functions for saving/loading info to/from server. Since no information is stored, no need for them yet. Will need to figure them out as part of implementing inventories.
//	@Override
//	public Packet getDescriptionPacket(){
//		NBTTagCompound titleTag = new NBTTagCompound();
//		this.writeToNBT(titleTag);
//		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,this.zCoord, 0, titleTag);
//	}
	
//	@Override
//	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt){
//		this.readFromNBT(pkt.customParam1);
//	}
	
	public String getName()	{
		return name;
	}
	
	//For things that do stuff automatically, once placed.
/*	@Override
	public void updateEntity()
	{
		if(!worldObj.isRemote)
		{
			if(tick < 20)
			{
				tick++;
				if(tick >= 20)
					System.out.println(tick);
			}
		}
	}*/
	
	//Function for starting the drill. Temporary. UI will take over its job once implemented
	public void drillProc(World world, int x, int y, int z, float hitX, float hitY, float hitZ)
	{
		drill(world, 4, 10, x, y, z, hitX, hitY, hitZ); //Manually calling either drill1 or drill3, UI will allow choice between the two.
	}
	
	//Drills a 1x1 hole in a single direction. May need to be refactored once UI implemented
	private void drill1(World world, int depth, int x, int y, int z, float hitX, float hitY, float hitZ){
		if(hitX == 0){
			for(int i=1; i<depth; i++)
				if(world.getBlock(x+i, y, z) != Blocks.bedrock)
					world.func_147480_a(x+i, y, z, true);
		}
		else if(hitX == 1){
			for(int i=1; i<depth; i++)
				if(world.getBlock(x-i, y, z) != Blocks.bedrock)
					world.func_147480_a(x-i, y, z, true);
		}
		else if(hitY == 0){
			for(int i=1; i<depth; i++)
				if(world.getBlock(x, y+i, z) != Blocks.bedrock)
					world.func_147480_a(x, y+i, z, true);
		}
		else if(hitY == 1){
			for(int i=1; i<depth; i++)
				if(world.getBlock(x, y-i, z) != Blocks.bedrock)
					world.func_147480_a(x, y-i, z, true);
		}
		else if(hitZ == 0){
			for(int i=1; i<depth; i++)
				if(world.getBlock(x, y, z+i) != Blocks.bedrock)
					world.func_147480_a(x, y, z+i, true);
		}
		else if(hitZ == 1){
			for(int i=1; i<depth; i++)
				if(world.getBlock(x, y, z-i) != Blocks.bedrock)
					world.func_147480_a(x, y, z-i, true);
		}
	}
	
	//Drills a 3x3 hole in the direction opposite the side right clicked. Depreciated. May revert if catch-all is too intense.
/*	private void drill3(World world, int depth, int x, int y, int z, float hitX, float hitY, float hitZ){
		if(hitX == 0){
			for(int i=1; i<depth; i++){
				if(world.getBlock(x+i, y, z) != Blocks.bedrock)
					world.func_147480_a(x+i, y, z, true);
				if(world.getBlock(x+i, y+1, z) != Blocks.bedrock)
					world.func_147480_a(x+i, y+1, z, true);
				if(world.getBlock(x+i, y+1, z+1) != Blocks.bedrock)
					world.func_147480_a(x+i, y+1, z+1, true);
				if(world.getBlock(x+i, y, z+1) != Blocks.bedrock)
					world.func_147480_a(x+i, y, z+1, true);
				if(world.getBlock(x+i, y-1, z+1) != Blocks.bedrock)
					world.func_147480_a(x+i, y-1, z+1, true);
				if(world.getBlock(x+i, y-1, z) != Blocks.bedrock)
					world.func_147480_a(x+i, y-1, z, true);
				if(world.getBlock(x+i, y-1, z-1) != Blocks.bedrock)
					world.func_147480_a(x+i, y-1, z-1, true);
				if(world.getBlock(x+i, y, z-1) != Blocks.bedrock)
					world.func_147480_a(x+i, y, z-1, true);
				if(world.getBlock(x+i, y+1, z-1) != Blocks.bedrock)
					world.func_147480_a(x+i, y+1, z-1, true);
			}
		}
		else if(hitX == 1){
			for(int i=1; i<depth; i++){
				if(world.getBlock(x-i, y, z) != Blocks.bedrock)
					world.func_147480_a(x-i, y, z, true);
				if(world.getBlock(x-i, y+1, z) != Blocks.bedrock)
					world.func_147480_a(x-i, y+1, z, true);
				if(world.getBlock(x-i, y+1, z+1) != Blocks.bedrock)
					world.func_147480_a(x-i, y+1, z+1, true);
				if(world.getBlock(x-i, y, z+1) != Blocks.bedrock)
					world.func_147480_a(x-i, y, z+1, true);
				if(world.getBlock(x-i, y-1, z+1) != Blocks.bedrock)
					world.func_147480_a(x-i, y-1, z+1, true);
				if(world.getBlock(x-i, y-1, z) != Blocks.bedrock)
					world.func_147480_a(x-i, y-1, z, true);
				if(world.getBlock(x-i, y-1, z-1) != Blocks.bedrock)
					world.func_147480_a(x-i, y-1, z-1, true);
				if(world.getBlock(x-i, y, z-1) != Blocks.bedrock)
					world.func_147480_a(x-i, y, z-1, true);
				if(world.getBlock(x-i, y+1, z-1) != Blocks.bedrock)
					world.func_147480_a(x-i, y+1, z-1, true);
			}
		}
		else if(hitY == 0){
			for(int i=1; i<depth; i++){
				if(world.getBlock(x, y+i, z) != Blocks.bedrock)
					world.func_147480_a(x, y+i, z, true);
				if(world.getBlock(x+1, y+i, z) != Blocks.bedrock)
					world.func_147480_a(x+1, y+i, z, true);
				if(world.getBlock(x+1, y+i, z+1) != Blocks.bedrock)
					world.func_147480_a(x+1, y+i, z+1, true);
				if(world.getBlock(x, y+i, z+1) != Blocks.bedrock)
					world.func_147480_a(x, y+i, z+1, true);
				if(world.getBlock(x-1, y+i, z+1) != Blocks.bedrock)
					world.func_147480_a(x-1, y+i, z+1, true);
				if(world.getBlock(x-1, y+i, z) != Blocks.bedrock)
					world.func_147480_a(x-1, y+i, z, true);
				if(world.getBlock(x-1, y+i, z-1) != Blocks.bedrock)
					world.func_147480_a(x-1, y+i, z-1, true);
				if(world.getBlock(x, y+i, z-1) != Blocks.bedrock)
					world.func_147480_a(x, y+i, z-1, true);
				if(world.getBlock(x+1, y+i, z-1) != Blocks.bedrock)
					world.func_147480_a(x+1, y+i, z-1, true);
			}
		}
		else if(hitY == 1){
			for(int i=1; i<depth; i++){
				if(world.getBlock(x, y-i, z) != Blocks.bedrock)
					world.func_147480_a(x, y-i, z, true);
				if(world.getBlock(x+1, y-i, z) != Blocks.bedrock)
					world.func_147480_a(x+1, y-i, z, true);
				if(world.getBlock(x+1, y-i, z+1) != Blocks.bedrock)
					world.func_147480_a(x+1, y-i, z+1, true);
				if(world.getBlock(x, y-i, z+1) != Blocks.bedrock)
					world.func_147480_a(x, y-i, z+1, true);
				if(world.getBlock(x-1, y-i, z+1) != Blocks.bedrock)
					world.func_147480_a(x-1, y-i, z+1, true);
				if(world.getBlock(x-1, y-i, z) != Blocks.bedrock)
					world.func_147480_a(x-1, y-i, z, true);
				if(world.getBlock(x-1, y-i, z-1) != Blocks.bedrock)
					world.func_147480_a(x-1, y-i, z-1, true);
				if(world.getBlock(x, y-i, z-1) != Blocks.bedrock)
					world.func_147480_a(x, y-i, z-1, true);
				if(world.getBlock(x+1, y-i, z-1) != Blocks.bedrock)
					world.func_147480_a(x+1, y-i, z-1, true);
			}
		}
		else if(hitZ == 0){
			for(int i=1; i<depth; i++){
				if(world.getBlock(x, y, z+i) != Blocks.bedrock)
					world.func_147480_a(x, y, z+i, true);
				if(world.getBlock(x+1, y, z+i) != Blocks.bedrock)
					world.func_147480_a(x+1, y, z+i, true);
				if(world.getBlock(x+1, y+1, z+i) != Blocks.bedrock)
					world.func_147480_a(x+1, y+1, z+i, true);
				if(world.getBlock(x, y+1, z+i) != Blocks.bedrock)
					world.func_147480_a(x, y+1, z+i, true);
				if(world.getBlock(x-1, y+1, z+i) != Blocks.bedrock)
					world.func_147480_a(x-1, y+1, z+i, true);
				if(world.getBlock(x-1, y, z+i) != Blocks.bedrock)
					world.func_147480_a(x-1, y, z+i, true);
				if(world.getBlock(x-1, y-1, z+i) != Blocks.bedrock)
					world.func_147480_a(x-1, y-1, z+i, true);
				if(world.getBlock(x, y-1, z+i) != Blocks.bedrock)
					world.func_147480_a(x, y-1, z+i, true);
				if(world.getBlock(x+1, y-1, z+i) != Blocks.bedrock)
					world.func_147480_a(x+1, y-1, z+i, true);
			}
		}
		else if(hitZ == 1){
			for(int i=1; i<depth; i++){
				if(world.getBlock(x, y, z-i) != Blocks.bedrock)
					world.func_147480_a(x, y, z-i, true);
				if(world.getBlock(x+1, y, z-i) != Blocks.bedrock)
					world.func_147480_a(x+1, y, z-i, true);
				if(world.getBlock(x+1, y+1, z-i) != Blocks.bedrock)
					world.func_147480_a(x+1, y+1, z-i, true);
				if(world.getBlock(x, y+1, z-i) != Blocks.bedrock)
					world.func_147480_a(x, y+1, z-i, true);
				if(world.getBlock(x-1, y+1, z-i) != Blocks.bedrock)
					world.func_147480_a(x-1, y+1, z-i, true);
				if(world.getBlock(x-1, y, z-i) != Blocks.bedrock)
					world.func_147480_a(x-1, y, z-i, true);
				if(world.getBlock(x-1, y-1, z-i) != Blocks.bedrock)
					world.func_147480_a(x-1, y-1, z-i, true);
				if(world.getBlock(x, y-1, z-i) != Blocks.bedrock)
					world.func_147480_a(x, y-1, z-i, true);
				if(world.getBlock(x+1, y-1, z-i) != Blocks.bedrock)
					world.func_147480_a(x+1, y-1, z-i, true);
			}
		}
	}*/
	
	//Drilling holes of varied width as well as depth.
	private void drill(World world, int width, int depth, int x, int y, int z, float hitX, float hitY, float hitZ){
		if(hitX == 0)
		{
			for(int i=1; i<depth+1; i++)
			{
				breakBlock(world, x+i, y, z);
				for(int j=1; j<width; j++)
				{
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+i, y+j, z+k);
					}
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+i, y+k, z-j);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x+i, y-j, z+k);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x+i, y+k, z+j);
					}
				}
			}
		}
		else if(hitX == 1){
			for(int i=1; i<depth+1; i++)
			{
				breakBlock(world, x-i, y, z);
				for(int j=1; j<width; j++)
				{
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x-i, y+j, z+k);
					}
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x-i, y+k, z-j);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x-i, y-j, z+k);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x-i, y+k, z+j);
					}
				}
			}
		}
		else if(hitY == 0){
			for(int i=1; i<depth+1; i++)
			{
				breakBlock(world, x, y+i, z);
				for(int j=1; j<width; j++)
				{
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+j, y+i, z+k);
					}
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+k, y+i, z-j);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x-j, y+i, z+k);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x+k, y+i, z+j);
					}
				}
			}
		}
		else if(hitY == 1){
			for(int i=1; i<depth+1; i++)
			{
				breakBlock(world, x, y-i, z);
				for(int j=1; j<width; j++)
				{
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+j, y-i, z+k);
					}
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+k, y-i, z-j);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x-j, y-i, z+k);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x+k, y-i, z+j);
					}
				}
			}
		}
		else if(hitZ == 0){
			for(int i=1; i<depth+1; i++)
			{
				breakBlock(world, x, y, z+i);
				for(int j=1; j<width; j++)
				{
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+j, y+k, z+i);
					}
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+k, y-j, z+i);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x-j, y+k, z+i);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x+k, y+j, z+i);
					}
				}
			}
		}
		else if(hitZ == 1){
			for(int i=1; i<depth+1; i++)
			{
				breakBlock(world, x, y, z-i);
				for(int j=1; j<width; j++)
				{
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+j, y+k, z-i);
					}
					for(int k=j; k>-j; k--)
					{
						breakBlock(world, x+k, y-j, z-i);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x-j, y+k, z-i);
					}
					for(int k=-j; k<j; k++)
					{
						breakBlock(world, x+k, y+j, z-i);
					}
				}
			}
		}
	}
	
	private void breakBlock(World world, int x,int y,int z)
	{
		if(world.getBlock(x, y, z) != Blocks.bedrock)
			world.func_147480_a(x, y, z, false);
	}
}


