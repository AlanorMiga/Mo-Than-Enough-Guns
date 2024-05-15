package ttv.migami.mteg.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.client.particle.FireballParticle;
import ttv.migami.mteg.client.particle.FlareSmokeParticle;
import ttv.migami.mteg.init.ModParticleTypes;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryRegistry
{
    @SubscribeEvent
    public static void onRegisterParticleFactory(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ModParticleTypes.FIREBALL_PARTICLES.get(), FireballParticle.Provider::new);
        event.registerSpriteSet(ModParticleTypes.FLARE_SMOKE.get(), FlareSmokeParticle.Provider::new);
    }
}
