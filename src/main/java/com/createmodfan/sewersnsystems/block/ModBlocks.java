package com.createmodfan.sewersnsystems.block;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.createmodfan.sewersnsystems.item.ModItems;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.netty.channel.epoll.EpollDatagramChannel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import static com.simibubi.create.foundation.data.CreateRegistrate.casingConnectivity;

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
