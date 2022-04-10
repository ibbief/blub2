
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.mod.item.BlobbusShootusItem;
import net.mcreator.mod.item.BlobAmmoItem;
import net.mcreator.mod.item.BarriesBrainBasherItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item DK_BAREL = register(ModModBlocks.DK_BAREL, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GEILE_BLOB = register(
			new SpawnEggItem(ModModEntities.GEILE_BLOB, -256, -13312, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("geile_blob_spawn_egg"));
	public static final Item BOZE_BADGAST_BARRIE = register(
			new SpawnEggItem(ModModEntities.BOZE_BADGAST_BARRIE, -16724788, -16711885, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("boze_badgast_barrie_spawn_egg"));
	public static final Item BARRIES_BRAIN_BASHER = register(new BarriesBrainBasherItem());
	public static final Item BLOBBUS_SHOOTUS = register(new BlobbusShootusItem());
	public static final Item BLOB_AMMO = register(new BlobAmmoItem());
	public static final Item BLOB_SPAWNER = register(ModModBlocks.BLOB_SPAWNER, CreativeModeTab.TAB_COMBAT);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
