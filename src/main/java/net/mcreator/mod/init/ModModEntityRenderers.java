
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.mod.client.renderer.GeileBlobRenderer;
import net.mcreator.mod.client.renderer.BozeBadgastBarrieRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModModEntities.GEILE_BLOB, GeileBlobRenderer::new);
		event.registerEntityRenderer(ModModEntities.BOZE_BADGAST_BARRIE, BozeBadgastBarrieRenderer::new);
		event.registerEntityRenderer(ModModEntities.BLOBBUS_SHOOTUS, ThrownItemRenderer::new);
	}
}
