package Bouzhar.BotolaPro.demo.service.contract;

import Bouzhar.BotolaPro.demo.dto.ArticleDto;
import Bouzhar.BotolaPro.demo.dto.ArticleLight;
import Bouzhar.BotolaPro.demo.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ArticleServiceC extends CrudService<ArticleDto, Long>{
    List<ArticleLight> getLatestArticles();
    List<ArticleLight> getMostReadArticles();
    Page<ArticleDto> getAll(Pageable pageable);
    List<ArticleDto> searchByTitle(String title);
}
