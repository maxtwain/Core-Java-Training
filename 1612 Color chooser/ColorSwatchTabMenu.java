import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

class ColorSwatchTabMenu {
    private GridPane swatchGridPane;

    ColorSwatchTabMenu(ColorMenu colorMenu){
        swatchGridPane = new GridPane();
        swatchGridPane.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);

        List<Color> colorList = Arrays.asList(Color.TOMATO, Color.YELLOW, Color.SPRINGGREEN, Color.CYAN, Color.CORNFLOWERBLUE, Color.VIOLET, Color.CHOCOLATE, Color.GOLD, Color.TEAL, Color.TURQUOISE, Color.SLATEBLUE, Color.MAGENTA, Color.BLACK);

        final double rectSize = 20;
        for (Color color : colorList){
            Rectangle rect = new Rectangle(rectSize, rectSize, color);
            rect.setStroke(Color.BLACK);
            rect.setStrokeWidth(1);
            int row = colorList.indexOf(color) / 4;
            int col = colorList.indexOf(color) % 4;
            swatchGridPane.add(rect, col, row);

            rect.setOnMouseClicked( event -> {
                colorMenu.setColorRGBA((int)(color.getRed() * 255), (int)(color.getGreen() * 255), (int)(color.getBlue() * 255));
            });
        }
    }

    GridPane get(){
        return swatchGridPane;
    }

    // this function is not used.  I have let it remain as it satisfies the requirements of the exercise.
    private void createMap(Map<String, Color> swatchMap){

        swatchMap.put("Red", Color.RED);
        swatchMap.put("Yellow", Color.YELLOW);
        swatchMap.put("Green", Color.GREEN);
        swatchMap.put("Cyan", Color.CYAN);
        swatchMap.put("Blue", Color.BLUE);
        swatchMap.put("Magenta", Color.MAGENTA);
        swatchMap.put("Brown", Color.BROWN);
        swatchMap.put("Gold", Color.GOLD);
        swatchMap.put("Forest Green", Color.FORESTGREEN);
        swatchMap.put("Dark Cyan", Color.DARKCYAN);
        swatchMap.put("Dark Blue", Color.DARKBLUE);
        swatchMap.put("Purple", Color.PURPLE);
        swatchMap.put("Black", Color.BLACK);
    }
}
