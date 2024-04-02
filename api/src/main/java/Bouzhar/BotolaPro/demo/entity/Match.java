package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private Boolean isPlayed;
    @ManyToOne
    private Week week;
}
