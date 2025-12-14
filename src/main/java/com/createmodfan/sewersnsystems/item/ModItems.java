package com.createmodfan.sewersnsystems.item;

import com.createmodfan.sewersnsystems.SewersNSystems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SewersNSystems.MOD_ID);
    public static final RegistryObject<Item> SEWER_BRICK_ITEM = ITEMS.register("sewer_brick_item",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHOSPHATE_POWDER = ITEMS.register("phosphate_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUIDEBOOK = ITEMS.register("guidebook",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_SPOOL = ITEMS.register("wire_spool",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHEAP_NOZZLE = ITEMS.register("cheap_nozzle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FANCY_NOZZLE = ITEMS.register("fancy_nozzle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_SEWER_BRICK = ITEMS.register("light_sewer_brick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAFETY_VEST = ITEMS.register("safety_vest",
            () -> new ArmorItem(ModArmorMaterials.SAFETY_VEST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
