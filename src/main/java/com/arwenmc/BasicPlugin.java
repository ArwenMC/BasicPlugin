package com.arwenmc;

import com.arwenmc.commands.BasicCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin { // The main plugin class should always have the same name as the project and never be called Main.

    @Override
    public void onEnable() {
        getCommand("basiccommand").setExecutor(new BasicCommand(this));
    }

    @Override
    public void onDisable() {

    }

}
