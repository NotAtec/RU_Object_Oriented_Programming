package properties;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.util.converter.NumberStringConverter;

public class PieChart extends Application {
  private GridPane root = new GridPane();
  private SimpleIntegerProperty sum = new SimpleIntegerProperty();

  @Override
  public void start(Stage primaryStage) {
    root.setAlignment(Pos.CENTER);
    root.setHgap(20);
    root.setVgap(10);

    addInput();
    
    Scene scene = new Scene(root, 500, 500);
    primaryStage.setTitle("Pie Chart Builder");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void addInput() {
    TextField[] textField = new TextField[4];
    SimpleIntegerProperty[] input = new SimpleIntegerProperty[4];
    SimpleDoubleProperty[] output = new SimpleDoubleProperty[4];
    Label[] label = new Label[4];

    for (int i = 0; i < 4; i++) {
      textField[i] = new TextField();
      TextField local = textField[i];
      input[i] = new SimpleIntegerProperty();
      output[i] = new SimpleDoubleProperty();
      label[i] = new Label();
      label[i].setMinWidth(200);
      label[i].setMaxWidth(200);
      textField[i].textProperty().bindBidirectional(input[i], new NumberStringConverter());
      input[i].setValue(1);
      label[i].textProperty().bind(output[i].asString("%.4f"));

      local.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
          if (!newValue.matches("[1-9]\\d{0,3}")) {
            local.setText(oldValue);
          }
        }
      });

      root.add(textField[i], 0, i);
      root.add(label[i], 1, i);
    }
    
    sum.bind(input[0].add(input[1]).add(input[2]).add(input[3]));
    for (int i = 0; i < 4; i++) {
      output[i].bind(input[i].add(0d).divide(sum));
    }
  }

}
