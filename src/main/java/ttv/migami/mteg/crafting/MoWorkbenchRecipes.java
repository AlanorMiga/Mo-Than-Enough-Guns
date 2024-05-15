package ttv.migami.mteg.crafting;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import ttv.migami.mteg.init.ModRecipeTypes;

import javax.annotation.Nullable;
import java.util.stream.Collectors;

/**
 * Author: MrCrayfish
 */
public class MoWorkbenchRecipes
{
    public static boolean isEmpty(Level world)
    {
        return world.getRecipeManager().getRecipes().stream().noneMatch(recipe -> recipe.getType() == ModRecipeTypes.MO_WORKBENCH.get());
    }

    public static NonNullList<MoWorkbenchRecipe> getAll(Level world)
    {
        return world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == ModRecipeTypes.MO_WORKBENCH.get())
                .map(recipe -> (MoWorkbenchRecipe) recipe)
                .collect(Collectors.toCollection(NonNullList::create));
    }

    @Nullable
    public static MoWorkbenchRecipe getRecipeById(Level world, ResourceLocation id)
    {
        return world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == ModRecipeTypes.MO_WORKBENCH.get())
                .map(recipe -> (MoWorkbenchRecipe) recipe)
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst().orElse(null);
    }
}
