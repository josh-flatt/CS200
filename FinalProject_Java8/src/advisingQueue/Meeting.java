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
	private Student student;
	private Advisor advisor;
	private Boolean isActive;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private ArrayList<String> notes;
	
	public Meeting(Student student, Advisor advisor) {
		this.student = student;
		this.advisor = advisor;
		this.isActive = true;
		this.notes = new ArrayList<>();
		this.startDateTime = LocalDateTime.now();
	}
	
	// Setters
	public void addNote(String note) {
		this.notes.add(note);
	}
	
	// Getters
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
//		if (!isActive) { return this.endDateTime; }
		return null;
	}
	public Duration getDuration() {
		if (isActive) { return null; }
		return Duration.between(startDateTime, endDateTime);
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
