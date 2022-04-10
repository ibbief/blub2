
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mod.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.mod.entity.GeileBlobEntity;
import net.mcreator.mod.entity.BozeBadgastBarrieEntity;
import net.mcreator.mod.entity.BlobbusShootusEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<GeileBlobEntity> GEILE_BLOB = register("geile_blob",
			EntityType.Builder.<GeileBlobEntity>of(GeileBlobEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(44).setUpdateInterval(3).setCustomClientFactory(GeileBlobEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<BozeBadgastBarrieEntity> BOZE_BADGAST_BARRIE = register("boze_badgast_barrie",
			EntityType.Builder.<BozeBadgastBarrieEntity>of(BozeBadgastBarrieEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BozeBadgastBarrieEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<BlobbusShootusEntity> BLOBBUS_SHOOTUS = register("entitybulletblobbus_shootus",
			EntityType.Builder.<BlobbusShootusEntity>of(BlobbusShootusEntity::new, MobCategory.MISC).setCustomClientFactory(BlobbusShootusEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		EntityType<T> entityType = (EntityType<T>) entityTypeBuilder.build(registryname).setRegistryName(registryname);
		REGISTRY.add(entityType);
		return entityType;
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new EntityType[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GeileBlobEntity.init();
			BozeBadgastBarrieEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GEILE_BLOB, GeileBlobEntity.createAttributes().build());
		event.put(BOZE_BADGAST_BARRIE, BozeBadgastBarrieEntity.createAttributes().build());
	}
}
