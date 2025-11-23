package com.createmodfan.sewersnsystems.datagen.loot;

import com.createmodfan.sewersnsystems.block.ModBlocks;
import com.createmodfan.sewersnsystems.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CRACKED_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.SEWER_BRICK.get());
        this.dropSelf(ModBlocks.MOSSY_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.LIGHT_CRACKED_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.LIGHT_SEWER_BRICKS.get());
        this.dropSelf(ModBlocks.LIGHT_MOSSY_SEWER_BRICK.get());

        this.add(ModBlocks.PHOSPHATE_ORE.get(),
                block -> createOreDrop(ModBlocks.PHOSPHATE_ORE.get(), ModItems.PHOSPHATE_POWDER.get()));
        this.add(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get()  , ModItems.PHOSPHATE_POWDER.get()));
    }
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
