package eclipseHW2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CS200 Programming Assignment 3
 *
 * @author Josh Flatt
 * @version 11/06/2022
 */


public class Program {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] inputPrompts = new String[] {"Enter the length: ","Enter the width: ",
											  "Enter the height: ", "Enter the weight: "};
		ArrayList<Double> dimensions = new ArrayList<Double>();
		double weight;
		
		for (int i = 0; i < 4;) {
			try {
				System.out.print(inputPrompts[i]);
				double input = scnr.nextDouble();
				if (!(input > 0)) { throw new Exception(); }
				if (i != 4) { dimensions.add(input); }
				else { weight = input; }
				i++;
			}
			catch (Exception e) {
				System.out.println("Invalid entry.  Only positive values > 0 allowed. Please re-enter.");
				scnr.nextLine(); //Clears scanner
			}
		}
		
		
		
		
		
		
		
		scnr.close();
		
		
		System.out.printf("The volume of the box is %.2f cubic feet.\n", -1.0);
		System.out.printf("The density of the box is %.2f lbs./cubic ft.\n", -1.0);

	}

}
