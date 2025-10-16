package Snapbrief_AI.demo.Controller;

import Snapbrief_AI.demo.Entity.CategoryResult;
import Snapbrief_AI.demo.Service.ArticleProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class NewsSummarizeController {

        @Autowired
        private ArticleProcessingService articleProcessingService;

        @PostMapping("/{id}/process")
        public CategoryResult processArticle(@PathVariable Long id) {
            return articleProcessingService.processArticle(id);
        }

     @PostMapping("/{id}/process-range")
    public List<CategoryResult> processArticlesFromId(@PathVariable Long id) {
        Long lastId = articleProcessingService.getLastArticleId(); // implement in service
        List<CategoryResult> results = new ArrayList<>();

        for (Long i = id; i <= lastId; i++) {
            CategoryResult result = articleProcessingService.processArticle(i);
            results.add(result);
        }

        return results;
    }
    }


