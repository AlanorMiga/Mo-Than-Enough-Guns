package ttv.migami.mteg.init;

import net.minecraft.world.item.crafting.RecipeType;
import ttv.migami.mteg.crafting.MoWorkbenchRecipe;

/**
 * Author: MrCrayfish
 */
public class ModRecipeTypes {

    public static final RecipeType<MoWorkbenchRecipe> MO_WORKBENCH = RecipeType.register("jeg:mo_workbench");

    // Does nothing but trigger loading of static fields
    public static void init() {
    }
}
