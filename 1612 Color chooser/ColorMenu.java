
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

class ColorMenu {
    private int redValue, greenValue, blueValue;
    private double alphaValue;
    private TabPane colorTabPane;

    ColorMenu() {
        redValue = 0;
        greenValue = 0;
        blueValue = 0;
        alphaValue = 1.0;

        ColorSliderTabMenu colorSliderTabMenu = new ColorSliderTabMenu(this);
        ColorSwatchTabMenu colorSwatchTabMenu = new ColorSwatchTabMenu(this);

        colorTabPane = new TabPane();
        Tab colorSliderTab = new Tab("Color");
        colorSliderTab.setContent(colorSliderTabMenu.get());

        Tab colorSwatchTab = new Tab("Swatch");
        colorSwatchTab.setContent(colorSwatchTabMenu.get());

        colorTabPane.getTabs().addAll(colorSliderTab, colorSwatchTab);

        colorSliderTab.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                colorSliderTabMenu.revertColor();
            }
        });

    }

    TabPane get(){
        return colorTabPane;
    }

    Color getColor(){
        return Color.rgb(redValue, greenValue, blueValue, alphaValue);
    }
    // alpha can be changed to a modifiable value if required at a later date.
    void setColorRGBA(int red, int green, int blue){
        redValue = red;
        greenValue = green;
        blueValue = blue;
        alphaValue = 1.0;
    }
    void setRedValue(int redValue){
        this.redValue = redValue;
    }
    void setGreenValue(int greenValue){
        this.greenValue = greenValue;
    }
    void setBlueValue(int blueValue){
        this.blueValue = blueValue;
    }
    void setAlphaValue(double alphaValue){
        this.alphaValue = alphaValue;
    }
}
