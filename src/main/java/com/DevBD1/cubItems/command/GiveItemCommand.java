package com.DevBD1.cubItems.command;

import com.DevBD1.cubItems.item.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("Usage: /giveitem <item-key>");
            return true;
        }

        String key = args[0];
        ItemStack item = ItemManager.getItem(key);

        if (item == null) {
            player.sendMessage("§cUnknown item: " + key);
            return true;
        }

        player.getInventory().addItem(item.clone());
        player.sendMessage("§aGiven item: " + key);
        return true;
    }
}
