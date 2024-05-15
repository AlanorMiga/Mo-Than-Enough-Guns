package ttv.migami.mteg.datagen;

import net.minecraft.world.item.Items;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.init.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import ttv.migami.jeg.common.*;
import ttv.migami.jeg.init.ModItems;

/**
 * Author: MrCrayfish
 */
public class GunGen extends GunProvider
{
    public GunGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected void registerGuns()
    {

        this.addGun(new ResourceLocation(Reference.MOD_ID, "scar_l"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(4)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(4.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(30)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(8.0F)
                .setAdvantage(ModTags.Entities.HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(16F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.SCAR_L_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.SCAR_L_COCK.get())
                .setSilencedFireSound(ModSounds.SCAR_L_FIRE_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.6, -6.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.2, 2.75))
                .setScope(1.5F, 0.0, 4.5, 4.5)
                .setBarrel(1.5F, 0.0, 3.6, -10.0)
                .setStock(0.0F, 0.0, -6.0, -1.0)
                .setUnderBarrel(1.5F, 0.0, 2.0, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "scar_h"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(5)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.35F)
                .setRecoilAngle(5.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(9.0F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(26F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.SCAR_L_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.SCAR_L_COCK.get())
                .setSilencedFireSound(ModSounds.SCAR_L_FIRE_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.6, -9.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.2, 2.75))
                .setScope(1.5F, 0.0, 4.5, 4.5)
                .setBarrel(1.5F, 0.0, 3.6, -10.0)
                .setStock(0.0F, 0.0, -6.0, -1.0)
                .setUnderBarrel(1.5F, 0.0, 2.0, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "g36c"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(2)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(3.0F)
                .setAlwaysSpread(true)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(30)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(6.0F)
                .setAdvantage(ModTags.Entities.HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(18F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.G36C_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.G36C_COCK.get())
                .setSilencedFireSound(ModSounds.G36C_FIRE_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.6, -6.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.9, 2.75))
                .setScope(1.5F, 0.0, 5.1, 3.75)
                .setBarrel(1.5F, 0.0, 3.6, -10.0)
                .setStock(0.0F, 0.0, 0.0, 0.0)
                .setUnderBarrel(1.5F, 0.0, 2.0, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "akm"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(4)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(3.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(40)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(9.5F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(26F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.AKM_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.AKM_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, -8.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.9, 2.75))
                .setScope(1.5F, 0.0, 4.3, 4.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "akm_custom"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(3.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(30)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(8F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(26F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.AKM_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.AKM_COCK.get())
                .setSilencedFireSound(ModSounds.SCAR_L_FIRE_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, -8.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.9, 2.75))
                .setScope(1.5F, 0.0, 4.3, 4.0)
                .setBarrel(1.5F, 0.0, 2.85, -12.0)
                .setStock(0.0F, 0.0, 0.0, 0.0)
                .setUnderBarrel(1.5F, 0.0, 1.7, -2.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "vss_vintorez"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(6)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(10)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(10F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.AS_VAL_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.AS_VAL_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.6, -8.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.35, 2.75))
                .setScope(1.5F, 0.0, 3.7, 5.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "as_val"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(4)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(1.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(8F)
                .setAdvantage(ModTags.Entities.HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.AS_VAL_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.AS_VAL_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.6, -8.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.35, 2.75))
                .setScope(1.5F, 0.0, 3.7, 5.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "thompson"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(2)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.15F)
                .setRecoilAngle(3.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(6F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(16F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.THOMPSON_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.THOMPSON_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.6, -6.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.65, 2.75))
                //.setBarrel(1.5F, 0.0, 3.6, -10.0)
                .setUnderBarrel(0F, 0.0, 0.0, 0.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "famas"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.BURST)
                .setBurstAmount(3)
                .setFireRate(2)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.15F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(true)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(25)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(8.0F)
                .setAdvantage(ModTags.Entities.HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(16F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.FAMAS_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.FAMAS_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.5, -6)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.8, 2.75))
                .setScope(1.5F, 0.0, 5.4, 4)
                .setUnderBarrel(1.5F, 0.0, 1.6, 1.2)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "m1_garand"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.35F)
                .setRecoilAngle(3.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(8)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(20)
                .setEmptyMagTimer(0)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(13F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.GARAND_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.GARAND_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, -11.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.3, 2.75))
                .setScope(1.5F, 0.0, 3.2, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "glock_17"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(3)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(false)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(17)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(6F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.GLOCK_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.GLOCK_COCK.get())
                .setSilencedFireSound(ModSounds.GLOCK_FIRE_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, 1.5)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.7F)
                        .setOffset(0.0, 3.7, 0.0))
                .setBarrel(1.5F, 0.0, 2.9, -3.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "remington_870"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(20)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(14.0F)
                .setAlwaysSpread(false)
                .setSpread(1.0F)

                // Reloads
                .setMaxAmmo(6)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ModItems.SHOTGUN_SHELL.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(18F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.REMINGTON_870_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.REMINGTON_870_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 4.0, -13)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.4, 2.75))
                .setScope(1.5F, 0.0, 3.9, 4.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "mossberg_590"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(17)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(12.0F)
                .setAlwaysSpread(true)
                .setSpread(8.0F)

                // Reloads
                .setMaxAmmo(8)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ModItems.SHOTGUN_SHELL.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(22F)
                .setProjectileAmount(8)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(8)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.MOSSBERG_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.MOSSBERG_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 4.0, -13)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.4, 2.75))
                .setScope(1.5F, 0.0, 4.0, 4.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "benelli_m4"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(15)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(10.0F)
                .setAlwaysSpread(true)
                .setSpread(10.0F)

                // Reloads
                .setMaxAmmo(8)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ModItems.SHOTGUN_SHELL.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(20F)
                .setProjectileAmount(6)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(8)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.BENELLI_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.BENELLI_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 4.0, -13)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.6, 2.75))
                .setScope(1.5F, 0.0, 4.3, 2.2)
                .setBarrel(1.5F, 0.0, 3.7, -15.5)
                .setStock(0F, 0.0, 0.0, 0.0)
                .setUnderBarrel(1.5F, 0.0, 1.5, -2.3)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "m14"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(6)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.35F)
                .setRecoilAngle(4.0F)
                .setAlwaysSpread(false)
                .setSpread(1.8F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(15F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.GARAND_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.GARAND_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, -11.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 3.85, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "m1911"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(4)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(false)
                .setSpread(4.0F)

                // Reloads
                .setMaxAmmo(7)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(8F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.M1911_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M1911_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3, 1.5)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.7F)
                        .setOffset(0.0, 3.7, 0.0))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "m14_ebr"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.35F)
                .setRecoilAngle(4.0F)
                .setAlwaysSpread(false)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(16.5F)
                .setAdvantage(ModTags.Entities.VERY_HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.M14_EBR_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M14_EBR_COCK.get())
                .setSilencedFireSound(ModSounds.SCAR_L_FIRE_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, -11.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.15, 2.75))
                .setScope(1.5F, 0.0, 3.9, 2.4)
                .setBarrel(1.5F, 0.0, 3.1, -16.0)
                .setStock(0, 0.0, 0.0, 0.0)
                .setUnderBarrel(1.5F, 0.0, 1.5, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "walther_ppk"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(3)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(1.0F)
                .setAlwaysSpread(false)
                .setSpread(4.0F)

                // Reloads
                .setMaxAmmo(6)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(5.5F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.M1911_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M1911_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3, 1.5)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.7F)
                        .setOffset(0.0, 3.7, 0.0))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "welrod"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(30)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.3F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(true)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(5)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(10F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.M1911_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M1911_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3, 0)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 3.7, 0.0))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "lanchester"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(4.0F)
                .setAlwaysSpread(true)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(32)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(6.5F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.LANCHESTER_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.LANCHESTER_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3.2, -4)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.0, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "ppsh_41"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(1)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(2.5F)
                .setAlwaysSpread(true)
                .setSpread(4.0F)

                // Reloads
                .setMaxAmmo(71)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(4.5F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.PPSH_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.PPSH_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 3, -6.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 3.95, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "wrapped_rifle"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(1.0F)
                .setAlwaysSpread(true)
                .setSpread(1.0F)

                // Reloads
                .setMaxAmmo(40)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(Items.GLASS_PANE)
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(2.5F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(7F)
                .setProjectileLife(100)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(true)

                // Sounds
                .setFireSound(ModSounds.WRAPPED_RIFLE_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.WRAPPED_RIFLE_COCK.get())

                // Attachments
                .setMuzzleFlash(0.8, 0.0, 2.9, -8.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.9, 2.75))
                .setScope(1.5F, 0.0, 4.3, 4.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "awp"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(34)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(3.5F)
                .setAlwaysSpread(false)
                .setSpread(0.0F)

                // Reloads
                .setMaxAmmo(10)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(20F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.AWP_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.AWP_BOLT.get())
                .setSilencedFireSound(ModSounds.AWP_SUPPRESSED.get())

                // Attachments
                .setMuzzleFlash(2, 0.0, 3.6, -15)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.05, 2.75))
                .setScope(1.5F,0.0, 4.5, 2.5)
                .setBarrel(1.5F,0.0, 3.85, -18.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "hellfire"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(2)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(4.0F)
                .setAlwaysSpread(true)
                .setSpread(6.0F)

                // Reloads
                .setMaxAmmo(18)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(20)

                // Projectile
                .setAmmo(ttv.migami.mteg.init.ModItems.AMMO_TAKI.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(3.0F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(7F)
                .setProjectileLife(100)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.HELLFIRE_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M16A1_COCK.get())

                // Attachments
                .setMuzzleFlash(1.0, 0.0, 2.9, -8.41)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.8, 2.75))
                .setStock(0F, 0.0, 0.0, 0.0)
                .setUnderBarrel(0F, 0.0, 1.0, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "blue_heat"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(4.0F)
                .setAlwaysSpread(false)
                .setSpread(5.0F)

                // Reloads
                .setMaxAmmo(22)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ttv.migami.mteg.init.ModItems.AMMO_TAKI.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(5.0F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(7F)
                .setProjectileLife(100)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.HELLFIRE_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.AKM_COCK.get())

                // Attachments
                .setMuzzleFlash(1.0, 0.0, 3.5, -7)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 4.9, 2.75))
                .setScope(1.5F, 0.0, 4.4, 4.0)
                .setStock(0F, 0.0, 0.0, 0.0)
                .setUnderBarrel(0F, 0.0, 1.6, -0.3)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "double_barrel"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(2)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(7.0F)
                .setAlwaysSpread(true)
                .setSpread(25.0F)
                .setProjectileAmount(6)

                // Reloads
                .setMaxAmmo(2)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ModItems.SHOTGUN_SHELL.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(23F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(55)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.REMINGTON_870_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.REMINGTON_870_COCK.get())

                // Attachments
                .setMuzzleFlash(1.0, 0.0, 3.0, -7)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 3.4, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "hog_bonker"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(1)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(10.0F)
                .setAlwaysSpread(true)
                .setSpread(25.0F)
                .setProjectileAmount(12)

                // Reloads
                .setMaxAmmo(2)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ModItems.SHOTGUN_SHELL.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(26F)
                .setProjectileSize(0.05F)
                .setProjectileSpeed(20F)
                .setProjectileLife(55)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.MOSSBERG_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.REMINGTON_870_COCK.get())

                // Attachments
                .setMuzzleFlash(1.0, 0.0, 3.0, -2)
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 3.4, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "baker_rifle"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(17)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.55F)
                .setRecoilAngle(7.0F)
                .setAlwaysSpread(true)
                .setSpread(4.0F)

                // Reloads
                .setMaxAmmo(1)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(100)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(18.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(30.0F)
                .setProjectileLife(50)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.BAKER_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.BAKER_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.4, -12)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 3.9, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "m16a1"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(3)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.15F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(7.5F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(30.0F)
                .setProjectileLife(100)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.M16A1_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M16A1_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.5, -12)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 6.25, 2.75))

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "mp5"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(2)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(30)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(6.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(30.0F)
                .setProjectileLife(100)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds
                .setFireSound(ModSounds.MP5_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.MP5_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.6, -6.41)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.45, 2.75))
                .setScope(1.0F, 0.0, 4.7, 4.75)
                .setUnderBarrel(1.0F, 0.0, 2.799, -1.0)

                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "uzi"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(3)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.5F)
                .setRecoilAngle(1.0F)
                .setAlwaysSpread(true)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(32)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(5.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(30.0F)
                .setProjectileLife(30)

                // Sounds
                .setFireSound(ModSounds.UZI_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.MP5_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.0, -1.0)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.7F)
                        .setOffset(0.0, 4.0, 1.75))
                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "micro_uzi"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(1)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.3F)
                .setRecoilAngle(2.0F)
                .setAlwaysSpread(true)
                .setSpread(2.0F)

                // Reloads
                .setMaxAmmo(20)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.PISTOL_AMMO.get())
                .setEjectsCasing(false)
                .setProjectileVisible(false)
                .setDamage(3.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(30.0F)
                .setProjectileLife(30)

                // Sounds
                .setFireSound(ModSounds.UZI_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.MP5_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.0, 0.5)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.7F)
                        .setOffset(0.0, 4.2, 1.75))
                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "flare_gun"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(100)
                .setGripType(GripType.ONE_HANDED)
                .setRecoilKick(0.35F)
                .setRecoilAngle(3.0F)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(1)
                .setReloadType(ReloadType.MANUAL)
                .setReloadAmount(1)

                // Projectile
                .setAmmo(ttv.migami.mteg.init.ModItems.FLARE.get())
                .setProjectileVisible(false)
                .setDamage(2.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(3.0F)
                .setProjectileAffectedByGravity(true)
                .setProjectileLife(100)

                // Sounds
                .setFireSound(ModSounds.FLARE_GUN_FIRE.get())
                .setReloadSound(ModSounds.FLARE_GUN_RELOAD.get())
                .setCockSound(ModSounds.FLARE_GUN_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.0, 3.0)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.7F)
                        .setOffset(0.0, 3.7, 2.75))
                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "flamer"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(1)
                .setGripType(GripType.MINI_GUN)
                .setRecoilKick(0.25F)
                .setRecoilAngle(1.0F)
                .setProjectileAmount(2)
                .setAlwaysSpread(true)
                .setSpread(3.0F)

                // Reloads
                .setMaxAmmo(75)
                .setReloadType(ReloadType.SINGLE_ITEM)
                .setReloadItem(Items.LAVA_BUCKET)
                .setReloadTimer(100)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(Items.MAGMA_CREAM)
                .setProjectileVisible(false)
                .setDamage(2.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(2.0F)
                .setProjectileAffectedByGravity(true)
                .setProjectileLife(200)

                // Sounds
                .setFireSound(ModSounds.M2_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M16A1_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 2.0, -10.0)
                .build());

        this.addGun(new ResourceLocation(Reference.MOD_ID, "m2_flamethrower"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.AUTOMATIC)
                .setFireRate(1)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(0.25F)
                .setRecoilAngle(1.0F)
                .setProjectileAmount(3)
                .setAlwaysSpread(true)
                .setSpread(20.0F)

                // Reloads
                .setMaxAmmo(75)
                .setReloadType(ReloadType.SINGLE_ITEM)
                .setReloadItem(Items.LAVA_BUCKET)
                .setReloadTimer(100)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(Items.MAGMA_CREAM)
                .setProjectileVisible(false)
                .setDamage(2.0F)
                .setProjectileSize(0.2F)
                .setProjectileSpeed(2.0F)
                .setProjectileLife(10)

                // Sounds
                .setFireSound(ModSounds.M2_FIRE.get())
                .setReloadSound(ttv.migami.jeg.init.ModSounds.ITEM_PISTOL_RELOAD.get())
                .setCockSound(ModSounds.M16A1_COCK.get())

                // Display
                .setMuzzleFlash(1.0, 0.0, 3.5, -8.0)

                // Modules
                .setZoom(Gun.Modules.Zoom.builder()
                        .setFovModifier(0.6F)
                        .setOffset(0.0, 5.8, 2.75))
                .setScope(1.0F, 0.0, 4.5, 4.0)

                .build());

    }
}

