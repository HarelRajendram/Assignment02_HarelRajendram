package com.mycompany.assignment2_harelrajendram;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PrimaryController {

    private double finishLineX = 650.0;
    
    private ParallelTransition race;
    
    @FXML private ImageView Car09;

    @FXML private ImageView Car12;

    @FXML private ImageView Car31;

    @FXML private ImageView Car87;

    @FXML private Button pauseButton;

    @FXML private Button resetButton;

    @FXML private Slider speedSlider;

    @FXML private Button startButton;
    
    public void handleStart() {
        double randomSeconds = 1.0 + (Math.random() * 15.0); 
        if(race == null || race.getStatus() == javafx.animation.Animation.Status.PAUSED) {
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(randomSeconds),Car09);
            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(randomSeconds),Car12);
            TranslateTransition tt3 = new TranslateTransition(Duration.seconds(randomSeconds),Car31);
            TranslateTransition tt4 = new TranslateTransition(Duration.seconds(randomSeconds),Car87);
            
        }
        race.play();
    
    }
     public void handlePause() {
         race.pause();
    
    }
      public void handleReset() {
          race.playFromStart();
    }
    
}
