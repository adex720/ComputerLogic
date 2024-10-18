package com.adex.compl.block.logicgate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class LogicGate extends HorizontalFacingBlock {

    public LogicGate(Settings settings) {
        super(settings);
        setDefaultState(createDefaultState());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING));
    }

    protected BlockState createDefaultState() {
        return this.stateManager.getDefaultState().with(FACING, Direction.NORTH);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        updateState(world, state, pos);
        update(world, pos, state);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        if (updateStatus(world, pos, state)) {
            update(world, pos, state);
        }
    }

    /**
     * @return true if the state was changed
     */
    public boolean updateStatus(World world, BlockPos pos, BlockState state) {
        boolean old = getOutput(state);
        updateState(world, state, pos);
        boolean updated = getOutput(state);

        return old != updated;
    }

    public abstract void updateState(World world, BlockState state, BlockPos pos);

    public void update(World world, BlockPos pos, BlockState state) {
        world.updateNeighbor(pos.offset(state.get(FACING)), this, pos);
    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return direction == state.get(FACING).getOpposite() && getOutput(state) ? 15 : 0;
    }

    @Override
    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true; // always connect to redstone
    }

    public BlockPos getOutputPos(BlockPos ownPos, BlockState state) {
        return ownPos.offset(state.get(FACING));
    }

    public Direction getOutputDirection(BlockState state) {
        return state.get(FACING);
    }

    public abstract boolean getOutput(BlockState state);

    public boolean isReceivingPowerFrom(World world, BlockPos sourcePos, BlockState sourceState, Direction direction) {
        return sourceState.getWeakRedstonePower(world, sourcePos, direction.getOpposite()) > 0;
    }

}
