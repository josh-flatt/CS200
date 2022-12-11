package advisingQueue;
import java.util.ArrayList;

/**
 * @author Josh Flatt
 * CS 200 Final Project
 * 10 December 2022
 */
public class AdvisorQueueSystem {
	
	private ExportToCSV exportSystem;
	private ArrayList<Student> students;
	private ArrayList<Meeting> meetings;
	private AdvisorQueue advisorQueueA = null;
	private AdvisorQueue advisorQueueB = null;
	private AdvisorQueue advisorQueueC = null;
	private AdvisorQueue advisorQueueD = null;
	
	// Constructors
	public AdvisorQueueSystem() {
		this.students = new ArrayList<>();
		this.meetings = new ArrayList<>();
		this.exportSystem = new ExportToCSV(this.meetings);
	}
	public AdvisorQueueSystem(ArrayList<Student> students) {
		this.students = students;
		this.meetings = new ArrayList<>();
		this.exportSystem = new ExportToCSV(this.meetings);
	}

	// Getters
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	public ArrayList<Meeting> getMeetings() {
		return this.meetings;
	}
	
	// Setters (None)
	
	// Advisor Queues
	public AdvisorQueue CreateAdvisorQueueA(Advisor advisor) {
		this.advisorQueueA = new AdvisorQueue(students, meetings, advisor);
		return this.advisorQueueA;
	}
	public AdvisorQueue CreateAdvisorQueueB(Advisor advisor) {
		this.advisorQueueB = new AdvisorQueue(students, meetings, advisor);
		return this.advisorQueueB;
	}
	public AdvisorQueue CreateAdvisorQueueC(Advisor advisor) {
		this.advisorQueueC = new AdvisorQueue(students, meetings, advisor);
		return this.advisorQueueC;
	}
	public AdvisorQueue CreateAdvisorQueueD(Advisor advisor) {
		this.advisorQueueD = new AdvisorQueue(students, meetings, advisor);
		return this.advisorQueueD;
	}

	// Export Data
	public void exportMeetings() {
		exportSystem.descendSortByDuration();
//		exportSystem.ascendSortByStartTimeDate();
		exportSystem.exportMeetings();
	}
	public void exportStudents() {
		
	}
}
