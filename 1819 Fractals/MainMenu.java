import javafx.scene.control.*;
import javafx.scene.paint.Color;

class MainMenu {
    private int MIN_LEVEL = 0;
    private int MAX_LEVEL = 10;
    private int level = MIN_LEVEL;

    private ToolBar menuToolBar;
    private ColorPicker colorPicker;
    private Button decreaseButton;
    private Button increaseButton;
    private Label levelLabel;

    MainMenu(){
        buildColorPicker();
        buildDecreaseButton();
        buildIncreaseButton();
        buildLevelLabel();

        menuToolBar = new ToolBar();
        menuToolBar.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        menuToolBar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        menuToolBar.getItems().add(colorPicker);
        menuToolBar.getItems().add(decreaseButton);
        menuToolBar.getItems().add(increaseButton);
        menuToolBar.getItems().add(levelLabel);
    }

    ToolBar get() { return menuToolBar; }

    Color getColor() { return colorPicker.getValue(); }
    int getLevel() { return level; }
    int getMIN_LEVEL() { return MIN_LEVEL; }
    int getMAX_LEVEL() { return MAX_LEVEL; }

    void setLevel(int level) { this.level = level; }

    Button getDecreaseButton() { return decreaseButton; }
    Button getIncreaseButton() { return increaseButton; }
    Label getLevelLabel() { return levelLabel; }
    ColorPicker getColorPicker() { return colorPicker; }

    private void buildColorPicker(){
        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);
    }

    private void buildDecreaseButton(){
        decreaseButton = new Button("Decrease Level");
        decreaseButton.setMaxWidth(Double.MAX_VALUE);
    }

    private void buildIncreaseButton(){
        increaseButton = new Button("Increase Level");
        increaseButton.setMaxWidth(Double.MAX_VALUE);
    }

    private void buildLevelLabel(){
        levelLabel = new Label("Level: " + level);
        levelLabel.setMaxWidth(Double.MAX_VALUE);
    }
}
