package ttv.migami.mteg.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.client.particle.FireballParticle;
import ttv.migami.mteg.client.particle.FlareSmokeParticle;
import ttv.migami.mteg.init.ModParticleTypes;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryRegistry {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onParticlesRegistry(RegisterParticleProvidersEvent event) {
        event.register(ModParticleTypes.FIREBALL_PARTICLES.get(), FireballParticle.Provider::new);
        event.register(ModParticleTypes.FLARE_SMOKE.get(), FlareSmokeParticle.Provider::new);
    }

}
