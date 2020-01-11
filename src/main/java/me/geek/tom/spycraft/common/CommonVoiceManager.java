package me.geek.tom.spycraft.common;

import me.geek.tom.audioserver.VoiceServerManager;

import java.io.IOException;

public class CommonVoiceManager {
    private static CommonVoiceManager INSTANCE;

    private VoiceServerManager manager;
    private boolean isRunning = false;

    public static CommonVoiceManager get() {
        if (INSTANCE == null)
            INSTANCE = new CommonVoiceManager();
        return INSTANCE;
    }

    public void startServer() {
        if (isRunning)
            return;

        System.out.println("[WalkieStream] Server starting...");
        manager = new VoiceServerManager();
        try {
            manager.begin(56789);
            isRunning = true;
        } catch (IOException e) {
            System.err.println("[WalkieStream] Failed to start server:");
            e.printStackTrace();
            return;
        }
        System.out.println("[WalkieStream] Server started!");
    }

    public void stopServer() {
        if (!isRunning)
            return;

        System.out.println("[WalkieStream] Server stopping...");
        manager.stop();
        isRunning = false;
        System.out.println("[WalkieStream] Server stopped!");
    }
}
