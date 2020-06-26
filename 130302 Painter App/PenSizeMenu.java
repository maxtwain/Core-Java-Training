import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

class PenSizeMenu {
    private ToggleButton smallButton, mediumButton, largeButton;
    private int sizeSelected;
    private TitledPane sizeTitledPane;

    PenSizeMenu(){
        buildSizeGroup();

        VBox sizeVBox = new VBox();
        sizeVBox.setSpacing(8);
        sizeVBox.setPrefHeight(Control.USE_COMPUTED_SIZE);
        sizeVBox.setPrefWidth(Control.USE_COMPUTED_SIZE);

        sizeVBox.getChildren().addAll(smallButton, mediumButton, largeButton);

        sizeTitledPane = new TitledPane("Pen Size", sizeVBox);
        sizeTitledPane.setPrefHeight(Control.USE_COMPUTED_SIZE);
        sizeTitledPane.setPrefWidth(Control.USE_COMPUTED_SIZE);
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

    int getSizeSelected(){
        return sizeSelected;
    }
}
