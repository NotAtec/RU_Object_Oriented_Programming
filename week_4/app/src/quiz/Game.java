package quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Question> questions = new LinkedList<>();
    List<Question> incorrect = new LinkedList<>();
    int[] scores = {0,0};

    public Game() {}

    public void initializeQuestions() {
        questions.add(new OpenQuestion("What is the big O complexity of binary search?", "O(log N)"));
        questions.add(new OpenQuestion("How would you read an integer i from scanner s in Java?", "i = s.nextInt();", 2));
        questions.add(new OpenQuestion("What is the minimum amount of constructors you have to define for a class in Java?", "0", 2));

        questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?", new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1, 4));
        questions.add(new MultipleChoiceQuestion("How do you print \"Hello world\" on a line in Java?", new String[] { "System.out.print(\"Hello world\");", "System.out.println(\"Hello world\");", "cout << \"Hello world\";" }, 1));
        questions.add(new MultipleChoiceQuestion("How do you read a non-empty word in Java using scanner s?", new String[] { "s.nextline()", "s.next(\"\\S+\")", "s.next(\"\\a*\")", "s.next(\"\\S*\")", "s.next(\"\\\\s+\")", "s.next(\"\\s+\")", "s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")", "s.nextString()" }, 7, 1));

        questions.add(new ThisThatQuestion("Every class must have a constructor", "Right", "Wrong", 1));
        questions.add(new ThisThatQuestion("Is there a difference between an interface and an abstract class?", "Yes", "No", 0, 5));
        questions.add(new ThisThatQuestion("Is there a maximum to the amount of constructors a class can have in Java?", "Yes", "No", 1));

    }

    public void playQuiz() {
        int round = 0;
        for (Question q : questions) {
            boolean result = askQuestionGetResult(q);

            if(result) {
                scores[round] += q.getScore();
            } else {
                incorrect.add(q);
            }
            showResult(result, q);
        }

        for (Question q : incorrect) {
            boolean result = askQuestionGetResult(q);
            showResult(result, q);
        }
    }

    public void showScores() {
        System.out.println("Points scored in round 1: " + scores[0] + "\n");
        System.out.println("Points scored in round 2: " + scores[1] + "\n");
    }
    
    private static void showResult(boolean result, Question q) {
        if(result) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect..\n");
            System.out.println(q.correctAnswer());
        }
    }

    private static boolean askQuestionGetResult(Question q) {
        System.out.println(q.toString());
        String in = getInput();
        return q.isCorrect(in);
    }

    private static String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
