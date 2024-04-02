package Bouzhar.BotolaPro.demo.service.contract;

import Bouzhar.BotolaPro.demo.dto.ArticleDto;
import Bouzhar.BotolaPro.demo.entity.Article;
import org.springframework.web.multipart.MultipartFile;

public interface ArticleServiceC extends CrudService<ArticleDto, Long>{
    Article saveAttachment(MultipartFile file) throws Exception;
}
