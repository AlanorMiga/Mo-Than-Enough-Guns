package ttv.migami.mteg.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ttv.migami.mteg.MoThanEnoughGuns;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.block.MoWorkbenchBlock;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ModBlocks {


    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    public static final RegistryObject<Block> MO_WORKBENCH = register("mo_workbench",
            () -> new MoWorkbenchBlock(Block.Properties.of(Material.STONE).noOcclusion()
                    .strength(3.0F)));

    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier) {
        return register(id, blockSupplier, block1 -> new BlockItem(block1, new Item.Properties().tab(MoThanEnoughGuns.GROUP)));
    }

    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier, @Nullable Function<T, BlockItem> supplier) {
        RegistryObject<T> registryObject = REGISTER.register(id, blockSupplier);
        if (supplier != null) {
            ModItems.ITEMS.register(id, () -> supplier.apply(registryObject.get()));
        }
        return registryObject;
    }
}
