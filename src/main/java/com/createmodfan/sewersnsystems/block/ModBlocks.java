package com.createmodfan.sewersnsystems.block;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SewersNSystems.MOD_ID);

    public static final RegistryObject<Block> SEWER_BRICK = registerBlock("sewer_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> CRACKED_SEWER_BRICK = registerBlock("cracked_sewer_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> MOSSY_SEWER_BRICK = registerBlock("mossy_sewer_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> SEWER_GRATE = registerBlock("sewer_grate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> PHOSPHATE_ORE = registerBlock("phosphate_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_PHOSPHATE_ORE = registerBlock("deepslate_phosphate_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final RegistryObject<Block> LIGHT_SEWER_BRICKS = registerBlock("light_sewer_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> LIGHT_CRACKED_SEWER_BRICK = registerBlock("light_cracked_sewer_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> LIGHT_MOSSY_SEWER_BRICK = registerBlock("light_mossy_sewer_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> PHOSPHATE_BLOCK = registerBlock("phosphate_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));
    //stairs
    public static final RegistryObject<Block> LIGHT_SEWER_BRICK_STAIRS = registerBlock("light_sewer_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.LIGHT_SEWER_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)));
    public static final RegistryObject<Block> SEWER_BRICK_STAIRS = registerBlock("sewer_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.LIGHT_SEWER_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)));
    //slabs
    public static final RegistryObject<Block> LIGHT_SEWER_BRICK_SLAB = registerBlock("sewer_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)));
    public static final RegistryObject<Block> SEWER_BRICK_SLAB = registerBlock("sewer_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)));
    //walls
    public static final RegistryObject<Block> LIGHT_SEWER_BRICK_WALL = registerBlock("sewer_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)));
    public static final RegistryObject<Block> SEWER_BRICK_WALL = registerBlock("sewer_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
