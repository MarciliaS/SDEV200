/*
Author: Marcilia Alves
Date written: 3/20/2025
Assignment: Module 01 Programming Assignment 01

This is a Java program that converts feet to meters and meters to feet using a formatted table.

*/

public class Module1Assigment1 {
    /** 
     * Convert from feet to meters 
     * foot - the length in feet to be converted
     * return equivalent length in meters
     */
    public static double footToMeter(double foot) {
        return 0.305 * foot;  // Multiply foot by 0.305 to convert it to meters
    }

    /** 
     * Convert from meters to feet 
     * meter - the length in meters to be converted
     * return equivalent length in feet
     */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;  // Multiply meter by 3.279 to convert it to feet
    }

    // Main method: program execution starts here
    public static void main(String[] args) {
        
        // Print a formatted header for the conversion table
        System.out.printf("------------------------------------------%n"); 
        System.out.printf("    Table to Convert Feet to Meters      %n"); 
        System.out.printf("------------------------------------------%n"); 

        // Print column headers for the table
        System.out.println(" Feet    Meters    |    Meters    Feet");
        System.out.println("------------------------------------------");

        // Loop to generate and display the conversion table
        for (double feet = 1.0, meters = 20.0; feet <= 10.0; feet++, meters += 5) {
            
            // Print feet value (4.1f ensures 4-character width, 1 decimal place)
            System.out.printf("%4.1f     ", feet);
            
            // Print the converted meters value (6.3f ensures 6-character width, 3 decimal places)
            System.out.printf("%5.3f", footToMeter(feet));
            
            // Print separator for readability
            System.out.print("     |     ");
            
            // Print meters value left-aligned (-11.1f ensures 11-character width, 1 decimal place)
            System.out.printf("%-8.1f", meters);
            
            // Print the converted feet value (7.3f ensures 7-character width, 3 decimal places)
            System.out.printf("%8.3f\n", meterToFoot(meters));
        }
    }
}
