package geometric;
import java.util.Scanner;
public class CommandUI {
    private Shapes shapeList = new Shapes();

    public CommandUI() {}

    public void inputLoop() {
        String w = getUserInput().toLowerCase();

        while(!w.equals("quit")) {
            String[] args = w.split(" ");

            switch(args[0]) {
                case "show":
                    Geometric[] shapes = shapeList.getShapes();

                    for (Geometric shape : shapes) {
                        System.out.println(shape.toString());
                    }
                    break;

                case "circle":
                    double cx = Double.parseDouble(args[1]);
                    double cy = Double.parseDouble(args[2]);
                    double cr = Double.parseDouble(args[3]);
                    shapeList.addShape(new Circle(cx, cy, cr));
                    break;

                case "rectangle":
                    double rx = Double.parseDouble(args[1]);
                    double ry = Double.parseDouble(args[2]);
                    double rw = Double.parseDouble(args[3]);
                    double rh = Double.parseDouble(args[4]);
                    shapeList.addShape(new Rectangle(rx, ry, rw, rh));
                    break;

                case "move":
                    int mi = Integer.parseInt(args[1]);
                    double mx = Double.parseDouble(args[2]);
                    double my = Double.parseDouble(args[3]);

                    Geometric shape = shapeList.find(mi);

                    shape.move(mx, my);
                    break;

                case "remove":
                    int ri = Integer.parseInt(args[1]);

                    shapeList.removeShapeByIndex(ri);
                    break;

                case "sort":
                    System.out.print("temp\n");
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
