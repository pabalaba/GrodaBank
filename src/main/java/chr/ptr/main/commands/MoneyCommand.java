package chr.ptr.main.commands;

import chr.ptr.main.managers.GBManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)){
            sender.sendMessage(ChatColor.RED+"Balance: "+ GBManager.console.getBalance()+" groda conis");
            return true;
        }

        sender.sendMessage(ChatColor.RED+"Balance: "+ GBManager.getPlayer(player).getBalance()+" groda conis");
        return true;
    }
}
