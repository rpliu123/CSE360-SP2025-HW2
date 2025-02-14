package QA;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Questions questions;
    private static Answers answers;
    private static Scanner scanner;

    public static void main(String[] args) {
        questions = new Questions();
        answers = new Answers();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Q&A System =====");
            System.out.println("1. Ask a question");
            System.out.println("2. View all questions");
            System.out.println("3. Answer a question");
            System.out.println("4. View answers");
            System.out.println("5. Search questions");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    askQuestion();
                    break;
                case 2:
                    viewQuestions();
                    break;
                case 3:
                    answerQuestion();
                    break;
                case 4:
                    viewAnswers();
                    break;
                case 5:
                    searchQuestions();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void askQuestion() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your question: ");
        String content = scanner.nextLine();
        
        Question question = new Question(content, name);
        questions.addQuestion(question);
        System.out.println("Question added! ID: " + question.getQuestionId());
    }

    private static void viewQuestions() {
        List<Question> allQuestions = questions.getAllQuestions();
        if (allQuestions.isEmpty()) {
            System.out.println("No questions yet.");
            return;
        }

        for (Question q : allQuestions) {
            System.out.println("\nID: " + q.getQuestionId());
            System.out.println("Asked by: " + q.getAskedBy());
            System.out.println("Question: " + q.getContent());
            System.out.println("Status: " + (q.isResolved() ? "Resolved" : "Unresolved"));
        }
    }

    private static void answerQuestion() {
        viewQuestions();
        
        System.out.print("\nEnter question ID to answer: ");
        String questionId = scanner.nextLine();
        
        Question question = questions.getQuestion(questionId);
        if (question == null) {
            System.out.println("Question not found!");
            return;
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your answer: ");
        String content = scanner.nextLine();
        
        Answer answer = new Answer(questionId, content, name);
        answers.addAnswer(answer);
        System.out.println("Answer added successfully!");
    }

    private static void viewAnswers() {
        System.out.print("Enter question ID: ");
        String questionId = scanner.nextLine();
        
        Question question = questions.getQuestion(questionId);
        if (question == null) {
            System.out.println("Question not found!");
            return;
        }

        System.out.println("\nQuestion: " + question.getContent());
        List<Answer> questionAnswers = answers.getAnswersForQuestion(questionId);
        
        if (questionAnswers.isEmpty()) {
            System.out.println("No answers yet.");
            return;
        }

        for (Answer a : questionAnswers) {
            System.out.println("\nAnswered by: " + a.getAnsweredBy());
            System.out.println("Answer: " + a.getContent());
            System.out.println("Time: " + a.getTimestamp());
        }
    }

    private static void searchQuestions() {
        System.out.print("Enter search term: ");
        String keyword = scanner.nextLine();
        
        List<Question> results = questions.searchByContent(keyword);
        if (results.isEmpty()) {
            System.out.println("No matching questions found.");
            return;
        }

        System.out.println("\nSearch results:");
        for (Question q : results) {
            System.out.println("\nID: " + q.getQuestionId());
            System.out.println("Asked by: " + q.getAskedBy());
            System.out.println("Question: " + q.getContent());
        }
    }
}