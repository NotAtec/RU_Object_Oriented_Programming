package hangman;
import java.util.ArrayList;

public class Gallows {
    private final String word;
    private StringBuilder[] maskedWord;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();
    private int remainingGuesses = 10;
    private GallowsUI gui;

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
        this.gui = gui;
        boolean result = this.mainLoop();

        gui.showStatus();
        if (result) gui.gameWon();
        else gui.gameLost();
    }

    private boolean mainLoop() {
        while (remainingGuesses != 0) {
            if (gameWon()) { return true; }

            gui.showStatus();
            char guess = gui.getValidGuess();

            this.checkGuess(guess);
            guessedLetters.add(guess);
        }
        return false;
    }

    private void checkGuess(char guess) {
        if(word.contains(Character.toString(guess))) {
            char[] arr = this.word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == guess) {
                    maskedWord[i].replace(0,maskedWord.length,Character.toString(arr[i]));
                }
            }
        } else {
            this.remainingGuesses -= 1;
        }
    }

    private boolean gameWon() {
        StringBuilder temp = new StringBuilder();
        for (StringBuilder val : maskedWord) {
            temp.append(val);
        }

        return temp.toString().equals(word);
    }
    public int getRemaining() {
        return remainingGuesses;
    }

    public ArrayList<Character> getGuessed() {
        return guessedLetters;
    }

    public StringBuilder[] getMaskedWord() {
        return maskedWord;
    }

    public String getWord() {
        return word;
    }
}
