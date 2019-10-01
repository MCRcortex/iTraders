package kaptainwutax.itraders.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class InitModel {

	public static void registerModels() {
		registerSimpleItemModel(InitItem.BIT_100, 0);
		registerSimpleItemModel(InitItem.BIT_500, 0);
		registerSimpleItemModel(InitItem.BIT_1000, 0);
		registerSimpleItemModel(InitItem.BIT_5000, 0);
		registerSimpleItemModel(InitItem.BIT_10000, 0);
		registerSimpleItemModel(InitItem.SPAWN_EGG_FIGHTER, 0);
	}
	
	private static void registerSimpleItemModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
