package Snapbrief_AI.demo.DTOs;


import lombok.Data;
    @Data
    public class FastApiResponseDTO {
        private Long articleId;
        private String sourceUrl;
        private String category;
        private String summary;

        public Long getArticleId() {
            return articleId;
        }

        public String getCategory() {
            return category;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }
        public String getSummary() {
            return summary;
        }
    }
