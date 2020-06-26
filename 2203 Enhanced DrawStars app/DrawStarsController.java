import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Transform;
import javafx.util.Duration;

import java.security.SecureRandom;

public class DrawStarsController{
    @FXML
    private Pane pane;
    private static final SecureRandom random = new SecureRandom();

    public void initialize(){
        Double[] points = {205.0, 150.0, 217.0, 186.0, 259.0, 186.0, 223.0, 204.0, 233.0, 246.0, 205.0, 222.0, 177.0, 246.0, 187.0, 204.0, 151.0, 186.0, 193.0, 186.0};

        for(int count = 0; count < 18; ++count){
            Polygon newStar = new Polygon();
            newStar.getPoints().addAll(points);

            newStar.setStroke(Color.GREY);
            newStar.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextDouble()));

            newStar.getTransforms().add(Transform.rotate(count * 20, 150, 150));
            pane.getChildren().add(newStar);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(10),
                            new EventHandler<ActionEvent>() {
                                int dx = 1 + random.nextInt(5);
                                int dy = 1 + random.nextInt(5);

                                @Override
                                public void handle(ActionEvent event) {
                                    c.setLayoutX(c.getLayoutX() + dx);
                                    c.setLayoutY(c.getLayoutY() + dy);
                                    Bounds bounds = pane.getBoundsInLocal();


                                }
                            })
            )

            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));
            rotateTransition.setByAngle(360.0);
            rotateTransition.setCycleCount(2);
            rotateTransition.setInterpolator(Interpolator.EASE_BOTH);
            rotateTransition.setAutoReverse(true);
        }
    }
}