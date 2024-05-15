package ttv.migami.mteg.init;

import ttv.migami.mteg.Reference;
import ttv.migami.mteg.entity.FireballProjectileEntity;
import ttv.migami.mteg.entity.FlareProjectileEntity;
import ttv.migami.mteg.entity.TakiProjectileEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;

/**
 * This class is where all of the mod's entities are registered.
 */
/**
 */
public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);
	
	public static final RegistryObject<EntityType<TakiProjectileEntity>> TAKI = registerBasic("taki", TakiProjectileEntity::new);
	public static final RegistryObject<EntityType<FireballProjectileEntity>> FLAMMABLE_GEL = registerBasic("magma_cream", FireballProjectileEntity::new);
	public static final RegistryObject<EntityType<FlareProjectileEntity>> FLARE = registerBasic("flare", FlareProjectileEntity::new);
    
	/**
     * This is a helper method when registering projectiles.
     * All of the stuff in this method can be written each time we create a new projectile - but that isn't needed.
     * With this we can register things with much more ease.
     * 
     * @author Mr. Pineapple
     */
	private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function) {
		
        return ENTITIES.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id));
        
    }

}