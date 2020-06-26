
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

class MenuBar {
    private VBox menuVBox;
    private ColorMenu colorMenu;
    private Button clearButton;
    private Button undoButton;
    private PenMenu penSizeMenu;

    MenuBar(){

        colorMenu = new ColorMenu();
        penSizeMenu = new PenMenu();

        buildUndoButton();
        buildClearButton();

        menuVBox = new VBox();
        menuVBox.setSpacing(8);
        menuVBox.setPrefHeight(Control.USE_COMPUTED_SIZE);
        menuVBox.setPrefWidth(Control.USE_COMPUTED_SIZE);
        menuVBox.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(menuVBox, new Insets(0, 12, 0, 0));
        menuVBox.getChildren().add(colorMenu.get());
        menuVBox.getChildren().add(penSizeMenu.get());
        menuVBox.getChildren().add(undoButton);
        menuVBox.getChildren().add(clearButton);
        //menuVBox.getChildren().addAll(colorMenu.get(), penSizeMenu.get(), undoButton, clearButton);
    }

    VBox get() {
        return menuVBox;
    }

    Color getColor(){
        return colorMenu.getColor();
    }

    Button getClearButton(){return clearButton;}
    Button getUndoButton(){return undoButton;}

    private void buildClearButton(){
        clearButton = new Button("Clear");
        clearButton.setMaxWidth(Double.MAX_VALUE);
    }

    private void buildUndoButton(){
        undoButton = new Button( "Undo");
        undoButton.setMaxWidth(Double.MAX_VALUE);
    }

    int getSizeSelected(){
        return penSizeMenu.getSizeSelected();
    }

    boolean getFreedraw(){
        return penSizeMenu.getFreedraw();
    }

    int getBrushPoint(){
        return penSizeMenu.getBrushPoint();
    }
}

