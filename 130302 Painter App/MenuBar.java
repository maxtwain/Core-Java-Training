
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
    private PenSizeMenu penSizeMenu;

    MenuBar(){
        colorMenu = new ColorMenu();
        penSizeMenu = new PenSizeMenu();
        colorMenu = new ColorMenu();

        buildUndoButton();
        buildClearButton();

        menuVBox = new VBox();
        menuVBox.setSpacing(8);
        menuVBox.setPrefHeight(Control.USE_COMPUTED_SIZE);
        menuVBox.setPrefWidth(Control.USE_COMPUTED_SIZE);
        menuVBox.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(menuVBox, new Insets(0, 12, 0, 0));
        menuVBox.getChildren().addAll(colorMenu.get(), penSizeMenu.get(), undoButton, clearButton);
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
}

