package Bouzhar.BotolaPro.demo.seeders;

import Bouzhar.BotolaPro.demo.entity.Article;
import Bouzhar.BotolaPro.demo.repository.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ArticleSeeder implements CommandLineRunner {
    private final ArticleRepository articleRepository;

    public ArticleSeeder(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        if(articleRepository.count() == 0){
            articleRepository.save(new Article("title 1","content 1","image/url",false));
            articleRepository.save(new Article("title 2","content 2","image/url",false));
        }
    }
}
