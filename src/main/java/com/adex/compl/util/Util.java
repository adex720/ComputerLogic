package com.adex.compl.util;

import com.adex.compl.init.ComputerLogic;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class Util {

    public static Identifier id(String name) {
        return Identifier.of(ComputerLogic.MOD_ID, name);
    }

    /**
     * Returns true if the position is right next to the start position in the given direction
     *
     * @param startPos
     * @param goalPos
     * @param direction
     * @return
     */
    public static boolean isPositionInDirection(BlockPos startPos, BlockPos goalPos, Direction direction) {
        return isPositionInDirection(startPos, goalPos, direction, 1);
    }

    public static boolean isPositionInDirection(BlockPos startPos, BlockPos goalPos, Direction direction, int offset) {
        return startPos.getX() + direction.getOffsetX() * offset == goalPos.getX() &&
                startPos.getY() + direction.getOffsetY() * offset == goalPos.getY() &&
                startPos.getZ() + direction.getOffsetZ() * offset == goalPos.getZ();
    }

}
