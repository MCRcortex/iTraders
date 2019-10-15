package kaptainwutax.itraders.init;

import kaptainwutax.itraders.Traders;
import kaptainwutax.itraders.item.mesh.FighterEggMesh;
import kaptainwutax.itraders.item.mesh.TraderEggMesh;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

public class InitModel {

	public static void registerModels() {
		registerSimpleItemModel(InitItem.BIT_100, 0);
		registerSimpleItemModel(InitItem.BIT_500, 0);
		registerSimpleItemModel(InitItem.BIT_1000, 0);
		registerSimpleItemModel(InitItem.BIT_5000, 0);
		registerSimpleItemModel(InitItem.BIT_10000, 0);
		registerSimpleItemModel(InitItem.EGG_POUCH, 0);
		registerSimpleItemModel(InitItem.SKULL_NECKLACE, 0);

		registerBlockModel(InitBlock.SKULL_REFINER, 0);
		registerItemBlockModel(InitBlock.SKULL_REFINER_ITEM_BLOCK, 0);

		ModelLoader.setCustomMeshDefinition(InitItem.SPAWN_EGG_TRADER, new TraderEggMesh(InitItem.SPAWN_EGG_TRADER));
		ModelLoader.setCustomMeshDefinition(InitItem.SPAWN_EGG_FIGHTER, new FighterEggMesh(InitItem.SPAWN_EGG_FIGHTER));
	}

	private static void registerSimpleItemModel(Item item, int metadata) {
		ModelLoader.setCustomModelResourceLocation(item, metadata,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private static void registerBlockModel(Block block, int metadata) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), metadata,
				new ModelResourceLocation(Traders.getResource(block.getUnlocalizedName().substring(5)), "inventory"));
	}

	private static void registerItemBlockModel(ItemBlock itemBlock, int metadata) {
		ModelLoader.setCustomModelResourceLocation(itemBlock, metadata,
				new ModelResourceLocation(itemBlock.getRegistryName(), "inventory"));
	}

}
