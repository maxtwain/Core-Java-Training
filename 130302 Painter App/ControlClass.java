import javafx.scene.shape.Circle;

class ControlClass {

    ControlClass(GraphicPane graphicPane, MenuBar menuBar){

        graphicPane.get().setOnMouseDragged(e -> {
            double xCoord = e.getX();
            double yCoord = e.getY();
            double radius = menuBar.getSizeSelected() / 2;
            if (xCoord - radius > 0 && yCoord - radius > 0){
                Circle circle = new Circle(xCoord, yCoord, radius);
                circle.setStroke(menuBar.getColor());
                circle.setStrokeWidth(0);
                circle.setFill(menuBar.getColor());
                graphicPane.get().getChildren().add(circle);
            }
        });

        menuBar.getClearButton().setOnAction(e -> {
            graphicPane.get().getChildren().clear();
        });

        menuBar.getUndoButton().setOnAction(e -> {
            int circleCount = graphicPane.get().getChildren().size();
            if (circleCount > 0) {
                graphicPane.get().getChildren().remove(circleCount - 1);
            }
        });
    }
}
