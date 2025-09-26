package Snapbrief_AI.demo.DTOs;

public class SendArticleDTO {
        private Long articleId;
        private String content;
        private String sourceUrl;

        public SendArticleDTO() {} // default constructor

        public Long getArticleId() { return articleId; }
        public void setArticleId(Long articleId) { this.articleId = articleId; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }

        public String getSourceUrl() { return sourceUrl; }
        public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
}
