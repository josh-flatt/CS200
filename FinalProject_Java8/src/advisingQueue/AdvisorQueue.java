/**
 * 
 */
package advisingQueue;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author joshm
 *
 */
public class AdvisorQueue {

	private Queue<Student> studentQueue;
	private Advisor advisor;
	private Meeting currentMeeting;
	private ArrayList<Meeting> meetings;
	private ArrayList<Student> students;
	
	public AdvisorQueue(ArrayList<Student> students, ArrayList<Meeting> meetings, Advisor advisor) {
		this.advisor = advisor;
		this.students = students;
		this.studentQueue = new LinkedList<>();
		this.currentMeeting = null;
		this.meetings = meetings;
	}
	
	// Queue actions
	public void addStudent(Student student) {
		System.out.println("Student added");
		System.out.println("To queue: "+studentQueue.add(student));
		System.out.println("To students: "+students.add(student));
		System.out.println("Queue count size: "+ studentQueue.size());
		System.out.println("Queue: "+ studentQueue);
	}
	public void removeStudent(Student student) {
		studentQueue.remove(student);
	}
	public Student peekNextStudent() {
		return studentQueue.peek();
	}
	public int getQueueCount() {
		System.out.println("Queue: "+ studentQueue);
		System.out.println("Queue count size: "+ studentQueue.size());
		return studentQueue.size();
	}
	
	// Meeting actions
	public boolean startMeeting() {
		try {
			Student student = studentQueue.peek();
			if (student == null) {
				throw new Exception("There are no students in the Queue!");
			}
			if (this.currentMeeting != null) {
				throw new Exception("There is already a meeting in progress!");
			}
			this.currentMeeting = new Meeting(student, this.advisor);
			studentQueue.poll();
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean endMeeting() {
		Meeting meeting = currentMeeting;
		boolean success = meeting.endMeeting();
		if (success) {
			this.currentMeeting = null;
			meetings.add(meeting);
			return true;
		}
		return false;
	}
}
