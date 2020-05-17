package com.crankysupertoon.caversecakes.compat;

import com.crankysupertoon.caversecakes.CaverseCakes;
import com.crankysupertoon.caversecakes.registry.ModBlocks;
import com.crankysupertoon.caversecakes.registry.ModConfig;
import com.crankysupertoon.caversecakes.registry.ModItems;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JEIPlugin
public class JEICompat implements IModPlugin {

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
    }

    @Override
    public void register(IModRegistry registry) {
        //End Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.endCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".end_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.ender.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.ender.fuel))))));
        //Nether Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.netherCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".nether_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.nether.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.nether.fuel))))));
        //Overworld Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.underworldCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".overworld_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.overworld.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.overworld.fuel))))));
        //Erebus Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.erebusCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".erebus_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.erebus.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.erebus.fuel))))));
        //Hunting Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.huntingCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".hunting_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.hunting.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.hunting.fuel))))));
        //Aether Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.aetherCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".aether_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.aether.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.aether.fuel))))));
        //Underworld Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.underworldCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".overworld_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.overworld.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.overworld.fuel))))));
        //Twilight Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.twilightCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".twilight_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.twilight.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.twilight.fuel))))));
        //Void Cake
        registry.addIngredientInfo(new ItemStack(ModBlocks.voidCake), VanillaTypes.ITEM,
                I18n.format(CaverseCakes.MODID + ".void_cake.jeidesc",
                        Item.REGISTRY.getObject(new ResourceLocation(ModConfig.thevoid.fuel)).getItemStackDisplayName(
                                new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(ModConfig.thevoid.fuel))))));
        //Ender Apple
        registry.addIngredientInfo(new ItemStack(ModItems.enderApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".ender_apple.jeidesc");
        //Nether Apple
        registry.addIngredientInfo(new ItemStack(ModItems.netherApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".nether_apple.jeidesc");
        //Overworld Apple
        registry.addIngredientInfo(new ItemStack(ModItems.overworldApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".overworld_apple.jeidesc");
        //Erebus Apple
        registry.addIngredientInfo(new ItemStack(ModItems.erebusApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".erebus_apple.jeidesc");
        //Hunting Apple
        registry.addIngredientInfo(new ItemStack(ModItems.huntingApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".hunting_apple.jeidesc");
        //Underworld Apple
        registry.addIngredientInfo(new ItemStack(ModItems.underworldApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".underworld_apple.jeidesc");
        //Aether Apple
        registry.addIngredientInfo(new ItemStack(ModItems.aetherApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".aether_apple.jeidesc");
        //Twilight Apple
        registry.addIngredientInfo(new ItemStack(ModItems.twilightApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".twilight_apple.jeidesc");
        //Void Apple
        registry.addIngredientInfo(new ItemStack(ModItems.voidApple), VanillaTypes.ITEM,
                CaverseCakes.MODID + ".void_apple.jeidesc");
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
    }

}
