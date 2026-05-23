package com.createmodfan.sewersnsystems;

import com.createmodfan.sewersnsystems.SewersNSystems;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.createmod.catnip.render.SpriteShiftEntry;
import net.createmod.catnip.render.SpriteShifter;

public class SNSSpriteShifts {
    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }
    public static final CTSpriteShiftEntry SEWER_CASING = omni("sewer_casing");

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, SewersNSystems.asResource("block/" + blockTextureName), SewersNSystems.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

    private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
        return SpriteShifter.get(SewersNSystems.asResource(originalLocation), SewersNSystems.asResource(targetLocation));
    }
}
