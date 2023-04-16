package eu.tomger;

import eu.tomger.items.TomatoPlant;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ExampleMod.TOMATO_CROP_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ExampleMod.CORN_CROP_BLOCK, RenderLayer.getCutout());
	}
}