package com.crankysupertoon.caversecakes.registry;

import com.crankysupertoon.caversecakes.CaverseCakes;
import com.crankysupertoon.caversecakes.block.*;
import com.crankysupertoon.caversecakes.block.tile.TileDimensionCake;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static BlockEndCake endCake = new BlockEndCake();
    public static BlockNetherCake netherCake = new BlockNetherCake();
    public static BlockUnderworldCake underworldCake = new BlockUnderworldCake();
    public static BlockTwilightCake twilightCake = new BlockTwilightCake();
    public static BlockErebusCake erebusCake = new BlockErebusCake();
    public static BlockVoidCake voidCake = new BlockVoidCake();
    public static BlockHuntingCake huntingCake = new BlockHuntingCake();
    public static BlockOverworldCake overworldCake = new BlockOverworldCake();
    public static BlockCustomCake customCake = new BlockCustomCake();
    public static BlockAetherCake aetherCake = new BlockAetherCake();

    public static void init(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(endCake, netherCake, underworldCake, twilightCake, underworldCake, erebusCake, voidCake, huntingCake, aetherCake, customCake);
        GameRegistry.registerTileEntity(TileDimensionCake.class, new ResourceLocation(CaverseCakes.MODID, "tile_dimension_cake"));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        for (int i = 0; i <= 6; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(endCake), i, new ModelResourceLocation(endCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(netherCake), i, new ModelResourceLocation(netherCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(underworldCake), i, new ModelResourceLocation(underworldCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(twilightCake), i, new ModelResourceLocation(twilightCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(overworldCake), i, new ModelResourceLocation(overworldCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(erebusCake), i, new ModelResourceLocation(erebusCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(voidCake), i, new ModelResourceLocation(voidCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(huntingCake), i, new ModelResourceLocation(huntingCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(aetherCake), i, new ModelResourceLocation(aetherCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(customCake), i, new ModelResourceLocation(customCake.getRegistryName(), "inventory"));
        }
    }

}
