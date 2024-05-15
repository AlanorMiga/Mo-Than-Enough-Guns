package ttv.migami.mteg.init;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.crafting.MoWorkbenchRecipeSerializer;

/**
 * Author: MrCrayfish
 */
public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MOD_ID);

    public static final RegistryObject<MoWorkbenchRecipeSerializer> MO_WORKBENCH = REGISTER.register("mo_workbench", MoWorkbenchRecipeSerializer::new);
}