package Bouzhar.BotolaPro.demo.service;

import Bouzhar.BotolaPro.demo.mapping.ArticleMapper;
import Bouzhar.BotolaPro.demo.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArticleServiceTest {
    @Mock
    private ArticleMapper articleMapper;
    @Mock
    private ArticleRepository articleRepository;
    @Mock
    private ArticleService articleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        articleService = new ArticleService(articleRepository,articleMapper );
    }



    @Test
    void searchByTitle() {
        when(articleRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
    }
@Test
    void deleteNonExisting(){
    when(articleRepository.findById(1L)).thenReturn(Optional.empty());
    assertThrows(RuntimeException.class, () -> articleService.deleteById(1L));
    verify(articleRepository, times(1)).findById(1L);
}

}