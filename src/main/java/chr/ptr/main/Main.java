package chr.ptr.main;

import chr.ptr.main.commands.MoneyCommand;
import chr.ptr.main.commands.PayCommand;
import chr.ptr.main.commands.admin.SetMoneyCommand;
import chr.ptr.main.listeners.JoinEvent;
import chr.ptr.main.logs.GBLogger;
import chr.ptr.main.managers.GBManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    private static GBManager gbmanager = GBManager.getInstance();
    public String logPath = this.getDataFolder().getPath();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("setmoney").setExecutor(new SetMoneyCommand());
        new BukkitRunnable(){
            @Override
            public void run() {
                GBLogger.fileName();
            }
        }.runTaskTimer(this,0,10*60*20);
    }

    public static GBManager getBank(){
        return gbmanager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
