import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

class PenMenu {
    private ToggleButton smallButton, mediumButton, largeButton;
    private int sizeSelected;
    private TitledPane sizeTitledPane;
    private CheckBox freedrawCheckBox;
    private GridPane brushPointGrid;
    private TextField brushPointTextField;

    PenMenu(){
        buildSizeGroup();

        VBox sizeVBox = new VBox();
        sizeVBox.setSpacing(8);
        sizeVBox.setPrefHeight(Control.USE_COMPUTED_SIZE);
        sizeVBox.setPrefWidth(Control.USE_COMPUTED_SIZE);
        freedrawCheckBox = new CheckBox("Freedraw");
        freedrawCheckBox.setSelected(true);
        createBrushPointGrid();

        sizeVBox.getChildren().addAll(freedrawCheckBox, brushPointGrid, smallButton, mediumButton, largeButton);

        sizeTitledPane = new TitledPane("Pen Options", sizeVBox);
        sizeTitledPane.setPrefHeight(Control.USE_COMPUTED_SIZE);
        sizeTitledPane.setPrefWidth(Control.USE_COMPUTED_SIZE);
    }

    private void createBrushPointGrid() {
        Label brushPointLabel = new Label("Brush Points");

        Slider brushPointSlider = new Slider(3, 9, 9);
        brushPointSlider.setMaxWidth(65);

        brushPointTextField = new TextField("9");
        brushPointTextField.setMaxSize(20, 10);
        brushPointTextField.setPadding(new Insets(4, 4, 4, 4));

        brushPointGrid = new GridPane();
        brushPointGrid.add(brushPointLabel, 0, 0);
        brushPointGrid.add(brushPointSlider, 0, 1);
        brushPointGrid.add(brushPointTextField, 1, 1);

        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        col0.setPrefWidth(Control.USE_COMPUTED_SIZE);
        col1.setPrefWidth(Control.USE_COMPUTED_SIZE);
        row0.setPrefHeight(Control.USE_COMPUTED_SIZE);
        row1.setPrefHeight(Control.USE_COMPUTED_SIZE);
        GridPane.setMargin(brushPointSlider, new Insets(0, 5, 0, 0));
        brushPointGrid.getColumnConstraints().addAll(col0, col1);
        brushPointGrid.getRowConstraints().addAll(row0, row1);

        brushPointSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                brushPointTextField.setText(String.valueOf(newValue.intValue()));
            }
        });

    }

    private void buildSizeGroup(){
        ToggleGroup sizeGroup = new ToggleGroup();
        smallButton = new RadioButton("Small");
        mediumButton = new RadioButton("Medium");
        largeButton = new RadioButton("Large");

        smallButton.setToggleGroup(sizeGroup);
        mediumButton.setToggleGroup(sizeGroup);
        largeButton.setToggleGroup(sizeGroup);

        smallButton.setSelected(true);
        sizeSelected = 10;

        sizeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if(smallButton.isSelected()) { sizeSelected = 10; }
                else if(mediumButton.isSelected()) { sizeSelected = 20; }
                else {sizeSelected = 40; }
            }
        });
    }

    TitledPane get(){
        return sizeTitledPane;
    }

    boolean getFreedraw(){
        return freedrawCheckBox.isSelected();
    }

    int getBrushPoint(){
        return Integer.parseInt(brushPointTextField.getText());
    }

    int getSizeSelected(){
        return sizeSelected;
    }
}
