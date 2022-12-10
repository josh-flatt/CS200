/**
 * 
 */
package advisingQueue;
import java.util.ArrayList;

/**
 * @author joshm
 *
 */
public class AdvisorQueueSystem {
	
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
	}
	public AdvisorQueueSystem(ArrayList<Student> students) {
		this.students = students;
		this.meetings = new ArrayList<>();
	}

	// Getters
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	public ArrayList<Meeting> getMeetings() {
		return this.meetings;
	}
	
	// Setters - Handled elsewhere
	
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

	public void exportData(String exportType) {
		
	}
}
