package Snapbrief_AI.demo.Service;

import Snapbrief_AI.demo.Entity.Article;
import Snapbrief_AI.demo.Repo.ArticleRepo;
import org.springframework.stereotype.Service;

@Service
public class NewsProcessingService {

    private final ArticleRepo articleRepo;

    public NewsProcessingService(ArticleRepo articleRepository) {
        this.articleRepo = articleRepository;
    }

    public void saveArticle(Article article) {
        if (!articleRepo.existsByTitle(article.getTitle())) {
            articleRepo.save(article);
        }
    }
}
