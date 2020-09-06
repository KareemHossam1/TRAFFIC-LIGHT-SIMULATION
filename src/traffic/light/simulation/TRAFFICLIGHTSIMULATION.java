package traffic.light.simulation;
// Importing Packages
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class TRAFFICLIGHTSIMULATION extends Application {
    // Creating Objects
    Rectangle rectangle = new Rectangle(100,20,100,300);  // Creating Traffic Light body
    Rectangle rectangle1 = new Rectangle(130,500,40,20);  // Creating Traffic light base
    Pane pane = new Pane();                               // Creating a pane to add elements
    Circle stop = new Circle(150,70,50);                  // Creating Stop sign
    Circle wait = new Circle(150,170,50);                 // Creating wait sign
    Circle go = new Circle(150,270,50);                   // Creating go sign
    VBox v = new VBox();                                  // Creating VBox to order signs
    Line line = new Line(150,320,150,500);                // Creating traffic holder
    @Override
    public void start(Stage primaryStage) {
        rectangle.setFill(Color.GRAY);                    // Traffic light body color
        rectangle1.setFill(Color.BLACK);                  // Traffic light base color
        rectangle.setStroke(Color.BLACK);                 // Traffic light body stroke
        stop.setStroke(Color.BLACK);                      // Stop sign stroke
        wait.setStroke(Color.BLACK);                      // Wait sign stroke
        go.setStroke(Color.BLACK);                        // Go sign stroke
        stop.setFill(Color.RED);                          // Stop sign default color
        v.getChildren().addAll(stop,wait,go);             // Ordering signs
        pane.getChildren().addAll(rectangle,stop,wait,go,line,rectangle1); // Adding Elements to be shown on the scene
        Timeline simulation = new Timeline();             // Creating a timeline to change colors
        simulation.getKeyFrames().addAll(                 // Adding keyframes
        new KeyFrame(Duration.ZERO,e ->{                  // Default view on stop sign
                stop.setFill(Color.RED);
                wait.setFill(Color.WHITE);
                go.setFill(Color.WHITE);}),
        new KeyFrame(Duration.millis(3000),e ->{          // After 3 seconds it will be wait view
                stop.setFill(Color.WHITE);
                wait.setFill(Color.YELLOW);
                go.setFill(Color.WHITE);}),
        new KeyFrame(Duration.millis(4000),e ->{          // After another second it will be go view
                stop.setFill(Color.WHITE);
                wait.setFill(Color.WHITE);
                go.setFill(Color.LAWNGREEN);}),
        new KeyFrame(Duration.millis(8000),e ->{          // After another 4 seconds it will return to stop view
        }));
        simulation.setCycleCount(Timeline.INDEFINITE);    // To repeat the animation while the program is running
        simulation.play();                                // Play animation
        Scene scene = new Scene(pane, 290, 505);          // Creating scene
        primaryStage.setResizable(false);                 // To make the stage unresizable
        primaryStage.setTitle("Traffic Light");           // Window title
        primaryStage.setScene(scene);                     // Adding scene
        primaryStage.show();                              // Showing window
    }
    public static void main(String[] args) {
        launch(args);
    }}