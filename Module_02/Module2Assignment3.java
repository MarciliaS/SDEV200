/*
Author: Marcilia Alves
Date written: 3/29/2025
Assignment: Module 02 Programming Assignment 03

This Java program creates a class BinaryFormatException that extends the Exception class and is used to handle invalid binary numbers.
The program prompts the user for a binary number and calls the bin2Dec method to validate it. 
If the input is valid, it prints a message indicating that. Otherwise, it prints an error message.
*/
import java.util.Scanner;


/**
 * Class to represent a custom exception for invalid binary numbers.
 */
class BinaryFormatException extends Exception {
    /**
     * Constructor that takes a message to be displayed when the exception is thrown.
     */
    public BinaryFormatException(String message) {
       super(message);
    }
}


public class Module2Assignment3 {
    // This method takes a binary string as input and validates whether it is a valid binary number.
    // It throws a custom exception (BinaryFormatException) if the input contains any character other than 0 or 1.
    public static void  bin2Dec(String binary) throws BinaryFormatException {
        // Check if the input string is empty
        if (binary.isEmpty()) {
            System.out.println("Empty string is not a valid binary number."); 
        } 
        // Check if the string contains only binary digits (0s and 1s)
        else if  (!isBinary(binary)) {
             // If not, throw a custom exception with an appropriate message
            throw new BinaryFormatException("Invalid binary number.");
        } 
         // If the string is valid (non-empty and contains only 0s and 1s)
        else {
            System.out.println("Wow, it is a binary number.");
        }
    }


    /**
     * Helper method to check whether a given string is a valid binary number.
     * binary The string to be checked.
     * returns true if the string is a valid binary number (contains only 0s and 1s), false otherwise.
     */
    static boolean isBinary(String binary) {
        // Iterate over the characters in the string
        for (int i = 0; i < binary.length(); i++) {
            // If any character is not 0 or 1, return false
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                return false;
            }
        }
        // If we reach the end of the string without finding any invalid characters, return true
        return true;
    }
    

    /**
     * The main method is the entry point for the program.
     * It prompts the user for a binary number, and then calls the bin2Dec method to validate it.
     * If the input is valid, it prints a message indicating that. Otherwise, it prints an error message.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read input from the user.
        Scanner input = new Scanner(System.in);
        // Prompt the user for a binary number.
        System.out.print("Enter a binary number: ");
        // Read the user's input and store it in the binary variable.
        String binary = input.nextLine();
        // Attempt to validate the binary string by calling the bin2Dec method.
        try {
            bin2Dec(binary);
        } catch (BinaryFormatException e) {
            // If the input is invalid, print an appropriate error message.
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner object to release resources.
            input.close();
        }
    }

}
