package com.mycompany.assignment2_harelrajendram;

import java.io.IOException;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SecondaryController {
    
    @FXML
    private ImageView Car09;

    @FXML
    private ImageView Car12;

    @FXML
    private ImageView Car31;

    @FXML
    private ImageView Car87;

    @FXML
    private Button startRaceButton;

    Rectangle rect1 = new Rectangle(40,50,300,160);
    Rectangle rect2 = new Rectangle(25, 70, 50, 150);
    Rectangle rect3 = new Rectangle(60, 30, 100, 200);
    Rectangle rect4 = new Rectangle(45, 0, 400, 180);
    
       public void initialize() {
       PathTransition pt1 =  createCarAnimation(Car09,rect1,Duration.seconds(10.0),Duration.seconds(0.0));
       PathTransition pt2 =  createCarAnimation(Car12,rect2,Duration.seconds(5.0),Duration.seconds(2.0));
       PathTransition pt3 =  createCarAnimation(Car31,rect3,Duration.seconds(10.0),Duration.seconds(3.5));
       PathTransition pt4 =  createCarAnimation(Car87,rect4,Duration.seconds(9.0),Duration.seconds(4.5));
       
       ParallelTransition slideShowAnimation = new ParallelTransition(pt1,pt2,pt3,pt4);
       slideShowAnimation.setCycleCount(ParallelTransition.INDEFINITE);
       
       slideShowAnimation.play();
       }
       private PathTransition createCarAnimation(ImageView car ,Rectangle pathRect, Duration duration,Duration delay) {
       PathTransition pt = new PathTransition();
       
       pt.setDuration(duration);
       pt.setNode(car);
       pt.setPath(pathRect);
       pt.setOrientation(PathTransition.OrientationType.NONE);
       pt.setCycleCount(PathTransition.INDEFINITE);
       pt.setDelay(delay);
       return pt;
       }
       
       @FXML
       public void handleRaceButton() throws IOException {
       App.setRoot("primary");
       }
      
}