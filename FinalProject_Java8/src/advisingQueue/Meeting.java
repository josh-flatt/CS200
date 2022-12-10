/**
 * 
 */
package advisingQueue;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;

/**
 * @author joshm
 *
 */
public class Meeting {
	
	static Integer meetingcount = 0;
	
	private Integer ID;
	private Student student;
	private Advisor advisor;
	private Boolean isActive;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private ArrayList<String> notes;
	
	private String tableStudentFullName;
	private String tableStudentEmail;
	private String tableAdvisorFirstName;
	private String tableDuration;
	
	public Meeting(Student student, Advisor advisor) {
		meetingcount++;
		this.ID = meetingcount;
		this.student = student;
		this.tableStudentFullName = student.getFullName();
		this.tableStudentEmail = student.getEmail();
		this.advisor = advisor;
		this.tableAdvisorFirstName = advisor.getFirstName();
		this.isActive = true;
		this.notes = new ArrayList<>();
		this.startDateTime = LocalDateTime.now();
	}
	
	// Setters
	public void addNote(String note) {
		this.notes.add(note);
	}
	
	// Getters
	public Integer getID() {
		return this.ID;
	}
	public Student getStudent() {
		return this.student;
	}
	public Advisor getAdvisor() {
		return this.advisor;
	}
	public ArrayList<String> getNotes() {
		return this.notes;
	}
	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}
	public LocalDateTime getEndDateTime() {
		return this.endDateTime;
	}
	public Duration getDuration() {
		if (isActive) { return Duration.between(startDateTime, LocalDateTime.now()); }
		return Duration.between(startDateTime, endDateTime);
	}
	public String getTableStudentFullName() {
		return this.tableStudentFullName;
	}
	public String getTableStudentEmail() {
		return this.tableStudentEmail;
	}
	public String getTableAdvisorFirstName() {
		return this.tableAdvisorFirstName;
	}
	public String getTableDuration() {
		long minutes = this.getDuration().toMinutes();
		long seconds = this.getDuration().getSeconds() % 60;
		this.tableDuration = minutes +"m "+ seconds +"s";
		return this.tableDuration;
	}

	// End meeting
	public boolean endMeeting() {
		try {
			this.isActive = false;
			this.endDateTime = LocalDateTime.now();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
