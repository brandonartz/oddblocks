package net.fabricmc.oddblocks.mixin;

import java.util.List;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.client.world.GeneratorType;

@Mixin(GeneratorType.class)
public interface GeneratorTypeAccessorMixin {
    @Accessor("VALUES") 
    static List<GeneratorType> getValues(){
        throw new AssertionError();
    }
}
