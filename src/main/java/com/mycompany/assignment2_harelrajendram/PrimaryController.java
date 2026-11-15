package com.mycompany.assignment2_harelrajendram;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PrimaryController {
    // Git Link:https://github.com/HarelRajendram/Assignment02_HarelRajendram.git

    private double finishLineX = 650.0;
    
    private ParallelTransition race;
    
    private TranslateTransition tt1;
    private TranslateTransition tt2;
    private TranslateTransition tt3;
    private TranslateTransition tt4;
    
    
    @FXML private ImageView Car09;

    @FXML private ImageView Car12;

    @FXML private ImageView Car31;

    @FXML private ImageView Car87;

    @FXML private Button pauseButton;

    @FXML private Button resetButton;

    @FXML private Slider speedSlider;

    @FXML private Button startButton;
    
     @FXML private Label winnerLabel;
     
     
     public void initialize() {
         //controls the play speed of all the cars
         speedSlider.setMin(0.5);
         speedSlider.setMax(2);
         speedSlider.setValue(1);
         
     speedSlider.valueProperty().addListener((obs,oldV,newV) -> {
         if (race != null) {
             race.setRate(newV.doubleValue());
         }
     });
    }
     
    //methods to handle each button
    public void handleStart() {
        //generates random speed for each cars
        double randomSeconds1 = 1.0 + (Math.random() * 15.0); 
        double randomSeconds2 = 1.0 + (Math.random() * 15.0);
        double randomSeconds3 = 1.0 + (Math.random() * 15.0);
        double randomSeconds4 = 1.0 + (Math.random() * 15.0);
        
        //applying the animations to each car
        if(race == null ) {
            tt1 = new TranslateTransition(Duration.seconds(randomSeconds1),Car09);
            tt2 = new TranslateTransition(Duration.seconds(randomSeconds2),Car12);
            tt3 = new TranslateTransition(Duration.seconds(randomSeconds3),Car31);
            tt4 = new TranslateTransition(Duration.seconds(randomSeconds4),Car87);
            
             //changes the label to announce the winner
     tt1.setOnFinished(event -> {
         winnerLabel.setText("Congratulations Car09 has won the race! ");
         race.stop();
        });
     
     tt2.setOnFinished(event -> {
         winnerLabel.setText("Congratulations Car12 has won the race! ");
         race.stop();
        });
     
     tt3.setOnFinished(event -> {
         winnerLabel.setText("Congratulations Car31 has won the race! ");
         race.stop();
        });
     
     tt4.setOnFinished(event -> {
         winnerLabel.setText("Congratulations Car87 has won the race! ");
         race.stop();
        });
            
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
            
             
//        MotionBlur motionblur = new MotionBlur();
//        motionblur.setRadius(5.0); 
//        motionblur.setAngle(45.0);
//
//        Car09.setEffect(motionblur);
//        Car12.setEffect(motionblur);
//        Car31.setEffect(motionblur);
//        Car87.setEffect(motionblur);
        
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
            Car09.setTranslateX(15);
            Car12.setTranslateX(15);
            Car31.setTranslateX(15);
            Car87.setTranslateX(15);
            
            race = null;
    }
}
