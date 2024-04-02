package Bouzhar.BotolaPro.demo.entity;

import Bouzhar.BotolaPro.demo.entity.embeddables.PlayerSquad;
import jakarta.persistence.*;

@Entity
public class Selection {
    @Id
    private PlayerSquad playerSquad;
    private Integer pointsEarned;

    @ManyToOne
    private Week week;

}
