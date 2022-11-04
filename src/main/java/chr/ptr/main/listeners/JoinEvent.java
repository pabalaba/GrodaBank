package chr.ptr.main.listeners;

import chr.ptr.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        try{
            Main.getBank().addPlayer(player);
        }catch (Exception ex){
            return;
        }
    }
}
