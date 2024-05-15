package ttv.migami.mteg.event;

import ttv.migami.jeg.event.GunFireEvent.Post;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.init.ModItems;
import ttv.migami.mteg.init.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Adds a ping sound when the Garand is empty
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GarandPingEvent {
	
    @SubscribeEvent
    public static void postShoot(Post event) {
    	
        Player player = (Player) event.getEntity();
        ItemStack heldItem = player.getMainHandItem();
        CompoundTag tag = heldItem.getTag();
        
        if (heldItem.getItem() == ModItems.M1_GARAND.get() && tag != null) {
        	
            if (tag.getInt("AmmoCount") == 1)
                event.getEntity().level.playSound(player, player.blockPosition(), ModSounds.GARAND_PING.get(), SoundSource.MASTER, 3.0F, 1.0F);
            
        }
        
    }
    
}