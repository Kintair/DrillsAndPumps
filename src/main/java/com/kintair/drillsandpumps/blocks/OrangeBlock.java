package com.kintair.drillsandpumps.blocks;

import com.kintair.drillsandpumps.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

//Tutorial block, for reference. To be removed later
public class OrangeBlock extends Block {
	
	private String name = "orangeBlock";
	
	public OrangeBlock(){
		super(Material.rock); //Material of the block, influences many physical properties.
		this.setCreativeTab(CreativeTabs.tabBlock); //Adds block to a tab in Creative inventory
		this.setBlockName(Constants.MODID + "_" + name); //Sets name of block according to name above
		setBlockTextureName(Constants.MODID + ":" + name); //Sets texture to be used for this block
		GameRegistry.registerBlock(this, name); //Registers the block
	}
}
