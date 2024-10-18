package com.adex.compl.block;

import com.adex.compl.block.logicgate.LogicGateNot;
import com.adex.compl.util.Util;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final LogicGateNot LOGIC_CAGE_NOT = new LogicGateNot(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.METAL)
            .strength(5.0F, 6.0F)
            .mapColor(MapColor.IRON_GRAY)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .pistonBehavior(PistonBehavior.BLOCK)
            .solidBlock(Blocks::never));

    public static final BlockItem LOGIC_CAGE_NOT_ITEM = new BlockItem(LOGIC_CAGE_NOT, new Item.Settings());

    /**
     * Also registers block items
     */
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, Util.id("logic_cage_not"), LOGIC_CAGE_NOT);

        registerBlockItems();
    }

    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, Util.id("logic_cage_not"), LOGIC_CAGE_NOT_ITEM);
    }
}
