package eclipseHW2;

/**
 * CS200 Programming Assignment 3
 *
 * @author Josh Flatt
 * @version 11/06/2022
 */


public class Cylinder implements Shape {
	
	//Fields - All measured in feet
	private double height;
	private double diameter;
	private double weight; // pounds
	boolean divZeroExcept = false; // enables inhibition of error displayed multiple times per class instance
	
	//Constructors
	public Cylinder(double height, double diameter, double weight) {
		this.weight = weight;
		this.diameter = diameter;
		this.height = height;
	}
	
	//Setters
	public void setHeight(double height) {
		this.height = height;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//Getters
	public double getHeight() {
		return this.height;
	}
	public double getDiameter() {
		return this.diameter;
	}
	public double getWeight() {
		return this.weight;
	}
	
	//Methods
	public double calculateVolume() {
		double pi = Math.PI;
		double radius = this.diameter / 2.0;
		double volume = pi * (radius * radius) * this.height;
		return volume;
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
		return (getDiameter() * getDiameter() * getHeight());
	}
	
	public double calculateWaste() {
		double containerVolume = calculateBestFit(); // Added for efficiency; redundant calls of calculateBestFit() without.
		double packageVolume = calculateVolume();    // Added for efficiency; redundant calls of calculateVolume() without.
		double cubicWaste = containerVolume - packageVolume;
		double percentWaste = cubicWaste / packageVolume;
		return percentWaste;
	}

}
