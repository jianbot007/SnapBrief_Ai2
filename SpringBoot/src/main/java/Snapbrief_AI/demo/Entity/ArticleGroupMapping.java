package Snapbrief_AI.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_group_mapping")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ArticleGroupMappingId.class)
public class ArticleGroupMapping {

    @Id
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Id
    @ManyToOne
    @JoinColumn(name = "topic_group_id")
    private TopicGroup topicGroup;
}

