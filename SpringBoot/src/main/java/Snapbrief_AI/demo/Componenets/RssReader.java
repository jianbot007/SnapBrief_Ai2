package Snapbrief_AI.demo.Componenets;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import Snapbrief_AI.demo.Entity.Article;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;

public class RssReader {

    public static List<Article> fetchArticles(String feedUrl) {
        List<Article> articles = new ArrayList<>();
        try {
            HttpClient client = HttpClient.newBuilder()
                    .sslContext(SSLContext.getDefault())
                    .version(HttpClient.Version.HTTP_2)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(feedUrl))
                    .header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();

            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(response.body()));

            for (SyndEntry entry : feed.getEntries()) {
                Article article = new Article();
                article.setTitle(entry.getTitle());
                article.setContent(entry.getDescription() != null ? entry.getDescription().getValue() : "");
                article.setSourceUrl(entry.getLink());
                article.setPublishedAt(entry.getPublishedDate() != null ?
                        new Timestamp(entry.getPublishedDate().getTime()).toLocalDateTime() : null);

                articles.add(article);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
}
