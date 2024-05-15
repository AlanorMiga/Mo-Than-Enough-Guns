package ttv.migami.mteg.init;

import ttv.migami.mteg.Reference;
import ttv.migami.mteg.client.particle.FireballParticle;
import ttv.migami.mteg.client.particle.FlareSmokeParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Reference.MOD_ID);

    public static final RegistryObject<SimpleParticleType> FIREBALL_PARTICLES =
            PARTICLES.register("fireball", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> FLARE_SMOKE =
            PARTICLES.register("flare_smoke", () -> new SimpleParticleType(true));
    
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onParticlesRegistry(RegisterParticleProvidersEvent event) {
		event.register(ModParticleTypes.FIREBALL_PARTICLES.get(), FireballParticle.Provider::new);
		event.register(ModParticleTypes.FLARE_SMOKE.get(), FlareSmokeParticle.Provider::new);
    }
    
}