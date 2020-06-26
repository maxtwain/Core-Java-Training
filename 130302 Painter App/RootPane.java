import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

class RootPane {
    private BorderPane root;

    RootPane(){
        MenuBar menuBar = new MenuBar();
        GraphicPane graphicPane = new GraphicPane();
        ControlClass controlClass = new ControlClass(graphicPane, menuBar);

        root = new BorderPane();
        root.setPrefSize(640, 480);
        root.setPadding(new Insets(8, 8, 8, 8));

        root.setLeft(menuBar.get());
        root.setCenter(graphicPane.get());
    }

    BorderPane get(){return root;}
}
