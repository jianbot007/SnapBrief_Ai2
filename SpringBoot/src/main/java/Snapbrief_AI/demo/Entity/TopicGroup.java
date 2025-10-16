package Snapbrief_AI.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topic_groups")
public class TopicGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicGroupId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime lastUpdatedAt = LocalDateTime.now(); // optional
}
