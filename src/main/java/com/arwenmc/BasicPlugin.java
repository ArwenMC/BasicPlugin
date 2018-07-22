package com.arwenmc;

import com.arwenmc.commands.BasicCommand;
import com.arwenmc.commands.PlayerCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin { // The main plugin class should always have the same name as the project and never be called Main.

    public String NOT_PLAYER = ChatColor.RED + "You must be a player in order to use this command."; // Either hardcoded or get from config.
    public String NO_PERMISSION = ChatColor.RED + "You do not have permission to use this command.";

    public Permission BP_ADMIN = new Permission("basicplugin.admin");

    @Override
    public void onEnable() {
        getCommand("basiccommand").setExecutor(new BasicCommand(this));
        getCommand("playercommand").setExecutor(new PlayerCommand(this));
    }

    @Override
    public void onDisable() {

    }



}
