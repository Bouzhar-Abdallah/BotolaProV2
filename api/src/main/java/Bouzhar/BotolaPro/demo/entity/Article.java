package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity

@Builder
@AllArgsConstructor
@Setter
@Getter
public class Article {
    public Article(){}
    public Article( String title, String content, String imageUrl, Boolean isApproved) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.isApproved = isApproved;
    }

    public Article(Long id, String title, String content, String imageUrl, Boolean isApproved) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.isApproved = isApproved;
    }
    public Article(Long id, String title, String content, String imageUrl,byte[] image, Boolean isApproved){
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.image = image;
        this.isApproved = isApproved;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    private Integer readCount;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Lob
    private byte[] image;
    private Boolean isApproved;
    @ManyToMany
    private List<Player> players;
    @ManyToMany
    private List<Club> clubs;

}
