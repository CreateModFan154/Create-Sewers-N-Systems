package com.createmodfan.sewersnsystems.datagen;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SewersNSystems.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
       this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.LIGHT_CRACKED_SEWER_BRICK.get(),
                ModBlocks.LIGHT_MOSSY_SEWER_BRICK.get(),
                ModBlocks.LIGHT_SEWER_BRICKS.get(),
                ModBlocks.SEWER_BRICK.get(),
                ModBlocks.MOSSY_SEWER_BRICK.get(),
                ModBlocks.CRACKED_SEWER_BRICK.get(),
                ModBlocks.SEWER_GRATE.get(),
                ModBlocks.PHOSPHATE_ORE.get(),
                ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get()

                );

    }
}
