package src.application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MyEventHandlerExample extends Application {

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
		
		this.root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Event Filter"); //Executes first after event
				event.consume(); // Consumes event, event handler never sees it
			}
		});
		
		root.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Event handler"); // Executes after eventFilter
			}
		});
		
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
