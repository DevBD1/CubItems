package com.DevBD1.cubItems.util;

import de.tr7zw.changeme.nbtapi.NBTItem;

import org.bukkit.inventory.ItemStack;

public class ItemUtils {
    private static final String NBT_KEY = "cubItems";
    public static boolean isCustomItem(ItemStack item, String key) {
        if (item == null || item.getType().isAir()) return false;
        NBTItem nbt = new NBTItem(item);
        return nbt.hasTag(NBT_KEY) && key.equals(nbt.getString(NBT_KEY));
    }
    public static String getCustomItemKey(ItemStack item) {
        if (item == null || item.getType().isAir()) return null;
        NBTItem nbt = new NBTItem(item);
        return nbt.getString(NBT_KEY);
    }
}