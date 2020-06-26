
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

class ColorMenu {
    private int redValue, greenValue, blueValue;
    private double alphaValue;
    private TitledPane colorTitledPane;

    ColorMenu() {
        redValue = 0;
        greenValue = 0;
        blueValue = 0;
        alphaValue = 1.0;

        GridPane colorGridPane = new GridPane();
        colorGridPane.setHgap(2);
        colorGridPane.setPadding(new Insets(8, 8, 8, 8));
        colorGridPane.setPrefWidth(Control.USE_COMPUTED_SIZE);
        colorGridPane.setPrefHeight(Control.USE_COMPUTED_SIZE);

        Label redLabel = new Label("R");
        Label greenLabel = new Label("G");
        Label blueLabel = new Label("B");
        Label alphaLabel = new Label("A");

        Slider redSlider = new Slider(0, 255, 0);
        Slider greenSlider = new Slider(0, 255, 0);
        Slider blueSlider = new Slider(0, 255, 0);
        Slider alphaSlider = new Slider(0.00, 1.00, 1.00);
        final int sliderWidth = 40;
        redSlider.setMaxWidth(sliderWidth);
        greenSlider.setMaxWidth(sliderWidth);
        blueSlider.setMaxWidth(sliderWidth);
        alphaSlider.setMaxWidth(sliderWidth);

        TextField redTextField = new TextField("0");
        TextField greenTextField = new TextField("0");
        TextField blueTextField = new TextField("0");
        TextField alphaTextField = new TextField("1.00");
        final int textFieldWidth = 35;
        final int textFieldHeight = 17;
        redTextField.setMaxSize(textFieldWidth, textFieldHeight);
        greenTextField.setMaxSize(textFieldWidth, textFieldHeight);
        blueTextField.setMaxSize(textFieldWidth, textFieldHeight);
        alphaTextField.setMaxSize(textFieldWidth, textFieldHeight);
        redTextField.setMinSize(textFieldWidth, textFieldHeight);
        greenTextField.setMinSize(textFieldWidth, textFieldHeight);
        blueTextField.setMinSize(textFieldWidth, textFieldHeight);
        alphaTextField.setMinSize(textFieldWidth, textFieldHeight);
        final Insets textFieldInsets = new Insets(4, 4, 4, 4);
        redTextField.setPadding(textFieldInsets);
        greenTextField.setPadding(textFieldInsets);
        blueTextField.setPadding(textFieldInsets);
        alphaTextField.setPadding(textFieldInsets);

        Circle circle = new Circle(32);
        Rectangle rectangle = new Rectangle(80, 80);

        colorGridPane.add(redLabel, 0, 0);
        colorGridPane.add(greenLabel, 0, 1);
        colorGridPane.add(blueLabel, 0, 2);
        colorGridPane.add(alphaLabel, 0, 3);
        colorGridPane.add(redSlider, 1, 0);
        colorGridPane.add(greenSlider, 1, 1);
        colorGridPane.add(blueSlider, 1, 2);
        colorGridPane.add(alphaSlider, 1, 3);
        colorGridPane.add(redTextField, 2, 0);
        colorGridPane.add(greenTextField, 2, 1);
        colorGridPane.add(blueTextField, 2, 2);
        colorGridPane.add(alphaTextField, 2, 3);
        colorGridPane.add(circle, 0, 4, 3, 1);
        colorGridPane.add(rectangle, 0, 4, 3, 1);

        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        GridPane.setHalignment(circle, HPos.CENTER);
        GridPane.setHalignment(rectangle, HPos.CENTER);
        col0.setPrefWidth(Control.USE_COMPUTED_SIZE);
        col1.setPrefWidth(Control.USE_COMPUTED_SIZE);
        col2.setPrefWidth(Control.USE_COMPUTED_SIZE);
        row0.setPrefHeight(Control.USE_COMPUTED_SIZE);
        row1.setPrefHeight(Control.USE_COMPUTED_SIZE);
        row2.setPrefHeight(Control.USE_COMPUTED_SIZE);
        row3.setPrefHeight(Control.USE_COMPUTED_SIZE);
        row4.setPrefHeight(Control.USE_COMPUTED_SIZE);
        GridPane.setMargin(rectangle, new Insets(5, 0, 0, 0));
        GridPane.setMargin(circle, new Insets(5, 0, 0, 0));
        colorGridPane.getColumnConstraints().addAll(col0, col1, col2);
        colorGridPane.getRowConstraints().addAll(row0, row1, row2, row3, row4);

        redTextField.textProperty().bind(redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(alphaSlider.valueProperty().asString("%.2f"));

        redSlider.valueProperty().addListener( (arg, oldVal, newVal) -> {
            redValue = newVal.intValue();
            rectangle.setFill(Color.rgb(redValue, greenValue, blueValue, alphaValue));
        });

        greenSlider.valueProperty().addListener( (arg, oldVal, newVal) -> {
            greenValue = newVal.intValue();
            rectangle.setFill(Color.rgb(redValue, greenValue, blueValue, alphaValue));
        });

        blueSlider.valueProperty().addListener( (arg, oldVal, newVal) -> {
            blueValue = newVal.intValue();
            rectangle.setFill(Color.rgb(redValue, greenValue, blueValue, alphaValue));
        });

        alphaSlider.valueProperty().addListener( (arg, oldVal, newVal) -> {
            alphaValue = newVal.doubleValue();
            rectangle.setFill(Color.rgb(redValue, greenValue, blueValue, alphaValue));
        });

        colorTitledPane = new TitledPane("Drawing Color", colorGridPane);
        colorTitledPane.setPrefHeight(Control.USE_COMPUTED_SIZE);
        colorTitledPane.setPrefWidth(Control.USE_COMPUTED_SIZE);
    }

    TitledPane get(){
        return colorTitledPane;
    }

    Color getColor(){
        return Color.rgb(redValue, greenValue, blueValue, alphaValue);
    }
}
