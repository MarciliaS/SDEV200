
/*
Author: Marcilia Alves
Date written: 3/29/2025
Assignment: Module 02 Programming Assignment 02

This Java program creates a program that prompts the user to enter the length of the sides of a triangle and displays the area and perimeter of the triangle.
*/

import java.util.Scanner;


// Java Program to implement
// Abstract class with abstract method



// GeometricObject.java: The abstract GeometricObject class
abstract class GeometricObject {

    /**Abstract method getPerimeter*/
    private String color = "white";
    private boolean filled;

    /**Default construct*/
    protected GeometricObject() {
    }
    /**Construct a geometric object*/
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    /**Getter method for color*/
    public String getColor() {
        return color;
    }
    /**Setter method for color*/
    public void setColor(String color) {
        this.color = color;
    }
    /**Getter method for filled. Since filled is boolean,
    so, the get method name is isFilled*/
    public boolean isFilled() {
        return filled;
    }
    /**Setter method for filled*/
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    /**Abstract method findArea*/
    public abstract double getArea();
    /**Abstract method getPerimeter*/
    public abstract double getPerimeter();
}


// extending abstract class GeometricObject
class Triangle extends GeometricObject {
    // Instance variables to store the length of the sides of the triangle
    // Default length of the sides is 1.0
    private double side1 = 1.0; // side1 - length of the first side of the triangle
    private double side2 = 1.0; // side2 - length of the second side of the triangle
    private double side3 = 1.0; // side3 - length of the third side of the triangle

    //constructor
    /**
     * Default constructor for Triangle.
     * Initializes the triangle with default side lengths of 1.0.
     */
    public Triangle() {  
        // Default sides are already set to 1.0
    }

   
    //Constructor with three sides
    public Triangle (double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Constructor with three sides and color/filled
    public Triangle (double side1, double side2, double side3, String color, boolean filled) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setColor(color);
        setFilled(filled);
    }

    /**
     * @return the length of the first side of the triangle
     */
    public double getSide1() {
        return side1;
    }

    /**
     * @return the length of the second side of the triangle
     */
    public double getSide2() {
        return side2;
    }

    /**
     * @return the length of the third side of the triangle
     */
    public double getSide3() {
        return side3;
    }
      
    /**
     * @return the perimeter of the triangle
     */
    @Override
    public double getPerimeter() {
        // Calculate the perimeter of the triangle
        // using formula side1 + side2 + side3
        double ar = side1 + side2 + side3;
        return ar;
    }

    /**
     * @return the area of the triangle
     */
    @Override
    public double getArea() {
        // Finding Semi perimeter of the triangle
        // using formula (side1 + side2 + side3) / 2
        double S = (side1 + side2 + side3) / 2;

        // Finding the area of the triangle
        double A = Math.sqrt(S * (S - side1) * (S - side2)* (S - side3));
        return A;
    }

    /**
     * @return the details of the triangle
     */
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
    
}

public class Module2Assignment2 {
    // main function
    public static void main(String[] args)
    {
        // Create a Scanner object to read input from the console
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first side of the triangle
        System.out.print("Enter the first side: ");
        double a = input.nextDouble();

        // Prompt the user to enter the second side of the triangle
        System.out.print("Enter the second side: ");
        double b = input.nextDouble();

        // Prompt the user to enter the third side of the triangle
        System.out.print("Enter the third side: ");
        double c = input.nextDouble();

        // Prompt the user to enter the color of the triangle
        System.out.print("Enter a color: ");
        String color = input.next();

        // Prompt the user to indicate if the triangle is filled
        System.out.print("Is the triangle filled (true/false)? ");
        boolean filled = input.nextBoolean();

        // Create a Triangle object with the provided sides, color, and filled status
        Triangle triangle = new Triangle(a, b, c, color, filled);
        
        
        System.out.println("\n--- Triangle Details ---");
        System.out.println(triangle.toString());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        System.out.printf("Area: %.2f\n", triangle.getArea());
        System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());

    }
}


