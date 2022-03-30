package net.fabricmc.oddblocks.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class OddBlocksSandyKey extends OddBlocksPortalKey {
    
    public OddBlocksSandyKey(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // formatted gold text
        tooltip.add( new TranslatableText("item.oddblocks.odd_sandy_key.tooltip").formatted(Formatting.GOLD) );
    }
}
