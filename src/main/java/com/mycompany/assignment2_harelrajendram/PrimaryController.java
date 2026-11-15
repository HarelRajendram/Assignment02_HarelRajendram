package com.mycompany.assignment2_harelrajendram;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
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
        double randomSeconds1 = 1.0 + (Math.random() * 15.0); 
        double randomSeconds2 = 1.0 + (Math.random() * 15.0);
        double randomSeconds3 = 1.0 + (Math.random() * 15.0);
        double randomSeconds4 = 1.0 + (Math.random() * 15.0);
        
        if(race == null || race.getStatus() == javafx.animation.Animation.Status.PAUSED) {
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(randomSeconds1),Car09);
            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(randomSeconds2),Car12);
            TranslateTransition tt3 = new TranslateTransition(Duration.seconds(randomSeconds3),Car31);
            TranslateTransition tt4 = new TranslateTransition(Duration.seconds(randomSeconds4),Car87);
            
            Car09.setTranslateX(30);
            Car12.setTranslateX(30);
            Car31.setTranslateX(30);
            Car87.setTranslateX(30);
            
            tt1.setByX(finishLineX);
            tt2.setByX(finishLineX);
            tt3.setByX(finishLineX);
            tt4.setByX(finishLineX);
            
            tt1.setInterpolator(Interpolator.LINEAR);
            tt2.setInterpolator(Interpolator.LINEAR);
            tt3.setInterpolator(Interpolator.LINEAR);
            tt4.setInterpolator(Interpolator.LINEAR);
            
            race = new ParallelTransition(tt1,tt2,tt3,tt4);
        }
        race.play();
    
    }
     public void handlePause() {
         if(race != null) {
             race.pause();
         }
    }
      public void handleReset() {
           if(race != null) {
             race.stop();
         }
            Car09.setTranslateX(30);
            Car12.setTranslateX(30);
            Car31.setTranslateX(30);
            Car87.setTranslateX(30);
            
            race = null;
    }
    
}
