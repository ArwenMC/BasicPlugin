package com.arwenmc.commands;

import com.arwenmc.BasicPlugin;
import net.md_5.bungee.api.ChatColor; // Use md_5's ChatColor not Bukkits
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BasicCommand implements CommandExecutor {

    BasicPlugin plugin;
    public BasicCommand(BasicPlugin instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        commandSender.sendMessage(ChatColor.GREEN + "BasicCommand successfully completed");
        return true;
    }

}
