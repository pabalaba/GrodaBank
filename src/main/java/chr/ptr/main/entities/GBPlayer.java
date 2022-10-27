package chr.ptr.main.entities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.UUID;

public class GBPlayer implements IGBPlayer{

    private UUID uuid;
    private Player player;
    private BigDecimal balance;

    public GBPlayer(Player player){
        this.player = player;
        this.balance = BigDecimal.valueOf(0);
        this.uuid = player.getUniqueId();
    }

    public GBPlayer(UUID uuid){
        this.player = getPlayer(uuid);
        this.balance = BigDecimal.valueOf(0);
        this.uuid = uuid;
    }

    public GBPlayer(UUID uuid, BigDecimal balance) {
        this.uuid = uuid;
        this.balance = balance;
        this.player = getPlayer(uuid);
    }

    public GBPlayer(UUID uuid, Player player, BigDecimal balance) {
        this.uuid = uuid;
        this.player = player;
        this.balance = balance;
    }

    @Override
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    @Override
    public boolean withdraw(BigDecimal value) {
        BigDecimal i = this.balance.subtract(value);
        if(i.compareTo(BigDecimal.ZERO) < 0)
            return false;
        this.balance = i;
        return true;
    }

    @Override
    public Player getPlayer(UUID uuid) {
        try{
            return Bukkit.getPlayer(uuid);
        }catch (Exception e){
            System.err.println("There was an error!");
        }
        return null;
    }
}
