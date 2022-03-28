// package net.fabricmc.oddblocks.mixin;

// import java.util.List;

// import org.spongepowered.asm.mixin.Mixin;
// import org.spongepowered.asm.mixin.injection.At;
// import org.spongepowered.asm.mixin.injection.Inject;
// import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// import net.fabricmc.oddblocks.OddBlocksMod;
// import net.minecraft.util.registry.BuiltinRegistries;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.util.registry.RegistryEntry;
// import net.minecraft.util.registry.RegistryEntryList;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.BiomeKeys;
// import net.minecraft.world.biome.GenerationSettings;
// import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
// import net.minecraft.world.gen.feature.PlacedFeature;

// @Mixin(FlatChunkGeneratorConfig.class)
// public class FlatChunkGeneratorConfigMixin {
//     @Inject(at = @At("RETURN"), method = "createBiome()Lnet/minecraft/util/registry/RegistryEntry")
//     private void createBiome(CallbackInfoReturnable<RegistryEntry<Biome>> callbackInfo) {
//         OddBlocksMod.LOGGER.info("Hacking the flatchunk!");
//         Biome biome = ((FlatChunkGeneratorConfig)(Object)this).getBiome().value();
//         // GenerationSettings generationSettings = biome.getGenerationSettings();
//         // GenerationSettings.Builder builder = new GenerationSettings.Builder();
//         // List<RegistryEntryList<PlacedFeature>> list = generationSettings.getFeatures();
//         // for (int i = 0; i < list.size(); ++i) {
//         //     RegistryEntryList<PlacedFeature> registryEntryList = (RegistryEntryList<PlacedFeature>)list.get(i);
//         //     for (RegistryEntry<PlacedFeature> registryEntry : registryEntryList) {
//         //         OddBlocksMod.LOGGER.info("Ordinal: " + i);
//         //         OddBlocksMod.LOGGER.info(registryEntry.toString());
//         //         builder.feature(i, (RegistryEntry<PlacedFeature>)registryEntry);
//         //     }
//         //     if(i == 9){
//         //         builder.feature(i, )
//         //     }
//         // }
//         //Registry<Biome> registry = BuiltinRegistries.BIOME;
//         //Biome biome = registry.get(BiomeKeys.DEEP_OCEAN);
//         GenerationSettings generationSettings = biome.getGenerationSettings();
//         List<RegistryEntryList<PlacedFeature>> list = generationSettings.getFeatures();
//         for (int i = 0; i < list.size(); ++i) {
//             RegistryEntryList<PlacedFeature> registryEntryList = (RegistryEntryList<PlacedFeature>)list.get(i);
//             for (RegistryEntry<PlacedFeature> registryEntry : registryEntryList) {
//                 OddBlocksMod.LOGGER.info("Ordinal: " + i);
//                 OddBlocksMod.LOGGER.info(registryEntry.toString());
//             }
//         }

//         //builder.feature(GenerationStep.Feature.LAKES, MiscPlacedFeatures.LAKE_LAVA_SURFACE);
//  	}
// }
