/**
 * 
 */
package advisingQueue;


/**
 * @author joshm
 *
 */
public class Student extends Person{

	private String major;
	
	public Student(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		this.major = "";
	}
	public Student(String firstName, String lastName, String email, String major) {
		super(firstName, lastName, email);
		this.major = major;
	}
	
	
	// Setters
	public void SetMajor(String major) {
		this.major = major;
	}
	
	// Getters
	public String GetMajor() {
		return this.major;
	}
}
