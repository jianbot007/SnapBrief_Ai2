package Snapbrief_AI.demo.Repo;


import Snapbrief_AI.demo.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {


    boolean existsByTitle(String title);

    Optional<Article> findBySourceUrl(String sourceUrl);


    @Query("SELECT MAX(a.id) FROM Article a")
    Long findMaxId();
}
