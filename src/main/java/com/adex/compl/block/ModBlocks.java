package com.adex.compl.block;

import com.adex.compl.block.display.BinaryDisplayBlock;
import com.adex.compl.block.display.PoweredDisplayBlock;
import com.adex.compl.block.logicgate.*;
import com.adex.compl.item.ModItems;
import com.adex.compl.util.Util;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final LogicGateNot LOGIC_GATE_NOT = new LogicGateNot(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateAnd LOGIC_GATE_AND = new LogicGateAnd(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateNand LOGIC_GATE_NAND = new LogicGateNand(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateOr LOGIC_GATE_OR = new LogicGateOr(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateNor LOGIC_GATE_NOR = new LogicGateNor(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateXor LOGIC_GATE_XOR = new LogicGateXor(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateXnor LOGIC_GATE_XNOR = new LogicGateXnor(LogicGate.LOGIC_GATE_SETTINGS);

    public static final BinaryDisplayBlock BINARY_DISPLAY_BLOCK = new BinaryDisplayBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.METAL)
            .strength(3.0F, 3.0F)
            .mapColor(MapColor.BROWN)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .pistonBehavior(PistonBehavior.BLOCK)
            .solidBlock(Blocks::never));
    public static final PoweredDisplayBlock POWERED_DISPLAY_BLOCK = new PoweredDisplayBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.METAL)
            .strength(3.0F, 3.0F)
            .mapColor(MapColor.BROWN)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .pistonBehavior(PistonBehavior.BLOCK)
            .solidBlock(Blocks::never));


    public static final BlockItem LOGIC_GATE_NOT_ITEM = new BlockItem(LOGIC_GATE_NOT, new Item.Settings());
    public static final BlockItem LOGIC_GATE_AND_ITEM = new BlockItem(LOGIC_GATE_AND, new Item.Settings());
    public static final BlockItem LOGIC_GATE_NAND_ITEM = new BlockItem(LOGIC_GATE_NAND, new Item.Settings());
    public static final BlockItem LOGIC_GATE_OR_ITEM = new BlockItem(LOGIC_GATE_OR, new Item.Settings());
    public static final BlockItem LOGIC_GATE_NOR_ITEM = new BlockItem(LOGIC_GATE_NOR, new Item.Settings());
    public static final BlockItem LOGIC_GATE_XOR_ITEM = new BlockItem(LOGIC_GATE_XOR, new Item.Settings());
    public static final BlockItem LOGIC_GATE_XNOR_ITEM = new BlockItem(LOGIC_GATE_XNOR, new Item.Settings());

    public static final BlockItem BINARY_DISPLAY_BLOCK_ITEM = new BlockItem(BINARY_DISPLAY_BLOCK, new Item.Settings());
    public static final BlockItem POWERED_DISPLAY_BLOCK_ITEM = new BlockItem(POWERED_DISPLAY_BLOCK, new Item.Settings());

    /**
     * Calls {@link ModBlocks#registerBlockItems()}
     */
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, Util.id("logic_gate_not"), LOGIC_GATE_NOT);
        Registry.register(Registries.BLOCK, Util.id("logic_gate_and"), LOGIC_GATE_AND);
        Registry.register(Registries.BLOCK, Util.id("logic_gate_nand"), LOGIC_GATE_NAND);
        Registry.register(Registries.BLOCK, Util.id("logic_gate_or"), LOGIC_GATE_OR);
        Registry.register(Registries.BLOCK, Util.id("logic_gate_nor"), LOGIC_GATE_NOR);
        Registry.register(Registries.BLOCK, Util.id("logic_gate_xor"), LOGIC_GATE_XOR);
        Registry.register(Registries.BLOCK, Util.id("logic_gate_xnor"), LOGIC_GATE_XNOR);

        Registry.register(Registries.BLOCK, Util.id("binary_display_block"), BINARY_DISPLAY_BLOCK);
        Registry.register(Registries.BLOCK, Util.id("powered_display_block"), POWERED_DISPLAY_BLOCK);

        registerBlockItems();
    }

    /**
     * Calls {@link ModBlocks#addToItemGroups()}
     */
    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, Util.id("logic_gate_not"), LOGIC_GATE_NOT_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_gate_and"), LOGIC_GATE_AND_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_gate_nand"), LOGIC_GATE_NAND_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_gate_or"), LOGIC_GATE_OR_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_gate_nor"), LOGIC_GATE_NOR_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_gate_xor"), LOGIC_GATE_XOR_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_gate_xnor"), LOGIC_GATE_XNOR_ITEM);

        Registry.register(Registries.ITEM, Util.id("binary_display_block"), BINARY_DISPLAY_BLOCK_ITEM);
        Registry.register(Registries.ITEM, Util.id("powered_display_block"), POWERED_DISPLAY_BLOCK_ITEM);

        addToItemGroups();
    }

    public static void addToItemGroups() {
        ModItems.addToItemGroup(LOGIC_GATE_NOT_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_GATE_AND_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_GATE_NAND_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_GATE_OR_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_GATE_NOR_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_GATE_XOR_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_GATE_XNOR_ITEM, ItemGroups.REDSTONE);

        ModItems.addToItemGroup(BINARY_DISPLAY_BLOCK_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(POWERED_DISPLAY_BLOCK_ITEM, ItemGroups.REDSTONE);
    }
}
