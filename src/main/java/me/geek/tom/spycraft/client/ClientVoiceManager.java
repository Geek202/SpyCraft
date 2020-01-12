package me.geek.tom.spycraft.client;

import me.geek.tom.audioserver.client.VoiceClient;
import me.geek.tom.spycraft.common.items.ModItems;
import me.geek.tom.spycraft.event.ClientEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.Hand;

public class ClientVoiceManager {
    private static ClientVoiceManager INSTANCE;

    private boolean isConnected = false;

    private VoiceClient client;

    // public static int setup() { return 0; } // Dirty way to load the class/keybind

    public static ClientVoiceManager get() {
        if (INSTANCE == null)
            INSTANCE = new ClientVoiceManager();
        return INSTANCE;
    }

    public void connect(String ip) {
        if (isConnected)
            return;

        System.out.println("[WalkieStream] Starting client connection...");
        client = new VoiceClient(ip, 56789, this::shouldSend);
        client.start();
        isConnected = true;
        System.out.println("[WalkieStream] Client started!");
    }

    public void disconnect() {
        if (!isConnected)
            return;

        System.out.println("[WalkieStream] Stopping client connection...");
        client.shutdown();
        System.out.println("[WalkieStream] Client disconnected!");
        isConnected = false;
    }

    private boolean shouldSend(VoiceClient vc) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        boolean isItemInHand = player.getHeldItem(Hand.MAIN_HAND).getItem().equals(ModItems.WALKIE_TALKIE)
                || player.getHeldItem(Hand.OFF_HAND).getItem().equals(ModItems.WALKIE_TALKIE);

        return ClientEvents.TALK_KEY.isKeyDown() && isItemInHand;
    }
}
