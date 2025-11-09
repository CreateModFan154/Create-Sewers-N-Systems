package com.createmodfan.sewersnsystems.item;

import com.createmodfan.sewersnsystems.SewersNSystems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SewersNSystems.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SEWERS_N_SYSTEMS_TAB = CREATIVE_MODE_TABS.register("sewers_n_systems_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SEWER_BRICK.get()))
                    .title(Component.translatable("creativetab.sewers_n_systems_tab"))
                    .displayItems((pParameters))
                    .build())

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
