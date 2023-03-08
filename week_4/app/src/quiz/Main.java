package quiz;

public class Main {
	public static void main(String[] args) {
		// Set up the game instance.
		Game g = new Game();
		g.initializeQuestions();
		g.playQuiz();
		g.showScores();
	}
}