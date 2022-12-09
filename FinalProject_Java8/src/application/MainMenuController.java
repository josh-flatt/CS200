/**
 * 
 */
package application;

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
	
	@FXML
	private Button button;
	
	@FXML
	private TextField studentFirstName;
	
	@FXML
	private TextField studentLastName;
	
	@FXML
	private TextField studentEmail;
	
	@FXML
	private ComboBox<String> studentAdvisorSelection;
	
	@FXML
	public void initialize() {
		studentAdvisorSelection = new ComboBox<String>();
		studentAdvisorSelection.getItems().addAll(
            "A",
            "B",
            "C",
            "D"
        );   

		studentAdvisorSelection.setValue("B");
	}
	
	@FXML
	protected void onStudentSubmitButtonClicked(ActionEvent event) {
		String firstName = this.studentFirstName.getText();
		String lastName = this.studentLastName.getText();
		String email = this.studentEmail.getText();
		
		Student student1 = new Student(firstName, lastName, email);
		studentEmail.setText(student1.getFullName());
	}
	
}