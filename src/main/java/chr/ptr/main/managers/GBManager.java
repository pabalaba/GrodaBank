package chr.ptr.main.managers;

import chr.ptr.main.entities.GBPlayer;
import chr.ptr.main.logs.GBLAction;
import chr.ptr.main.logs.GBLog;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GBManager {
    public static HashMap<UUID, GBPlayer> bank = new HashMap<>();
    public static GBPlayer console = new GBPlayer(UUID.randomUUID(),null, BigDecimal.valueOf(999999999));
    public static ArrayList<GBLog> logs = new ArrayList<>();
    public static GBPlayer getPlayer(Player player){
        if(!bank.containsKey(player.getUniqueId()))
            return null;
        return bank.get(player.getUniqueId());
    }

    public static GBPlayer getPlayer(UUID uuid){
        if(!bank.containsKey(uuid))
            return null;
        return bank.get(uuid);
    }

    public static void addPlayer(UUID uuid){
        if(getPlayer(uuid) == null)
            bank.put(uuid,new GBPlayer(uuid));
    }

    public static void addPlayer(Player player){
        if(getPlayer(player) == null)
            bank.put(player.getUniqueId(),new GBPlayer(player));
    }

    public static void removePlayer(Player player){
        if(getPlayer(player) != null)
            bank.remove(player.getUniqueId());
    }

    public static void removePlayer(UUID uuid){
        if(getPlayer(uuid) != null)
            bank.remove(uuid);
    }

    public static void addLog(GBLog log){
        logs.add(log);
    }

    public static void addLog(GBLAction action,BigDecimal amount,String sender,String receiver){
        logs.add(new GBLog(action,amount,sender,receiver));
    }

    public static void printLogs(){
        logs.forEach(System.out::println);
    }

    public static void printLogs(String who,boolean sender){
        if(sender)
            logs.stream().filter(x -> x.getSender().equalsIgnoreCase(who)).forEach(System.out::println);
        else
            logs.stream().filter(x -> x.getReceiver().equalsIgnoreCase(who)).forEach(System.out::println);
    }

    public static void printLogs(BigDecimal amount){
        logs.stream().filter(x -> x.getValue().compareTo(amount) == 1).forEach(System.out::println);
    }

    public static void printLogs(GBLAction action){
        logs.stream().filter(x -> x.getAction()==action).forEach(System.out::println);
    }

}
