package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	public Button testButton;
	
	@Override
	public void start(Stage primaryStage) {
		testButton = new Button("Test Button");
		TabPane tabPane = new TabPane();
		Tab tab1 = new Tab("Planes", new Label("No clue what I am doing"));
		Tab tab2 = new Tab("Cars"  , new Label("Show all cars available"));
		Tab tab3 = new Tab("Boats" , new Label("Show all boats available"));

		tabPane.getTabs().add(tab1);
		tabPane.getTabs().add(tab2);
		tabPane.getTabs().add(tab3);
		
		VBox vbox = new VBox(tabPane);
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(vbox,800,800);
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
