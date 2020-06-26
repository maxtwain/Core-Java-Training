/*
Repeat the fractal pattern in Section 18.9 to form a star with several colors.  Begin with five lines (see Fig 18.22) instead of one, where each line is a different arm of the star.  Apply the "lo feather fractal" pattern to each arm of the star.
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