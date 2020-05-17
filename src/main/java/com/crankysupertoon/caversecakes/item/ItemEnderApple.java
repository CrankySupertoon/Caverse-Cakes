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
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnderApple extends ItemFood {
    public ModConfig.DimensionConfig config = ModConfig.ender;
    public String appleName = "ender";

    public ItemEnderApple() {
        super(4, 0.3F, false);
        setAlwaysEdible();
        setRegistryName(CaverseCakes.MODID + ":" + appleName + "_apple");
        setTranslationKey(CaverseCakes.MODID + "." + appleName + "_apple");
        setCreativeTab(CaverseCakes.TAB);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (world.provider.getDimension() != config.dimID) {
            if (!world.isRemote) {
                EntityPlayerMP playerMP = (EntityPlayerMP) player;
                BlockPos coords;
                if (config.useCustomCoords) {
                    coords = new BlockPos(config.customCoords.x, config.customCoords.y, config.customCoords.z);
                } else {
                    coords = TeleporterHandler.getDimPos(playerMP, config.dimID, player.getPosition());
                }
                TeleporterHandler.updateDimPos(playerMP, world.provider.getDimension(), player.getPosition());
                TeleporterHandler.teleport(playerMP, config.dimID, coords.getX(), coords.getY(), coords.getZ(), playerMP.server.getPlayerList());
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 200, false, false));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab))
            if (config.enableApple)
                list.add(new ItemStack(this));
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
