package src.application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class MyGridPaneExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			GridPane grid = new GridPane();
//			grid.setGridLinesVisible(true);
			
			// Create JavaFX Controls (nodes) to add to the GridPane
			Label lblFirstName = new Label("First Name");
			Label lblLastName = new Label("Last Name");
			TextField txtFirstName = new TextField();
			TextField txtLastName = new TextField();
			Button btnSave = new Button("Save");
			Button btnCancel = new Button("Cancel");
			ButtonBar btnBar = new ButtonBar();
			btnBar.getButtons().addAll(btnSave, btnCancel);
			
			grid.add(lblFirstName, 0, 0, 1, 1);
			grid.add(txtFirstName, 1, 0, 1, 1);
			grid.add(lblLastName, 0, 1, 1, 1);
			grid.add(txtLastName, 1, 1, 1, 1);
			grid.add(btnBar, 0, 2, 2, 1);
			
			
			//Set Column and Row Gap
			grid.setHgap(10);
			grid.setVgap(5);
			grid.setPadding(new Insets(10, 10, 10, 10));
			
			//Column Constraints
			ColumnConstraints column1 = new ColumnConstraints();
			ColumnConstraints column2 = new ColumnConstraints();
			ColumnConstraints column3 = new ColumnConstraints();
			
			grid.getColumnConstraints().add(column1);
			grid.getColumnConstraints().add(column2);
			grid.getColumnConstraints().add(column3);
			
			column1.setPrefWidth(100);
			column2.setPrefWidth(200);
			column3.setPrefWidth(100);
			
			column1.setPercentWidth(25);
			column2.setPercentWidth(50);
			column3.setPercentWidth(25);
			
			// Horizontal alignment
			GridPane.setHalignment(lblFirstName, HPos.RIGHT);
			GridPane.setHalignment(lblLastName, HPos.RIGHT);
			GridPane.setHalignment(btnBar, HPos.CENTER);
			
			//Horizontal Grow Priority
			GridPane.setHgrow(txtFirstName, Priority.ALWAYS);
			GridPane.setHgrow(txtLastName, Priority.ALWAYS);
			GridPane.setHgrow(btnBar, Priority.ALWAYS);
			
			root.setCenter(grid);
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Gridpane example title");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
