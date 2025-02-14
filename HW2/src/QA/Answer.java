package QA;

import java.time.LocalDateTime;

public class Answer {
    private String answerId;
    private String questionId;
    private String content;
    private String answeredBy;
    private LocalDateTime timestamp;

    public Answer(String questionId, String content, String answeredBy) {
        this.answerId = java.util.UUID.randomUUID().toString();
        this.questionId = questionId;
        this.content = content;
        this.answeredBy = answeredBy;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getAnswerId() { return answerId; }
    public String getQuestionId() { return questionId; }
    public String getContent() { return content; }
    public String getAnsweredBy() { return answeredBy; }
    public LocalDateTime getTimestamp() { return timestamp; }
}