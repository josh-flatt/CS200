package advisingQueue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Josh Flatt
 * CS 200 Final Project
 * 10 December 2022
 */
public class AdvisorQueue {

	private Queue<Student> studentQueue;
	private Advisor advisor;
	private Meeting currentMeeting;
	private ArrayList<Meeting> meetings; // Contains ALL meetings between AdvisorQueues
	private ArrayList<Student> students; // Contains ALL students between AdvisorQueues
	
	// Constructors
	public AdvisorQueue(ArrayList<Student> students, ArrayList<Meeting> meetings, Advisor advisor) {
		this.advisor = advisor;
		this.students = students;
		this.studentQueue = new LinkedList<>();
		this.currentMeeting = null;
		this.meetings = meetings;
	}
	
	// Queue actions
	public void addStudent(Student student) {
		studentQueue.add(student);
		students.add(student);

	}
	public void removeStudent(Student student) {
		studentQueue.remove(student);
	}
	public Student peekNextStudent() {
		return studentQueue.peek();
	}
	public Integer getQueueCount() {
		return studentQueue.size();
	}
	
	// Meeting actions
	public String startMeeting() {
		try {
			Student student = studentQueue.peek();
			if (student == null) {
				return "No_students_in_queue";
			}
			if (this.currentMeeting != null) {
				return "Meeting_in_progress";
			}
			this.currentMeeting = new Meeting(student, this.advisor);
			this.meetings.add(this.currentMeeting);
			studentQueue.poll();
			return "Success";
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "Unexpected_error";
		}
	}
	public Meeting getCurrentMeeting() {
		return this.currentMeeting;
	}
	public String endMeeting() {
		if (this.currentMeeting == null) {
			return "No_current_meeting";
		}
		boolean success = currentMeeting.endMeeting();
		if (success) {
			this.currentMeeting = null;
			return "Success";
		}
		return "Unexpected_error";
	}
	
}
