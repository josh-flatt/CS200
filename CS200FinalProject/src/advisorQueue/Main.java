package src.advisorQueue;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Student adamSandler = new Student("Adam", "Sandler", "AdamSandler@gmail.com");
		Student barackObama = new Student("Barack", "Obama", "BarackObama@gmail.com");
		Student joeBiden = new Student("Joe", "Biden", "JoeBiden@gmail.com");
		Advisor georgeWashington = new Advisor("George", "Washington", "Georgewash@gmail.com");
		Advisor thomasJefferson = new Advisor("Thomas", "Jefferson", "TJdaman@gmail.com");
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(adamSandler);
		students.add(barackObama);
		students.add(joeBiden);
		
		ArrayList<Advisor> advisors = new ArrayList<>();
		advisors.add(georgeWashington);
		advisors.add(thomasJefferson);
		
		AdvisingQueueSystem advisingQueueSystem = new AdvisingQueueSystem(students, advisors);
		
		System.out.println("We got this far with no crashing :)");

	}

}
