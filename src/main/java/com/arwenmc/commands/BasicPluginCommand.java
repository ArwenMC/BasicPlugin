package com.arwenmc.commands;

import com.arwenmc.BasicPlugin;
import com.google.common.collect.Lists;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public class BasicPluginCommand implements CommandExecutor, TabExecutor {

    BasicPlugin plugin;
    public BasicPluginCommand(BasicPlugin instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender.hasPermission(plugin.BP_ADMIN)) {
            switch (args[0]) {
                case "reload":
                    plugin.reloadConfig();
                    plugin.updateConfig();
                default:
                    commandSender.sendMessage(ChatColor.RED + "That particular sub command was not found.");
            }
            return true;
        } else {
            commandSender.sendMessage(plugin.NO_PERMISSION);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> listZero = Arrays.asList("reload");
        List<String> listFinal = Lists.newArrayList();

        switch (args.length) {
            case 1:
                for (String s : listZero) {
                    if (s.startsWith(args[0])) listFinal.add(s);
                }
                return listFinal;
        }

        return null;
    }
}
