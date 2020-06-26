/*
Use a HashMap to create a reusable class for choosing one of the 13 predefined colors in class Color.  The names of the colors should be used as keys, and the predefined Color objects should be used as values.  Use your new class in an application that allows the user to select a color and draw a shape in that color.

My notes:  This is a modification of a program I wrote in Chapter 13.  I couldn't think of a use for String Color names, so I didn't implement that aspect of the instructions.  I did however spend much more time adding and improving functionality to this program.  Now the undo works as well as could be asked for, freedraw has been added, and the user may now modify the shape they wish to draw with.

Now that I am a bit more comfortable with this, I took the time to improve the undo button.
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