package chr.ptr.main.commands;

import chr.ptr.main.Main;
import chr.ptr.main.logs.GBLogger;
import chr.ptr.main.managers.GBManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player player)){
            Player rec = null;
            BigDecimal amount = BigDecimal.ZERO;
            try {
                rec = Bukkit.getPlayer(args[0]);
            }catch (Exception e){
                return true;
            }
            if(rec==null) {
                sender.sendMessage("Invalid player!");
                return true;
            }
            try{
                amount = new BigDecimal(args[1]);
            }catch (Exception e){
                sender.sendMessage("Invalid amount!");
                return true;
            }
            if(amount.equals(BigDecimal.ZERO))
                return true;
            Main.getBank().getPlayer(rec).deposit(amount);
            Main.getBank().getConsole().withdraw(amount);
            rec.sendMessage("You received "+amount+" from console!");
            sender.sendMessage("You sent "+amount+" to "+rec.getDisplayName()+"!");
            GBLogger.writeLogPay(amount,rec.getDisplayName(),"console");
            return true;
        }

        return true;
    }
}
