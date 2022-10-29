package chr.ptr.main.managers;

import chr.ptr.main.entities.GBPlayer;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GBManager {
    public static HashMap<UUID, GBPlayer> bank = new HashMap<>();
    public static GBPlayer console = new GBPlayer(UUID.randomUUID(),null, BigDecimal.valueOf(999999999));
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

}
