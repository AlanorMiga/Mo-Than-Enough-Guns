package ttv.migami.mteg.client;

import ttv.migami.jeg.client.render.entity.ProjectileRenderer;

import ttv.migami.mteg.Reference;
import ttv.migami.mteg.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunEntityRenderers {
	
	/**
	 * Registers the default CGM bullet renderer to the Taki entity
	 */
	@SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		
        event.registerEntityRenderer(ModEntities.TAKI.get(), ProjectileRenderer::new);
        event.registerEntityRenderer(ModEntities.FLAMMABLE_GEL.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(ModEntities.FLARE.get(), ProjectileRenderer::new);
        
    }

}