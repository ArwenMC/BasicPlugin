package com.arwenmc;

import com.arwenmc.commands.BasicCommand;
import com.arwenmc.commands.PlayerCommand;
import com.arwenmc.commands.TabCompleteCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin { // The main plugin class should always have the same name as the project and never be called Main.

    public String NOT_PLAYER = GAC("general.not_player"); // Either hardcoded or get from config.
    public String NO_PERMISSION = GAC("general.no_permission");

    public Permission BP_ADMIN = new Permission("bp.admin"); // easily change the node here without changing the variable.
    public Permission BP_USER = new Permission("bp.user"); // the user permission

    @Override
    public void onEnable() {
        getCommand("basiccommand").setExecutor(new BasicCommand(this));
        getCommand("playercommand").setExecutor(new PlayerCommand(this));
        getCommand("tabcomplete").setTabCompleter(new TabCompleteCommand(this));
    }

    @Override
    public void onDisable() {

    }

    private String GAC(String path) { // Get And Colour - a function that gets config values and colourises them.
        String configValue = this.getConfig().getString(path);
        String coloredValue = ChatColor.translateAlternateColorCodes('&', configValue);
        return coloredValue;
    }

}
