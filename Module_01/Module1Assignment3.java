/*
Author: Marcilia Alves
Date written: 3/21/2025
Assignment: Module 01 Programming Assignment 03

This is a Java program that prompts the user to enter two 3 x 3 arrays of integer and display whether the two are identical.

*/
import java.util.Arrays;
import java.util.Scanner;

public class Module1Assignment3 {
    // Method to check if two 2D arrays are strictly identical
    public static boolean  check(int[][] m1, int[][] m2) {
        // Compare each row and element
        // Check if the number of columns in each row is the same
        return Arrays.deepEquals(m1, m2);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array size for a 3x3 matrix
        int arrSize = 3;

        //Initialize the array's
        int [][] m1 = new int[arrSize][arrSize];
        int [][] m2 = new int[arrSize][arrSize];

        //Take user elements for the array m1
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                m1[i][j] = input.nextInt();
            }
        }

        //Take user elements for the array m2
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                m2[i][j] = input.nextInt();
            }
        }

        // Call Check method to test if the arrays are strictly identical
        if (check(m1, m2)) {
            System.out.println("--The two arrays are strictly identical.--");
        } else {
            System.out.println("--The two arrays are not strictly identical.--");
        }

         // Output the first array
        System.out.println("The elements of the array 1 are: ");
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++){
                System.out.print(m1[i][j] + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }
        // Output the second array
        System.out.println("The elements of the array 2 are: ");
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++){
                System.out.print(m2[i][j] + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }

    }
}
