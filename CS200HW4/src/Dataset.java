import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataset {
    BufferedReader readBuffer;
    ArrayList<CSVRow> dataset;
    public Dataset(BufferedReader readBuffer) {
        this.readBuffer = readBuffer;
    }

    public void Build(String path) {
        this.dataset = ImportCSVFile(path);
    }

    public ArrayList<CSVRow> ImportCSVFile(String path) {
        ArrayList<CSVRow> CSVData = new ArrayList<CSVRow>();
        try {
            String inputLine;
            if (path == null || path.isEmpty()) {
                throw new IOException();
            }
            this.readBuffer = new BufferedReader(new FileReader(path));
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
    public void Sort(Scanner scnr) {
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
                if (columnToSort < 'a' || columnToSort > 'k' || columnToSort == null) {
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
        if (ascendOrDescend == 1) { AscendSort(this.dataset, column); }
        if (ascendOrDescend == 2) { DescendSort(this.dataset, column); }
    }

    public <T extends Comparable<T>> void AscendSort(ArrayList<CSVRow> CSVData, int column) { //Selection Sort
        int CSVRows = CSVData.size();
        int smallestIndex;
        CSVRow temp;
        for (int currentIndex = 0; currentIndex < CSVRows - 1; currentIndex++) {
            smallestIndex = currentIndex;
            T iCompareValue = (T) CSVData.get(currentIndex).GetAllData().get(column);

            for (int j = currentIndex + 1; j < CSVRows; j++) {
                T jCompareValue = (T) CSVData.get(j).GetAllData().get(column);

                T smallestCompareValue = (T) CSVData.get(smallestIndex).GetAllData().get(column);
                if (smallestCompareValue.compareTo(jCompareValue) < 0) {
                    smallestIndex = j; // Find smaller of 2 items
                }
            }
            // Swap
            if (currentIndex != smallestIndex) {
                temp = CSVData.get(currentIndex);
                CSVData.set(currentIndex, CSVData.get(smallestIndex));
                CSVData.set(smallestIndex, temp);
            }
        }
    }

    public <T extends Comparable<T>> void DescendSort(ArrayList<CSVRow> CSVData, int column) {
        int largestIndex;
        CSVRow temp;
        for (int currentIndex = 0; currentIndex < CSVData.size() - 1; currentIndex++) {
            largestIndex = currentIndex;
            T iCompareValue = (T) CSVData.get(currentIndex).GetAllData().get(column);

            for (int j = currentIndex + 1; j < CSVData.size(); j++) {
                T jCompareValue = (T) CSVData.get(j).GetAllData().get(column);

                T largestCompareValue = (T) CSVData.get(largestIndex).GetAllData().get(column);
                if (largestCompareValue.compareTo(jCompareValue) > 0) {
                    largestIndex = j; //Find larger of 2 items
                }
            }
            //Swap
            if (currentIndex != largestIndex) {
                temp = CSVData.get(currentIndex);
                CSVData.set(currentIndex, CSVData.get(largestIndex));
                CSVData.set(largestIndex, temp);
            }
        }
    }

    public ArrayList<CSVRow> Search(String country, String continent, Integer year) {
        ArrayList<CSVRow> filtered = new ArrayList<>();
        boolean isCountry;
        boolean isContinent;
        boolean isYear;
        for (CSVRow row : this.dataset) {
            isCountry = country.isEmpty() || row.GetCountry().equals(country);
            isContinent = continent.isEmpty() || row.GetContinent().equals(continent);
            isYear = year == 0 || row.GetYear().equals(year);
            if (isCountry && isContinent && isYear) {
                filtered.add(row);
            }
        }
        return filtered;
    }

    public void PrintRows(ArrayList<CSVRow> CSVData) {
        System.out.println();
        System.out.println("Country                 Year   Cont  Happ  GDP   Fam   Hlth  Free  Gene  Govt  CPI");
        for (CSVRow row : CSVData) {
            System.out.printf("%-22s  %d   %s    %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.0f\n", row.GetCountry(), row.GetYear(),
                    row.GetContinent(), row.GetHappinessScore(), row.GetGDP(), row.GetFamily(), row.GetHealth(), row.GetFreedom(),
                    row.GetGenerosity(), row.GetGovernmentTrust(), row.GetCPIScore());
        }
        if (CSVData.size() < 1) { System.out.println("No rows returned."); }
    }
    public void PrintRows() {
        System.out.println();
        System.out.println("Country                 Year   Cont  Happ  GDP   Fam   Hlth  Free  Gene  Govt  CPI");
        for (CSVRow row : this.dataset) {
            System.out.printf("%-22s  %d   %s    %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.0f\n", row.GetCountry(), row.GetYear(),
                    row.GetContinent(), row.GetHappinessScore(), row.GetGDP(), row.GetFamily(), row.GetHealth(), row.GetFreedom(),
                    row.GetGenerosity(), row.GetGovernmentTrust(), row.GetCPIScore());
        }
        if (this.dataset.size() < 1) { System.out.println("No rows returned."); }
    }
}
