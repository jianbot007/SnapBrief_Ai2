package Snapbrief_AI.demo.Componenets;

import Snapbrief_AI.demo.Entity.Article;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ExternalApiClient {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static List<Article> fetchArticles(String apiUrl) {
        List<Article> articles = new ArrayList<>();
        try {
            Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);
            List<Map<String, Object>> articlesList = (List<Map<String, Object>>) response.get("articles");

            for (Map<String, Object> item : articlesList) {
                Article article = new Article();
                article.setTitle((String) item.get("title"));
                article.setContent((String) item.get("description"));
                article.setSourceUrl((String) ((Map) item.get("source")).get("url"));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
}
