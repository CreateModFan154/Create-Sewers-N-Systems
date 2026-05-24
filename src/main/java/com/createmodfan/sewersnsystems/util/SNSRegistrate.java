package com.createmodfan.sewersnsystems.util;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.Nullable;

import com.simibubi.create.CreateClient;
import com.simibubi.create.api.behaviour.display.DisplaySource;
import com.simibubi.create.api.behaviour.display.DisplayTarget;
import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.simibubi.create.api.contraption.storage.item.MountedItemStorageType;
import com.simibubi.create.api.registrate.CreateRegistrateRegistrationCallback;
import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.api.registry.registrate.SimpleBuilder;
import com.simibubi.create.content.decoration.encasing.CasingConnectivity;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.block.connected.CTModel;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.BlockEntityBuilder.BlockEntityFactory;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.createmod.catnip.platform.CatnipServices;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
public class SNSRegistrate {
    public static <T extends Block> NonNullConsumer<? super T> casingConnectivity(
            BiConsumer<T, CasingConnectivity> consumer) {
        return entry -> onClient(() -> () -> registerCasingConnectivity(entry, consumer));
    }
    public static <T extends Block> NonNullConsumer<? super T> connectedTextures(
            Supplier<ConnectedTextureBehaviour> behavior) {
        return entry -> onClient(() -> () -> registerCTBehviour(entry, behavior));
    }

    @OnlyIn(Dist.CLIENT)
    private static <T extends Block> void registerCasingConnectivity(T entry,
                                                                     BiConsumer<T, CasingConnectivity> consumer) {
        consumer.accept(entry, CreateClient.CASING_CONNECTIVITY);
    }
    protected static void onClient(Supplier<Runnable> toRun) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, toRun);
    }
    @OnlyIn(Dist.CLIENT)
    private static void registerCTBehviour(Block entry, Supplier<ConnectedTextureBehaviour> behaviorSupplier) {
        ConnectedTextureBehaviour behavior = behaviorSupplier.get();
        CreateClient.MODEL_SWAPPER.getCustomBlockModels()
                .register(CatnipServices.REGISTRIES.getKeyOrThrow(entry), model -> new CTModel(model, behavior));
    }
}
