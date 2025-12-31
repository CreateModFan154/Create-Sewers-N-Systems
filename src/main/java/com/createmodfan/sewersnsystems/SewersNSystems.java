package com.createmodfan.sewersnsystems;

import com.createmodfan.sewersnsystems.block.ModBlocks;
import com.createmodfan.sewersnsystems.item.ModCreativeModeTabs;
import com.createmodfan.sewersnsystems.item.ModItems;
import com.createmodfan.sewersnsystems.util.ModTags;
import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.Registrate;
import cpw.mods.util.Lazy;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import java.lang.StackWalker;

import static com.tterrag.registrate.Registrate.*;

@Mod(SewersNSystems.MOD_ID)
public class SewersNSystems
{
    public static final String MOD_ID = "sewers_n_systems";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String ID = "sewers_n_systems";

    public static final Registrate REGISTRATE = create(ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public SewersNSystems(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModTags.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
    public static Registrate registrate() {
        // Only allow classes from your mod to call this
        if (!STACK_WALKER.getCallerClass().getPackageName().startsWith("com.createmodfan.sewersnsystems")) {
            throw new UnsupportedOperationException(
                    "Other mods are not permitted to use Sewers N' Systems' registrate instance."
            );
        }
        return REGISTRATE;
    }
private static final StackWalker STACK_WALKER = null;
}
