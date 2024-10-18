package com.adex.compl.item;

import com.adex.compl.util.Util;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModItems {

    public static final Item TRANSISTOR = new Item(new Item.Settings());

    public static void registerItems() {
        Registry.register(Registries.ITEM, Util.id("transistor"), TRANSISTOR);
    }

    public static void addToItemGroup(Item item, RegistryKey<ItemGroup> itemGroup) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(ig -> ig.add(item));
    }

}
