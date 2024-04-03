package Bouzhar.BotolaPro.demo.repository;

import Bouzhar.BotolaPro.demo.dto.ArticleLight;
import Bouzhar.BotolaPro.demo.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT new Bouzhar.BotolaPro.demo.dto.ArticleLight(a.id, a.title, a.readCount, a.createdAt, a.isApproved) FROM Article a ORDER BY a.createdAt DESC")
    List<ArticleLight> findAllLightByOrderByCreatedAtDesc(Pageable pageable);

    @Query("SELECT new Bouzhar.BotolaPro.demo.dto.ArticleLight(a.id, a.title, a.readCount, a.createdAt, a.isApproved) FROM Article a ORDER BY a.readCount DESC")
    List<ArticleLight> findAllLightByOrderByReadCountDesc(Pageable pageable);

    List<Article> findByTitleContaining(String title);
}
