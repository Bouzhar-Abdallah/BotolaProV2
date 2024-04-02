package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Club {

    public Club(String name, String shortName, String logoUrl, String primaryColor, String secondaryColor, String tirnaryColor) {
        this.name = name;
        this.shortName = shortName;
        this.logoUrl = logoUrl;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.tirnaryColor = tirnaryColor;
    }

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortName;
    private String logoUrl;
    private String primaryColor;
    private String secondaryColor;
    private String tirnaryColor;

}
