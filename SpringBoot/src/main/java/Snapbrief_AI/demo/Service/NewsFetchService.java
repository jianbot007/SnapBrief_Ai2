package Snapbrief_AI.demo.Service;

import Snapbrief_AI.demo.Componenets.ExternalApiClient;
import Snapbrief_AI.demo.Componenets.RssReader;
import Snapbrief_AI.demo.Entity.Article;
import Snapbrief_AI.demo.Repo.ArticleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFetchService {

    private final NewsProcessingService newsProcessingService;
     private final ArticleRepo articleRepo;
    public NewsFetchService(NewsProcessingService newsProcessingService, ArticleRepo articleRepo) {
        this.newsProcessingService = newsProcessingService;
        this.articleRepo = articleRepo;
    }

    public void fetchFromAllSources() {
        List<String> rssFeeds = List.of(
                "https://www.thedailystar.net/historical/front-page/rss.xml",
                "https://www.thedailystar.net/frontpage/rss.xml",
                "https://www.prothomalo.com/feed/",
                "https://prod-qt-images.s3.amazonaws.com/production/prothomalo-bangla/feed.xml",
                "https://www.jagonews24.com/rss/rss.xml"
                // "https://rss.cnn.com/rss/edition.rss",
               // "https://feeds.bbci.co.uk/news/rss.xml",
               // "https://www.theguardian.com/world/rss"
        );

        for (String feed : rssFeeds) {
            List<Article> articles = RssReader.fetchArticles(feed);
            for (Article article : articles) {
                newsProcessingService.saveArticle(article);
            }
        }

        List<String> apiEndpoints = List.of(
              //  "https://newsapi.org/v2/everything?q=tesla&from=2025-07-27&sortBy=publishedAt&apiKey=0933b757dd1047d28db1efa92b076225"
        );

        for (String api : apiEndpoints) {
            List<Article> articles = ExternalApiClient.fetchArticles(api);
            for (Article article : articles) {
                newsProcessingService.saveArticle(article);
            }
        }
    }
    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }

    public void DeleteAll(){
        articleRepo.deleteAll();
    }

}
