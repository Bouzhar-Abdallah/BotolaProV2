package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer price;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Club club;
    @ManyToMany
    private List<Article> articles;
    @ManyToMany
    private List<Squad> squads ;
}
