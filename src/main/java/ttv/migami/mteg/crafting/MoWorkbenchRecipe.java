package ttv.migami.mteg.crafting;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import ttv.migami.jeg.crafting.ScrapWorkbenchIngredient;
import ttv.migami.jeg.util.InventoryUtil;
import ttv.migami.mteg.blockentity.MoWorkbenchBlockEntity;
import ttv.migami.mteg.init.ModRecipeSerializers;
import ttv.migami.mteg.init.ModRecipeTypes;

/**
 * Author: MrCrayfish
 */
public class MoWorkbenchRecipe implements Recipe<MoWorkbenchBlockEntity>
{
    private final ResourceLocation id;
    private final ItemStack item;
    private final ImmutableList<ScrapWorkbenchIngredient> materials;

    public MoWorkbenchRecipe(ResourceLocation id, ItemStack item, ImmutableList<ScrapWorkbenchIngredient> materials)
    {
        this.id = id;
        this.item = item;
        this.materials = materials;
    }

    public ItemStack getItem()
    {
        return this.item.copy();
    }

    public ImmutableList<ScrapWorkbenchIngredient> getMaterials()
    {
        return this.materials;
    }

    @Override
    public boolean matches(MoWorkbenchBlockEntity inv, Level worldIn)
    {
        return false;
    }

    @Override
    public ItemStack assemble(MoWorkbenchBlockEntity entity)
    {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return true;
    }

    @Override
    public ItemStack getResultItem()
    {
        return this.item.copy();
    }

    @Override
    public ResourceLocation getId()
    {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.MO_WORKBENCH.get();
    }

    @Override
    public net.minecraft.world.item.crafting.RecipeType<?> getType()  { return ModRecipeTypes.MO_WORKBENCH.get(); }

    public boolean hasMaterials(Player player)
    {
        for(ScrapWorkbenchIngredient ingredient : this.getMaterials())
        {
            if(!InventoryUtil.hasWorkstationIngredient(player, ingredient))
            {
                return false;
            }
        }
        return true;
    }

    public void consumeMaterials(Player player)
    {
        for(ScrapWorkbenchIngredient ingredient : this.getMaterials())
        {
            InventoryUtil.removeWorkstationIngredient(player, ingredient);
        }
    }
}
