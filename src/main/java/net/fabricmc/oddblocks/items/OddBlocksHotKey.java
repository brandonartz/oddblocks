package net.fabricmc.oddblocks.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class OddBlocksHotKey extends OddBlocksPortalKey {

    public OddBlocksHotKey(Settings settings) {
        super(settings);
    }
    
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // formatted gold text
        tooltip.add( new TranslatableText("item.oddblocks.odd_hot_key.tooltip").formatted(Formatting.GOLD) );
    }
}
