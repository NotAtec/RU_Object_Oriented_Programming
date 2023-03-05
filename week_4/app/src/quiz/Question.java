package quiz;

public abstract class Question {
    private int score;
    private final String question;
    private final String answer;

    public Question(String q, String ans, int score) {
        question = q;
        answer = ans;
        this.setScore(score);
    }

    public String toString() {
        return question + "\n";
    }

    public boolean isCorrect(String guess) {
        return answer.equalsIgnoreCase(guess);
    }

    public String correctAnswer() {
        return "The correct answer is: " + answer + "\n";
    }
    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        if(validScore(newScore)) {
            score = newScore;
        } else {
            score = 3;
        }
    }

    private boolean validScore(int score) {
        return score >= 1 && score <= 5;
    }
}
