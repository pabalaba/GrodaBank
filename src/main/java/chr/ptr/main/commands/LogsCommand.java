package chr.ptr.main.commands;

import chr.ptr.main.logs.GBLAction;
import chr.ptr.main.managers.GBManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class LogsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player)
            return true;

        if(args.length == 0)
            GBManager.printLogs();

        switch (args[0].toLowerCase()) {
            case "receiver", "r" -> {
                if (args.length == 1)
                    return true;
                GBManager.printLogs(args[1], false);
            }
            case "sender", "s" -> {
                if (args.length == 1)
                    return true;
                GBManager.printLogs(args[1], true);
            }
            case "pay" -> {
                GBManager.printLogs(GBLAction.PAY);
            }
            default -> {
                try {
                    BigDecimal decimal = new BigDecimal(args[0]);
                    GBManager.printLogs(decimal);
                }catch (Exception e){
                    System.out.println("Invalid Amount!");
                }
            }
        }

        return true;
    }
}
