package chr.ptr.main.entities;

import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.UUID;

public interface IGBPlayer {

    BigDecimal getBalance();
    void deposit(BigDecimal value);
    boolean withdraw(BigDecimal value);
    Player getPlayer(UUID uuid);

}
