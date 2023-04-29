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
            String code = keyEvent.getCharacter();

            switch (code) {
                case "s":
                    world.setRunning(!world.isRunning());
                    break;
                case "a":
                    snake.setDirection(Direction.LEFT);
                    break;
                case "d":
                    snake.setDirection(Direction.RIGHT);
                    break;

                default:
                    break;
            }
            keyEvent.consume();
        };

        mouseHandler = mouseEvent -> {
            // TODO: Implement mouse
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
