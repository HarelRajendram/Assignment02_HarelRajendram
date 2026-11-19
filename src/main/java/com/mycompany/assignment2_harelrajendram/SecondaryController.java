package com.mycompany.assignment2_harelrajendram;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
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
    
    private MediaPlayer player;

       public void initialize() {
           Car09.setOpacity(0.0);
           Car12.setOpacity(0.0);
           Car31.setOpacity(0.0);
           Car87.setOpacity(0.0);
           
           SequentialTransition sqMain = new SequentialTransition(
                    carFade(Car09, Duration.seconds(3),Duration.seconds(1.0)),
                   carFade(Car12, Duration.seconds(3),Duration.seconds(1.0)),
                   carFade(Car31, Duration.seconds(3),Duration.seconds(1.0)),
                   carFade(Car87, Duration.seconds(3),Duration.seconds(1.0)));
           sqMain.setCycleCount(Animation.INDEFINITE);
           sqMain.play();
           
try {
            String path = getClass().getResource("/com/mycompany/assignment2_harelrajendram/guitar.wav").toExternalForm();
            Media media = new Media(path);
            player = new MediaPlayer(media);
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.setAutoPlay(true);
        } catch (Exception e) {
            System.out.println("Could not play guitar.wav: " + e.getMessage());
        }
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
           if( player != null) {
                player.pause();
           }
       App.setRoot("primary");
       }
       private SequentialTransition carFade(ImageView car, Duration duration,Duration pause) {
           FadeTransition fd1 = new FadeTransition(duration,car);
           fd1.setFromValue(0.0);
           fd1.setToValue(1.0);
           
           PauseTransition ps = new PauseTransition(pause);
           
            FadeTransition fd2 = new FadeTransition(duration,car);
           fd2.setFromValue(1.0);
           fd2.setToValue(0.0);
           

           return new SequentialTransition(fd1,ps,fd2);
       }
      
}