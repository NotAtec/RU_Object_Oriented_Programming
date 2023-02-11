package hangman;

public class Main {
	public static void main(String[] args) {
		WordReader file = new WordReader("words.txt");
		System.out.println(file.getWord());

		new GallowsUI();
	}
}