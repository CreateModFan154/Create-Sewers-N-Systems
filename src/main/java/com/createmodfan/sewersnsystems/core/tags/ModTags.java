package com.createmodfan.sewersnsystems.core.tags;

import com.createmodfan.sewersnsystems.SewersNSystems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> SCREWDRIVER_ROTATABLE = tag("screwdriver_rotatable");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(SewersNSystems.MOD_ID, name));
    }

    }
}
