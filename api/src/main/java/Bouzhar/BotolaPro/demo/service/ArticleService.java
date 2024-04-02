package Bouzhar.BotolaPro.demo.service;

import Bouzhar.BotolaPro.demo.dto.ArticleDto;
import Bouzhar.BotolaPro.demo.dto.ArticleWithImage;
import Bouzhar.BotolaPro.demo.entity.Article;
import Bouzhar.BotolaPro.demo.mapping.ArticleMapper;
import Bouzhar.BotolaPro.demo.repository.ArticleRepository;
import Bouzhar.BotolaPro.demo.service.contract.ArticleServiceC;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service

public class ArticleService implements ArticleServiceC {
    @Override
    public Article saveAttachment(MultipartFile file) throws Exception {


        return null;
    }

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public ArticleDto create(ArticleDto dto) {
        var newArticleEntity = articleMapper.toEntity(dto);
        //System.out.println(dto.getImage().length);
        System.out.println("service");
        return articleMapper.toDto(articleRepository.save(newArticleEntity));
    }
    public ArticleDto create_(ArticleWithImage dto) {
        ArticleDto articleDto = dto.getArticleDto();
        MultipartFile image = dto.getImage();

        Article newArticleEntity = articleMapper.toEntity(articleDto);

        try{
            if (image != null) {
                byte[] imageBytes = image.getBytes();
                newArticleEntity.setImage(imageBytes);
            }

        Article savedEntity = articleRepository.save(newArticleEntity);
        return articleMapper.toDto(savedEntity);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        //return articleMapper.toDto(articleRepository.save(newArticleEntity));
    }
    @Override
    public ArticleDto update(ArticleDto dto) {
        var newArticleEntity = articleMapper.toEntity(dto);
        return articleMapper.toDto(articleRepository.save(newArticleEntity));
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDto findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        return articleMapper.toDto(article);
    }

    @Override
    public List<ArticleDto> getAll() {
        return articleRepository.findAll().stream().map(articleMapper::toDto).toList();
    }
}
