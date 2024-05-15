package ttv.migami.mteg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import ttv.migami.mteg.Reference;

/**
 * This class will be used to register special models to be used in animations, like the drum of the grenade launcher in the default mod.
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public enum SpecialModels {

    SCAR_L("gun/scar_l"),
    SCAR_L_MAIN("scar_l/main"),
    SCAR_L_EJECTOR("scar_l/ejector"),
    SCAR_L_STOCK_LIGHT("scar_l/stock_light"),
    SCAR_L_STOCK_TACTICAL("scar_l/stock_tactical"),
    SCAR_L_STOCK_HEAVY("scar_l/stock_heavy"),

    SCAR_H("gun/scar_h"),
    SCAR_H_MAIN("scar_h/main"),
    SCAR_H_EJECTOR("scar_h/ejector"),
    SCAR_H_STOCK_LIGHT("scar_h/stock_light"),
    SCAR_H_STOCK_TACTICAL("scar_h/stock_tactical"),
    SCAR_H_STOCK_HEAVY("scar_h/stock_heavy"),

    G36C("gun/g36c"),
    G36C_MAIN("g36c/main"),
    G36C_EJECTOR("g36c/ejector"),
    G36C_STOCK_LIGHT("g36c/stock_light"),
    G36C_STOCK_TACTICAL("g36c/stock_tactical"),
    G46C_STOCK_HEAVY("g36c/stock_heavy"),

    AKM_MAIN("akm/main"),
    AKM_CHARGING_HANDLE("akm/ejector"),

    AKM_CUSTOM("gun/akm_custom"),
    AKM_CUSTOM_MAIN("akm_custom/main"),
    AKM_CUSTOM_EJECTOR("akm_custom/ejector"),
    AKM_CUSTOM_STOCK_LIGHT("akm_custom/stock_light"),
    AKM_CUSTOM_STOCK_TACTICAL("akm_custom/stock_tactical"),
    AKM_CUSTOM_STOCK_HEAVY("akm_custom/stock_heavy"),

    VSS_VINTOREZ("gun/vss_vintorez"),
    VSS_VINTOREZ_MAIN("vss_vintorez/main"),
    VSS_VINTOREZ_EJECTOR("vss_vintorez/ejector"),

    AS_VAL("gun/as_val"),
    AS_VAL_MAIN("as_val/main"),
    AS_VAL_EJECTOR("as_val/ejector"),

    THOMPSON("gun/thompson"),
    THOMPSON_MAIN("thompson/main"),
    THOMPSON_EJECTOR("thompson/ejector"),
    THOMPSON_LIGHT_GRIP("thompson/grip_light"),
    THOMPSON_SPECIALISED_GRIP("thompson/grip_specialised"),

    FAMAS("gun/famas"),
    FAMAS_MAIN("famas/main"),
    FAMAS_EJECTOR("famas/ejector"),

    M1_GARAND("gun/m1_garand"),
    M1_GARAND_MAIN("m1_garand/main"),
    M1_GARAND_EJECTOR("m1_garand/ejector"),

    GLOCK_17("gun/glock_17"),
    GLOCK_17_MAIN("glock_17/main"),
    GLOCK_17_SLIDE("glock_17/slide"),

    REMINGTON_870("gun/remington_870"),
    REMINGTON_870_MAIN("remington_870/main"),
    REMINGTON_870_PUMP("remington_870/pump"),

    MOSSBERG_590("gun/mossberg_590"),
    MOSSBERG_MAIN_590("mossberg_590/main"),
    MOSSBERG_PUMP_590("mossberg_590/pump"),

    BENELLI_M4("gun/benelli_m4"),
    BENELLI_M4_MAIN("benelli_m4/main"),
    BENELLI_M4_PUMP("benelli_m4/pump"),
    BENELLI_M4_STOCK_LIGHT("benelli_m4/stock_light"),
    BENELLI_M4_STOCK_TACTICAL("benelli_m4/stock_tactical"),
    BENELLI_M4_STOCK_HEAVY("benelli_m4/stock_heavy"),

    M14("gun/m14"),
    M14_MAIN("m14/main"),
    M14_EJECTOR("m14/ejector"),

    M1911("gun/m1911"),
    M1911_MAIN("m1911/main"),
    M1911_CHAMBER("m1911/slide"),

    M14_EBR("gun/m14_ebr"),
    M14_EBR_MAIN("m14_ebr/main"),
    M14_EBR_CHARGING_HANDLE("m14_ebr/ejector"),
    M14_EBR_STOCK_LIGHT("m14_ebr/stock_light"),
    M14_EBR_STOCK_TACTICAL("m14_ebr/stock_tactical"),
    M14_EBR_STOCK_HEAVY("m14_ebr/stock_heavy"),

    WALTHER_PPK("gun/walther_ppk"),
    WALTHER_PPK_MAIN("walther_ppk/main"),
    WALTHER_PPK_SLIDE("walther_ppk/slide"),

    WELROD("gun/welrod"),
    WELROD_MAIN("welrod/main"),
    WELROD_BOLT("welrod/bolt"),

    LANCHESTER("gun/lanchester"),
    LANCHESTER_MAIN("lanchester/main"),
    LANCHESTER_EJECTOR("lanchester/ejector"),

    PPSH_41("gun/ppsh_41"),
    PPSH_41_MAIN("ppsh_41/main"),
    PPSH_41_EJECTOR("ppsh_41/ejector"),

    WRAPPED_RIFLE("gun/wrapped_rifle"),
    WRAPPED_RIFLE_MAIN("wrapped_rifle/main"),
    WRAPPED_RIFLE_CHAMBER("wrapped_rifle/ejector"),

    HELLFIRE("gun/hellfire"),
    HELLFIRE_MAIN("hellfire/main"),
    HELLFIRE_SLIDE("hellfire/ejector"),
    LIGHT_HELLFIRE_STOCK("hellfire/stock_light"),
    TACTICAL_HELLFIRE_STOCK("hellfire/stock_tactical"),
    HEAVY_HELLFIRE_STOCK("hellfire/stock_heavy"),

    BLUE_HEAT("gun/blue_heat"),
    BLUE_HEAT_MAIN("blue_heat/main"),
    BLUE_HEAT_SLIDE("blue_heat/ejector"),
    LIGHT_BLUE_HEAT_STOCK("blue_heat/stock_light"),
    TACTICAL_BLUE_HEAT_STOCK("blue_heat/stock_tactical"),
    HEAVY_BLUE_HEAT_STOCK("blue_heat/stock_heavy"),

    HOG_BONKER("gun/hog_bonker"),
    HOG_BONKER_MAIN("hog_bonker/main"),
    HOG_BONKER_BARRELS("hog_bonker/barrels"),

    AWP("gun/awp"),
    AWP_MAIN("awp/main"),
    AWP_BOLT("awp/bolt"),
    AWP_CHAMBER("awp/ejector"),

    DOUBLE_BARREL("gun/double_barrel"),
    DOUBLE_BARREL_MAIN("double_barrel/main"),
    DOUBLE_BARREL_BARRELS("double_barrel/barrels"),

    BAKER_RIFLE("gun/baker_rifle"),

    MP5("gun/mp5"),

    FLARE_GUN("gun/flare_gun"),

    UZI("gun/uzi"),

    MICRO_UZI("gun/micro_uzi"),

    M16A1("gun/m16a1"),

    M2_FLAMETHROWER("gun/m2_flamethrower"),

    FLAMER("gun/flamer");

    //Variables
    private final ResourceLocation modelLocation;
    private BakedModel cachedModel;

    SpecialModels(String modelName) {
        this.modelLocation = new ResourceLocation(Reference.MOD_ID, "special/" + modelName);
    }

    public BakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }

    @SubscribeEvent
    public static void registerAdditional(ModelEvent.RegisterAdditional event)
    {
        for(SpecialModels model : values())
        {
            event.register(model.modelLocation);
        }
    }

    @SubscribeEvent
    public static void onBake(ModelEvent.BakingCompleted event)
    {
        for(SpecialModels model : values())
        {
            model.cachedModel = null;
        }
    }

}