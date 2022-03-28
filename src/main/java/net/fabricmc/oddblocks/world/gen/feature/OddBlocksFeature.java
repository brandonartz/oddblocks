package net.fabricmc.oddblocks.world.gen.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public abstract class OddBlocksFeature<FC extends FeatureConfig> {
    public static final Feature<DefaultFeatureConfig> ODD_DIRT = register("odd_dirt", new OddDirtFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> ODD_SPAWN = register("odd_spawn", new OddSpawnFeature(DefaultFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F)Registry.register(Registry.FEATURE, name, feature);
    }
}