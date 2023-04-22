package properties;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class PieChart extends Application {
  private GridPane root = new GridPane();

  @Override
  public void start(Stage primaryStage) {
    root.setAlignment(Pos.CENTER);
    root.setHgap(20);
    root.setVgap(10);

    Scene scene = new Scene(root, 500, 500);
    primaryStage.setTitle("Pie Chart Builder");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
