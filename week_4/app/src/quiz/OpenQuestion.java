package quiz;

public class OpenQuestion extends Question {

    public OpenQuestion(String question, String answer, int score) {
        super(question, answer, score);
    }

    public OpenQuestion(String question, String answer) {
        super(question, answer, 3);
    }
}
