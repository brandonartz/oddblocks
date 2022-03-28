// package net.fabricmc.oddblocks.world.gen.chunk;

// import java.util.List;
// import java.util.Optional;

// import com.google.common.collect.Lists;

// import org.spongepowered.asm.mixin.Mixin;

// import net.fabricmc.oddblocks.OddBlocksMod;
// import net.minecraft.block.BlockState;
// import net.minecraft.structure.StructureSet;
// import net.minecraft.util.registry.BuiltinRegistries;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.util.registry.RegistryEntry;
// import net.minecraft.util.registry.RegistryEntryList;
// import net.minecraft.world.Heightmap;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.BiomeKeys;
// import net.minecraft.world.biome.GenerationSettings;
// import net.minecraft.world.gen.GenerationStep;
// import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
// import net.minecraft.world.gen.chunk.FlatChunkGeneratorLayer;
// import net.minecraft.world.gen.feature.Feature;
// import net.minecraft.world.gen.feature.FillLayerFeatureConfig;
// import net.minecraft.world.gen.feature.MiscPlacedFeatures;
// import net.minecraft.world.gen.feature.PlacedFeature;
// import net.minecraft.world.gen.feature.PlacedFeatures;
// import net.minecraft.world.gen.placementmodifier.PlacementModifier;

// @Mixin(FlatChunkGeneratorConfig.class)
// public class AbyssChunkGeneratorConfig extends FlatChunkGeneratorConfig {

//     private final List<FlatChunkGeneratorLayer> layers = Lists.newArrayList();
//     private RegistryEntry<Biome> biome;
//     private boolean hasNoTerrain;
//     private boolean hasFeatures;
//     private boolean hasLakes;

//     public AbyssChunkGeneratorConfig(Optional<RegistryEntryList<StructureSet>> optional, Registry<Biome> biomeRegistry) {
//         super(optional, biomeRegistry);
//     }

//     //@Override
//     public FlatChunkGeneratorConfig withLayers(List<FlatChunkGeneratorLayer> layers, Optional<RegistryEntryList<StructureSet>> optional) {
//         return super.withLayers(layers, optional);
//     }

//     public RegistryEntry<Biome> createBiome() {
//         int i;
//         List<RegistryEntryList<PlacedFeature>> list;
//         boolean bl;
//         Biome biome = this.getBiome().value();
//         GenerationSettings generationSettings = biome.getGenerationSettings();
//         GenerationSettings.Builder builder = new GenerationSettings.Builder();
//         if (this.hasLakes) {
//             builder.feature(GenerationStep.Feature.LAKES, MiscPlacedFeatures.LAKE_LAVA_UNDERGROUND);
//             builder.feature(GenerationStep.Feature.LAKES, MiscPlacedFeatures.LAKE_LAVA_SURFACE);
//         }
//         boolean bl2 = bl = (!this.hasNoTerrain || this.biome.matchesKey(BiomeKeys.THE_VOID)) && this.hasFeatures;
//         if (bl) {
//             list = generationSettings.getFeatures();
//             for (i = 0; i < list.size(); ++i) {
//                 //if (i == GenerationStep.Feature.UNDERGROUND_STRUCTURES.ordinal() || i == GenerationStep.Feature.SURFACE_STRUCTURES.ordinal()) continue;
//                 RegistryEntryList<PlacedFeature> registryEntryList = (RegistryEntryList<PlacedFeature>)list.get(i);
//                 for (RegistryEntry registryEntry : registryEntryList) {
//                     builder.feature(i, (RegistryEntry<PlacedFeature>)registryEntry);
//                 }
//             }
//         }
//         List<BlockState> list2 = this.getLayerBlocks();
//         for (i = 0; i < list2.size(); ++i) {
//             BlockState blockState = (BlockState)list2.get(i);
//             if (Heightmap.Type.MOTION_BLOCKING.getBlockPredicate().test(blockState)) continue;
//             list2.set(i, null);
//             builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, PlacedFeatures.createEntry(Feature.FILL_LAYER, new FillLayerFeatureConfig(i, blockState), new PlacementModifier[0]));
//         }
        
//         return RegistryEntry.of(Biome.Builder.copy(biome).generationSettings(builder.build()).build());
//     }
// }