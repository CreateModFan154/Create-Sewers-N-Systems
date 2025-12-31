package com.createmodfan.sewersnsystems.core;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SNSCasingBlock extends CasingBlock implements IWrenchable {

    public SNSCasingBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        return InteractionResult.FAIL;
    }
}