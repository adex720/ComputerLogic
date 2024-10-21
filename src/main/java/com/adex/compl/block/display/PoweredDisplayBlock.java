package com.adex.compl.block.display;

import com.adex.compl.util.Util;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PoweredDisplayBlock extends Block {

    public static final IntProperty VALUE = Properties.POWER;

    public static final MapCodec<PoweredDisplayBlock> CODEC = Block.createCodec(PoweredDisplayBlock::new);

    public PoweredDisplayBlock(Settings settings) {
        super(settings);
        setDefaultState(stateManager.getDefaultState().with(VALUE, 0));
    }

    @Override
    protected MapCodec<? extends PoweredDisplayBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(VALUE));
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        updateState(world, pos, state);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        updateState(world, pos, state);
    }

    public void updateState(World world, BlockPos pos, BlockState state) {
        int oldValue = state.get(VALUE);

        int value1 = receivedPowerFrom(world, pos, Direction.NORTH);
        int value2 = receivedPowerFrom(world, pos, Direction.SOUTH);
        int value3 = receivedPowerFrom(world, pos, Direction.WEST);
        int value4 = receivedPowerFrom(world, pos, Direction.EAST);

        int newValue = Util.max(value1, value2, value3, value4);
        if (oldValue == newValue) return;
        world.setBlockState(pos, state.with(VALUE, newValue));
    }

    public int receivedPowerFrom(World world, BlockPos ownPos, Direction direction) {
        BlockPos sourcePos = ownPos.offset(direction);
        BlockState sourceState = world.getBlockState(sourcePos);

        return sourceState.getWeakRedstonePower(world, sourcePos, direction);
    }

}
