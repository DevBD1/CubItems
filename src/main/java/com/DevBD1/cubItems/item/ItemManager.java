package com.DevBD1.cubItems.item;

import com.DevBD1.corlex.api.lore.ClientSideLoreService;
import de.tr7zw.changeme.nbtapi.NBTItem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.logging.Logger;

public class ItemManager {

    private static final Map<String, ItemStack> REGISTERED_ITEMS = new HashMap<>();

    public static void loadItems(FileConfiguration config, ClientSideLoreService loreService) {
        Logger log = Bukkit.getLogger();

        ConfigurationSection itemsSection = config.getConfigurationSection("items");
        if (itemsSection == null) {
            log.warning("[CubItems] No items defined in items.yml.");
            return;
        }

        for (String key : itemsSection.getKeys(false)) {
            ConfigurationSection itemSection = itemsSection.getConfigurationSection(key);
            if (itemSection == null) continue;

            String materialName = itemSection.getString("material", "STONE");
            Material material = Material.getMaterial(materialName.toUpperCase(Locale.ROOT));

            if (material == null) {
                log.warning("[CubItems] Invalid material: " + materialName + " for item: " + key);
                continue;
            }

            ItemStack baseItem = new ItemStack(material);
            ItemMeta meta = baseItem.getItemMeta();
            if (meta == null) continue;

            // Display Name
            if (itemSection.contains("display_name")) {
                meta.setDisplayName(color(itemSection.getString("display_name")));
            }

            // Lore
            List<String> loreLines = itemSection.getStringList("lore");
            if (loreService == null) {
                meta.setLore(color(loreLines));
            } else {
                //loreService.setClientSideLore(baseItem, loreLines, player -> true);
            }

            baseItem.setItemMeta(meta);

            // Add NBT tags
            NBTItem nbtItem = new NBTItem(baseItem);
            if (itemSection.contains("nbt")) {
                ConfigurationSection nbtSection = itemSection.getConfigurationSection("nbt");
                if (nbtSection != null) {

                    for (String configKey : nbtSection.getKeys(false)) {
                        String value = nbtSection.getString(configKey);

                        if ("customKey".equalsIgnoreCase(configKey)) {
                            nbtItem.setString("cubItems", value); // ✅ Proper internal tag
                        } else {
                            nbtItem.setString(configKey, value);
                        }
                    }
                }
            }


            ItemStack finalItem = nbtItem.getItem();
            REGISTERED_ITEMS.put(key, finalItem);
            log.info("[CubItems] Loaded item: " + key);
        }
    }

    public static ItemStack getItem(String key) {
        return REGISTERED_ITEMS.get(key);
    }

    private static String color(String text) {
        return text == null ? null : text.replace('&', '§');
    }

    private static List<String> color(List<String> lines) {
        List<String> colored = new ArrayList<>();
        for (String line : lines) {
            colored.add(color(line));
        }
        return colored;
    }
}
