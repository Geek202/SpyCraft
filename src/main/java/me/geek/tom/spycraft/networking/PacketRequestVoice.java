package me.geek.tom.spycraft.networking;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.function.Supplier;

public class PacketRequestVoice {
    public PacketRequestVoice(PacketBuffer buf) {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public PacketRequestVoice() {
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            try {
                Networking.INSTANCE.sendTo(
                        new PacketVoiceIp(InetAddress.getLocalHost().getHostAddress()),
                        ctx.get().getSender().connection.netManager,
                        NetworkDirection.PLAY_TO_CLIENT
                );
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
