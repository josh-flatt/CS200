/**
 * 
 */
package src.advisingQueue;
import java.util.ArrayList;

/**
 * @author joshm
 *
 */
public class AdvisingQueueSystem {
	
	private ArrayList<Student> students;
	private ArrayList<Advisor> advisors;
	private ArrayList<Meeting> meetings;
	public AdvisorQueue advisorQueueA = null;
	public AdvisorQueue advisorQueueB = null;
	public AdvisorQueue advisorQueueC = null;
	public AdvisorQueue advisorQueueD = null;
	
	// Constructors
	public AdvisingQueueSystem() {
		this.students = new ArrayList<>();
		this.advisors = new ArrayList<>();
		this.meetings = new ArrayList<>();
	}
	public AdvisingQueueSystem(ArrayList<Student> students, ArrayList<Advisor> advisors) {
		this.students = students;
		this.advisors = advisors;
		this.meetings = new ArrayList<>();
	}

	// Getters
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	public ArrayList<Advisor> getAdvisors() {
		return this.advisors;
	}
	public ArrayList<Meeting> getMeetings() {
		return this.meetings;
	}
	
	// Setters
	public void addStudents(Student student) {
		this.students.add(student);
	}
	public void addAdvisors(Advisor advisor) {
		this.advisors.add(advisor);
	}
	
	// Advisor Queues
	public void CreateAdvisorQueueA() {
		this.advisorQueueA = new AdvisorQueue(meetings, advisors.get(0));
	}
	public void CreateAdvisorQueueB() {
		this.advisorQueueB = new AdvisorQueue(meetings, advisors.get(1));
	}
	public void CreateAdvisorQueueC() {
		this.advisorQueueC = new AdvisorQueue(meetings, advisors.get(2));
	}
	public void CreateAdvisorQueueD() {
		this.advisorQueueD = new AdvisorQueue(meetings, advisors.get(3));
	}
}
