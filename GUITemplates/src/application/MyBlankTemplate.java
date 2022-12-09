package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class MyBlankTemplate extends Application {

	private Stage stage;
	private Scene scene;
	private BorderPane root;
	private Button button;
	private Label label;
	
	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.setTitle("Event Explorer");
		this.root = new BorderPane();
		this.scene = new Scene(root, 700, 500);
		this.button = new Button("Click me");
		
		this.button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				label.setText("Button Clicked");
			}
		});
		
		this.label = new Label();
		this.root.setCenter(button);
		this.root.setBottom(label);
		this.stage.setScene(scene);
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
