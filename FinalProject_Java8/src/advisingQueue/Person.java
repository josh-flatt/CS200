/**
 * 
 */
package src.advisingQueue;

/**
 * @author joshm
 *
 */
public abstract class Person {

	private String firstName;
	private String lastName;
	private String email;
	
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Getters
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public String getEmail() {
		return this.email;
	}
	
}
