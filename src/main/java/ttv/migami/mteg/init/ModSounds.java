package ttv.migami.mteg.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ttv.migami.mteg.Reference;

/**
 * This class is where all of the mod's sounds are registered.
 */
public class ModSounds {
	
	/*
     * This creates a Deferred Register where all of the sounds will be registered
     * This is called and added to the event bus in the main mod file.
     */
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);
	
	public static final RegistryObject<SoundEvent> SCAR_L_FIRE = register("item.scar_l.fire");
	
	public static final RegistryObject<SoundEvent> SCAR_L_FIRE_SUPPRESSED = register("item.scar_l.suppressed_fire");
	
	public static final RegistryObject<SoundEvent> SCAR_L_COCK = register("item.scar_l.cock");
	
	public static final RegistryObject<SoundEvent> G36C_FIRE = register("item.g36c.fire");
	
	public static final RegistryObject<SoundEvent> G36C_FIRE_SUPPRESSED = register("item.g36c.suppressed_fire");
	
	public static final RegistryObject<SoundEvent> G36C_COCK = register("item.g36c.cock");
	
	public static final RegistryObject<SoundEvent> BOOM = register("item.trashcan.boom");
	
	public static final RegistryObject<SoundEvent> LAUGH = register("item.trashcan.reload");
	
	public static final RegistryObject<SoundEvent> BIG_IRON_FIRE = register("item.big_iron.fire");
	
	public static final RegistryObject<SoundEvent> AKM_FIRE = register("item.akm.fire");
	
	public static final RegistryObject<SoundEvent> AKM_COCK = register("item.akm.cock");
	
	public static final RegistryObject<SoundEvent> AS_VAL_FIRE = register("item.as_val.fire");
	
	public static final RegistryObject<SoundEvent> AS_VAL_COCK = register("item.as_val.cock");
	
	public static final RegistryObject<SoundEvent> THOMPSON_FIRE = register("item.thompson.fire");
	
	public static final RegistryObject<SoundEvent> THOMPSON_COCK = register("item.thompson.cock");
	
	public static final RegistryObject<SoundEvent> M16A1_FIRE = register("item.m16a1.fire");
	
	public static final RegistryObject<SoundEvent> M16A1_COCK = register("item.m16a1.cock");
	
	public static final RegistryObject<SoundEvent> FAMAS_FIRE = register("item.famas.fire");
	
	public static final RegistryObject<SoundEvent> FAMAS_COCK = register("item.famas.cock");
	
	public static final RegistryObject<SoundEvent> GARAND_FIRE = register("item.m1_garand.fire");
	
	public static final RegistryObject<SoundEvent> GARAND_COCK = register("item.m1_garand.cock");
	
	public static final RegistryObject<SoundEvent> GARAND_PING = register("item.m1_garand.ping");
	
	public static final RegistryObject<SoundEvent> AWP_FIRE = register("item.awp.fire");

	public static final RegistryObject<SoundEvent> AWP_BOLT = register("item.awp.bolt");
	
	public static final RegistryObject<SoundEvent> AWP_SUPPRESSED = register("item.awp.suppressed_fire");
	
	public static final RegistryObject<SoundEvent> BENELLI_FIRE = register("item.benelli_m4.fire");
	
	public static final RegistryObject<SoundEvent> BENELLI_COCK = register("item.benelli_m4.cock");
	
	public static final RegistryObject<SoundEvent> GLOCK_FIRE = register("item.glock_17.fire");
	
	public static final RegistryObject<SoundEvent> GLOCK_FIRE_SUPPRESSED = register("item.glock_17.suppressed_fire");
	
	public static final RegistryObject<SoundEvent> GLOCK_COCK = register("item.glock_17.cock");
	
	public static final RegistryObject<SoundEvent> M14_EBR_FIRE = register("item.m14_ebr.fire");
	
	public static final RegistryObject<SoundEvent> M14_EBR_COCK = register("item.m14_ebr.cock");
	
	public static final RegistryObject<SoundEvent> M1911_FIRE = register("item.m1911.fire");
	
	public static final RegistryObject<SoundEvent> M1911_COCK = register("item.m1911.cock");
	
	public static final RegistryObject<SoundEvent> MOSSBERG_FIRE = register("item.mossberg_590.fire");
	
	public static final RegistryObject<SoundEvent> MOSSBERG_COCK = register("item.mossberg_590.cock");
	
	public static final RegistryObject<SoundEvent> REMINGTON_870_FIRE = register("item.remington_870.fire");
	
	public static final RegistryObject<SoundEvent> REMINGTON_870_COCK = register("item.remington_870.cock");
	
	public static final RegistryObject<SoundEvent> UZI_FIRE = register("item.uzi.fire");
	
	public static final RegistryObject<SoundEvent> GLOCKEST_GLOCK_FIRE = register("item.glockest_glock.fire");
	
	public static final RegistryObject<SoundEvent> GLOCKEST_GLOCK_COCK = register("item.glockest_glock.cock");
	
	public static final RegistryObject<SoundEvent> GLOCKEST_GLOCK_RELOAD = register("item.glockest_glock.reload");
	
	public static final RegistryObject<SoundEvent> BAKER_FIRE = register("item.baker_rifle.fire");
	
	public static final RegistryObject<SoundEvent> BAKER_COCK = register("item.baker_rifle.cock");
	
	public static final RegistryObject<SoundEvent> LANCHESTER_FIRE = register("item.lanchester.fire");
	
	public static final RegistryObject<SoundEvent> LANCHESTER_COCK = register("item.lanchester.cock");
	
	public static final RegistryObject<SoundEvent> MP5_FIRE = register("item.mp5.fire");
	
	public static final RegistryObject<SoundEvent> MP5_COCK = register("item.mp5.cock");
	
	public static final RegistryObject<SoundEvent> PPSH_FIRE = register("item.ppsh_41.fire");
	
	public static final RegistryObject<SoundEvent> PPSH_COCK = register("item.ppsh_41.cock");
	
	public static final RegistryObject<SoundEvent> WRAPPED_RIFLE_FIRE = register("item.wrapped_rifle.fire");
	
	public static final RegistryObject<SoundEvent> WRAPPED_RIFLE_COCK = register("item.wrapped_rifle.cock");

	public static final RegistryObject<SoundEvent> HELLFIRE_FIRE = register("item.hellfire.fire");
	
	public static final RegistryObject<SoundEvent> M2_FIRE = register("item.m2_flamethrower.fire");

	public static final RegistryObject<SoundEvent> FLARE_GUN_FIRE = register("item.flare_gun.fire");

	public static final RegistryObject<SoundEvent> FLARE_GUN_COCK = register("item.flare_gun.cock");

	public static final RegistryObject<SoundEvent> FLARE_GUN_RELOAD = register("item.flare_gun.reload");
	
	public static final RegistryObject<SoundEvent> TRUMPET = register("item.trumpet.doot");
	
	//Method to help us register sounds
	private static RegistryObject<SoundEvent> register(String key) {
			
		return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(Reference.MOD_ID, key)));
	        
	}

}