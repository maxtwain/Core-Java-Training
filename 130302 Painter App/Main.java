/*
My notes: This is a later version of my painter app I made which is a more modular version.  I made this after coming across a later exercise that asked to replace the color chooser with a swatch design.  To make it easier to modify any part of the program, I converted much of the code into separate classes.  This was done as I was working on chapter 16.  Up until that point, I had written code with the main objective of making it easy to read.  I am now adjusting my strategy to prioritize easy modification over readability.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        RootPane rootPane = new RootPane();

        Scene scene = new Scene(rootPane.get(), Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scene Graph Painter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}