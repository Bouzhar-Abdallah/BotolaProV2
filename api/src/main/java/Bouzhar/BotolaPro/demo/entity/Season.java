package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Season {
    @Id
    private String name;
    @OneToMany(mappedBy = "season")
    private List<Week> weeks;
    @OneToMany(mappedBy = "season")
    private List<Squad> squads;

}
