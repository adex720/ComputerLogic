package com.adex.compl.block;

import com.adex.compl.block.logicgate.*;
import com.adex.compl.item.ModItems;
import com.adex.compl.util.Util;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {

    public static final LogicGateNot LOGIC_CAGE_NOT = new LogicGateNot(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateAnd LOGIC_CAGE_AND = new LogicGateAnd(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateNand LOGIC_CAGE_NAND = new LogicGateNand(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateOr LOGIC_CAGE_OR = new LogicGateOr(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateNor LOGIC_CAGE_NOR = new LogicGateNor(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateXor LOGIC_CAGE_XOR = new LogicGateXor(LogicGate.LOGIC_GATE_SETTINGS);
    public static final LogicGateXnor LOGIC_CAGE_XNOR = new LogicGateXnor(LogicGate.LOGIC_GATE_SETTINGS);

    public static final BlockItem LOGIC_CAGE_NOT_ITEM = new BlockItem(LOGIC_CAGE_NOT, new Item.Settings());
    public static final BlockItem LOGIC_CAGE_AND_ITEM = new BlockItem(LOGIC_CAGE_AND, new Item.Settings());
    public static final BlockItem LOGIC_CAGE_NAND_ITEM = new BlockItem(LOGIC_CAGE_NAND, new Item.Settings());
    public static final BlockItem LOGIC_CAGE_OR_ITEM = new BlockItem(LOGIC_CAGE_OR, new Item.Settings());
    public static final BlockItem LOGIC_CAGE_NOR_ITEM = new BlockItem(LOGIC_CAGE_NOR, new Item.Settings());
    public static final BlockItem LOGIC_CAGE_XOR_ITEM = new BlockItem(LOGIC_CAGE_XOR, new Item.Settings());
    public static final BlockItem LOGIC_CAGE_XNOR_ITEM = new BlockItem(LOGIC_CAGE_XNOR, new Item.Settings());

    /**
     * Calls {@link ModBlocks#registerBlockItems()}
     */
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, Util.id("logic_cage_not"), LOGIC_CAGE_NOT);
        Registry.register(Registries.BLOCK, Util.id("logic_cage_and"), LOGIC_CAGE_AND);
        Registry.register(Registries.BLOCK, Util.id("logic_cage_nand"), LOGIC_CAGE_NAND);
        Registry.register(Registries.BLOCK, Util.id("logic_cage_or"), LOGIC_CAGE_OR);
        Registry.register(Registries.BLOCK, Util.id("logic_cage_nor"), LOGIC_CAGE_NOR);
        Registry.register(Registries.BLOCK, Util.id("logic_cage_xor"), LOGIC_CAGE_XOR);
        Registry.register(Registries.BLOCK, Util.id("logic_cage_xnor"), LOGIC_CAGE_XNOR);

        registerBlockItems();
    }

    /**
     * Calls {@link ModBlocks#addToItemGroups()}
     */
    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, Util.id("logic_cage_not"), LOGIC_CAGE_NOT_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_cage_and"), LOGIC_CAGE_AND_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_cage_nand"), LOGIC_CAGE_NAND_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_cage_or"), LOGIC_CAGE_OR_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_cage_nor"), LOGIC_CAGE_NOR_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_cage_xor"), LOGIC_CAGE_XOR_ITEM);
        Registry.register(Registries.ITEM, Util.id("logic_cage_xnor"), LOGIC_CAGE_XNOR_ITEM);

        addToItemGroups();
    }

    public static void addToItemGroups() {
        ModItems.addToItemGroup(LOGIC_CAGE_NOT_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_CAGE_AND_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_CAGE_NAND_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_CAGE_OR_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_CAGE_NOR_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_CAGE_XOR_ITEM, ItemGroups.REDSTONE);
        ModItems.addToItemGroup(LOGIC_CAGE_XNOR_ITEM, ItemGroups.REDSTONE);
    }
}
