package ttv.migami.mteg.client.screen;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.opengl.GL11;
import ttv.migami.jeg.client.screen.CheckBox;
import ttv.migami.jeg.client.util.RenderUtil;
import ttv.migami.jeg.common.NetworkGunManager;
import ttv.migami.jeg.crafting.ScrapWorkbenchIngredient;
import ttv.migami.jeg.init.ModItems;
import ttv.migami.jeg.item.GunItem;
import ttv.migami.jeg.item.IAmmo;
import ttv.migami.jeg.item.IColored;
import ttv.migami.jeg.item.attachment.IAttachment;
import ttv.migami.jeg.util.InventoryUtil;
import ttv.migami.mteg.blockentity.MoWorkbenchBlockEntity;
import ttv.migami.mteg.common.container.MoWorkbenchContainer;
import ttv.migami.mteg.crafting.MoWorkbenchRecipe;
import ttv.migami.mteg.crafting.MoWorkbenchRecipes;
import ttv.migami.mteg.init.ModBlocks;
import ttv.migami.mteg.network.PacketHandler;
import ttv.migami.mteg.network.message.C2SMessageCraft;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: MrCrayfish
 */
public class MoWorkbenchScreen extends AbstractContainerScreen<MoWorkbenchContainer>
{
    private static final ResourceLocation GUI_BASE = new ResourceLocation("jeg:textures/gui/workbench.png");
    private static boolean showRemaining = false;

    private MoWorkbenchScreen.Tab currentTab;
    private final List<MoWorkbenchScreen.Tab> tabs = new ArrayList<>();
    private final List<MoWorkbenchScreen.MaterialItem> materials;
    private List<MoWorkbenchScreen.MaterialItem> filteredMaterials;
    private final Inventory playerInventory;
    private final MoWorkbenchBlockEntity workbench;
    private Button btnCraft;
    private CheckBox checkBoxMaterials;
    private ItemStack displayStack;

    public MoWorkbenchScreen(MoWorkbenchContainer container, Inventory playerInventory, Component title)
    {
        super(container, playerInventory, title);
        this.playerInventory = playerInventory;
        this.workbench = container.getWorkbench();
        this.imageWidth = 275;
        this.imageHeight = 184;
        this.materials = new ArrayList<>();
        this.createTabs(MoWorkbenchRecipes.getAll(playerInventory.player.level));
        if(!this.tabs.isEmpty())
        {
            this.imageHeight += 28;
        }
    }

    private void createTabs(NonNullList<MoWorkbenchRecipe> recipes)
    {
        List<MoWorkbenchRecipe> weapons = new ArrayList<>();
        List<MoWorkbenchRecipe> attachments = new ArrayList<>();
        List<MoWorkbenchRecipe> ammo = new ArrayList<>();
        List<MoWorkbenchRecipe> stations = new ArrayList<>();
        List<MoWorkbenchRecipe> misc = new ArrayList<>();

        for(MoWorkbenchRecipe recipe : recipes)
        {
            ItemStack output = recipe.getItem();
            if(output.getItem() instanceof GunItem)
            {
                weapons.add(recipe);
            }
            else if(output.getItem() instanceof IAttachment)
            {
                attachments.add(recipe);
            }
            else if(this.isAmmo(output))
            {
                ammo.add(recipe);
            }
            else if(output.getItem() instanceof BlockItem)
            {
                stations.add(recipe);
            }
            else
            {
                misc.add(recipe);
            }
        }

        if(!weapons.isEmpty())
        {
            ItemStack icon = new ItemStack(ttv.migami.mteg.init.ModItems.SCAR_L.get());
            icon.getOrCreateTag().putInt("AmmoCount", ttv.migami.mteg.init.ModItems.SCAR_L.get().getGun().getReloads().getMaxAmmo());
            this.tabs.add(new MoWorkbenchScreen.Tab(icon, "weapons", weapons));
        }

        if(!attachments.isEmpty())
        {
            this.tabs.add(new MoWorkbenchScreen.Tab(new ItemStack(ModItems.HOLOGRAPHIC_SIGHT.get()), "attachments", attachments));
        }

        if(!ammo.isEmpty())
        {
            this.tabs.add(new MoWorkbenchScreen.Tab(new ItemStack(ttv.migami.mteg.init.ModItems.FLARE.get()), "ammo", ammo));
        }

        if(!stations.isEmpty())
        {
            ItemStack icon = new ItemStack(ModBlocks.MO_WORKBENCH.get());
            this.tabs.add(new MoWorkbenchScreen.Tab(icon, "stations", stations));
        }

        if(!misc.isEmpty())
        {
            this.tabs.add(new MoWorkbenchScreen.Tab(new ItemStack(ModItems.SCRAP.get()), "misc", misc));
        }

        if(!this.tabs.isEmpty())
        {
            this.currentTab = this.tabs.get(0);
        }
    }

