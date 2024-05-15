package ttv.migami.mteg.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.event.loot.HogBonkerFromBruteAdditionModifier;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootBusEvent {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new HogBonkerFromBruteAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Reference.MOD_ID,"hog_bonker_from_brute"))
        );
    }
}
