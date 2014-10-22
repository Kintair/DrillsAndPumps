package com.kintair.drillsandpumps.blocks;

import com.kintair.drillsandpumps.tileentities.TileEntityPump;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class Pump extends BlockContainer
{
	private String name = "pump";
	
	public Pump()
	{
		super(Material.rock);
        setBlockName(name);
        setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(this, name);
	}
	
	@Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
    	return new TileEntityPump();
    }
	
	@Override
    public boolean hasTileEntity(int metadata)
    {
    	return true;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			TileEntityPump s = (TileEntityPump) world.getTileEntity(x, y, z); //Creates new Tile Entity for the block clicked. Should probably move to an onBlockPlaced function once UI/Inventory are added.
		}
		return true;
	}
}
