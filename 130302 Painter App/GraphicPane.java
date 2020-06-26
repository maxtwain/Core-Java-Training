import javafx.scene.layout.Pane;

class GraphicPane {
    private Pane graphicPane;

    GraphicPane(){
        graphicPane = new Pane();
    }

    Pane get(){
        return graphicPane;
    }
}
