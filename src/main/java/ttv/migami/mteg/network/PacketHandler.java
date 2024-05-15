package ttv.migami.mteg.network;

import com.mrcrayfish.framework.api.network.FrameworkChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.simple.SimpleChannel;
import ttv.migami.mteg.Reference;
import ttv.migami.mteg.network.message.C2SMessageCraft;

public class PacketHandler
{
    private static SimpleChannel PLAY_CHANNEL;

    /**
     * Gets the play network channel for MrCrayfish's Gun Mod
     */
    public static SimpleChannel getPlayChannel()
    {
        return PLAY_CHANNEL;
    }

    public static void init()
    {
        PLAY_CHANNEL = FrameworkChannelBuilder
                .create(Reference.MOD_ID, "play", 1)
                .registerPlayMessage(C2SMessageCraft.class, NetworkDirection.PLAY_TO_SERVER)
                .build();
    }

}
