package hangman;

public class Gallows {
    private final String word;
    private StringBuilder[] maskedWord;
    private char[] guessedLetters = new char[10];
    private int remainingGuesses = 10;

    public Gallows() {
        WordReader file = new WordReader("words.txt");
        this.word = file.getWord();
        this.generalSetup();
    }

    public Gallows(String w) {
        this.word = w;
        this.generalSetup();
    }

    private void generalSetup() {
        maskedWord = new StringBuilder[word.length()];
        for (int i = 0; i < word.length(); i++) {
            maskedWord[i] = new StringBuilder(".");
        }
    }
    public void playGame(GallowsUI gui) {
        gui.showStatus();
        // TD: Rest of the game lol.
    }

    public int getRemaining() {
        return remainingGuesses;
    }

    public char[] getGuessed() {
        return guessedLetters;
    }

    public StringBuilder[] getMaskedWord() {
        return maskedWord;
    }
}
