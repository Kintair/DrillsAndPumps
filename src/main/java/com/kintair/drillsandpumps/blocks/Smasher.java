package com.kintair.drillsandpumps.blocks;

import com.kintair.drillsandpumps.tileentities.TileEntitySmasher;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Smasher extends Block implements ITileEntityProvider{
	 
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
}