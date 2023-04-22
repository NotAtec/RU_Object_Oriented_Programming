package properties;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
public class PieChart extends Application {
  private GridPane root = new GridPane();

  @Override
  public void start(Stage primaryStage) {
    root.setAlignment(Pos.CENTER);
    root.setHgap(20);
    root.setVgap(10);

    addInput(0, 0);
    addInput(0, 1);
    addInput(0, 2);
    addInput(0, 3);
    
    Scene scene = new Scene(root, 500, 500);
    primaryStage.setTitle("Pie Chart Builder");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void addInput(int col, int row) {
    TextField textField = new TextField();

    Label label = new Label();
    label.setMinWidth(200);
    label.setMaxWidth(200);

    label.textProperty().bind(textField.textProperty());

    textField.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue, 
          String newValue) {
        if (!newValue.matches("[1-9]\\d{0,3}")) {
          textField.setText(oldValue);
        }
      }
  });

    root.add(textField, col, row);
    root.add(label, col + 1, row);
  }

}
