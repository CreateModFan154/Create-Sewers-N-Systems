package com.createmodfan.sewersnsystems.datagen.loot;

import com.createmodfan.sewersnsystems.block.ModBlocks;
import com.createmodfan.sewersnsystems.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.data.loot.BlockLootSubProvider;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        // Misc Blocks
        this.dropSelf(ModBlocks.SEWER_BRICK.get());
        this.dropSelf(ModBlocks.CRACKED_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.MOSSY_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.SEWER_GRATE.get());
        this.dropSelf(ModBlocks.PHOSPHATE_ORE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get());
        this.dropSelf(ModBlocks.LIGHT_SEWER_BRICKS.get());
        this.dropSelf(ModBlocks.LIGHT_CRACKED_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.LIGHT_MOSSY_SEWER_BRICK.get());
        this.dropSelf(ModBlocks.PHOSPHATE_BLOCK.get());

        // Stairs
        this.dropSelf(ModBlocks.LIGHT_SEWER_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.SEWER_BRICK_STAIRS.get());

        // Slabs
       this.add(ModBlocks.SEWER_BRICK_SLAB.get(),
               block -> createSlabItemTable(ModBlocks.SEWER_BRICK_SLAB.get()));
        this.add(ModBlocks.LIGHT_SEWER_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_SEWER_BRICK_SLAB.get()));

        // Walls
        this.dropSelf(ModBlocks.LIGHT_SEWER_BRICK_WALL.get());
        this.dropSelf(ModBlocks.SEWER_BRICK_WALL.get());

        // Manholes
        this.dropSelf(ModBlocks.MANHOLE_COVER.get());

        // Cone
        this.dropSelf(ModBlocks.TRAFFIC_CONE.get());

        // Panels
        this.dropSelf(ModBlocks.ELECTRIC_PANEL.get());

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