    private boolean isAmmo(ItemStack stack)
    {
        if(stack.getItem() instanceof IAmmo)
        {
            return true;
        }
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(stack.getItem());
        Objects.requireNonNull(id);
        for(GunItem gunItem : NetworkGunManager.getClientRegisteredGuns())
        {
            if(id.equals(gunItem.getModifiedGun(stack).getProjectile().getItem()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void init()
    {
        super.init();
        if(!this.tabs.isEmpty())
        {
            this.topPos += 28;
        }
        this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 18, 15, 20, Component.literal("<"), button ->
        {
            int index = this.currentTab.getCurrentIndex();
            if(index - 1 < 0)
            {
                this.loadItem(this.currentTab.getRecipes().size() - 1);
            }
            else
            {
                this.loadItem(index - 1);
            }
        }));
        this.addRenderableWidget(new Button(this.leftPos + 153, this.topPos + 18, 15, 20, Component.literal(">"), button ->
        {
            int index = this.currentTab.getCurrentIndex();
            if(index + 1 >= this.currentTab.getRecipes().size())
            {
                this.loadItem(0);
            }
            else
            {
                this.loadItem(index + 1);
            }
        }));
        this.btnCraft = this.addRenderableWidget(new Button(this.leftPos + 195, this.topPos + 16, 74, 20, Component.translatable("gui.jeg.workbench.assemble"), button ->
        {
            int index = this.currentTab.getCurrentIndex();
            MoWorkbenchRecipe recipe = this.currentTab.getRecipes().get(index);
            ResourceLocation registryName = recipe.getId();
            PacketHandler.getPlayChannel().sendToServer(new C2SMessageCraft(registryName, this.workbench.getBlockPos()));
        }));
        this.btnCraft.active = false;
        this.checkBoxMaterials = this.addRenderableWidget(new CheckBox(this.leftPos + 172, this.topPos + 51, Component.translatable("gui.jeg.workbench.show_remaining")));
        this.checkBoxMaterials.setToggled(MoWorkbenchScreen.showRemaining);
        this.loadItem(this.currentTab.getCurrentIndex());
    }

    @Override
    public void containerTick()
    {
        super.containerTick();

        for(MoWorkbenchScreen.MaterialItem material : this.materials)
        {
            material.tick();
        }

        boolean canCraft = true;
        for(MoWorkbenchScreen.MaterialItem material : this.materials)
        {
            if(!material.isEnabled())
            {
                canCraft = false;
                break;
            }
        }

        this.btnCraft.active = canCraft;
        this.updateColor();
    }

    private void updateColor()
    {
        if(this.currentTab != null)
        {
            ItemStack item = this.displayStack;
            if(IColored.isDyeable(item))
            {
                IColored colored = (IColored) item.getItem();
                if(!this.workbench.getItem(0).isEmpty())
                {
                    ItemStack dyeStack = this.workbench.getItem(0);
                    if(dyeStack.getItem() instanceof DyeItem)
                    {
                        DyeColor color = ((DyeItem) dyeStack.getItem()).getDyeColor();
                        float[] components = color.getTextureDiffuseColors();
                        int red = (int) (components[0] * 255F);
                        int green = (int) (components[1] * 255F);
                        int blue = (int) (components[2] * 255F);
                        colored.setColor(item, ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF)));
                    }
                    else
                    {
                        colored.removeColor(item);
                    }
                }
                else
                {
                    colored.removeColor(item);
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton)
    {
        boolean result = super.mouseClicked(mouseX, mouseY, mouseButton);
        MoWorkbenchScreen.showRemaining = this.checkBoxMaterials.isToggled();

        for(int i = 0; i < this.tabs.size(); i++)
        {
            if(RenderUtil.isMouseWithin((int) mouseX, (int) mouseY, this.leftPos + 28 * i, this.topPos - 28, 28, 28))
            {
                this.currentTab = this.tabs.get(i);
                this.loadItem(this.currentTab.getCurrentIndex());
                this.minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                return true;
            }
        }

        return result;
    }

    private void loadItem(int index)
    {
        MoWorkbenchRecipe recipe = this.currentTab.getRecipes().get(index);
        this.displayStack = recipe.getItem().copy();
        this.updateColor();

        this.materials.clear();

        List<ScrapWorkbenchIngredient> ingredients = recipe.getMaterials();
        if(ingredients != null)
        {
            for(ScrapWorkbenchIngredient ingredient : ingredients)
            {
                MoWorkbenchScreen.MaterialItem item = new MoWorkbenchScreen.MaterialItem(ingredient);
                item.updateEnabledState();
                this.materials.add(item);
            }

            this.currentTab.setCurrentIndex(index);
        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);

        int startX = this.leftPos;
        int startY = this.topPos;

        for(int i = 0; i < this.tabs.size(); i++)
        {
            if(RenderUtil.isMouseWithin(mouseX, mouseY, startX + 28 * i, startY - 28, 28, 28))
            {
                this.renderTooltip(poseStack, Component.translatable(this.tabs.get(i).getTabKey()), mouseX, mouseY);
                return;
            }
        }

        for(int i = 0; i < this.filteredMaterials.size(); i++)
        {
            int itemX = startX + 172;
            int itemY = startY + i * 19 + 63;
            if(RenderUtil.isMouseWithin(mouseX, mouseY, itemX, itemY, 80, 19))
            {
                MoWorkbenchScreen.MaterialItem materialItem = this.filteredMaterials.get(i);
                if(materialItem != MoWorkbenchScreen.MaterialItem.EMPTY)
                {
                    this.renderTooltip(poseStack, materialItem.getDisplayStack(), mouseX, mouseY);
                    return;
                }
            }
        }

        if(RenderUtil.isMouseWithin(mouseX, mouseY, startX + 8, startY + 38, 160, 48))
        {
            this.renderTooltip(poseStack, this.displayStack, mouseX, mouseY);
        }
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY)
    {
        int offset = this.tabs.isEmpty() ? 0 : 28;
        this.font.draw(poseStack, this.title, (float)this.titleLabelX, (float)this.titleLabelY - 28 + offset, 4210752);
        this.font.draw(poseStack, this.playerInventory.getDisplayName(), (float)this.inventoryLabelX, (float)this.inventoryLabelY - 9 + offset, 4210752);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY)
    {
        /* Fixes partial ticks to use percentage from 0 to 1 */
        partialTicks = Minecraft.getInstance().getFrameTime();

        int startX = this.leftPos;
        int startY = this.topPos;

        RenderSystem.enableBlend();

        /* Draw unselected tabs */
        for(int i = 0; i < this.tabs.size(); i++)
        {
            MoWorkbenchScreen.Tab tab = this.tabs.get(i);
            if(tab != this.currentTab)
            {
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, GUI_BASE);
                blit(poseStack, startX + 28 * i, startY - 28, 80, 184, 28, 32);
                Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(tab.getIcon(), startX + 28 * i + 6, startY - 28 + 8);
                Minecraft.getInstance().getItemRenderer().renderGuiItemDecorations(this.font, tab.getIcon(), startX + 28 * i + 6, startY - 28 + 8, null);
            }
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_BASE);
        blit(poseStack, startX, startY, 0, 0, 173, 184);
        blit(poseStack, startX + 173, startY, 78, 184, 173, 0, 1, 184, 256, 256);
        blit(poseStack, startX + 251, startY, 174, 0, 24, 184);
        blit(poseStack, startX + 172, startY + 16, 198, 0, 20, 20);

        /* Draw selected tab */
        if(this.currentTab != null)
        {
            int i = this.tabs.indexOf(this.currentTab);
            int u = i == 0 ? 80 : 108;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, GUI_BASE);
            blit(poseStack, startX + 28 * i, startY - 28, u, 214, 28, 32);
            Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(this.currentTab.getIcon(), startX + 28 * i + 6, startY - 28 + 8);
            Minecraft.getInstance().getItemRenderer().renderGuiItemDecorations(this.font, this.currentTab.getIcon(), startX + 28 * i + 6, startY - 28 + 8, null);
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_BASE);

        if(this.workbench.getItem(0).isEmpty())
        {
            blit(poseStack, startX + 174, startY + 18, 165, 199, 16, 16);
        }

        ItemStack currentItem = this.displayStack;
        StringBuilder builder = new StringBuilder(currentItem.getHoverName().getString());
        if(currentItem.getCount() > 1)
        {
            builder.append(ChatFormatting.GOLD);
            builder.append(ChatFormatting.BOLD);
            builder.append(" x ");
            builder.append(currentItem.getCount());
        }
        drawCenteredString(poseStack, this.font, builder.toString(), startX + 88, startY + 22, Color.WHITE.getRGB());

        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        RenderUtil.scissor(startX + 8, startY + 17, 160, 70);

        PoseStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.pushPose();
        {
            modelViewStack.translate(startX + 88, startY + 60, 100);
            modelViewStack.scale(50F, -50F, 50F);
            modelViewStack.mulPose(Vector3f.XP.rotationDegrees(5F));
            modelViewStack.mulPose(Vector3f.YP.rotationDegrees(Minecraft.getInstance().player.tickCount + partialTicks));
            RenderSystem.applyModelViewMatrix();
            MultiBufferSource.BufferSource buffer = this.minecraft.renderBuffers().bufferSource();
            Minecraft.getInstance().getItemRenderer().render(currentItem, ItemTransforms.TransformType.FIXED, false, poseStack, buffer, 15728880, OverlayTexture.NO_OVERLAY, RenderUtil.getModel(currentItem));
            buffer.endBatch();
        }
        modelViewStack.popPose();
        RenderSystem.applyModelViewMatrix();

        GL11.glDisable(GL11.GL_SCISSOR_TEST);

        this.filteredMaterials = this.getMaterials();
        for(int i = 0; i < this.filteredMaterials.size(); i++)
        {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, GUI_BASE);

            MoWorkbenchScreen.MaterialItem materialItem = this.filteredMaterials.get(i);
            ItemStack stack = materialItem.getDisplayStack();
            if(!stack.isEmpty())
            {
                Lighting.setupForFlatItems();
                if(materialItem.isEnabled())
                {
                    this.blit(poseStack, startX + 172, startY + i * 19 + 63, 0, 184, 80, 19);
                }
                else
                {
                    this.blit(poseStack, startX + 172, startY + i * 19 + 63, 0, 222, 80, 19);
                }

                String name = stack.getHoverName().getString();
                if(this.font.width(name) > 55)
                {
                    name = this.font.plainSubstrByWidth(name, 50).trim() + "...";
                }
                this.font.draw(poseStack, name, startX + 172 + 22, startY + i * 19 + 6 + 63, Color.WHITE.getRGB());

                Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(stack, startX + 172 + 2, startY + i * 19 + 1 + 63);

                if(this.checkBoxMaterials.isToggled())
                {
                    int count = InventoryUtil.getItemStackAmount(Minecraft.getInstance().player, stack);
                    stack = stack.copy();
                    stack.setCount(stack.getCount() - count);
                }

                Minecraft.getInstance().getItemRenderer().renderGuiItemDecorations(this.font, stack, startX + 172 + 2, startY + i * 19 + 1 + 63, null);
            }
        }
    }

