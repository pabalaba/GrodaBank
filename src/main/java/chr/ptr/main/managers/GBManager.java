package chr.ptr.main.managers;

import chr.ptr.main.entities.GBPlayer;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

public class GBManager {
    private HashMap<UUID, GBPlayer> bank = new HashMap<>();

    private static GBManager manager = new GBManager();
    private GBPlayer console = new GBPlayer(UUID.randomUUID(),null, BigDecimal.valueOf(999999999));

    private GBManager() {

    }

    public static GBManager getInstance(){
        return manager;
    }

    public GBPlayer getPlayer(Player player){
        if(!bank.containsKey(player.getUniqueId()))
            return null;
        return bank.get(player.getUniqueId());
    }

    public GBPlayer getPlayer(UUID uuid){
        if(!bank.containsKey(uuid))
            return null;
        return bank.get(uuid);
    }

    public void addPlayer(UUID uuid){
        if(getPlayer(uuid) == null)
            bank.put(uuid,new GBPlayer(uuid));
    }

    public void addPlayer(Player player){
        if(getPlayer(player) == null)
            bank.put(player.getUniqueId(),new GBPlayer(player));
    }

    public void removePlayer(Player player){
        if(getPlayer(player) != null)
            bank.remove(player.getUniqueId());
    }

    public void removePlayer(UUID uuid){
        if(getPlayer(uuid) != null)
            bank.remove(uuid);
    }

    public GBPlayer getConsole() {
        return console;
    }
}
