package Bouzhar.BotolaPro.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class ArticleWithImage {
    private ArticleDto articleDto;
    private MultipartFile image;
}
