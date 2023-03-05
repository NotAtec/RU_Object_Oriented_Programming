package quiz;

public class OpenQuestion extends Question {

    public OpenQuestion(String question, String answer, int score) {
        super(question, answer, score);
    }

    public OpenQuestion(String question, String answer) {
        super(question, answer, 3);
    }

    @Override
    public String correctAnswer() {
        return "Q: " + super.correctAnswer();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isCorrect(String ans) {
        return super.isCorrect(ans);
    }
}
