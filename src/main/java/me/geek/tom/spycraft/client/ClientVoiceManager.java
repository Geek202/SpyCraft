package me.geek.tom.spycraft.client;

import me.geek.tom.audioserver.client.VoiceClient;

public class ClientVoiceManager {
    private static ClientVoiceManager INSTANCE;

    private boolean isConnected = false;

    private VoiceClient client;

    public static ClientVoiceManager get() {
        if (INSTANCE == null)
            INSTANCE = new ClientVoiceManager();
        return INSTANCE;
    }

    public void connect(String ip) {
        if (isConnected)
            return;

        System.out.println("[WalkieStream] Starting client connection...");
        client = new VoiceClient(ip, 56789);
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
}
