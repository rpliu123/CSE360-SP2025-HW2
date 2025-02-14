package QA;

import java.time.LocalDateTime;

public class Question {
    private String questionId;
    private String content;
    private String askedBy;
    private LocalDateTime timestamp;
    private boolean resolved;

    public Question(String content, String askedBy) {
        this.questionId = java.util.UUID.randomUUID().toString();
        this.content = content;
        this.askedBy = askedBy;
        this.timestamp = LocalDateTime.now();
        this.resolved = false;
    }

    // Getters and setters
    public String getQuestionId() { return questionId; }
    public String getContent() { return content; }
    public String getAskedBy() { return askedBy; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}