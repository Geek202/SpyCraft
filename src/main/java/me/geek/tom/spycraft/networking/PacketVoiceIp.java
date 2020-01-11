package me.geek.tom.spycraft.networking;

import me.geek.tom.spycraft.client.ClientVoiceManager;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketVoiceIp {
    private String addr;

    public PacketVoiceIp(String addr) {
        this.addr = addr;
    }

    public PacketVoiceIp(PacketBuffer buf) {
        this.addr = buf.readString();
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeString(this.addr);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientVoiceManager.get().connect(this.addr);
        });
    }
}
