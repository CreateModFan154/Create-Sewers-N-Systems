package com.createmodfan.sewersnsystems.worldgen;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.antlr.v4.tool.Rule;

import java.util.List;

public class ModConfiguredFeatures {
        public static final ResourceKey<ConfiguredFeature<?, ?>> PHOSPHATE_ORE_KEY = registerKey("phosphate_ore");

   public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
       RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
       RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

       List<OreConfiguration.TargetBlockState>OverworldPhosphateOres = List.of(OreConfiguration.target(stoneReplacable,
               ModBlocks.PHOSPHATE_ORE.get().defaultBlockState()),
               OreConfiguration.target(deepslateReplacables, ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get().defaultBlockState()));
   }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SewersNSystems.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}