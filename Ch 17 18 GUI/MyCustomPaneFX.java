import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyCustomPaneFX extends Application {
   private Label wageLabel;     // Label for hourly salary
   private Label salLabel;      // Label for yearly salary
   private TextField salField;  // Displays hourly salary 
   private TextField wageField; // Displays yearly salary
   private Button calcButton;   // Triggers salary calculation
   
   @Override
   public void start(Stage applicationStage) {
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      
      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane); // Create scene containing the grid pane
      
      // Set hourly and yearly salary
      wageLabel = new Label("Hourly wage:");
      salLabel = new Label("Yearly salary:");
      
      wageField = new TextField(); 
      wageField.setPrefColumnCount(15);
      wageField.setEditable(true);
      wageField.setText("0");
      
      salField = new TextField(); 
      salField.setPrefColumnCount(15);
      salField.setEditable(false);
      
      // Create a "Calculate" button
      calcButton = new Button("Calculate");
      
      gridPane.setPadding(new Insets(10, 10, 10, 10)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
      gridPane.setVgap(10);                            // Spacing between rows
      
      gridPane.add(wageLabel, 0, 0);  // Add wage label to location (0, 0)
      gridPane.add(wageField, 1, 0);  // Add wage text field to location (1, 0)
      gridPane.add(salLabel, 0, 1);   // Add salary label to location (0, 1)
      gridPane.add(salField, 1, 1);   // Add salary text field to location (1, 1)
      gridPane.add(calcButton, 0, 2); // Add calculate button to location (0, 2)
      
      // Set an event handler to handle button presses
      calcButton.setOnAction(new EventHandler<ActionEvent>() {
         /* Method is automatically called when an event 
            occurs (e.g, button is pressed) */
         @Override
         public void handle(ActionEvent event) {
            String userInput; 
            int hourlyWage;    
            int yearlySalary;    

            // Get user's wage input and calculate yearly salary
            userInput = wageField.getText();            
            hourlyWage = Integer.parseInt(userInput);
            yearlySalary = hourlyWage * 40 * 50;

            if (hourlyWage >= 0) {
               // Display calculated salary
               salField.setText(Integer.toString(yearlySalary));
            }
            else {
               // Display an alert dialog 
               Alert alert = new Alert(AlertType.ERROR, 
                                       "Enter a positive hourly wage value.");
               alert.showAndWait();
            }
         } 
      });
      
      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
