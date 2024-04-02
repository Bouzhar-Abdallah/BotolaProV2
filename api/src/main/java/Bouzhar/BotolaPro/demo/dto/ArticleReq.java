package Bouzhar.BotolaPro.demo.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReq {
    private Long id;
    private String title;
    private String content;
    private MultipartFile image;
    private String imageUrl;
    private Boolean isApproved;
    private List<Long> playersIds;
    private List<Long> clubsIds;
}
