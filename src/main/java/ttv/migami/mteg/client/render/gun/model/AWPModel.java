package ttv.migami.mteg.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.world.item.ItemDisplayContext;
import ttv.migami.jeg.client.render.gun.IOverrideModel;
import ttv.migami.jeg.client.util.RenderUtil;

import ttv.migami.mteg.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

/**
 * Since we want to have an animation for the slide, we will be overriding the standard model rendering.
 */
public class AWPModel implements IOverrideModel {

	@SuppressWarnings("resource")
	@Override
	public void render(float partialTicks, ItemDisplayContext ItemDisplayContext, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
		
		//Renders the static parts of the model.
		RenderUtil.renderModel(SpecialModels.AWP_MAIN.getModel(), stack, matrixStack, buffer, light, overlay);

        if(entity.equals(Minecraft.getInstance().player)) {

            //Always push.
            matrixStack.pushPose();
            //Don't touch this, it's better to use the display options in Blockbench.
            //Gets the cooldown tracker for the item. Items like swords and enderpearls also have this.
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) ease(cooldown);
            /**
             * We are moving whatever part is moving.
             * X,Y,Z, use Z for moving back and forth.
             * The higher the number, the shorter the distance.
             */
            if (cooldown != 0) {
                matrixStack.translate(-0.172, -0.0755, cooldown/10);
                matrixStack.mulPose(Axis.ZN.rotationDegrees(-45F));
            }
            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.AWP_BOLT.getModel(), stack, matrixStack, buffer, light, overlay);
            //Always pop
            matrixStack.popPose();
            
            //Another push/pop block because the AWP has that big block at the end of the bolt that doesn't turn.
            //Always push.
            matrixStack.pushPose();
            //Don't touch this, it's better to use the display options in Blockbench.
            /**
             * We are moving whatever part is moving.
             * X,Y,Z, use Z for moving back and forth.
             * The higher the number, the shorter the distance.
             */
            matrixStack.translate(0, 0, cooldown/10);
            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.AWP_CHAMBER.getModel(), stack, matrixStack, buffer, light, overlay);
            //Always pop
            matrixStack.popPose();

        }

    }

    private double ease(double x) {

        return 1 - Math.pow(1 - (2 * x), 4);

    }

}