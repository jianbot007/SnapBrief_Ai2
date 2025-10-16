package Snapbrief_AI.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "summaries")
@Data @NoArgsConstructor @AllArgsConstructor
public class Summary {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long summaryId;

    @ManyToOne
    @JoinColumn(name = "topic_group_id")
    private TopicGroup topicGroup;

    @Column(columnDefinition = "TEXT")
    private String summaryText;

    private String sentiment;
    private Float importanceScore;
    private LocalDateTime createdAt = LocalDateTime.now();
}
