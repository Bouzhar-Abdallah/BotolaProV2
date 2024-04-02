package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logoUrl;
    @ManyToOne
    private Season season;

    @ManyToMany()
    private List<Player> players;
}
