package ttv.migami.mteg.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import ttv.migami.jeg.client.render.gun.IOverrideModel;
import ttv.migami.jeg.client.util.RenderUtil;
import ttv.migami.mteg.client.SpecialModels;

public class PPSH41Model implements IOverrideModel {
	
	@SuppressWarnings("resource")
	@Override
	public void render(float partialTicks, ItemDisplayContext ItemDisplayContext, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
		
		//Renders the static parts of the model.
		RenderUtil.renderModel(SpecialModels.PPSH_41_MAIN.getModel(), stack, matrixStack, buffer, light, overlay);
		
		if(entity.equals(Minecraft.getInstance().player)) {
			
			//Always push.
            matrixStack.pushPose();
            //Don't touch this, it's better to use the display options in Blockbench.
            matrixStack.translate(0, -5.8 * 0.0625, 0);
            //Gets the cooldown tracker for the item. Items like swords and enderpearls also have this.
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            /**
             * We are moving whatever part is moving.
             * X,Y,Z, use Z for moving back and forth.
             * The higher the number, the shorter the distance.
             */
            matrixStack.translate(0, 0, -cooldown/8);
            matrixStack.translate(0, 5.8 * 0.0625, 0);
            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.PPSH_41_EJECTOR.getModel(), stack, matrixStack, buffer, light, overlay);
            //Always pop
            matrixStack.popPose();
			
		}
		
	}

}