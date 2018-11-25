package jackyy.dimensionaledibles.registry;

import jackyy.dimensionaledibles.block.BlockEndCake;
import jackyy.dimensionaledibles.block.BlockNetherCake;
import jackyy.dimensionaledibles.block.BlockOverworldCake;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static BlockEndCake endCake = new BlockEndCake();
    public static BlockNetherCake netherCake = new BlockNetherCake();
    public static BlockOverworldCake overworldCake = new BlockOverworldCake();

    public static void init(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                endCake,
                netherCake,
                overworldCake
        );
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        for (int i = 0; i <= 6; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(endCake), i,
                    new ModelResourceLocation(endCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(netherCake), i,
                    new ModelResourceLocation(netherCake.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(overworldCake), i,
                    new ModelResourceLocation(overworldCake.getRegistryName(), "inventory"));
        }
    }

}
