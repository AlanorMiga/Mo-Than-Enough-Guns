package ttv.migami.mteg.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import ttv.migami.jeg.client.render.gun.IOverrideModel;
import ttv.migami.jeg.client.util.RenderUtil;
import ttv.migami.mteg.client.SpecialModels;

/**
 * Since we want to have an animation for the charging handle, we will be overriding the standard model rendering.
 * This also allows us to replace the model for the different stocks.
 */
public class M16A1Model implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext ItemDisplayContext, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {

        //Renders the static parts of the model.
        RenderUtil.renderModel(SpecialModels.M16A1.getModel(), stack, matrixStack, buffer, light, overlay);

    }

    private double ease(double x) {

        return 1 - Math.pow(1 - (2 * x), 4);

    }

}