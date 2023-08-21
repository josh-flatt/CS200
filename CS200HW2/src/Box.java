import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CS 200 Programming Assignment 2
 *
 * @author Josh Flatt
 * @version 10/09/2022
 */

public class Box extends Shape {

    //Fields - doubles are measured in feet
    private double length;
    private double height;
    private double width;
    boolean divZeroExcept = false; // enables inhibition of error displayed multiple times per class instance

    //Constructors
    public Box() {
        super(); //sets weight as 0.0
        this.length = 0.0;
        this.height = 0.0;
        this.width = 0.0;
    }
    public Box(double length, double width, double height, double weight) {
        super(weight);
        this.length = length;
        this.width = width;
        this.height = height;
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

    //Methods
    public boolean isACube() {
        if (length != width) { return false; }
        if (length != height) { return false; }
        return true;
    }
    public boolean hasASquare() {
        if (length == width) { return true; }
        if (length == height) { return true; }
        if (width == height) { return true; }
        return false;
    }
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
    public boolean isHeavy() {
        if (calculateDensity() >= 10.0) { return true; }
        return false;
    }
    public boolean isLightweight() {
        if (calculateDensity() <= 0.10) { return true; }
        return false;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Box box = new Box();
        boolean inputsComplete = false;
        while (!inputsComplete) {
            try {
                System.out.print("Enter the length in feet: ");
                box.setLength(scnr.nextDouble());
                System.out.print("Enter the width in feet: ");
                box.setWidth(scnr.nextDouble());
                System.out.print("Enter the height in feet: ");
                box.setHeight(scnr.nextDouble());
                System.out.print("Enter the weight in pounds: ");
                box.setWeight(scnr.nextDouble());

                inputsComplete = true;
            }
            catch (InputMismatchException e) {
                System.out.println("\nPlese enter double values only.");
                scnr.nextLine(); //Clears scanner
            }
        }
        scnr.close();

        double volume = box.calculateVolume();
        double density = box.calculateDensity();
        System.out.printf("The volume of the box is %.2f cubic feet.\n", volume);
        System.out.printf("The density of the box is %.2f lbs./cubic ft.\n", density);

        if (box.hasASquare()) { System.out.println("At least one side of the box is square."); }
        if (!box.hasASquare()) { System.out.println("No sides of the box are square."); }

        if (box.isACube()) { System.out.println("The box is a cube."); }
        if (!box.isACube()) { System.out.println("The box is not a cube."); }

        if (box.isHeavy()) { System.out.println("The box is heavy."); }
        if (!box.isHeavy()) { System.out.println("The box is not heavy."); }

        if (box.isLightweight()) { System.out.println("The box is lightweight."); }
        if (!box.isLightweight()) { System.out.println("The box is not lightweight."); }
    }
}