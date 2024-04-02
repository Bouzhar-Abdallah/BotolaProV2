package Bouzhar.BotolaPro.demo.entity.embeddables;

import Bouzhar.BotolaPro.demo.entity.Player;
import Bouzhar.BotolaPro.demo.entity.Squad;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class PlayerSquad implements Serializable {
    @ManyToOne
    private Player player;
    @ManyToOne
    private Squad squad;
}
