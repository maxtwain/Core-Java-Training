import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

class GraphicPane {
    private Pane graphicPane;
    private List<Integer> actionCountList = new ArrayList<>();
    private double radius;

    GraphicPane(MenuBar menuBar){
        graphicPane = new Pane();
        radius = 1;

        graphicPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                radius = menuBar.getSizeSelected() / 2;
                actionCountList.add(0);

                if (!menuBar.getFreedraw()){
                    double centerX = event.getX();
                    double centerY = event.getY();
                    Polygon polygon = createPolygon(menuBar, centerX, centerY);
                    graphicPane.getChildren().add(polygon);

                    int index = actionCountList.size() - 1;
                    actionCountList.set(index, 1);
                }
            }
        });

        graphicPane.setOnMouseDragged(e -> {
            double xCoord = e.getX();
            double yCoord = e.getY();

            if (menuBar.getFreedraw()){
                if (xCoord - radius > 0 && yCoord - radius > 0){
                    Polygon polygon = createPolygon(menuBar, xCoord, yCoord);
                    graphicPane.getChildren().add(polygon);

                    int index = actionCountList.size() - 1;
                    int value = actionCountList.get(index) + 1;
                    actionCountList.set(index, value);
                }
            }
        });

        menuBar.getClearButton().setOnAction(e -> {
            graphicPane.getChildren().clear();
            for (int i = actionCountList.size() - 1; i >= 0; --i){
                actionCountList.remove(i);
            }
        });

        menuBar.getUndoButton().setOnAction(e -> {
            int circleCount = graphicPane.getChildren().size();
            if (circleCount > 0) {
                int index = actionCountList.size() - 1;
                int value = actionCountList.get(index);
                graphicPane.getChildren().remove(circleCount - value, circleCount);
                actionCountList.remove(index);
            }
        });
    }

    private Polygon createPolygon(MenuBar menuBar, double centerX, double centerY){
        Polygon polygon = new Polygon();
        int polyPoint = menuBar.getBrushPoint();
        for (int i = 0; i < polyPoint; ++i){
            double xCoord = centerX + radius * Math.sin(2 * i * Math.PI / polyPoint);
            double yCoord = centerY - radius * Math.cos(2 * i * Math.PI / polyPoint);
            polygon.getPoints().addAll(xCoord, yCoord);
        }
        polygon.setStroke(menuBar.getColor());
        polygon.setStrokeWidth(0);
        polygon.setFill(menuBar.getColor());
        return polygon;
    }

    Pane get(){
        return graphicPane;
    }
}
