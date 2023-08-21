/**
 * CS200 Programming Assignment 3
 *
 * @author Josh Flatt
 * @version 11/06/2022
 */

public interface Shape {

    //Methods
    public double calculateVolume();
    public double calculateDensity();
    public double calculateBestFit();
    public double calculateWaste();

    //Setters
    public void setWeight(double weight);

    //Getters
    public double getWeight();
}