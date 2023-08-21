import java.util.ArrayList;
/**
 * adopted from Crunchify.com
 * Josh Flatt
 * CS 200 HW Assignment 4
 * 29 November 2022
 */

public class CSVRow {
    private String country;
    private Integer year;
    private String continent;
    private Double happinessScore;
    private Double gdp;
    private Double family;
    private Double health;
    private Double freedom;
    private Double generosity;
    private Double governmentTrust;
    private Double cpiScore;

    public CSVRow(String inputLine) {
        try {

            if (inputLine == null) { throw new Exception("Input line is null."); }
            String[] splitData = inputLine.split("\\,", -1); //the -1 helps handle the null values
            for (int i = 0; i < splitData.length; i++) {
                if (splitData[i].length() == 0 || splitData == null) { //replace empty values with a "0"
                    splitData[i] = "0";
                }
            }

            this.country = splitData[0];
            this.happinessScore = Double.parseDouble(splitData[1]);
            this.gdp = Double.parseDouble(splitData[2]);
            this.family = Double.parseDouble(splitData[3]);
            this.health = Double.parseDouble(splitData[4]);
            this.freedom = Double.parseDouble(splitData[5]);
            this.generosity = Double.parseDouble(splitData[6]);
            this.governmentTrust = Double.parseDouble(splitData[7]);
            this.continent = splitData[9];
            this.year = Integer.parseInt(splitData[10]);
            this.cpiScore = Double.parseDouble(splitData[12]);

        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //Getters
    public String GetCountry() {
        return this.country;
    }
    public Integer GetYear() {
        return this.year;
    }
    public String GetContinent() {
        return this.continent;
    }
    public Double GetHappinessScore() {
        return this.happinessScore;
    }
    public Double GetGDP() {
        return this.gdp;
    }
    public Double GetFamily() {
        return this.family;
    }
    public Double GetHealth() {
        return this.health;
    }
    public Double GetFreedom() {
        return this.freedom;
    }
    public Double GetGenerosity() {
        return this.generosity;
    }
    public Double GetGovernmentTrust() {
        return this.governmentTrust;
    }
    public Double GetCPIScore() {
        return this.cpiScore;
    }
    public ArrayList<Object> GetAllData() {
        ArrayList<Object> allData = new ArrayList<Object>();
        allData.add(this.country);
        allData.add(this.year);
        allData.add(this.continent);
        allData.add(this.happinessScore);
        allData.add(this.gdp);
        allData.add(this.family);
        allData.add(this.health);
        allData.add(this.freedom);
        allData.add(this.generosity);
        allData.add(this.governmentTrust);
        allData.add(this.cpiScore);
        return allData;
    }
    //No Setters - information is not to be modified
}
