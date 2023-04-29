package snake;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * A JavaFX Pane that displays the snake game represented by the given world
 */
public class SnakeGame extends Pane {

    public static final int SCALE = 16;

    public SnakeGame(World world) {
        setPrefSize(world.getSize() * SCALE, world.getSize() * SCALE);

        // TODO: Implement graphics
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label("Press 's' to start");
        scoreText.textProperty().bind(Bindings.concat(world.getScore() + " points"));
        runningText.textProperty().bind(Bindings.when(world.getRunningProperty()).then("Press 's' to pause").otherwise("Press 's' to start"));

        ui.getChildren().addAll(scoreText, runningText);

        return ui;
    }
}
