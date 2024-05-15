package ttv.migami.mteg.network;

import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.network.FrameworkNetwork;
import com.mrcrayfish.framework.api.network.MessageDirection;
import net.minecraft.resources.ResourceLocation;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.network.message.C2SMessageCraft;

public class PacketHandler
{
    private static FrameworkNetwork playChannel;

    public static void init()
    {
        playChannel = FrameworkAPI.createNetworkBuilder(new ResourceLocation(Reference.MOD_ID, "play"), 1)
                .registerPlayMessage(C2SMessageCraft.class, MessageDirection.PLAY_SERVER_BOUND)
                .build();
    }

    public static FrameworkNetwork getPlayChannel()
    {
        return playChannel;
    }

}
