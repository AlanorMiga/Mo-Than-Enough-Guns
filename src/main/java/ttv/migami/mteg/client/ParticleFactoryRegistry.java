package ttv.migami.mteg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.client.particle.FireballParticle;
import ttv.migami.mteg.client.particle.FlareSmokeParticle;
import ttv.migami.mteg.client.particle.SonicBoomParticle;
import ttv.migami.mteg.init.ModParticleTypes;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryRegistry
{
    @SubscribeEvent
    public static void onRegisterParticleFactory(ParticleFactoryRegisterEvent event)
    {
        ParticleEngine particleManager = Minecraft.getInstance().particleEngine;
        particleManager.register(ModParticleTypes.FIREBALL_PARTICLES.get(), FireballParticle.Provider::new);
        particleManager.register(ModParticleTypes.FLARE_SMOKE.get(), FlareSmokeParticle.Provider::new);
        particleManager.register(ModParticleTypes.SONIC_BOOM.get(), SonicBoomParticle.Provider::new);
    }
}
