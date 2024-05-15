package ttv.migami.mteg.init;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.blockentity.MoWorkbenchBlockEntity;
import ttv.migami.mteg.common.container.MoWorkbenchContainer;

/**
 * Author: MrCrayfish
 */
public class ModContainers {
    public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Reference.MOD_ID);

    public static final RegistryObject<MenuType<MoWorkbenchContainer>> MO_WORKBENCH = register("mo_workbench", (IContainerFactory<MoWorkbenchContainer>) (windowId, playerInventory, data) -> {
        MoWorkbenchBlockEntity mo_workbench = (MoWorkbenchBlockEntity) playerInventory.player.level().getBlockEntity(data.readBlockPos());
        return new MoWorkbenchContainer(windowId, playerInventory, mo_workbench);
    });

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String id, MenuType.MenuSupplier<T> factory) {
        return REGISTER.register(id, () -> new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS));
    }
}
