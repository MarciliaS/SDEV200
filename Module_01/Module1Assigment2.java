/*
Author: Marcilia Alves
Date written: 3/22/2025
Assignment: Module 01 Programming Assignment 02

This is a Java program that prompts the user to enter a credit card number as a long interger and display whether that card is valid or invalid.

*/

// Import the Scanner class to handle user input
import java.util.Scanner;

public class Module1Assigment2 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a credit card number
        System.out.println("Enter Credit Card Number:");
        
        // Read the credit card number as a long value (using nextLong for large numbers)
        long number = scanner.nextLong();
        
        // Check if the entered credit card number is valid using the isValid method
        // Print the result along with the number and close the scanner
        System.out.println(number + " is " + (isValid(number) ? "valid" : "invalid"));
        
        // Close the scanner to free up resources
        scanner.close();
    }

    // This method checks if the credit card number is valid based on specific criteria
    public static boolean isValid(long number) {
        // The card is valid if:
        // 1. Its length is between 13 and 16 digits.
        // 2. Its prefix matches one of the accepted values (4, 5, 37, or 6).
        // 3. The sum of the digits, processed by the Luhn algorithm, is divisible by 10.
        return (getSize(number) >= 13 && getSize(number) <= 16) &&
               (prefixMatched(number, 4) ||
                prefixMatched(number, 5) ||
                prefixMatched(number, 37) ||
                prefixMatched(number, 6)) &&
               ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    }

    // This method doubles every second digit from the right, adds the digits of the product if necessary, and returns their sum.
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0; // Initialize the sum to zero
        // Convert the number to a string to easily access individual digits
        String numStr = Long.toString(number);
        
        // Loop over every second digit from the right (starting from the second last digit)
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            // Get the digit at the current index and convert it to an integer
            int digit = Character.getNumericValue(numStr.charAt(i));
            // Double the digit and then use getDigit to handle any two-digit result
            sum += getDigit(digit * 2);
        }
        // Return the final sum of the processed even-place digits
        return sum;
    }

    // This method returns the number if it is a single digit; otherwise, it returns the sum of its two digits.
    public static int getDigit(int number) {
        // If the number is less than 10, it's a single digit and is returned directly.
        if (number < 10)
            return number;
        // Otherwise, split the number into two digits and return their sum.
        return number / 10 + number % 10;
    }

    // This method sums all the digits in the odd places (from right) of the credit card number.
    public static int sumOfOddPlace(long number) {
        int sum = 0; // Initialize the sum to zero
        // Convert the number to a string for digit extraction
        String numStr = Long.toString(number);
        
        // Loop over every odd-place digit from the right (starting from the last digit)
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            // Convert the character at the current index to its integer value and add it to the sum
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += digit;
        }
        // Return the final sum of the odd-place digits
        return sum;
    }

    // This method checks if the credit card number starts with the given prefix 'd'.
    public static boolean prefixMatched(long number, int d) {
        // Determine the number of digits in the prefix 'd'
        int dSize = getSize(d);
        // Compare the extracted prefix of the card number with 'd'
        return getPrefix(number, dSize) == d;
    }

    // This method returns the number of digits in a given number by converting it to a string.
    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    // This method extracts and returns the first k digits of the number.
    // If the number has fewer than k digits, the entire number is returned.
    public static long getPrefix(long number, int k) {
        // Convert the number to a string to extract the prefix
        String numStr = Long.toString(number);
        // If the number of digits is greater than k, extract the substring representing the first k digits
        if (numStr.length() > k) {
            return Long.parseLong(numStr.substring(0, k));
        }
        // Otherwise, return the original number
        return number;
    }
}