    private List<MoWorkbenchScreen.MaterialItem> getMaterials()
    {
        List<MoWorkbenchScreen.MaterialItem> materials = NonNullList.withSize(6, MoWorkbenchScreen.MaterialItem.EMPTY);
        List<MoWorkbenchScreen.MaterialItem> filteredMaterials = this.materials.stream().filter(materialItem -> this.checkBoxMaterials.isToggled() ? !materialItem.isEnabled() : materialItem != MoWorkbenchScreen.MaterialItem.EMPTY).collect(Collectors.toList());
        for(int i = 0; i < filteredMaterials.size() && i < materials.size(); i++)
        {
            materials.set(i, filteredMaterials.get(i));
        }
        return materials;
    }

    public List<MoWorkbenchScreen.Tab> getTabs()
    {
        return ImmutableList.copyOf(this.tabs);
    }

    public static class MaterialItem
    {
        public static final MoWorkbenchScreen.MaterialItem EMPTY = new MoWorkbenchScreen.MaterialItem();

        private long lastTime = System.currentTimeMillis();
        private int displayIndex;
        private boolean enabled = false;
        private ScrapWorkbenchIngredient ingredient;
        private final List<ItemStack> displayStacks = new ArrayList<>();

        private MaterialItem() {}

        private MaterialItem(ScrapWorkbenchIngredient ingredient)
        {
            this.ingredient = ingredient;
            Stream.of(ingredient.getItems()).forEach(stack -> {
                ItemStack displayStack = stack.copy();
                displayStack.setCount(ingredient.getCount());
                this.displayStacks.add(displayStack);
            });
        }

