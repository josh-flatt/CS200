import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HistogramViewerFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      Pane pane = new Pane();                    // Create an empty pane    
      Scene scene = new Scene(pane);             // Create a scene containing the pane
      Canvas canvas = new Canvas(400, 200);      // Create a canvas in which to draw
      
      // Get the canvas' graphics context to draw
      GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
            
      // Draw 1st bin as an olive colored rectangle at (10,10)
      // with width = 200 and height = 50
      Color binColor1 = Color.rgb(128, 128, 0);
      graphicsContext.setFill(binColor1);
      graphicsContext.fillRect(10, 10, 200, 50);
      
      // Draw 2nd bin as a teal blue rectangle at (10,75)
      // with width = 150 and height = 50      
      Color binColor2 = Color.rgb(0, 200, 200);
      graphicsContext.setFill(binColor2);
      graphicsContext.fillRect(10, 75, 150, 50);
      
      // Draw 3rd bin as a gray rectangle at (10,140)
      // with width = 350 and height = 50 
      Color binColor3 = Color.rgb(100, 100, 100);
      graphicsContext.setFill(binColor3);
      graphicsContext.fillRect(10, 140, 350, 50);
      
      pane.getChildren().add(canvas);                // Add canvas to pane 
      applicationStage.setTitle("Histogram viewer"); // Set window's title
      applicationStage.setScene(scene);              // Set window's scene
      applicationStage.show();                       // Display window
   }
   
   public static void main(String [] args) {
       launch(args); // Launch application
   }
}
