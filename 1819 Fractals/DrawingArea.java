import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class DrawingArea {

    private Canvas canvas;
    private GraphicsContext graphicsContext;

    DrawingArea(MainMenu mainMenu) {
        canvas = new Canvas(400, 480);
        graphicsContext = canvas.getGraphicsContext2D();
        drawFractal(mainMenu);

        mainMenu.getDecreaseButton().setOnAction(event -> {
            if (mainMenu.getLevel() > mainMenu.getMIN_LEVEL()){
                mainMenu.setLevel(mainMenu.getLevel() - 1);
                mainMenu.getLevelLabel().setText("Level: " + mainMenu.getLevel());
                drawFractal(mainMenu);
            }
        });

        mainMenu.getIncreaseButton().setOnAction(event -> {
            if (mainMenu.getLevel() < mainMenu.getMAX_LEVEL()){
                mainMenu.setLevel(mainMenu.getLevel() + 1);
                mainMenu.getLevelLabel().setText("Level: " + mainMenu.getLevel());
                drawFractal(mainMenu);
            }
        });

        mainMenu.getColorPicker().setOnAction(event -> {
            drawFractal(mainMenu);
        });
    }

    private void drawFractal(MainMenu mainMenu) {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // coordinate variables
        int radius = 160;
        int x0 = (int)(Math.sin(2 * Math.PI / 5) * radius);
        int x1 = (int)(Math.sin(4 * Math.PI / 5) * radius);
        int y0 = (int)(Math.cos(2 * Math.PI / 5) * radius);
        int y1 = (int)(Math.cos(Math.PI / 5) * radius);

        Color color = mainMenu.getColor();
        graphicsContext.setStroke(color);
        drawArm(mainMenu.getLevel(), 200, 240, 200, 240 + radius);

        color = getNextColor(color);
        graphicsContext.setStroke(color);
        drawArm(mainMenu.getLevel(), 200, 240, x0 * -1 + 200, y0 + 240);

        color = getNextColor(color);
        graphicsContext.setStroke(color);
        drawArm(mainMenu.getLevel(), 200, 240, x1 * -1 + 200, y1 * -1 + 240);

        color = getNextColor(color);
        graphicsContext.setStroke(color);
        drawArm(mainMenu.getLevel(), 200, 240, x1 + 200, y1 * -1 + 240);

        color = getNextColor(color);
        graphicsContext.setStroke(color);
        drawArm(mainMenu.getLevel(), 200, 240, x0 + 200, y0 + 240);
    }

    private void drawArm(int level, int xA, int yA, int xB, int yB) {
        if (level == 0){
            graphicsContext.strokeLine(xA, yA, xB, yB);
        } else {
            int xC = (xA + xB) / 2;
            int yC = (yA + yB) / 2;

            int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
            int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

            drawArm(level - 1, xD, yD, xA, yA);
            drawArm(level - 1, xD, yD, xC, yC);
            drawArm(level - 1, xD, yD, xB, yB);
        }
    }

    private Color getNextColor(Color inColor){
        int red = offsetColor((int)(inColor.getRed() * 255));
        int blue = offsetColor((int)(inColor.getBlue() * 255));
        int green = offsetColor((int)(inColor.getGreen() * 255));
        return Color.rgb(red, green, blue);
    }

    private int offsetColor(int color){
        color += 255 / 5;
        if (color > 255){
            color -= 255;
        }
        return color;
    }

    Canvas get() { return canvas; }
}
