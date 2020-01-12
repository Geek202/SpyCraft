package me.geek.tom.spycraft;

import me.geek.tom.audioserver.mains.Client;
import me.geek.tom.spycraft.client.ClientVoiceManager;
import me.geek.tom.spycraft.event.ClientEvents;
import me.geek.tom.spycraft.networking.Networking;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.StartupMessageManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@SuppressWarnings("Convert2MethodRef")
@Mod(SpyCraft.MODID)
public class SpyCraft {
    public static final String MODID = "spycraft";

    public SpyCraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
    }

    private void init(FMLCommonSetupEvent event) {
        StartupMessageManager.addModMessage("Spycraft::init");
        Networking.setupNetworking();
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> ClientEvents.init());
    }
}
