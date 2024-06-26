package Bouzhar.BotolaPro.demo.controller;

import Bouzhar.BotolaPro.demo.dto.ArticleDto;
import Bouzhar.BotolaPro.demo.dto.ArticleReq;
import Bouzhar.BotolaPro.demo.dto.ArticleWithImage;
import Bouzhar.BotolaPro.demo.entity.Article;
import Bouzhar.BotolaPro.demo.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(path = "getAll")
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAll());
    }

    @GetMapping(path = "{articleId}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("articleId") Long articleId) {
        System.out.println("id is : " + articleId);
        return ResponseEntity.ok(articleService.findById(articleId));
    }

    @PostMapping(/*path = "add"*/consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ArticleDto> addArticle(@ModelAttribute ArticleReq article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle(article.getTitle());
        articleDto.setContent(article.getContent());
        articleDto.setImageFile(article.getImage());

        ArticleWithImage articleWithImage = new ArticleWithImage(articleDto, article.getImage());
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.create_(articleWithImage));
    }

/*    @PostMapping(path = "test")
    public String addTest(MultipartFile file) {
        return articleService.getImageDataUrl();
    }*/

    @PutMapping()
    public ResponseEntity<ArticleDto> updateArticle(@RequestBody ArticleDto articleDto) {
        return ResponseEntity.ok(articleService.update(articleDto));
    }

    @DeleteMapping(path = "{articleId}")
    public ResponseEntity<String> deleteLevel(@PathVariable("articleId") Long articleId) {
        articleService.deleteById(articleId);
        return ResponseEntity.ok("Article with id " + articleId + " has been deleted");
    }
}
