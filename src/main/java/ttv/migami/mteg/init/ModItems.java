package ttv.migami.mteg.init;

import ttv.migami.jeg.item.AmmoItem;
import ttv.migami.jeg.item.GunItem;

import ttv.migami.mteg.MoThanEnoughGuns;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.items.TrumpetItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * This class is where all of the mod's items are registered.
 */
public class ModItems {
	
	/*
     * This creates a Deferred Register where all of the items will be registered
     * This is called and added to the event bus in the main mod file.
     */
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Reference.MOD_ID);
	
	//Gun Items
	public static final RegistryObject<GunItem> SCAR_L = ITEMS.register("scar_l", 
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384)
					.tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> SCAR_H = ITEMS.register("scar_h",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> G36C = ITEMS.register("g36c",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> AKM = ITEMS.register("akm",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> AS_VAL = ITEMS.register("as_val",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> THOMPSON = ITEMS.register("thompson",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(426).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> M16A1 = ITEMS.register("m16a1",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> FAMAS = ITEMS.register("famas",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> M1_GARAND = ITEMS.register("m1_garand",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> AKM_CUSTOM = ITEMS.register("akm_custom",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> AWP = ITEMS.register("awp",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> BENELLI_M4 = ITEMS.register("benelli_m4",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> GLOCK_17 = ITEMS.register("glock_17",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> M14 = ITEMS.register("m14",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> M14_EBR = ITEMS.register("m14_ebr",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> M1911 = ITEMS.register("m1911",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> MOSSBERG_590 = ITEMS.register("mossberg_590",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> REMINGTON_870 = ITEMS.register("remington_870",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> VSS_VINTOREZ = ITEMS.register("vss_vintorez",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> WALTHER_PPK = ITEMS.register("walther_ppk",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(256).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> UZI = ITEMS.register("uzi",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> WELROD = ITEMS.register("welrod",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> BAKER = ITEMS.register("baker_rifle",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> LANCHESTER = ITEMS.register("lanchester",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> MP5 = ITEMS.register("mp5",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> PPSH = ITEMS.register("ppsh_41",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> MICRO_UZI = ITEMS.register("micro_uzi",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> DOUBLE_BARREL = ITEMS.register("double_barrel",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> WRAPPED_RIFLE = ITEMS.register("wrapped_rifle",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> HELLFIRE = ITEMS.register("hellfire",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> BLUE_HEAT = ITEMS.register("blue_heat",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(384).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> HOG_BONKER = ITEMS.register("hog_bonker",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> M2_FLAMETHROWER = ITEMS.register("m2_flamethrower",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(512).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> FLAMER = ITEMS.register("flamer",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(512).tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> FLARE_GUN = ITEMS.register("flare_gun",
			() -> new GunItem(new Item.Properties().stacksTo(1).durability(128).tab(MoThanEnoughGuns.GROUP)));

	/*public static final RegistryObject<GunItem> GLOCKEST_GLOCK = ITEMS.register("glockest_glock",
			() -> new GunItem(new Item.Properties().tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> BIG_IRON = ITEMS.register("big_iron",
			() -> new GunItem(new Item.Properties().tab(MoThanEnoughGuns.GROUP)));

	public static final RegistryObject<GunItem> TRASHCAN = ITEMS.register("trashcan",
			() -> new GunItem(new Item.Properties().tab(MoThanEnoughGuns.GROUP)));*/

	//Ammo Items
	public static final FoodProperties TAKI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1), 1.0F).fast().build();

	public static final RegistryObject<Item> AMMO_TAKI = ITEMS.register("taki",
			() -> new AmmoItem(new Item.Properties().tab(MoThanEnoughGuns.GROUP).food(TAKI)));

	public static final RegistryObject<Item> FLARE = ITEMS.register("flare",
			() -> new AmmoItem(new Item.Properties().stacksTo(8).tab(MoThanEnoughGuns.GROUP)));

	//Misc Items
	public static final RegistryObject<TrumpetItem> TRUMPET = ITEMS.register("trumpet",
			() -> new TrumpetItem(new Item.Properties().stacksTo(1).durability(64).tab(MoThanEnoughGuns.GROUP)));

}