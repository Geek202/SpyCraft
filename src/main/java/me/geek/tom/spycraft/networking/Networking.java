package me.geek.tom.spycraft.networking;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import static me.geek.tom.spycraft.SpyCraft.MODID;

public class Networking {
    private static int ID = 0;

    public static SimpleChannel INSTANCE;

    private static int nextId() {
        return ID++;
    }

    public static void setupNetworking() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID), () -> "1.0", s -> true, s -> true);

        INSTANCE.registerMessage(
                nextId(),
                PacketRequestVoice.class,
                PacketRequestVoice::toBytes,
                PacketRequestVoice::new,
                PacketRequestVoice::handle
        );

        INSTANCE.registerMessage(
                nextId(),
                PacketVoiceIp.class,
                PacketVoiceIp::toBytes,
                PacketVoiceIp::new,
                PacketVoiceIp::handle
        );
    }
}
