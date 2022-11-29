import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
/**
 * adopted from Crunchify.com
 * 
 */
 
public class CSVtoArrayList {
    public static void main(String[] args) {
        
        BufferedReader readBuffer = null;
        Scanner scnr = new Scanner(System.in);
        boolean acceptedAnswer = false;
        int searchOrSortDecision = 0;
        Character columnToSort;
    	int ascendOrDescend;
        ArrayList<ArrayList<Object>> CSVData = new ArrayList<ArrayList<Object>>();
        
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
        	System.out.print("Enter the continent: ");
        	System.out.print("Enter the year to search by (15-20 inclusive): ");
        }
        if (searchOrSortDecision == 2) { //If sort was selected
        	System.out.println("Sort selected.");
        }
    	acceptedAnswer = false; //Sorting options available for either selection.
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
	    		if (columnToSort.equals(null)) { throw new IllegalArgumentException(); }
	    		if (columnToSort < 'a' || columnToSort > 'k') { throw new IllegalArgumentException(); }
	    		acceptedAnswer = true;
	    	} catch (Exception e) {
	    		System.out.println("Invalid value.");
	    	}
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
        	} catch (Exception e) {
        		System.out.println("Invalid input. Enter 1 or 2 only.");

        	}
        }
    	PrintRows(CSVData);
    }
    
    public static ArrayList<ArrayList<Object>> ImportCSVFile(BufferedReader readBuffer, Scanner scnr) {
    	ArrayList<ArrayList<Object>> CSVData = new ArrayList<ArrayList<Object>>();
    	System.out.print("Enter a full pathname and filename for the input file: ");
         
         try {
             String inputLine;
             String filePath = scnr.nextLine();
             if (filePath.equals(null) || filePath.isEmpty()) { 
             	throw new IOException(); 
             }
             readBuffer = new BufferedReader(new FileReader(filePath));
             
             readBuffer.readLine(); // Ignore header row
             while ((inputLine = readBuffer.readLine()) != null) {
             	CSVData.add(CSVtoArrayList(inputLine));
             }
             System.out.println("Reading file...Done.");
//             for (int i = 0; i < CSVData.size(); i++) {
//             	System.out.println(CSVData.get(i));
//             }
             
         } 
         catch (IOException e) {
             System.out.println("This filename cannot be found.  Exiting.");
             System.exit(0);
         }
         return CSVData;
    }
    
    // Utility which converts CSV to ArrayList using Split operation
    
    public static ArrayList<Object> CSVtoArrayList(String CSVFileName) {
        ArrayList<Object> arrlist = new ArrayList<Object>();
        
        
        if (CSVFileName != null) {
            String[] splitData = CSVFileName.split("\\,", -1); //the -1 helps handle the null values
            
            for (int i = 0; i < splitData.length; i++) {
                //if it is null, replace it with a 0
                if (splitData[i].length() == 0) {
                    splitData[i] = "0";
                }
                //as long as it is not null and the length is not 0, trim the value and add it to the arraylist
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                	String trimmedString = splitData[i];
                	if (i == 0) { 		// Country (String)
                		arrlist.add(trimmedString);
                	}
                	if (i == 1) { 		// Year (integer)
                		int trimmedInteger = Integer.parseInt(trimmedString);
                		arrlist.add(trimmedInteger);
                	}
            		if (i == 2) { 		// Continent (String)
            			arrlist.add(trimmedString);
            		}
            		if (i != 0 && i != 1 && i != 2) {				// Other (Double) -- Else not working here for unknown reason
            			double trimmedDouble = Double.parseDouble(trimmedString);
            			arrlist.add(trimmedDouble);
            		}
                }
            }
         }
     return arrlist;
    }
    
    public static <T extends Comparable<T>> void Sort(Character columnToSort, int ascendOrDescend) {
    	int column = -1;
    	if (columnToSort == 'a') { column = 0;  }
    	if (columnToSort == 'b') { column = 1;  }
    	if (columnToSort == 'c') { column = 2;  }
    	if (columnToSort == 'd') { column = 3;  }
    	if (columnToSort == 'e') { column = 4;  }
    	if (columnToSort == 'f') { column = 5;  }
    	if (columnToSort == 'g') { column = 6;  }
    	if (columnToSort == 'h') { column = 7;  }
    	if (columnToSort == 'i') { column = 8;  }
    	if (columnToSort == 'j') { column = 9;  }
    	if (columnToSort == 'k') { column = 10; }
    	
    	
    }
    
    public static void PrintRows(ArrayList<ArrayList<Object>> sortedRows) {
    	System.out.println();
    	System.out.println("Country                 Year   Cont  Happ  GDP   Fam   Hlth  Free  Gene  Govt  CPI");
    	for (ArrayList<Object> row : sortedRows) {
    		System.out.printf("%-22s  %d   %s    %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.0f\n", row.get(0), row.get(1), row.get(2), row.get(3), row.get(4),
    				row.get(5), row.get(6), row.get(7), row.get(8), row.get(9), row.get(10));
    	}
    	if (sortedRows.size() < 1) { System.out.println("No rows returned."); }
    }
 }