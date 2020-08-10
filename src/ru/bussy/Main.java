package ru.bussy;

import org.bukkit.plugin.java.JavaPlugin;
import ru.bussy.commands.*;

public class Main extends JavaPlugin {
    public void onEnable() {
        getCommand("me").setExecutor(new me(this));
        getCommand("gme").setExecutor(new gme(this));
        getCommand("try").setExecutor(new Try(this));
        getCommand("gtry").setExecutor(new gtry(this));
    }
}
