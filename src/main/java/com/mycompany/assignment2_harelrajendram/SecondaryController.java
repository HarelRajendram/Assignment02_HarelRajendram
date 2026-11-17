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

    Rectangle rect = new Rectangle(50,50,300,200);
    
       public void initialize() {
        PathTransition pt = new PathTransition();
       
       pt.setDuration(Duration.seconds(4.0));
       pt.setNode(Car09);
       pt.setPath(rect);
       pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
       pt.setCycleCount(PathTransition.INDEFINITE);
       pt.play();
       
       ParallelTransition slideShow = new ParallelTransition();
       }
       @FXML
       public void handleRaceButton() throws IOException {
       App.setRoot("primary");
       }
      
}