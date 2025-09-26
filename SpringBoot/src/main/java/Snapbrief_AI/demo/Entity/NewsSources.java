package Snapbrief_AI.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "news_sources")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsSources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sourceId;

    private String name;
    private String apiUrl;
    private LocalDateTime lastFetched;
}
