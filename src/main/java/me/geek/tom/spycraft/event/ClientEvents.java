package me.geek.tom.spycraft.event;

import me.geek.tom.spycraft.client.ClientVoiceManager;
import me.geek.tom.spycraft.networking.Networking;
import me.geek.tom.spycraft.networking.PacketRequestVoice;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import static me.geek.tom.spycraft.SpyCraft.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    public static final KeyBinding TALK_KEY = new KeyBinding("key.talk", GLFW.GLFW_KEY_Z, "key.categories.spycraft");

    @SubscribeEvent
    public static void onPlayerJoin(ClientPlayerNetworkEvent.LoggedInEvent event) {
        if (Minecraft.getInstance().getIntegratedServer() != null)
            ClientVoiceManager.get().connect("127.0.0.1");
        else
            Networking.INSTANCE.sendToServer(new PacketRequestVoice());
    }

    @SubscribeEvent
    public static void onPlayerLeave(ClientPlayerNetworkEvent.LoggedOutEvent event) {
        ClientVoiceManager.get().disconnect();
    }

    public static void init() {
        ClientRegistry.registerKeyBinding(ClientEvents.TALK_KEY);
    }
}
