package ttv.migami.mteg.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import ttv.migami.jeg.client.render.gun.IOverrideModel;
import ttv.migami.jeg.client.util.RenderUtil;
import ttv.migami.jeg.common.Gun;
import ttv.migami.mteg.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class DoubleBarrelModel implements IOverrideModel {

	@SuppressWarnings("resource")
	@Override
	public void render(float partialTicks, TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
		
		//Renders the static parts of the model.
		RenderUtil.renderModel(SpecialModels.DOUBLE_BARREL_MAIN.getModel(), stack, matrixStack, buffer, light, overlay);
		
		if(entity.equals(Minecraft.getInstance().player)) {

            //Always push
            matrixStack.pushPose();
            //Gets the cooldown tracker for the item. Items like swords and enderpearls also have this.
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());

            if(Gun.hasAmmo(stack))
                matrixStack.translate(0, 0, 0.1f * (-4.5 * Math.pow(cooldown-0.5, 2) + 1.125));
            else if(!Gun.hasAmmo(stack)) {

                if(cooldown > 0.5)
                    matrixStack.mulPose(Vector3f.XN.rotationDegrees(45F));
                else
                    matrixStack.translate(0, -0.35f, -0.175);
                    matrixStack.mulPose(Vector3f.XN.rotationDegrees(45F));

            }

            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.DOUBLE_BARREL_BARRELS.getModel(), stack, matrixStack, buffer, light, overlay);
            //Always pop
            matrixStack.popPose();
            
        }
		
	}

}