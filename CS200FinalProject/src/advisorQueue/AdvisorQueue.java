/**
 * 
 */
package advisorQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author joshm
 *
 */
public class AdvisorQueue {

	private Queue<Student> studentQueue;
	private Advisor advisor;
	private Student currentlyBeingMetWith;
	private Student upNext; //THIS SHOULD ALWAYS EQUAL LAST ELEMENT IN QUEUE
	
	public AdvisorQueue(Advisor advisor) {
		this.advisor = advisor;
		this.studentQueue = new LinkedList<>();
	}
	
	// Add students
	public void addStudent(Student student) {
		// Add student to queue
		// if queue size BEFORE ADDITION == 0
		//  ---> set added student to currentlyBeingMetWith
		// if queue size BEFORE ADDITION == 1
		//  ---> set added student to upNext
	}
	
	// Remove students
	public void removeStudent() {
		// Remove student from currentlyBeingMetWith
		// Set student from upNext ---> currentlyBeingMetWith
		// Pull student from queue ---> upNext
		// RETURN THE NEW STUDENT IN CURRENTLYBEINGMETWITH?
		
	}
	
	// Stats
	// Up next
	// Export
}
