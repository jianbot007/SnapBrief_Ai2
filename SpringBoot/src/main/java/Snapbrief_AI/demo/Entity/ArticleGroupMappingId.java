package Snapbrief_AI.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleGroupMappingId implements Serializable {
    private Long article;
    private Long topicGroup;
}