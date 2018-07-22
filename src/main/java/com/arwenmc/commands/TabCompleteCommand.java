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

public class TabCompleteCommand implements CommandExecutor, TabExecutor {

    BasicPlugin plugin;
    public TabCompleteCommand(BasicPlugin instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(" ");
        }
        commandSender.sendMessage(ChatColor.GREEN + sb.toString());
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> listZero = Arrays.asList("I", "You", "We", "He", "She", "They");
        List<String> listOne = Arrays.asList("love", "hate", "eat", "throw");
        List<String> listTwo = Arrays.asList("bacon", "ball", "you", "her");
        // this can extended to how many subcommands that are required but I felt three enough
        List<String> listFinal = Lists.newArrayList();

        switch (args.length) {
            case 1:
                for (String s : listZero) {
                    if (s.startsWith(args[0])) listFinal.add(s);
                }
                return listFinal;
            case 2:
                for (String s : listOne) {
                    if (s.startsWith(args[1])) listFinal.add(s);
                }
                return listFinal;
            case 3:
                for (String s : listTwo) {
                    if (s.startsWith(args[2])) listFinal.add(s);
                }
                return listFinal;
        }
        return null;
    }
}
