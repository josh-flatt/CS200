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
        
        System.out.println("Welcome to the World Happiness - Corruption Dataset (2015-2020).");
        CSVData = ImportCSVFile(readBuffer, scnr); // Set this ArrayList equal to all of the CSV data
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
        	System.out.println("Search selected.");
        	System.out.print("Enter the country name: ");
        	country = scnr.nextLine();
        	System.out.print("Enter the continent: ");
        	continent = scnr.nextLine();
        	System.out.print("Enter the year to search by (15-20 inclusive): ");
        	year = scnr.nextInt();
        }
        if (searchOrSortDecision == 2) { //If sort was selected
        	System.out.println("Sort selected.");
        }
    	Sort(CSVData, scnr);
    	Search(CSVData, country, continent, year);
    	PrintRows(CSVData);
    }
    
    public static ArrayList<CSVRow> ImportCSVFile(BufferedReader readBuffer, Scanner scnr) {
    	ArrayList<CSVRow> CSVData = new ArrayList<CSVRow>();
    	System.out.print("Enter a full pathname and filename for the input file: ");
         
         try {
             String inputLine;
             String filePath = scnr.nextLine();
             if (filePath.equals(null) || filePath.isEmpty()) { 
             	throw new IOException(); 
             }
             readBuffer = new BufferedReader(new FileReader(filePath));
             System.out.print("Reading file...");
             readBuffer.readLine(); // Ignore header row
             while ((inputLine = readBuffer.readLine()) != null) {
            	CSVRow row = new CSVRow(inputLine);
             	CSVData.add(row);
             }
             System.out.println("Done."); 
         } 
         catch (IOException e) {
             System.out.println("This filename cannot be found.  Exiting.");
             System.exit(0);
         }
         return CSVData;
    }
    
    public static void Sort(ArrayList<CSVRow> CSVData, Scanner scnr) {
    	Character columnToSort = 'z';
    	int ascendOrDescend = 0;
    	int column = -1;
    	boolean acceptedAnswer = false;
    	while(!acceptedAnswer) {
	    	System.out.println("Sort by:");
	    	System.out.println("a. country");
	    	System.out.println("b. year");
	    	System.out.println("c. continent");
	    	System.out.println("d. happiness score");
	    	System.out.println("e. GDP per capita");
	    	System.out.println("f. family");
	    	System.out.println("g. health");
	    	System.out.println("h. freedom");
	    	System.out.println("i. generosity");
	    	System.out.println("j. government trust");
	    	System.out.println("k. CPI score");
	    	System.out.print("Enter the primary sort column (a-k): ");
	    	
	    	try {
	    		String rawInput = scnr.nextLine().toLowerCase();
	    		columnToSort = rawInput.charAt(0);
	    		if (columnToSort < 'a' || columnToSort > 'k' ||columnToSort.equals(null)) { 
	    			throw new IllegalArgumentException();
	    		}
	    		acceptedAnswer = true;
	    	} catch (Exception e) { System.out.println("Invalid value."); }
    	}
    	acceptedAnswer = false;
    	while (!acceptedAnswer) {
        	System.out.print("Sort by column in ascending (1) or descending (2) order? (Enter 1 or 2): ");
        	try {
        		String rawInput = scnr.nextLine();
        		ascendOrDescend = Integer.parseInt(rawInput);
        		if (ascendOrDescend != 1 && ascendOrDescend != 2) { 
        			throw new IllegalArgumentException();
        		}
        		acceptedAnswer = true;
        	} catch (Exception e) { System.out.println("Invalid input. Enter 1 or 2 only."); }
        }
    	switch(columnToSort) {
	    	case 'a': column = 0; break;
	    	case 'b': column = 1; break;
	    	case 'c': column = 2; break;
	    	case 'd': column = 3; break;
	    	case 'e': column = 4; break;
	    	case 'f': column = 5; break;
	    	case 'g': column = 6; break;
	    	case 'h': column = 7; break;
	    	case 'i': column = 8; break;
	    	case 'j': column = 9; break;
	    	case 'k': column = 10; break;
	    	default : column = 0;
    	}
    	if (ascendOrDescend == 1) { AscendSort(CSVData, column); }
    	if (ascendOrDescend == 2) { DescendSort(CSVData, column); }
    }
    
	public static <T extends Comparable<T>> void AscendSort(ArrayList<CSVRow> CSVData, int column) { //Selection Sort
    	int smallestIndex;
    	CSVRow temp;
    	for (int currentIndex = 0; currentIndex < CSVData.size() - 1; currentIndex++) {
    		smallestIndex = currentIndex;
    		T iCompareValue = (T) CSVData.get(currentIndex).GetAllData().get(column);
    		
    		for (int j = currentIndex + 1; j < CSVData.size(); j++) {
    			T jCompareValue = (T) CSVData.get(j).GetAllData().get(column);
    			
    			if (iCompareValue.compareTo(jCompareValue) < 0) {
    				smallestIndex = j; //Find smaller of 2 items
    			}
    		}
    		//Swap
    		if (currentIndex != smallestIndex) {
	    		temp = CSVData.get(currentIndex);
	    		CSVData.set(currentIndex, CSVData.get(smallestIndex));
	    		CSVData.set(smallestIndex, temp);
    		}
    	}
    }
    
    public static <T extends Comparable<T>> void DescendSort(ArrayList<CSVRow> CSVData, int column) {
    	int smallestIndex;
    	CSVRow temp;
    	for (int currentIndex = 0; currentIndex < CSVData.size() - 1; currentIndex++) {
    		smallestIndex = currentIndex;
    		T currentCompareValue = (T) CSVData.get(currentIndex).GetAllData().get(column);
    		
    		for (int j = currentIndex + 1; j < CSVData.size(); j++) {
    			T jCompareValue = (T) CSVData.get(j).GetAllData().get(column);
    			
    			if (currentCompareValue.compareTo(jCompareValue) > 0) {
    				smallestIndex = j; //Find smaller of 2 items
    			}
    		}
    		//Swap
    		if (currentIndex != smallestIndex) {
	    		temp = CSVData.get(currentIndex);
	    		CSVData.set(currentIndex, CSVData.get(smallestIndex));
	    		CSVData.set(smallestIndex, temp);
    		}
    	}
    }
    
    public static void Search(ArrayList<CSVRow> CSVData, String country, String continent, Integer year) {
    	if (!(country.isEmpty())) {
    		for (CSVRow row : CSVData) {
    			if (!(row.GetCountry().equals(country))) {
    				CSVData.remove(row);
    			}
    		}
    	}
    	if (!(continent.isEmpty())) {
    		for (CSVRow row : CSVData) {
    			if (!(row.GetContinent().equals(continent))) {
    				CSVData.remove(row);
    			}
    		}
    	}
    	if (year != 0 && year != null) {
    		for (CSVRow row : CSVData) {
    			if (!(row.GetYear().equals(year))) {
    				CSVData.remove(row);
    			}
    		}
    	}
    }
    
    
    public static void PrintRows(ArrayList<CSVRow> sortedRows) {
    	System.out.println();
    	System.out.println("Country                 Year   Cont  Happ  GDP   Fam   Hlth  Free  Gene  Govt  CPI");
    	for (CSVRow row : sortedRows) {
    		System.out.printf("%-22s  %d   %s    %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.0f\n", row.GetCountry(), row.GetYear(),
    				row.GetContinent(), row.GetHappinessScore(), row.GetGDP(), row.GetFamily(), row.GetHealth(), row.GetFreedom(),
    				row.GetGenerosity(), row.GetGovernmentTrust(), row.GetCPIScore());
    	}
    	if (sortedRows.size() < 1) { System.out.println("No rows returned."); }
    }
 }