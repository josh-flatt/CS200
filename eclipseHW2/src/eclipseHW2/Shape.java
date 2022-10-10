package eclipseHW2;

/**
 * CS200 Programming Assignment 2
 *
 * @author Josh Flatt
 * @version 10/09/2022
 */

public abstract class Shape {

	//Fields - measured in pounds
	private double weight;
	
	//Constructors
	public Shape() {
		this.weight = 0.0;
	}
	public Shape(double weight) {
		this.weight = weight;
	}
	
	//Setters
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//Getters
	public double getWeight() {
		return this.weight;
	}
	
}
