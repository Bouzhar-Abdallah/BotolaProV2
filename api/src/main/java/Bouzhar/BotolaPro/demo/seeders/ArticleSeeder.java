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
        //seedData();
    }

    private void seedData() {
        if(articleRepository.count() == 0){
            articleRepository.save(new Article("Coupe du Trône : le match MCO-RAC ouvre le bal des huitièmes de finale","content 1","image/url",false));
            articleRepository.save(new Article("Coupe de la CAF : la RSB prend une belle option pour la manche retour face au club libyen d’Abu Salim","content 2","image/url",false));
        }
    }
}
