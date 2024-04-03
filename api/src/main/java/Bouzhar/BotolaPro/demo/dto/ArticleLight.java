package Bouzhar.BotolaPro.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLight {
    private Long id;
    private String title;
    private Integer readCount;
    private LocalDateTime createdAt;
    private Boolean isApproved;

}
