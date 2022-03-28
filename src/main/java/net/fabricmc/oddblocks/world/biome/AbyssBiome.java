package net.fabricmc.oddblocks.world.biome;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.OverworldBiomeCreator;

public class AbyssBiome{
    public static final Biome ABYSS_BIOME = createTheAbyss();
    public static final RegistryKey<Biome> ABYSS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("oddblocks", "abyss"));
    
    private static Biome createTheAbyss() {	 
        //Temporarily returning the results from createNormalOcean because I don't know any other way
        //TODO: Fix this
		return OverworldBiomeCreator.createNormalOcean(true);
	}

    public static void registerBiome(){
        Registry.register(BuiltinRegistries.BIOME, ABYSS_KEY.getValue(), ABYSS_BIOME);
    }
}