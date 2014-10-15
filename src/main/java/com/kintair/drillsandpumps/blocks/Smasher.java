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

//Second tutorial block, with added functionality. To be converted/renamed later.
public class Smasher extends BlockContainer{
	 
    private String name = "smasher";
 
    public Smasher() {
 
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(this, name);
    }
    
    //Creates a Tile Entity associated with this block
    @Override
    public TileEntity createNewTileEntity(World world, int meta){
    	return new TileEntitySmasher();
    }
    
    //A necessary function used somewhere in the depths of Forge or Minecraft
    @Override
    public boolean hasTileEntity(int metadata){
    	return true;
    }
    
    //Function for when a block is right-clicked. Currently activates the drill starting from side opposite the side clicked.
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			TileEntitySmasher s = (TileEntitySmasher) world.getTileEntity(x, y, z); //Creates new Tile Entity for the block clicked. Should probably move to an onBlockPlaced function once UI/Inventory are added.
			s.drillProc( world, x, y, z, hitX, hitY, hitZ); //Starts the drill. Will be done via UI when it's added.
		}
		return true;
	}
}