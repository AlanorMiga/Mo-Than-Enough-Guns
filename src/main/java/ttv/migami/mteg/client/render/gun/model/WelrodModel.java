package ttv.migami.mteg.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import ttv.migami.jeg.client.render.gun.IOverrideModel;
import ttv.migami.jeg.client.util.RenderUtil;

import ttv.migami.mteg.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

/**
 * Since we want to have an animation for the bolt, we will be overriding the standard model rendering.
 */
public class WelrodModel implements IOverrideModel {
	
	@SuppressWarnings("resource")
	@Override
	public void render(float partialTicks, TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
		
		//Renders the static parts of the model.
		RenderUtil.renderModel(SpecialModels.WELROD_MAIN.getModel(), stack, matrixStack, buffer, light, overlay);
		
		if(entity.equals(Minecraft.getInstance().player)) {

            //Always push
            matrixStack.pushPose();
            //Don't touch this, it's better to use the display options in Blockbench.
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            
            if (cooldown != 0 && cooldown < 0.86) {
            	
                matrixStack.translate(-0.225, -0.0975, 0);
                matrixStack.mulPose(Vector3f.ZN.rotationDegrees(-45F));
                
                if (cooldown < 0.74 && cooldown > 0.42)
                	matrixStack.translate(0, 0, (-cooldown+0.74)/4);
                if (cooldown < 0.42 && cooldown > 0.07)
                	matrixStack.translate(0, 0, (cooldown-0.07)/4);
                
            }
            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.WELROD_BOLT.getModel(), stack, matrixStack, buffer, light, overlay);
            //Always pop
            matrixStack.popPose();
            
        }
		
	}

}