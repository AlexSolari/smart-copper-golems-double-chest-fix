package com.anantaya.smartcgolem.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemFrameHelper {

    public static ItemStack getFramedItem(
            ServerLevel level,
            BlockPos chestPos
    ) {

        for (Direction direction : Direction.values()) {

            BlockPos framePos =
                    chestPos.relative(direction);

            AABB searchBox =
                    new AABB(framePos).inflate(0.5);

            List<ItemFrame> frames =
                    level.getEntitiesOfClass(
                            ItemFrame.class,
                            searchBox
                    );

            for (ItemFrame frame : frames) {

                Direction attachedFace =
                        frame.getDirection();

                if (attachedFace != direction) {
                    continue;
                }

                ItemStack displayed =
                        frame.getItem();

                if (!displayed.isEmpty()) {
                    return displayed;
                }
            }
        }

        return ItemStack.EMPTY;
    }
}