package Bouzhar.BotolaPro.demo.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReq {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    @Lob
    private byte[] image;
    private Boolean isApproved;
    private List<Long> playersIds;
    private List<Long> clubsIds;
}
