package snake;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import snake.Snake.SnakeSegmentListener;

/**
 * A JavaFX Pane that displays the snake game represented by the given world
 */
public class SnakeGame extends Pane implements SnakeSegmentListener {

    public static final int SCALE = 16;

    public SnakeGame(World world) {
        setPrefSize(world.getSize() * SCALE, world.getSize() * SCALE);
        world.getSnake().addListener(this);
        world.getSnake().createHead();

        Circle foodGfx = new Circle(SCALE / 2);
        foodGfx.centerXProperty().bind(world.getFood().getXProperty().multiply(SCALE).add(SCALE/ 2));
        foodGfx.centerYProperty().bind(world.getFood().getYProperty().multiply(SCALE).add(SCALE / 2));

        getChildren().add(foodGfx);
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

    @Override
    public void onNewSegment(Segment segment) {
        Rectangle segmentGfx = new Rectangle(SCALE, SCALE);
        segmentGfx.xProperty().bind(segment.getXProperty().multiply(SCALE));
        segmentGfx.yProperty().bind(segment.getYProperty().multiply(SCALE));
        getChildren().add(segmentGfx);
    }
}
