package com.DevBD1.cubItems;

import com.DevBD1.corlex.api.lore.ClientSideLoreService;
import com.DevBD1.cubItems.command.GiveItemCommand;
import com.DevBD1.cubItems.item.ItemManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main instance;
    private ClientSideLoreService loreService;

    private FileConfiguration itemsConfig;

    @Override
    public void onEnable() {
        instance = this;

        // Load config.yml
        saveDefaultConfig();

        // Load items.yml
        loadItemsConfig();

        // Corlex integration
        if (getServer().getPluginManager().isPluginEnabled("Corlex")) {
            getLogger().info("Corlex detected. Enabling message and command localizations and client-side lore support...");
            loreService = getServer().getServicesManager().load(ClientSideLoreService.class);

            if (loreService == null) {
                getLogger().warning("Failed to load Corlex API service.");
            }
        } else {
            getLogger().warning("Corlex not found. Localizations and client-side lore support will be disabled.");
        }

        // Load custom items
        ItemManager.loadItems(getItemsConfig(), loreService);

        getLogger().info("CubItems has been enabled.");

        getCommand("giveitem").setExecutor(new GiveItemCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("CubItems has been disabled.");
    }

    private void loadItemsConfig() {
        File file = new File(getDataFolder(), "items.yml");
        if (!file.exists()) {
            saveResource("items.yml", false);
        }
        itemsConfig = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getItemsConfig() {
        return itemsConfig;
    }

    public static Main getInstance() {
        return instance;
    }

    public ClientSideLoreService getLoreService() {
        return loreService;
    }
}
