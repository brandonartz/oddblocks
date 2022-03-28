// package net.fabricmc.oddblocks.world.gen.chunk;

// import java.util.List;
// import java.util.Optional;
// import java.util.concurrent.CompletableFuture;
// import java.util.concurrent.Executor;

// import com.google.common.collect.Lists;
// import com.mojang.datafixers.kinds.Applicative;
// import com.mojang.serialization.Codec;
// import com.mojang.serialization.codecs.RecordCodecBuilder;

// import net.minecraft.block.BlockState;
// import net.minecraft.block.Blocks;
// import net.minecraft.structure.StructureSet;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.util.registry.RegistryEntry;
// import net.minecraft.util.registry.RegistryEntryList;
// import net.minecraft.util.registry.RegistryKey;
// import net.minecraft.world.ChunkRegion;
// import net.minecraft.world.HeightLimitView;
// import net.minecraft.world.Heightmap;
// import net.minecraft.world.Heightmap.Type;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.BiomeKeys;
// import net.minecraft.world.biome.source.BiomeAccess;
// import net.minecraft.world.biome.source.BiomeSource;
// import net.minecraft.world.biome.source.util.MultiNoiseUtil;
// import net.minecraft.world.biome.source.util.MultiNoiseUtil.MultiNoiseSampler;
// import net.minecraft.world.chunk.Chunk;
// import net.minecraft.world.gen.GenerationStep.Carver;
// import net.minecraft.world.gen.GenerationStep;
// import net.minecraft.world.gen.StructureAccessor;
// import net.minecraft.world.gen.chunk.Blender;
// import net.minecraft.world.gen.chunk.ChunkGenerator;
// import net.minecraft.world.gen.chunk.FlatChunkGenerator;
// import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
// import net.minecraft.world.gen.chunk.VerticalBlockSample;

// public class AbyssChunkGenerator extends ChunkGenerator {
//     public static final Codec<AbyssChunkGenerator> CODEC = RecordCodecBuilder.create(null);
    
//     //private final AbyssChunkGeneratorConfig config;
//     private static final RegistryKey<Biome> BIOME_KEY = BiomeKeys.PLAINS;

//     public AbyssChunkGenerator(Registry<StructureSet> registry, Optional<RegistryEntryList<StructureSet>> optional, BiomeSource biomeSource) {
//         super(registry, optional, biomeSource);
//     }

//     @Override
//     protected Codec<? extends ChunkGenerator> getCodec() {
//         return CODEC;
//     }

//     @Override
//     public ChunkGenerator withSeed(long seed) {
//         return this;
//     }

//     @Override
//     public void buildSurface(ChunkRegion region, StructureAccessor structures, Chunk chunk) {
//     }

//     @Override
//     public int getSpawnHeight(HeightLimitView world) {
//         //return world.getBottomY() + Math.min(world.getHeight(), this.config.getLayerBlocks().size());
        
//         //Spawn should be 20 blocks above the bottom of the abyss
//         return world.getBottomY() + Math.min(world.getHeight(), 20);
//     }

//     @Override
//     protected RegistryEntry<Biome> filterBiome(RegistryEntry<Biome> biome) {
//         return biome;
//     }

//     @Override
//     public CompletableFuture<Chunk> populateNoise(Executor executor, Blender blender, StructureAccessor structureAccessor, Chunk chunk) {
//         // List<BlockState> list = this.config.getLayerBlocks();
//         // BlockPos.Mutable mutable = new BlockPos.Mutable();
//         // Heightmap heightmap = chunk.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG);
//         // Heightmap heightmap2 = chunk.getHeightmap(Heightmap.Type.WORLD_SURFACE_WG);
//         // for (int i = 0; i < Math.min(chunk.getHeight(), list.size()); ++i) {
//         //     BlockState blockState = list.get(i);
//         //     if (blockState == null) continue;
//         //     int j = chunk.getBottomY() + i;
//         //     for (int k = 0; k < 16; ++k) {
//         //         for (int l = 0; l < 16; ++l) {
//         //             chunk.setBlockState(mutable.set(k, j, l), blockState, false);
//         //             heightmap.trackUpdate(k, j, l, blockState);
//         //             heightmap2.trackUpdate(k, j, l, blockState);
//         //         }
//         //     }
//         // }
//         return CompletableFuture.completedFuture(chunk);
//     }

//     @Override
//     public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world) {
//         // List<BlockState> list = .layerBlocks.stream().allMatch(state -> state.isOf(Blocks.AIR));
//         // for (int i = Math.min(list.size(), world.getTopY()) - 1; i >= 0; --i) {
//         //     BlockState blockState = list.get(i);
//         //     if (blockState == null || !heightmap.getBlockPredicate().test(blockState)) continue;
//         //     return world.getBottomY() + i + 1;
//         // }
//         // return world.getBottomY();
//         return 20;
//     }

//     @Override
//     public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world) {
//         List<BlockState> blockStates = Lists.newArrayList();
//         for(int i = 0; i < world.getTopY(); i++){
//             blockStates.add(Blocks.AIR.getDefaultState());
//         }
//         return new VerticalBlockSample(world.getBottomY(), (BlockState[])blockStates.toArray());
//     }

//     @Override
//     public void getDebugHudText(List<String> text, BlockPos pos) {
//     }

//     @Override
//     public MultiNoiseUtil.MultiNoiseSampler getMultiNoiseSampler() {
//         return MultiNoiseUtil.method_40443();
//     }

//     @Override
//     public void carve(ChunkRegion chunkRegion, long seed, BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk, GenerationStep.Carver generationStep) {
//     }

//     @Override
//     public void populateEntities(ChunkRegion region) {
//     }

//     @Override
//     public int getMinimumY() {
//         return 0;
//     }

//     @Override
//     public int getWorldHeight() {
//         return 384;
//     }

//     @Override
//     public int getSeaLevel() {
//         return -63;
//     }
// }
