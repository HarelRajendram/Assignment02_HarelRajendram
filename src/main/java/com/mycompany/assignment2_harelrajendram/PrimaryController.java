package com.mycompany.assignment2_harelrajendram;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrimaryController {
    // Git Link:https://github.com/HarelRajendram/Assignment02_HarelRajendram.git

    private final double finishLineX = 620.0;
    private int place = 1;
    
     private MediaPlayer player;
    
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
    
    @FXML private Circle car09Wheel1;

    @FXML private Circle car09Wheel2;

    @FXML private Circle car12Wheel1;

    @FXML private Circle car12Wheel2;

    @FXML private Circle car31Wheel1;

    @FXML private Circle car31Wheel2;

    @FXML private Circle car87Wheel1;

    @FXML private Circle car87Wheel2;
    
     @FXML
    private Line car09Spoke1;

    @FXML
    private Line car09Spoke2;
 
    @FXML
    private Line car12Spoke1;

    @FXML
    private Line car12Spoke2;
    
    @FXML
    private Line car31Spoke1;

    @FXML
    private Line car31Spoke2;

     @FXML
    private Line car87Spoke1;

    @FXML
    private Line car87Spoke2;


    public void initialize() throws IOException {
       
         Car09.getPoints().clear();
         Car12.getPoints().clear();
         Car31.getPoints().clear();
         Car87.getPoints().clear();
         
         Car09.getPoints().addAll(
                 0.0, 10.0, 
                 15.0,  0.0,  
                 40.0,  0.0, 
                 55.0, 12.0, 
                 65.0, 14.0,
                 65.0, 24.0, 
                 0.0, 24.0 );
         Car12.getPoints().addAll(
                0.0, 10.0, 
                 15.0,  0.0,  
                 40.0,  0.0, 
                 55.0, 12.0, 
                 65.0, 14.0,
                 65.0, 24.0, 
                 0.0, 24.0 );
         Car31.getPoints().addAll(
                 0.0, 10.0, 
                 15.0,  0.0,  
                 40.0,  0.0, 
                 55.0, 12.0, 
                 65.0, 14.0,
                 65.0, 24.0, 
                 0.0, 24.0 );
         Car87.getPoints().addAll(
                 0.0, 10.0, 
                 15.0,  0.0,  
                 40.0,  0.0, 
                 55.0, 12.0, 
                 65.0, 14.0,
                 65.0, 24.0, 
                 0.0, 24.0 );
         
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
        double randomSeconds1 = 1.0 + (Math.random() * 7.0); 
        double randomSeconds2 = 1.0 + (Math.random() * 7.0);
        double randomSeconds3 = 1.0 + (Math.random() * 7.0);
        double randomSeconds4 = 1.0 + (Math.random() * 7.0);
        
        //applying the animations to each car
        if(race == null ) {
            tt1 = new TranslateTransition(Duration.seconds(randomSeconds1),Car09Layout);
            tt2 = new TranslateTransition(Duration.seconds(randomSeconds2),Car12Layout);
            tt3 = new TranslateTransition(Duration.seconds(randomSeconds3),Car31Layout);
            tt4 = new TranslateTransition(Duration.seconds(randomSeconds4),Car87Layout);
            
             //changes the label to announce the winner
     tt1.setOnFinished(e -> assignPlace("Car09")
     );
     
     tt2.setOnFinished(e -> assignPlace("Car12")
     );
     
     tt3.setOnFinished(e -> assignPlace("Car31")
        );
     
     tt4.setOnFinished(e -> assignPlace("Car87")
        );
//            
//            Car09.setTranslateX(25);
//            Car12.setTranslateX(25);
//            Car31.setTranslateX(25); 
//            Car87.setTranslateX(25);
            
            tt1.setByX(finishLineX);
            tt2.setByX(finishLineX);
            tt3.setByX(finishLineX);
            tt4.setByX(finishLineX);
            
            tt1.setInterpolator(Interpolator.EASE_BOTH);
            tt2.setInterpolator(Interpolator.EASE_BOTH);
            tt3.setInterpolator(Interpolator.EASE_BOTH);
            tt4.setInterpolator(Interpolator.EASE_BOTH);
            
            ParallelTransition wheels1 = wheelAnimation(Duration.seconds(0.3), car09Wheel1, car09Wheel2,car09Spoke1,car09Spoke2);
            
            ParallelTransition wheels2 = wheelAnimation(Duration.seconds(0.3), car12Wheel1, car12Wheel2,car12Spoke1,car12Spoke2);
            
            ParallelTransition wheels3 = wheelAnimation(Duration.seconds(0.3), car31Wheel1, car31Wheel2,car31Spoke1,car31Spoke2);
            
            ParallelTransition wheels4 = wheelAnimation(Duration.seconds(0.3), car87Wheel1, car87Wheel2,car87Spoke1,car87Spoke2);
   
            race = new ParallelTransition(tt1,tt2,tt3,tt4,wheels1,wheels2,wheels3,wheels4);
            
//        MotionBlur motionblur = new MotionBlur();
//        motionblur.setRadius(5.0); 
//        motionblur.setAngle(45.0);
//
//        Car09.setEffect(motionblur);
//        Car12.setEffect(motionblur);
//        Car31.setEffect(motionblur);
//        Car87.setEffect(motionblur);
        
            if(player == null) {
            String path = getClass().getResource("/com/mycompany/assignment2_harelrajendram/TakeOff.mp4").toExternalForm();
            Media media = new Media(path);
            
            player = new javafx.scene.media.MediaPlayer(media);
            player.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
            player.setAutoPlay(true);
            }
        
        }
        race.play();
        if(player != null) {
            player.play();
        }
    
    }
     public void handlePause() {
         if(race != null) {
             race.pause();
            if (player != null) {
              player.pause();
            }
         }
    }
      public void handleReset() {
           if(race != null) {
             race.stop(); 
             if (player != null) {
              player.stop();
             }
             player.seek(Duration.ZERO);
         }
            Car09Layout.setTranslateX(0);
            Car12Layout.setTranslateX(0);
            Car31Layout.setTranslateX(0);
            Car87Layout.setTranslateX(0);
            
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
   private ParallelTransition wheelAnimation(Duration duration, javafx.scene.Node n1, javafx.scene.Node n2, javafx.scene.Node n3, javafx.scene.Node n4) {
    RotateTransition rt1 = new RotateTransition(duration, n1);
    rt1.setByAngle(360);
    rt1.setCycleCount(Animation.INDEFINITE);
    rt1.setInterpolator(Interpolator.LINEAR);

    RotateTransition rt2 = new RotateTransition(duration, n2);
    rt2.setByAngle(360);
    rt2.setCycleCount(Animation.INDEFINITE);
    rt2.setInterpolator(Interpolator.LINEAR);
    
    RotateTransition rt3 = new RotateTransition(duration, n3);
    rt3.setByAngle(360);
    rt3.setCycleCount(Animation.INDEFINITE);
    rt3.setInterpolator(Interpolator.LINEAR);
    
    RotateTransition rt4 = new RotateTransition(duration, n4);
    rt4.setByAngle(360);
    rt4.setCycleCount(Animation.INDEFINITE);
    rt4.setInterpolator(Interpolator.LINEAR);

    return new ParallelTransition(rt1, rt2,rt3,rt4);
}
}
