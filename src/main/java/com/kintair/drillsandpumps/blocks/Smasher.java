package com.kintair.drillsandpumps.blocks;

import com.kintair.drillsandpumps.tileentities.TileEntitySmasher;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Smasher extends BlockContainer{
	 
    private String name = "smasher";
 
    public Smasher() {
 
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(this, name);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int meta){
    	return new TileEntitySmasher();
    }
    
    @Override
    public boolean hasTileEntity(int metadata){
    	return true;
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			TileEntitySmasher s = (TileEntitySmasher) world.getTileEntity(x, y, z);
			s.drillProc( world, x, y, z, hitX, hitY, hitZ);
		}
		return true;
	}
}