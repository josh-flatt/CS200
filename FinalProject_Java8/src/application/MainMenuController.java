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
	
	private AdvisorQueueSystem advisingQueueSystem = new AdvisorQueueSystem();;
	private AdvisorQueue cjAQ = advisingQueueSystem
					.CreateAdvisorQueueA(new Advisor("CJ", "Cron", "firstBaseman@rockies.com"));
	private AdvisorQueue brendanAQ = advisingQueueSystem
					.CreateAdvisorQueueB(new Advisor("Brendan", "Rodgers", "secondBaseman@rockies.com"));
	private AdvisorQueue alanAQ = advisingQueueSystem
			.CreateAdvisorQueueC(new Advisor("Alan", "Trejo", "shortstop@rockies.com"));
	private AdvisorQueue ryanAQ = advisingQueueSystem
			.CreateAdvisorQueueD(new Advisor("Ryan", "McMahon", "thirdBaseman@rockies.com"));
	
	ObservableList<String> advisorList = FXCollections
			.observableArrayList("CJ", "Brendan", "Alan", "Ryan");
	
	// Initialize
	@FXML
	public void initialize() {
		System.out.println("Initializing!!!");
		studentAdvisorSelection.setItems(advisorList);
	}
	
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
		String advisor = this.studentAdvisorSelection.getValue();
		
		Student student = new Student(firstName, lastName, email);
		if (advisor.equals("CJ")) {
			cjAQ.addStudent(student);
		}
		if (advisor.equals("Brendan")) {
			brendanAQ.addStudent(student);	
		}
		if (advisor.equals("Alan")) {
			alanAQ.addStudent(student);
		}
		if (advisor.equals("Ryan")) {
			ryanAQ.addStudent(student);
		}
		else {
			System.out.println("No advisor selected!!!");
		}
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
		advCJQueueCtLabel.setText("Students in queue: " + cjAQ.getQueueCount());
	}
	@FXML
	protected void onAdvCJStartMeetingButtonClicked(ActionEvent event) {
		System.out.println("Starting meeting...");
		cjAQ.startMeeting();
	}
	@FXML
	protected void onAdvCJEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		cjAQ.endMeeting();
	}

	//Advisor Brendan
	@FXML
	private Button advBrendanStartMeetingButton;
	@FXML
	private Button advBrendanEndMeetingButton;
	@FXML
	private Button advBrendanRefreshButton;
	@FXML
	private Label advBrendanQueueCtLabel;
	@FXML
	protected void onAdvBrendanRefreshButtonClicked(ActionEvent event) {
		advBrendanQueueCtLabel.setText("Students in queue: " + brendanAQ.getQueueCount());
	}
	@FXML
	protected void onAdvBrendanStartMeetingButtonClicked(ActionEvent event) {
		System.out.println("Starting meeting...");
		brendanAQ.startMeeting();
	}
	@FXML
	protected void onAdvBrendanEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		brendanAQ.endMeeting();
	}
	
	//Advisor Alan
	@FXML
	private Button advAlanStartMeetingButton;
	@FXML
	private Button advAlanEndMeetingButton;
	@FXML
	private Button advAlanRefreshButton;
	@FXML
	private Label advAlanQueueCtLabel;
	@FXML
	protected void onAdvAlanRefreshButtonClicked(ActionEvent event) {
		advAlanQueueCtLabel.setText("Students in queue: " + alanAQ.getQueueCount());
	}
	@FXML
	protected void onAdvAlanStartMeetingButtonClicked(ActionEvent event) {
		System.out.println("Starting meeting...");
		alanAQ.startMeeting();
	}
	@FXML
	protected void onAdvAlanEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		alanAQ.endMeeting();
	}
	
	//Advisor Ryan
	@FXML
	private Button advRyanStartMeetingButton;
	@FXML
	private Button advRyanEndMeetingButton;
	@FXML
	private Button advRyanRefreshButton;
	@FXML
	private Label advRyanQueueCtLabel;
	@FXML
	protected void onAdvRyanRefreshButtonClicked(ActionEvent event) {
		advRyanQueueCtLabel.setText("Students in queue: " + ryanAQ.getQueueCount());
	}
	@FXML
	protected void onAdvRyanStartMeetingButtonClicked(ActionEvent event) {
		System.out.println("Starting meeting...");
		ryanAQ.startMeeting();
	}
	@FXML
	protected void onAdvRyanEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		ryanAQ.endMeeting();
	}
}