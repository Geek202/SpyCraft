package me.geek.tom.spycraft.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class WalkieTalkieItem extends Item {
    public WalkieTalkieItem(Properties properties) {
        super(properties);
        setRegistryName("walkie");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent(ChatFormatting.DARK_GRAY + "Speak, and I will listen..."));
    }

    @Override
    public String getHighlightTip(ItemStack item, String displayName) {
        return displayName + ChatFormatting.GREEN + " (On)";
    }
}
