package com.adex.compl.block.logicgate;

import com.adex.compl.gamerule.ModGameRules;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.tick.TickPriority;
import org.jetbrains.annotations.Nullable;

public abstract class LogicGate extends HorizontalFacingBlock {

    public static final Settings LOGIC_GATE_SETTINGS = AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.METAL)
            .strength(5.0F, 6.0F)
            .mapColor(MapColor.IRON_GRAY)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .pistonBehavior(PistonBehavior.BLOCK)
            .solidBlock(Blocks::never);

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

        scheduleUpdate(world, pos, state);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        scheduleUpdate(world, pos, state);
    }

    /**
     * @return True if the state was updated
     */
    public abstract boolean updateState(World world, BlockState state, BlockPos pos);

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        update(world, pos, state);
    }

    public void update(World world, BlockPos pos, BlockState state) {
        if (updateState(world, state, pos)) {
            world.updateNeighbor(pos.offset(state.get(FACING)), this, pos);
        }
    }

    public void scheduleUpdate(World world, BlockPos pos, BlockState state) {
        if (world.getBlockTickScheduler().isTicking(pos, this)) return; // Update is already scheduled
        world.scheduleBlockTick(pos, this, world.getGameRules().getInt(ModGameRules.LOGIC_GATE_DELAY), getOutput(state) ? TickPriority.VERY_HIGH : TickPriority.HIGH);
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
