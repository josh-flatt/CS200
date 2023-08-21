import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * adopted from Crunchify.com
 * Josh Flatt
 * CS 200 HW Assignment 4
 * 29 November 2022
 */

public class CSVtoArrayList {
    public static void main(String[] args) {

        BufferedReader readBuffer = null;
        Scanner scnr = new Scanner(System.in);
        boolean acceptedAnswer = false;
        int searchOrSortDecision = 0;
        String country = "";
        String continent = "";
        Integer year = 0;
        ArrayList<CSVRow> CSVData = new ArrayList<CSVRow>();
        Dataset dataset;

        System.out.println("Welcome to the World Happiness - Corruption Dataset (2015-2020).");
        System.out.print("Enter a full pathname and filename for the input file: ");

        String filePath = scnr.nextLine();
        dataset = new Dataset(readBuffer);
        dataset.Build(filePath);
        while (!acceptedAnswer) {
            System.out.print("Do you wish to (1) Search or (2) Sort by a column? (Enter 1 or 2): ");
            try {
                String rawInput = scnr.nextLine();
                searchOrSortDecision = Integer.parseInt(rawInput);
                if (searchOrSortDecision != 1 && searchOrSortDecision != 2) {
                    throw new IllegalArgumentException();
                }
                acceptedAnswer = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter 1 or 2 only.");
            }
        }
        if (searchOrSortDecision == 1) { //If search was selected
            ArrayList<CSVRow> slice;
            System.out.println("Search selected.");
            System.out.print("Enter the country name: ");
            country = scnr.nextLine();
            System.out.print("Enter the continent: ");
            continent = scnr.nextLine();
            System.out.print("Enter the year to search by (15-20 inclusive): ");
            year = scnr.nextInt();
            slice = dataset.Search(country, continent, year);
            dataset.PrintRows(slice);
        }
        if (searchOrSortDecision == 2) { //If sort was selected
            System.out.println("Sort selected.");
            dataset.Sort(scnr);
            dataset.PrintRows();
        }
    }
}