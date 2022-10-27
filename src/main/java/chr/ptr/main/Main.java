package chr.ptr.main;

import chr.ptr.main.commands.LogsCommand;
import chr.ptr.main.commands.MoneyCommand;
import chr.ptr.main.commands.PayCommand;
import chr.ptr.main.listeners.JoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("logs").setExecutor(new LogsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
