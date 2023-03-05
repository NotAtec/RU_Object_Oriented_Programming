package quiz;

public class ThisThatQuestion extends MultipleChoiceQuestion {
    private String a1;
    private String a2;
    private String correct;


    public ThisThatQuestion ( String question , String answer1 , String answer2 , int correctAnswer , int score) {
        super(question, new String[] {answer1, answer2}, correctAnswer, score);
        this.setRemaining(answer1, answer2, correctAnswer);

    }
    public ThisThatQuestion (String question , String answer1 , String answer2 , int correctAnswer) {
        super(question, new String[] {answer1, answer2}, correctAnswer);
        this.setRemaining(answer1, answer2, correctAnswer);
    }

    private void setRemaining(String answer1, String answer2, int correctAnswer) {
        a1 = answer1;
        a2 = answer2;
        if(correctAnswer == 0) {
            correct = answer1;
        } else {
            correct = answer2;
        }
    }

    @Override
    public String toString() {
        return a1 + " or " + a2 + ": " + super.questionOnlyString();
    }

    @Override
    public String correctAnswer() {
        return correct + " is the correct answer.\n";
    }

    @Override
    public boolean isCorrect(String guess) {
        return correct.equalsIgnoreCase(guess);
    }
}
