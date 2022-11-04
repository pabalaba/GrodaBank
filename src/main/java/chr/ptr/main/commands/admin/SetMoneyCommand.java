package chr.ptr.main.commands.admin;

import chr.ptr.main.Main;
import chr.ptr.main.logs.GBLogger;
import chr.ptr.main.managers.GBManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class SetMoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player && !player.hasPermission(".setMoney")) {
            sender.sendMessage(ChatColor.RED+"You don't have the permission!");
            return true;
        }

        if(args.length < 2)
            return false;
        Player target = null;
        try{
            target = Bukkit.getPlayer(args[0]);
            if(target==null){
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }
        }catch (Exception e){
            GBLogger.write(e.getMessage());
            return true;
        }

        BigDecimal amount = BigDecimal.ZERO;
        try{
            amount = new BigDecimal(args[1]);
            if(amount.compareTo(BigDecimal.ZERO) < 0) {
                sender.sendMessage(ChatColor.RED + "Amount can't be negative!");
                return true;
            }
        }catch (Exception e){
            GBLogger.write(e.getMessage());
            sender.sendMessage(ChatColor.RED + "Amount bad formatted!");
            return true;
        }

        Main.getBank().getPlayer(target).setBalance(amount);
        GBLogger.writeLogSet(amount,target.getDisplayName(),sender instanceof Player player?player.getDisplayName():"console");
        return true;
    }
}
