package eu.tomger.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class Corn extends Item {
    public Corn(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // default white text
        tooltip.add(Text.translatable("item.atom.corn.tooltip"));
    }
}
