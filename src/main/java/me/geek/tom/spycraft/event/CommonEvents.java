package me.geek.tom.spycraft.event;

import me.geek.tom.spycraft.SpyCraft;
import me.geek.tom.spycraft.common.CommonVoiceManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;


public class CommonEvents {

    @Mod.EventBusSubscriber(modid = SpyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onServerStart(FMLServerStartingEvent event) {
            CommonVoiceManager.get().startServer();
        }

        public static void onServerStop(FMLServerStoppingEvent event) {
            CommonVoiceManager.get().stopServer();
        }

    }

    @Mod.EventBusSubscriber(modid = SpyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

    }
}
