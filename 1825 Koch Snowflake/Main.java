/*
Using the techniques you learned in Section 18.9, implement an application that draws the Koch Curve.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RootPane rootPane = new RootPane();

        Scene scene = new Scene(rootPane.get(), Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fractal Canvas Painter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}