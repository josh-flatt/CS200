import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Double> dimensions = new ArrayList<Double>();
        getInputs(scnr, dimensions);
        double weight = getWeight(dimensions);

        Box box = new Box(dimensions.get(0), dimensions.get(1), dimensions.get(2), weight);
        descendSortDimensions(dimensions);
        double firstLargestDimension = dimensions.get(0);
        double secondLargestDimension = dimensions.get(1);

        Cone cone = new Cone(firstLargestDimension, secondLargestDimension, weight);
        Cylinder cylinder = new Cylinder(firstLargestDimension, secondLargestDimension, weight);
        Sphere sphere = new Sphere(firstLargestDimension, weight);

        printStats(box, cone, cylinder, sphere);
    }


    public static void getInputs(Scanner scnr, ArrayList<Double> dimensions) {
        String[] prompts = new String[] {"Enter the length: ","Enter the width: ",
                "Enter the height: ", "Enter the weight: "};
        for (int i = 0; i < 4;) {
            try {
                System.out.print(prompts[i]);
                double inputDouble = scnr.nextDouble();
                if (!(inputDouble > 0)) { throw new Exception(); }
                dimensions.add(inputDouble);
                i++;
            }
            catch (Exception e) {
                System.out.println("Invalid entry.  Only positive values > 0 allowed. Please re-enter.");
                scnr.nextLine(); //Clears scanner
            }
        }
    }


    public static void printStats(Box box, Cone cone, Cylinder cylinder, Sphere sphere) {

        System.out.println("\n");
        System.out.printf("Box volume: %.2f cu ft         Box density: %.2f lbs./cu ft\n", box.calculateVolume(), box.calculateDensity());
        System.out.printf("Cone volume: %.2f cu ft        Cone density: %.2f lbs./cu ft\n", cone.calculateVolume(), cone.calculateDensity());
        System.out.printf("Cylinder volume: %.2f cu ft    Cylinder density: %.2f lbs./cu ft\n", cylinder.calculateVolume(), cylinder.calculateDensity());
        System.out.printf("Sphere volume: %.2f cu ft      Sphere density: %.2f lbs./cu ft\n", sphere.calculateVolume(), sphere.calculateDensity());
        System.out.println();
        System.out.println("An object container would need to be:");
        System.out.printf("%.2f cu ft for a Box (%.2f%% waste)\n", box.calculateBestFit(), box.calculateWaste());
        System.out.printf("%.2f cu ft for a Cone (%.2f%% waste)\n", cone.calculateBestFit(), cone.calculateWaste());
        System.out.printf("%.2f cu ft for a Cylinder (%.2f%% waste)\n", cylinder.calculateBestFit(), cylinder.calculateWaste());
        System.out.printf("%.2f cu ft for a Sphere (%.2f%% waste)\n", sphere.calculateBestFit(), sphere.calculateWaste());
        //Note: %% will print out as "%" when using the printf method.
    }


    public static void descendSortDimensions(ArrayList<Double> dimensions) {

        Collections.sort(dimensions, Collections.reverseOrder()); //order input dimensions in descending order
    }

    public static double getWeight(ArrayList<Double> dimensions) {
        return dimensions.remove(3); //Weight is always the fourth object in the dimensions ArrayList.
        //Removed instead of retrieved for later manipulation of non-weight dimensions.
    }
}