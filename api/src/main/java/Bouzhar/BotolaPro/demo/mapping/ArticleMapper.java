package Bouzhar.BotolaPro.demo.mapping;


import Bouzhar.BotolaPro.demo.dto.ArticleDto;
import Bouzhar.BotolaPro.demo.dto.ArticleLight;
import Bouzhar.BotolaPro.demo.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    //@Mapping(source = "emailAddress", target = "email")
    ArticleDto toDto(Article source);
    ArticleLight toArticleLight(Article source);
    Article toEntity(ArticleDto destination);

    List<ArticleDto> toDto(List<Article> source);
    List<Article> toEntity(List<ArticleDto> destination);
}
