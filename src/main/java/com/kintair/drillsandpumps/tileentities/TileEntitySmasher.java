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

public class TileEntitySmasher extends TileEntity{
	int tick = 1;
	public static final String publicName = "tileEntitySmasher";
	private String name = "tileEntitySmasher";
	private ItemStack[] inv;
	
	public TileEntitySmasher(){
		
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
	}
	
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
	
	public void drill(World world, int x, int y, int z, float hitX, float hitY, float hitZ){
		if(hitX == 0){
			for(int i=1; i<5; i++)
				if(world.getBlock(x+i, y, z) != Blocks.bedrock)
					world.func_147480_a(x+i, y, z, true);
		}
		if(hitX == 1){
			for(int i=1; i<5; i++)
				if(world.getBlock(x-i, y, z) != Blocks.bedrock)
					world.func_147480_a(x-i, y, z, true);
		}
		if(hitY == 0){
			for(int i=1; i<5; i++)
				if(world.getBlock(x, y+i, z) != Blocks.bedrock)
					world.func_147480_a(x, y+i, z, true);
		}
		if(hitY == 1){
			for(int i=1; i<5; i++)
				if(world.getBlock(x, y-i, z) != Blocks.bedrock)
					world.func_147480_a(x, y-i, z, true);
		}
		if(hitZ == 0){
			for(int i=1; i<5; i++)
				if(world.getBlock(x, y, z+i) != Blocks.bedrock)
					world.func_147480_a(x, y, z+i, true);
		}
		if(hitZ == 1){
			for(int i=1; i<5; i++)
				if(world.getBlock(x, y, z-i) != Blocks.bedrock)
					world.func_147480_a(x, y, z-i, true);
		}
	}
	
}
