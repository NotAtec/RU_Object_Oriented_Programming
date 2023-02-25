package geometric;
import java.util.Scanner;
public class CommandUI {
    private Shapes shapeList = new Shapes();

    public CommandUI() {}

    public void inputLoop() {
        String w = getUserInput().toLowerCase();

        while(!w.equals("quit")) {
            String[] parts = w.split(" ");

            switch(parts[0]) {
                case "show":
                    break;
                case "circle":
                    break;
                case "rectangle":
                    break;
                case "move":
                    break;
                case "remove":
                    break;
                case "sort":
                    break;
                case "help":
                    break;
                default:
                    System.out.println("Command not recognized. Please try again.\n");
            }

            // Processing next user input
            w = getUserInput().toLowerCase();
        }
    }

    private static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
