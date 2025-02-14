package QA;

import java.util.*;

public class Questions {
    private Map<String, Question> allQuestions;
    private List<Question> searchResults;

    public Questions() {
        this.allQuestions = new HashMap<>();
        this.searchResults = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        allQuestions.put(question.getQuestionId(), question);
    }

    public Question getQuestion(String questionId) {
        return allQuestions.get(questionId);
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(allQuestions.values());
    }

    public List<Question> searchByContent(String keyword) {
        searchResults = new ArrayList<>();
        for (Question q : allQuestions.values()) {
            if (q.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(q);
            }
        }
        return searchResults;
    }

    public List<Question> getSearchResults() {
        return new ArrayList<>(searchResults);
    }

    public void clearSearchResults() {
        searchResults.clear();
    }
}