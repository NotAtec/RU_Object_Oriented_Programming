package quiz;

public class MultipleChoiceQuestion extends Question {
    private final String[] options;
    private final int correctOption;
    private final String[] letters = {"a)", "b)", "c)", "d)", "e)", "f)", "g)", "h)", "i)", "j)"};
    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer, int score) {
        super(question, answers[correctAnswer], score);
        options = answers;
        correctOption = correctAnswer;
    }

    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer) {
        super(question, answers[correctAnswer], 3);
        options = answers;
        correctOption = correctAnswer;
    }

    public String questionOnlyString() {
        return super.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder builtString = new StringBuilder();

        for (int i = 0; i < options.length; i++) {
            builtString.append(letters[i]).append(" ").append(options[i]).append("\n");
        }

        return super.toString() + builtString;
    }

    @Override
    public String correctAnswer() {
        return "The correct answer is: (" + letters[correctOption] + ". Which corresponds to: " + options[correctOption] + "\n";
    }

    @Override
    public boolean isCorrect(String guess) {
        String modified = guess + ")";
        for (int i = 0; i < letters.length; i++) {
            if(letters[i].equalsIgnoreCase(modified)) return correctOption == i;
        }
        return false;
    }
}
