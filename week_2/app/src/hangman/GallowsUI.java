package hangman;
import java.util.Arrays;
import java.util.Scanner;

public class GallowsUI {
    private Gallows game;

    public GallowsUI() {
        this.prepareGame();
        game.playGame(this);
    }

    private void prepareGame() {
        System.out.println("""
                Welcome to Hangman!
                Please enter a word or press Enter to randomly pick one.
                """);

        String w = getUserInput();

        if(w.equals("")) {
            System.out.println("Randomly picking a word.\n");
            this.game = new Gallows();
        } else {
            this.game = new Gallows(w);
        }
    }

    private static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public Gallows getGame() {
        return game;
    }

    public void showStatus() {
        System.out.println("Incorrect guesses remaining: " + game.getRemaining() + "\n");
        System.out.println("Guessed letters: " + Arrays.toString(game.getGuessed()) + "\n");
        System.out.println("Word: " + Arrays.toString(game.getMaskedWord()) + "\n");
    }
}
