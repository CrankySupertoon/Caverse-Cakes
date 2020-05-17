package com.crankysupertoon.caversecakes.proxy;

import com.crankysupertoon.caversecakes.block.tile.TileDimensionCake;
import com.crankysupertoon.caversecakes.client.TileCustomCakeRenderer;
import com.crankysupertoon.caversecakes.registry.ModBlocks;
import com.crankysupertoon.caversecakes.registry.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onModelRegistry(ModelRegistryEvent event) {
        ModItems.initModels();
        ModBlocks.initModels();
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
        ClientRegistry.bindTileEntitySpecialRenderer(TileDimensionCake.class, TileCustomCakeRenderer.INSTANCE);
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}
