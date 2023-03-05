package quiz;

public abstract class Question {
    private int score;
    private final String question;
    private final String answer;



    public Question(String q, String ans) {
        question = q;
        answer = ans;
        this.setScore(3);
    }

    public Question(String q, String ans, int score) {
        question = q;
        answer = ans;
        this.setScore(score);
    }

    public abstract String toString();

    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(answer)
    }

    public String correctAnswer() {
        return "The answer is: " + answer;
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