        public ScrapWorkbenchIngredient getIngredient()
        {
            return this.ingredient;
        }

        public void tick()
        {
            if(this.ingredient == null)
                return;

            this.updateEnabledState();
            long currentTime = System.currentTimeMillis();
            if(currentTime - this.lastTime >= 1000)
            {
                this.displayIndex = (this.displayIndex + 1) % this.displayStacks.size();
                this.lastTime = currentTime;
            }
        }

        public ItemStack getDisplayStack()
        {
            return this.ingredient != null ? this.displayStacks.get(this.displayIndex) : ItemStack.EMPTY;
        }

        public void updateEnabledState()
        {
            this.enabled = InventoryUtil.hasWorkstationIngredient(Minecraft.getInstance().player, this.ingredient);
        }

        public boolean isEnabled()
        {
            return this.ingredient == null || this.enabled;
        }
    }

    private static class Tab
    {
        private final ItemStack icon;
        private final String id;
        private final List<MoWorkbenchRecipe> items;
        private int currentIndex;

        public Tab(ItemStack icon, String id, List<MoWorkbenchRecipe> items)
        {
            this.icon = icon;
            this.id = id;
            this.items = items;
        }

        public ItemStack getIcon()
        {
            return this.icon;
        }

        public String getTabKey()
        {
            return "gui.jeg.workbench.tab." + this.id;
        }

        public void setCurrentIndex(int currentIndex)
        {
            this.currentIndex = currentIndex;
        }

        public int getCurrentIndex()
        {
            return this.currentIndex;
        }

        public List<MoWorkbenchRecipe> getRecipes()
        {
            return this.items;
        }
    }
}
