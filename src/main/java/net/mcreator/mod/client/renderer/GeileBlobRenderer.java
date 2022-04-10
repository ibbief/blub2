package net.mcreator.mod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.mod.entity.GeileBlobEntity;

public class GeileBlobRenderer extends HumanoidMobRenderer<GeileBlobEntity, HumanoidModel<GeileBlobEntity>> {
	public GeileBlobRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<GeileBlobEntity, HumanoidModel<GeileBlobEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("mod:textures/eyes.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GeileBlobEntity entity) {
		return new ResourceLocation("mod:textures/geileblob_.png");
	}
}
