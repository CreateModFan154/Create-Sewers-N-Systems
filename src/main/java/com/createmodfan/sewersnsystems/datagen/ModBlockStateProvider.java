package com.createmodfan.sewersnsystems.datagen;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
