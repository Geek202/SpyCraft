package me.geek.tom.spycraft;

import me.geek.tom.spycraft.networking.Networking;
import net.minecraftforge.fml.StartupMessageManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpyCraft.MODID)
public class SpyCraft {
    public static final String MODID = "spycraft";

    public SpyCraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
    }

    private void init(FMLCommonSetupEvent event) {
        StartupMessageManager.addModMessage("Spycraft::init");
        Networking.setupNetworking();
    }
}
