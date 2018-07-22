package com.arwenmc;

import com.arwenmc.commands.BasicCommand;
import com.arwenmc.commands.PlayerCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin { // The main plugin class should always have the same name as the project and never be called Main.

    public String NOT_PLAYER = ChatColor.RED + "You must be a player in order to use this command.";

    @Override
    public void onEnable() {
        getCommand("basiccommand").setExecutor(new BasicCommand(this));
        getCommand("playercommand").setExecutor(new PlayerCommand(this));
    }

    @Override
    public void onDisable() {

    }



}