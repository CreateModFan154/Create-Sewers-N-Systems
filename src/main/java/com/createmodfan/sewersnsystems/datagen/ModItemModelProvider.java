package com.createmodfan.sewersnsystems.datagen;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.block.ModBlocks;
import com.createmodfan.sewersnsystems.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
@SuppressWarnings("deprecated")
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SewersNSystems.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Items
        simpleItem(ModItems.SEWER_BRICK_ITEM);
        simpleItem(ModItems.PHOSPHATE_POWDER);
        simpleItem(ModItems.GUIDEBOOK);
        simpleItem(ModItems.CHEAP_NOZZLE);
        simpleItem(ModItems.FANCY_NOZZLE);
        simpleItem(ModItems.LIGHT_SEWER_BRICK);
        simpleItem(ModItems.SAFETY_VEST);
        simpleItem(ModItems.SCREWDRIVER);

        // Block Items
        wallItem(ModBlocks.LIGHT_SEWER_BRICK_WALL, ModBlocks.LIGHT_SEWER_BRICKS);
        wallItem(ModBlocks.SEWER_BRICK_WALL, ModBlocks.SEWER_BRICK);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SewersNSystems.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(SewersNSystems.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SewersNSystems.MOD_ID, "item/" + item.getId().getPath()));
    }
}
