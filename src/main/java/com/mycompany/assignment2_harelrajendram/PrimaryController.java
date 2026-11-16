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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class PrimaryController {
    // Git Link:https://github.com/HarelRajendram/Assignment02_HarelRajendram.git

    private double finishLineX = 650.0;
    private int place = 1;
    
    private ParallelTransition race;
    
    private TranslateTransition tt1;
    private TranslateTransition tt2;
    private TranslateTransition tt3;
    private TranslateTransition tt4;
    
  
    
    @FXML
    private Pane Car09Layout;

    @FXML
    private Pane Car12Layout;

    @FXML
    private Pane Car31Layout;

    @FXML
    private Pane Car87Layout;
    
    @FXML private Polygon Car09;

    @FXML private Polygon Car12;

    @FXML private Polygon Car31;

    @FXML private Polygon Car87;

    @FXML private Button pauseButton;

    @FXML private Button resetButton;

    @FXML private Slider speedSlider;

    @FXML private Button startButton;
    
    @FXML private Label winnerLabel;
     
    @FXML private Label FourthPlaceLabel;

    @FXML private Label SecondPlaceLabel;

    @FXML private Label ThirdPlaceLabel;
     
     
     public void initialize() {
         Car09.getPoints().clear();
         Car12.getPoints().clear();
         Car31.getPoints().clear();
         Car87.getPoints().clear();
         
         Car09.getPoints().addAll(160.0, 20.0, 300.0, 120.0,160.0, 220.0,20.0, 120.0, 160.0, 20.0);
         Car12.getPoints().addAll(160.0, 20.0, 300.0, 120.0,160.0, 220.0,20.0, 120.0, 160.0, 20.0);
         Car31.getPoints().addAll(160.0, 20.0, 300.0, 120.0,160.0, 220.0,20.0, 120.0, 160.0, 20.0);
         Car87.getPoints().addAll(160.0, 20.0, 300.0, 120.0,160.0, 220.0,20.0, 120.0, 160.0, 20.0);
         
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
        place = 1;
        
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
     tt1.setOnFinished(e -> assignPlace("Car09")
     );
     
     tt2.setOnFinished(e -> assignPlace("Car12")
     );
     
     tt3.setOnFinished(e -> assignPlace("Car31")
        );
     
     tt4.setOnFinished(e -> assignPlace("Car87")
        );
            
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
            
            winnerLabel.setText("Winner of the race:");
            SecondPlaceLabel.setText("Second place of the race:");
            ThirdPlaceLabel.setText("Third place of the race:");
            FourthPlaceLabel.setText("Last place of the race:");
            place = 1;
            
            race = null;
    }
      private void assignPlace(String carName) {
        switch (place) {
            case 1:
                winnerLabel.setText("Winner of the race:" + carName);
                place++;
                break;
            case 2:
                SecondPlaceLabel.setText("Second place of the race:" + carName);
                place++;
                break;
            case 3:
                ThirdPlaceLabel.setText("Third place of the race:" + carName);
                place++;
                break;
            case 4:
                FourthPlaceLabel.setText("Last place of the race:" + carName);
                place++;
                break;
            default:
                break;
        }
      }
}
