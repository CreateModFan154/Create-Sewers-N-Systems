package com.createmodfan.sewersnsystems.datagen;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SewersNSystems.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRACKED_SEWER_BRICK);
        blockWithItem(ModBlocks.MOSSY_SEWER_BRICK);
        blockWithItem(ModBlocks.SEWER_BRICK);
        blockWithItem(ModBlocks.SEWER_GRATE);
        blockWithItem(ModBlocks.PHOSPHATE_BLOCK);
        blockWithItem(ModBlocks.PHOSPHATE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PHOSPHATE_ORE);
        blockWithItem(ModBlocks.LIGHT_CRACKED_SEWER_BRICK);
        blockWithItem(ModBlocks.LIGHT_MOSSY_SEWER_BRICK);
        blockWithItem(ModBlocks.LIGHT_SEWER_BRICKS);

        stairsBlock(((StairBlock) ModBlocks.SEWER_BRICK_STAIRS.get()), blockTexture(ModBlocks.SEWER_BRICK.get()));
        stairsBlock(((StairBlock) ModBlocks.LIGHT_SEWER_BRICK_STAIRS.get()), blockTexture(ModBlocks.LIGHT_SEWER_BRICKS.get()));

        slabBlock(((SlabBlock) ModBlocks.SEWER_BRICK_SLAB.get()), blockTexture(ModBlocks.SEWER_BRICK.get()), blockTexture(ModBlocks.SEWER_BRICK.get()));
        slabBlock(((SlabBlock) ModBlocks.LIGHT_SEWER_BRICK_SLAB.get()), blockTexture(ModBlocks.LIGHT_SEWER_BRICKS.get()), blockTexture(ModBlocks.LIGHT_SEWER_BRICKS.get()));

        wallBlock(((WallBlock) ModBlocks.SEWER_BRICK_WALL.get()), blockTexture(ModBlocks.SEWER_BRICK.get()));
        wallBlock(((WallBlock) ModBlocks.LIGHT_SEWER_BRICK_WALL.get()), blockTexture(ModBlocks.LIGHT_SEWER_BRICKS.get()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
