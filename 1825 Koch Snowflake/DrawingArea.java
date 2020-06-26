import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class DrawingArea {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Color color;

    DrawingArea(MainMenu mainMenu) {
        canvas = new Canvas(400, 480);
        graphicsContext = canvas.getGraphicsContext2D();
        color = mainMenu.getColor();

        drawKochSnowflake(mainMenu);

        mainMenu.getDecreaseButton().setOnAction(event -> {
            if (mainMenu.getLevel() > mainMenu.getMIN_LEVEL()){
                mainMenu.setLevel(mainMenu.getLevel() - 1);
                mainMenu.getLevelLabel().setText("Level: " + mainMenu.getLevel());
                drawKochSnowflake(mainMenu);
            }
        });

        mainMenu.getIncreaseButton().setOnAction(event -> {
            if (mainMenu.getLevel() < mainMenu.getMAX_LEVEL()){
                mainMenu.setLevel(mainMenu.getLevel() + 1);
                mainMenu.getLevelLabel().setText("Level: " + mainMenu.getLevel());
                drawKochSnowflake(mainMenu);
            }
        });

        mainMenu.getColorPicker().setOnAction(event -> {
            color = mainMenu.getColor();
            drawKochSnowflake(mainMenu);
        });
    }

    private void drawKochSnowflake(MainMenu mainMenu){
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.setStroke(color);

        double margin = 40;
        double bottomUp = 100;
        double x1 = 0 + margin;
        double y = 480 - margin - bottomUp;

        double x2 = 400 - margin;

        double x0 = (x1 + x2) / 2;
        double y0 = y - 160 * Math.sqrt(3);

        drawKoch(mainMenu.getLevel(), x1, y, x0, y0);
        drawKoch(mainMenu.getLevel(), x0, y0, x2, y);
        drawKoch(mainMenu.getLevel(), x2, y, x1, y);
    }

    private void drawKoch(int level, double x0, double y0, double x4, double y4){
        if (level == 0){
            graphicsContext.strokeLine(x0, y0, x4, y4);
        } else {

            double x1 = (2 * x0 + x4) / 3;
            double y1 = (2 * y0 + y4) / 3;

            double x3 = (x0 + 2 * x4) / 3;
            double y3 = (y0 + 2 * y4) / 3;

            double x2 = (x1 + x3 + (Math.sqrt(3)*(y3 - y1)))/2;
            double y2 = (y1 + y3 + (Math.sqrt(3)*(x1 - x3)))/2;

            color = getNextColor(color);
            graphicsContext.setStroke(color);
            drawKoch(level - 1, x0, y0, x1, y1);

            color = getNextColor(color);
            graphicsContext.setStroke(color);
            drawKoch(level - 1, x1, y1, x2, y2);

            color = getNextColor(color);
            graphicsContext.setStroke(color);
            drawKoch(level - 1, x2, y2, x3, y3);

            color = getNextColor(color);
            graphicsContext.setStroke(color);
            drawKoch(level - 1, x3, y3, x4, y4);
        }
    }

    private Color getNextColor(Color inColor){
        int red = offsetColor((int)(inColor.getRed() * 255));
        int blue = offsetColor((int)(inColor.getBlue() * 255));
        int green = offsetColor((int)(inColor.getGreen() * 255));
        return Color.rgb(red, green, blue);
    }

    private int offsetColor(int color){
        color += 255 / 200;
        if (color > 255){
            color -= 255;
        }
        return color;
    }

    Canvas get() { return canvas; }
}
