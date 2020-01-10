package me.geek.tom.spycraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static me.geek.tom.spycraft.SpyCraft.MODID;

@ObjectHolder(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    @ObjectHolder("walkie")
    public static WalkieTalkieItem WALKIE_TALKIE;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Item.Properties properties = new Item.Properties().group(ItemGroup.REDSTONE);

        event.getRegistry().registerAll(
                new WalkieTalkieItem(properties)
        );
    }
}
