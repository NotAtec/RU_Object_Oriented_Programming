package snake;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * Handles controls of a snake game, where the 'a' and 'd' keys can be used to move and 's' (un)pauses the game
 */
public class InputHandler {

    private final EventHandler<KeyEvent> keyHandler;
    private final EventHandler<MouseEvent> mouseHandler;

    public InputHandler(World world) {
        Snake snake = world.getSnake();

        keyHandler = keyEvent -> {
            // TODO: Implement Controls
            
            switch (keyEvent.getCode().toString()) {
                case "A":
                    snake.setDirection(snake.getDirection().rotateLeft());
                    break;
                case "D":
                    snake.setDirection(snake.getDirection().rotateRight());
                    break;
                case "S":
                    world.setRunning(!world.isRunning());
                    break;
            }
            
            keyEvent.consume();
        };

        mouseHandler = mouseEvent -> {
            
            System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
            if (mouseEvent.getX() <= 400 && mouseEvent.getY() <= 400) {
                world.getFood().moveTo((int)Math.floor(mouseEvent.getX() / 16), (int) Math.floor(mouseEvent.getY() / 16));
            }
            mouseEvent.consume();
        };
    }

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }

    public EventHandler<MouseEvent> getMouseHandler() {
        return mouseHandler;
    }
}
