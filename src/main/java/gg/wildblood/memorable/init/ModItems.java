package gg.wildblood.memorable.init;

import gg.wildblood.memorable.MemorableMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ModItems {
	static Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

	Item TEST_ITEM = createItem("test_item", new Item(new QuiltItemSettings()));

	private static <T extends Item> T createItem(String name, T item) {
		ITEMS.put(item, new Identifier(MemorableMod.MOD_ID, name));
		return item;
	}

	public static void initialize() {
		ITEMS.keySet().forEach(item -> {
			Registry.register(Registries.ITEM, ITEMS.get(item), item);
//			ModItemGroup.addToItemGroup(ModItemGroup.MOD_ITEMS, item);
		});
	}
}
