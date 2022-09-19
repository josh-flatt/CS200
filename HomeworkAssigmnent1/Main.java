import java.util.*;

/***********************************
 * CS 200 programming assignment 1 *
 * Josh Flatt                      *
 * 09/18/2022                      *
 ***********************************/


class Main {
    private static long seed; //Used for random number generation seeding
    private static int length;
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        length = 0; //Initialize variable to 0 to begin while-loop accepting only length between 2 and 8
        while (length < 2 || length > 8) {
            System.out.print("Enter the dimension size of the array: ");
            length = scnr.nextInt();
            if (length < 2 || length > 8) {
                System.out.println("The integer value given must be between 2 and 8. Try again.");
            }
        }
            
        System.out.print("Enter a seed to randomly populate the array with numbers: ");
        seed = scnr.nextLong();
        
        int[][] mainArray = SetMainArray(); //Initialization
        
        PrintMatrix(mainArray);
        PrintMatrixSum(mainArray);
        PrintMatrixAverage(mainArray);
        PrintMatrixMinimum(mainArray);
        PrintMatrixMaximum(mainArray);
        
    }
    
    public static int[][] SetMainArray() {
        Random random = new Random(seed);
        int[][] tempArray = new int[length][length];
        
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                tempArray[x][y] = (random.nextInt(16)); //Inserts random value from 0-15 at each position in array
            }
        }
        return tempArray;
    }
    
    public static void PrintMatrix(int[][] matrix) {
        System.out.println("\nMain array:");
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                String stringVal;
                int intVal = matrix[x][y];
                
                if (matrix[x][y] < 10) { 
                    stringVal = "0" + String.valueOf(intVal); //Creates leading 0 for vals<10 for table formatting
                }
                else { 
                    stringVal = String.valueOf(intVal); 
                }
                System.out.printf("%2s ", stringVal); //formatting
            }
            System.out.println();
        } 
    }
    
    public static void PrintMatrixSum(int[][] matrix) {
        System.out.println("\nSum array:");
        for (int x = 0; x < (matrix.length - 1); x++) {
            for (int y = 0; y < (matrix.length - 1); y++) {
                String stringVal;
                int total = matrix[x][y] + matrix[x+1][y] + matrix[x][y+1] + matrix[x+1][y+1];
                
                if (total < 10) { 
                    stringVal = "0" + String.valueOf(total); //Creates leading 0 for vals<10 for table formatting
                }
                else { 
                    stringVal = String.valueOf(total); 
                }
                System.out.printf("%2s ", stringVal); //formatting
            }
            System.out.println();
        }
    }
    
    public static void PrintMatrixAverage(int[][] matrix) {
        System.out.println("\nAvg array:");
        for (int x = 0; x < (matrix.length - 1); x++) {
            for (int y = 0; y < (matrix.length - 1); y++) {
                String stringVal;
                int total = matrix[x][y] + matrix[x+1][y] + matrix[x][y+1] + matrix[x+1][y+1];
                int average = total/4;
                
                if (average < 10) { 
                    stringVal = "0" + String.valueOf(average); //Creates leading 0 for vals<10 for table formatting
                }
                else { 
                    stringVal = String.valueOf(average); 
                }
                System.out.printf("%2s ", stringVal); //formatting
            }
            System.out.println();
        }
    }
    
    public static void PrintMatrixMinimum(int[][] matrix) {
        System.out.println("\nMin array:");
        for (int x = 0; x < (matrix.length - 1); x++) {
            for (int y = 0; y < (matrix.length - 1); y++) {
                String stringVal;
                int tempMin1 = Math.min(matrix[x][y], matrix[x+1][y]);
                int tempMin2 = Math.min(matrix[x][y+1], matrix[x+1][y+1]);
                int min = Math.min(tempMin1, tempMin2);
                
                if (min < 10) { 
                    stringVal = "0" + String.valueOf(min); //Creates leading 0 for vals<10 for table formatting
                }
                else { 
                    stringVal = String.valueOf(min); 
                }
                System.out.printf("%2s ", stringVal);
            }
            System.out.println();
        }
    }
    
    public static void PrintMatrixMaximum(int[][] matrix) {
        System.out.println("\nMax array:");
        for (int x = 0; x < (matrix.length - 1); x++) {
            for (int y = 0; y < (matrix.length - 1); y++) {
                String stringVal;
                int tempMax1 = Math.max(matrix[x][y], matrix[x+1][y]);
                int tempMax2 = Math.max(matrix[x][y+1], matrix[x+1][y+1]);
                int max = Math.max(tempMax1, tempMax2);
                
                if (max < 10) { 
                    stringVal = "0" + String.valueOf(max); //Creates leading 0 for vals<10 for table formatting
                }
                else { 
                    stringVal = String.valueOf(max); 
                }
                System.out.printf("%2s ", stringVal);
            }
            System.out.println();
        }
    }
    
}