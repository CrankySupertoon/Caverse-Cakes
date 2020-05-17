package com.crankysupertoon.caversecakes.proxy;

import com.crankysupertoon.caversecakes.compat.TOPCompat;
import com.crankysupertoon.caversecakes.compat.WailaCompat;
import com.crankysupertoon.caversecakes.registry.ModBlocks;
import com.crankysupertoon.caversecakes.registry.ModEvents;
import com.crankysupertoon.caversecakes.registry.ModItems;
import com.crankysupertoon.caversecakes.registry.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        if (Loader.isModLoaded("theoneprobe")) {
            TOPCompat.register();
        }
        if (Loader.isModLoaded("waila")) {
            WailaCompat.register();
        }
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }

    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> event) {
        ModItems.init(event);
    }

    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> event) {
        ModBlocks.init(event);
    }

    @SubscribeEvent
    public void onRecipeRegistry(RegistryEvent.Register<IRecipe> event) {
        ModRecipes.init(event);
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

}
