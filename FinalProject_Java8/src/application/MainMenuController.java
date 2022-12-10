/**
 * 
 */
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		try {
			boolean validAdvisor = false;
			String firstName = this.studentFirstName.getText();
			String lastName = this.studentLastName.getText();
			String email = this.studentEmail.getText();
			String advisor = this.studentAdvisorSelection.getValue();
			
			Student student = new Student(firstName, lastName, email);
			if (advisor.equals("CJ")) {
				cjAQ.addStudent(student);
				validAdvisor = true;
			}
			if (advisor.equals("Brendan")) {
				brendanAQ.addStudent(student);	
				validAdvisor = true;
			}
			if (advisor.equals("Alan")) {
				alanAQ.addStudent(student);
				validAdvisor = true;
			}
			if (advisor.equals("Ryan")) {
				ryanAQ.addStudent(student);
				validAdvisor = true;
			}
			else if (!validAdvisor) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setContentText("Please select one of the advisors.");
			alert.showAndWait();
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
		advCJQueueCtLabel.setText("Students in Queue: " + cjAQ.getQueueCount());
	}
	@FXML
	protected void onAdvCJStartMeetingButtonClicked(ActionEvent event) {
		System.out.println("Starting meeting...");
		String meetingMessage = cjAQ.startMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_students_in_queue")) {
			alert.setTitle("Notification");
			alert.setContentText("There are no students in the queue.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Meeting_in_progress")) {
			alert.setTitle("Notification");
			alert.setContentText("There is a meeting already in progress.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting started.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
	}
	@FXML
	protected void onAdvCJEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		String meetingMessage = cjAQ.endMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_current_meeting")) {
			alert.setTitle("Notification");
			alert.setContentText("There is no active meeting to end.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting ended.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
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
		advBrendanQueueCtLabel.setText("Students in Queue: " + brendanAQ.getQueueCount());
	}
	@FXML
	protected void onAdvBrendanStartMeetingButtonClicked(ActionEvent event) {
		String meetingMessage = brendanAQ.startMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_students_in_queue")) {
			alert.setTitle("Notification");
			alert.setContentText("There are no students in the queue.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Meeting_in_progress")) {
			alert.setTitle("Notification");
			alert.setContentText("There is a meeting already in progress.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting started");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
	}
	@FXML
	protected void onAdvBrendanEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		String meetingMessage = brendanAQ.endMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_current_meeting")) {
			alert.setTitle("Notification");
			alert.setContentText("There is no active meeting to end.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting ended.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
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
		advAlanQueueCtLabel.setText("Students in Queue: " + alanAQ.getQueueCount());
	}
	@FXML
	protected void onAdvAlanStartMeetingButtonClicked(ActionEvent event) {
		String meetingMessage = alanAQ.startMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_students_in_queue")) {
			alert.setTitle("Notification");
			alert.setContentText("There are no students in the queue.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Meeting_in_progress")) {
			alert.setTitle("Notification");
			alert.setContentText("There is a meeting already in progress.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting started");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
	}
	@FXML
	protected void onAdvAlanEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		String meetingMessage = alanAQ.endMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_current_meeting")) {
			alert.setTitle("Notification");
			alert.setContentText("There is no active meeting to end.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting ended.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
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
		advRyanQueueCtLabel.setText("Students in Queue: " + ryanAQ.getQueueCount());
	}
	@FXML
	protected void onAdvRyanStartMeetingButtonClicked(ActionEvent event) {
		String meetingMessage = ryanAQ.startMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_students_in_queue")) {
			alert.setTitle("Notification");
			alert.setContentText("There are no students in the queue.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Meeting_in_progress")) {
			alert.setTitle("Notification");
			alert.setContentText("There is a meeting already in progress.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting started");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
	}
	@FXML
	protected void onAdvRyanEndMeetingButtonClicked(ActionEvent event) {
		System.out.println("Meeting ending...");
		String meetingMessage = ryanAQ.endMeeting();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (meetingMessage.equals("No_current_meeting")) {
			alert.setTitle("Notification");
			alert.setContentText("There is no active meeting to end.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Success")) {
			alert.setTitle("Notification");
			alert.setContentText("Meeting ended.");
			alert.showAndWait();
		}
		if (meetingMessage.equals("Unexpected_error")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unexpected error :(");
			alert.showAndWait();
		}
	}
}