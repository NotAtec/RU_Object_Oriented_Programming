package quiz;

public class MultipleChoiceQuestion extends Question {
    private final String[] options;
    private final int correctOption;

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

    @Override
    public String toString() {
        StringBuilder builtString = new StringBuilder();
        String[] letters = {"a)", "b)", "c)", "d)", "e)", "f)", "g)", "h)", "i)", "j)"};

        for (int i = 0; i < options.length; i++) {
            builtString.append(letters[i]).append(" ").append(options[i]).append("\n");
        }

        return super.toString() + builtString;
    }
}
