
public class CSVRow {
	public String country;
	public Integer year;
	public String continent;
	public Double happinessScore;
	public Double gdp;
	public Double family;
	public Double health;
	public Double freedom;
	public Double generosity;
	public Double governmentTrust;
	public Double cpiScore;

	
	public CSVRow(String inputLine) {
		try {
			if (inputLine == null) { throw new Exception("Input line is null."); }
			
	        String[] splitData = inputLine.split("\\,", -1); //the -1 helps handle the null values
	        for (int i = 0; i < splitData.length; i++) {
	            
	            if (splitData[i].length() == 0 || splitData == null) { //replace empty values with a "0"
	            	splitData[i] = "0";
	            }
            	String trimmedString = splitData[i];
            	Double trimmedDouble;
            	Integer trimmedInteger;
            	switch(i) {
            		case 0:
            			this.country = trimmedString;
            		case 1:
            			trimmedInteger = Integer.parseInt(trimmedString);
            			this.year = trimmedInteger;
            		case 2:
            			this.continent = trimmedString;
            		case 3:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.happinessScore = trimmedDouble;
            		case 4:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.gdp = trimmedDouble;
            		case 5:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.family = trimmedDouble;
            		case 6:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.health = trimmedDouble;
            		case 7:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.freedom = trimmedDouble;
            		case 8:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.generosity = trimmedDouble;
            		case 9:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.happinessScore = trimmedDouble;
            		case 10:
            			trimmedDouble = Double.parseDouble(trimmedString);
            			this.happinessScore = trimmedDouble;
            	}
	        }
        } catch (Exception e) {
        	System.out.println("An error has occured.");
        	System.out.println(e.getMessage());
        }
	}
}
