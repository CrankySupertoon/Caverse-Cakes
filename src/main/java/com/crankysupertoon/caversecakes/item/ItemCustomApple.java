package com.crankysupertoon.caversecakes.item;

import com.crankysupertoon.caversecakes.CaverseCakes;
import com.crankysupertoon.caversecakes.registry.ModConfig;
import com.crankysupertoon.caversecakes.util.TeleporterHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;

public class ItemCustomApple extends ItemFood {

    public ItemCustomApple() {
        super(4, 0.3F, false);
        setAlwaysEdible();
        setRegistryName(CaverseCakes.MODID + ":custom_apple");
        setTranslationKey(CaverseCakes.MODID + ".custom_apple");
        setCreativeTab(CaverseCakes.TAB);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        int dimension;
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null || !nbt.hasKey("dimID")) {
            return;
        }
        dimension = nbt.getInteger("dimID");
        if (world.provider.getDimension() != dimension) {
            if (!world.isRemote) {
                EntityPlayerMP playerMP = (EntityPlayerMP) player;
                BlockPos coords = TeleporterHandler.getDimPos(playerMP, dimension, player.getPosition());
                TeleporterHandler.updateDimPos(playerMP, world.provider.getDimension(), player.getPosition());
                TeleporterHandler.teleport(playerMP, dimension, coords.getX(), coords.getY(), coords.getZ(), playerMP.server.getPlayerList());
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 200, false, false));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (ModConfig.customEdible.enableApples) {
                ItemStack stack;
                for (String s : ModConfig.customEdible.dimensions) {
                    try {
                        String[] parts = s.split(",");
                        if (parts.length < 2) {
                            CaverseCakes.logger.log(Level.ERROR, s + " is not a valid input line! Format needs to be: <dimID>, <cakeName>");
                            continue;
                        }
                        int dimension = Integer.parseInt(parts[0]);
                        if (DimensionManager.isDimensionRegistered(dimension)) {
                            stack = new ItemStack(this);
                            NBTTagCompound nbt = stack.getTagCompound();
                            if (nbt == null) {
                                nbt = new NBTTagCompound();
                                stack.setTagCompound(nbt);
                            }
                            nbt.setInteger("dimID", dimension);
                            nbt.setString("appleName", parts[1].trim());
                            list.add(stack);
                        } else {
                            CaverseCakes.logger.log(Level.ERROR, parts[0] + " is not a valid dimension ID! (Needs to be a number)");
                        }
                    } catch (NumberFormatException e) {
                        CaverseCakes.logger.log(Level.ERROR, s + " is not a valid line input! The dimension ID needs to be a number!");
                    }
                }
            }
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null || !nbt.hasKey("appleName")) {
            return "Custom Apple";
        }
        return nbt.getString("appleName") + " Apple";
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
