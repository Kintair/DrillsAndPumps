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
	//int tick = 0; //Part of Tutorial, unused at the moment, may toy with it later.
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
	
	//Function for starting the drill. Temporary. UI will take over its job once implemented
	public void drillProc(World world, int x, int y, int z, float hitX, float hitY, float hitZ){
		drill3(world, 10, x, y, z, hitX, hitY, hitZ); //Manually calling either drill1 or drill3, UI will allow choice between the two.
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
	
	//Drills a 3x3 hole in the direction opposite the side right clicked. May also need to be refactored later.
	private void drill3(World world, int depth, int x, int y, int z, float hitX, float hitY, float hitZ){
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
	}
	
}
