package com.arwenmc.commands;

import com.arwenmc.BasicPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {

    BasicPlugin plugin;
    public PlayerCommand(BasicPlugin instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (player.hasPermission(plugin.BP_ADMIN)) {
                player.sendMessage(ChatColor.GREEN + "You are an admin and had permission to use this admin section.");
                return true;
            } else {
                player.sendMessage(ChatColor.GREEN + "You are a player and were able to use this command.");
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
    }
}
