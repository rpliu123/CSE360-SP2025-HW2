package QA;

import java.util.*;

public class Answers {
    private Map<String, List<Answer>> questionAnswers;
    private List<Answer> searchResults;

    public Answers() {
        this.questionAnswers = new HashMap<>();
        this.searchResults = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        String questionId = answer.getQuestionId();
        questionAnswers.computeIfAbsent(questionId, k -> new ArrayList<>()).add(answer);
    }

    public List<Answer> getAnswersForQuestion(String questionId) {
        return new ArrayList<>(questionAnswers.getOrDefault(questionId, new ArrayList<>()));
    }

    public List<Answer> searchInAnswers(String keyword) {
        searchResults = new ArrayList<>();
        for (List<Answer> answers : questionAnswers.values()) {
            for (Answer a : answers) {
                if (a.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                    searchResults.add(a);
                }
            }
        }
        return searchResults;
    }

    public List<Answer> getSearchResults() {
        return new ArrayList<>(searchResults);
    }

    public void clearSearchResults() {
        searchResults.clear();
    }
}