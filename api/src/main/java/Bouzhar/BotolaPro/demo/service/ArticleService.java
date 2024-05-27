package Bouzhar.BotolaPro.demo.service;

import Bouzhar.BotolaPro.demo.dto.ArticleDto;
import Bouzhar.BotolaPro.demo.dto.ArticleLight;
import Bouzhar.BotolaPro.demo.dto.ArticleWithImage;
import Bouzhar.BotolaPro.demo.entity.Article;
import Bouzhar.BotolaPro.demo.mapping.ArticleMapper;
import Bouzhar.BotolaPro.demo.repository.ArticleRepository;
import Bouzhar.BotolaPro.demo.service.contract.ArticleServiceC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@Service

public class ArticleService implements ArticleServiceC {


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
        articleDto.setIsApproved(false);
        MultipartFile image = dto.getImage();

        Article newArticleEntity = articleMapper.toEntity(articleDto);

        try{
            if (image != null) {
                byte[] imageBytes = image.getBytes();
                newArticleEntity.setImage(imageBytes);
                System.out.println("here");
                System.out.println(imageBytes.length);
            }
        Article savedEntity = articleRepository.save(newArticleEntity);
        return articleMapper.toDto(savedEntity);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        //return articleMapper.toDto(articleRepository.save(newArticleEntity));
    }
    public String getImageDataUrl(byte[] imageData) {

        String base64Image = Base64.getEncoder().encodeToString(imageData);
        return "data:image/jpeg;base64," + base64Image;
    }
    @Override
    public ArticleDto update(ArticleDto dto) {
        var newArticleEntity = articleMapper.toEntity(dto);
        return articleMapper.toDto(articleRepository.save(newArticleEntity));
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDto findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        if (article.getImage() != null){

            article.setImageUrl(getImageDataUrl(article.getImage()));
        }
        return articleMapper.toDto(article);
    }

    @Override
    public List<ArticleDto> searchByTitle(String title) {
        System.out.println("searching for : " + title);
        List<Article> articles = articleRepository.findByTitleContaining(title);
        System.out.println(articles.size());
        articles.stream().map(article -> {
            if (article.getImage() != null){

                article.setImageUrl(getImageDataUrl(article.getImage()));
            }
            return article;
        }).toList();
        return articles.stream().map(articleMapper::toDto).toList();
    }

    @Override
    public Page<ArticleDto> getAll(Pageable pageable) {
        Page<Article> articles= articleRepository.findAll(pageable);
        articles.stream().map(article -> {
            if (article.getImage() != null){

                article.setImageUrl(getImageDataUrl(article.getImage()));
            }
            return article;
        }).toList();
        return articleRepository.findAll(pageable).map(articleMapper::toDto);
    }

    @Override
    public List<ArticleDto> getAll() {
        List<Article> articles= articleRepository.findAll();
        articles.stream().map(article -> {
            if (article.getImage() != null){

            article.setImageUrl(getImageDataUrl(article.getImage()));
            }
            return article;
        }).toList();
        return articleRepository.findAll().stream().map(articleMapper::toDto).toList();
    }

    @Override
    public List<ArticleLight> getLatestArticles() {
        Pageable topFive = PageRequest.of(0, 5);
        return articleRepository.findAllLightByOrderByCreatedAtDesc(topFive);
    }

    @Override
    public List<ArticleLight> getMostReadArticles() {
        Pageable topFive = PageRequest.of(0, 3);
        return articleRepository.findAllLightByOrderByReadCountDesc(topFive);
    }
}
