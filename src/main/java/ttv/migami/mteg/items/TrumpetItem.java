package ttv.migami.mteg.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import ttv.migami.jeg.init.ModEffects;
import ttv.migami.jeg.init.ModItems;
import ttv.migami.mteg.init.ModSounds;

public class TrumpetItem extends Item {

	public TrumpetItem(Properties pProperties) {
		super(pProperties);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
		
		if(!world.isClientSide()) {
			
			HitResult result = user.pick(25, 0, false);
			Vec3 userPos = user.getEyePosition();
			Vec3 targetPos = result.getLocation();
			Vec3 distanceTo = targetPos.subtract(userPos);
			Vec3 normal = distanceTo.normalize();
			
			for(int i = 1; i < Mth.floor(distanceTo.length()) + 7; ++i) {
	               Vec3 vec33 = userPos.add(normal.scale((double)i));
	               ((ServerLevel) world).sendParticles(ParticleTypes.SONIC_BOOM, vec33.x, vec33.y, vec33.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
	        }
			
			user.getCooldowns().addCooldown(this, 40);
			
			EntityHitResult e = ProjectileUtil.getEntityHitResult(world, user, userPos, targetPos, new AABB(userPos, targetPos), this::canDamage);
			
			if(e != null && e.getEntity() instanceof LivingEntity entity) {
				
				entity.hurt(user.damageSources().sonicBoom(user), 10.0F);
		        double d1 = 0.5D * (1.0D - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
		        double d0 = 2.5D * (1.0D - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
		        entity.push(normal.x() * d0, normal.y() * d1, normal.z() * d0);
		        entity.addEffect(new MobEffectInstance(ModEffects.DEAFENED.get(), 100, 0, false, false));
		        if(entity instanceof Warden) {
		        	
		        	entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100));
		        	entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));
		        	
		        }
				
			}
			
			
			
		}
		world.playSound(user, user.blockPosition(), ModSounds.TRUMPET.get(), SoundSource.PLAYERS, 3F, 1F);

		ItemStack heldItem = user.getMainHandItem();
		if (!user.getAbilities().instabuild) {
			if (heldItem.isDamageableItem()) {
				int maxDamage = heldItem.getMaxDamage();
				int currentDamage = heldItem.getDamageValue();
				if (currentDamage >= (maxDamage - 1)) {
					if (currentDamage >= (maxDamage - 2)) {
						world.playSound(user, user.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
						//stack.shrink(1);
					}
				} else {
					heldItem.hurtAndBreak(1, user, null);
				}
			}
		}

		return InteractionResultHolder.consume(user.getItemInHand(hand));
		
	}
	
	private boolean canDamage(Entity entity) {
		
		return entity instanceof LivingEntity;
		
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		
		return 72000;
		
	}

	public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
		return pRepair.is(ModItems.REPAIR_KIT.get());
	}

}