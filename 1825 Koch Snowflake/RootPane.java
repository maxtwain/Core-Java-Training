import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;

class RootPane {
    private BorderPane root;

    RootPane(){
        MainMenu mainMenu = new MainMenu();
        DrawingArea drawingArea = new DrawingArea(mainMenu);

        root = new BorderPane();
        root.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        root.setPadding(new Insets(8, 8, 8, 8));

        root.setTop(mainMenu.get());
        root.setCenter(drawingArea.get());
    }

    BorderPane get() { return root; }
}
