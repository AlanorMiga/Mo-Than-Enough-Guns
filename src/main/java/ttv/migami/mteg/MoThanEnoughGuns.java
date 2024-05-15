package ttv.migami.mteg;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ttv.migami.jeg.common.ProjectileManager;
import ttv.migami.mteg.client.ClientHandler;
import ttv.migami.mteg.datagen.GunGen;
import ttv.migami.mteg.entity.FireballProjectileEntity;
import ttv.migami.mteg.entity.FlareProjectileEntity;
import ttv.migami.mteg.entity.TakiProjectileEntity;
import ttv.migami.mteg.init.*;
import ttv.migami.mteg.network.PacketHandler;
import ttv.migami.mteg.world.loot.ModLootModifiers;

import java.util.concurrent.CompletableFuture;

import static ttv.migami.mteg.Reference.MOD_ID;

@Mod(MOD_ID)
public class MoThanEnoughGuns {
	
	public MoThanEnoughGuns() {
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		//Registers all of the Deferred Registers from our init classes.
		ModItems.ITEMS.register(bus);
		ModSounds.SOUNDS.register(bus);
		ModEntities.ENTITIES.register(bus);
		ModParticleTypes.PARTICLES.register(bus);
		ModRecipeSerializers.REGISTER.register(bus);
		ModRecipeTypes.REGISTER.register(bus);
		ModBlocks.REGISTER.register(bus);
		ModTileEntities.REGISTER.register(bus);
		ModContainers.REGISTER.register(bus);
		ModLootModifiers.register(bus);
		bus.addListener(this::onGatherData);
		bus.addListener(this::onClientSetup);
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			bus.addListener(ClientHandler::onRegisterCreativeTab);});

	}
	
	//This is the common setup event, only really registers the Taki entity to the item
	private void setup(final FMLCommonSetupEvent event) {
			
		System.out.println("Mo' Guns is back in the game!");
		
		ProjectileManager.getInstance().registerFactory(ModItems.AMMO_TAKI.get(), ((world, livingEntity, itemStack, gunItem, gun) -> new TakiProjectileEntity(ModEntities.TAKI.get(), world, livingEntity, itemStack, gunItem, gun)));
		ProjectileManager.getInstance().registerFactory(Items.MAGMA_CREAM, ((world, livingEntity, itemStack, gunItem, gun) -> new FireballProjectileEntity(ModEntities.FLAMMABLE_GEL.get(), world, livingEntity, itemStack, gunItem, gun)));
		ProjectileManager.getInstance().registerFactory(ModItems.FLARE.get(), ((world, livingEntity, itemStack, gunItem, gun) -> new FlareProjectileEntity(ModEntities.FLARE.get(), world, livingEntity, itemStack, gunItem, gun)));
		PacketHandler.init();

	}
	
	//This is the client setup event.
	private void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(ClientHandler::setup);
	}

	private void onGatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		generator.addProvider(event.includeServer(), new GunGen(output, lookupProvider));
	}

}