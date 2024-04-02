package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Season season;
    @OneToMany(mappedBy = "week")
    private List<Match> matches;
}
