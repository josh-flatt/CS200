/**
 * 
 */
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import advisingQueue.*;

/**
 * @author joshm
 *
 */
public class MainMenuController {
	
	private AdvisorQueue advQA;
	private AdvisorQueue advQB;
	private AdvisorQueue advQC;
	private AdvisorQueue advQD;
	
	ObservableList<String> advisorList = FXCollections
			.observableArrayList("A", "B", "C", "D");
	
	//Student Page
	@FXML
	private Button studentSubmitButton;
	@FXML
	private TextField studentFirstName;
	@FXML
	private TextField studentLastName;
	@FXML
	private TextField studentEmail;
	@FXML
	private ComboBox<String> studentAdvisorSelection;
	@FXML
	protected void onStudentSubmitButtonClicked(ActionEvent event) {
		String firstName = this.studentFirstName.getText();
		String lastName = this.studentLastName.getText();
		String email = this.studentEmail.getText();
		
		Student student1 = new Student(firstName, lastName, email);
		studentEmail.setText(student1.getFullName());
	}
	
	
	
	
	//Advisor CJ
	@FXML
	private Button advCJStartMeetingButton;
	@FXML
	private Button advCJEndMeetingButton;
	@FXML
	private Button advCJRefreshButton;
	@FXML
	private Label advCJQueueCtLabel;
	@FXML
	protected void onAdvCJRefreshButtonClicked(ActionEvent event) {
		
	}
	@FXML
	protected void onAdvCJStartMeetingButtonClicked(ActionEvent event) {
		
	}
	@FXML
	protected void onAdvCJEndMeetingButtonClicked(ActionEvent event) {
		
	}
	
	
	@FXML
	public void initialize() {
		studentAdvisorSelection.setItems(advisorList);
	}
	
	
	
}