package Bouzhar.BotolaPro.demo.repository;

import Bouzhar.BotolaPro.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
