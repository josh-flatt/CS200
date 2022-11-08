/**
 * CS200 Programming Assignment 3
 *
 * @author Josh Flatt
 * @version 11/06/2022
 */

public class Box implements Shape {

	//Fields - All measured in feet
	private double length;
	private double height;
	private double width;
	private double weight; // pounds
	boolean divZeroExcept = false; // enables inhibition of error displayed multiple times per class instance
	
	//Constructors
	public Box(double length, double width, double height, double weight) {
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
		System.out.println("A Box of length " + this.length + ", width " 
				+ this.width + ", height " + this.height + ", and weight " + this.weight + " lb. created.");
	}
	
	
	//Setters
	public void setLength(double length) {
		this.length = length;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	//Getters
	public double getLength() {
		return this.length;
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	public double getWeight() {
		return this.weight;
	}
	
	
	//Methods
	public double calculateVolume() {
		return (getLength() * getWidth() * getHeight());
	}
	
	public double calculateDensity() {
		double density = 0.0;
		try {
			if (calculateVolume() == 0.0) { throw new Exception("Division by zero attempted."); }
			density = getWeight() / calculateVolume(); //Since doubles are floating-point nums, dividing by 0 will not raise an error
		} catch (Exception e) { 
			if (!divZeroExcept) {System.out.println(e.getMessage()); } //Prints only if first time occurring within instance
			divZeroExcept = true;
		}
		return density;
	}
	
	public double calculateBestFit() {
		return (getLength() * getWidth() * getHeight());
	}
	
	public double calculateWaste() {
		double containerVolume = calculateBestFit(); // Added for efficiency; redundant calls of calculateBestFit() without.
		double volume = calculateVolume();			 // Added for efficiency
		double cubicWaste = containerVolume - volume;
		double percentWaste = cubicWaste / containerVolume;
		return percentWaste;
	}
}
