/*
Author: Marcilia Alves
Date written: 3/23/2025
Assignment: Module 01 Programming Assignment 02

This is a Java program that creates three RegularPolygon Objects using a class RegularPolygon and display, for each object, area and perimeter.
*/

// This class defines a regular polygon (equal sides and angles)
class RegularPolygon {

    // The number of sides of the polygon, default is 3
    private int n = 3;

    // The length of each side, default is 1.0
    private double side = 1.0;

    // The x-coordinate of the polygon's center, default is 0.0
    private double x = 0.0;

    // The y-coordinate of the polygon's center, default is 0.0
    private double y = 0.0;

    // No-argument constructor: sets everything to default values
    public RegularPolygon() {
        // This constructor does nothing because defaults are already set
    }

    // Constructor with number of sides and side length
    public RegularPolygon(int n, double side) {
        this.n = n;           // "this.n" refers to the instance variable, set to the input parameter
        this.side = side;
    }

    // Constructor with number of sides, side length, and center coordinates
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Accessor method (getter) for number of sides
    public int getN() {
        return n;
    }

    // Mutator method (setter) to change number of sides
    public void setN(int n) {
        this.n = n;
    }

    // Getter for side length
    public double getSide() {
        return side;
    }

    // Setter for side length
    public void setSide(double side) {
        this.side = side;
    }

    // Getter for x-coordinate
    public double getX() {
        return x;
    }

    // Setter for x-coordinate
    public void setX(double x) {
        this.x = x;
    }

    // Getter for y-coordinate
    public double getY() {
        return y;
    }

    // Setter for y-coordinate
    public void setY(double y) {
        this.y = y;
    }

    // Method to calculate and return the perimeter of the polygon
    public double getPerimeter() {
        return n * side; // Perimeter = number of sides × side length
    }

    // Method to calculate and return the area of the polygon
    public double getArea() {
        // Formula: (n × side²) / (4 × tan(π / n))
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}


// Main class that will run when we start the program
public class Module1Assignment4 {
    // This is the entry point of any Java program
    public static void main(String[] args) {

        // Create a polygon using default constructor (n = 3, side = 1.0)
        RegularPolygon polygon1 = new RegularPolygon();

        // Create a polygon with 6 sides, each side is 4.0
        RegularPolygon polygon2 = new RegularPolygon(6, 4);

        // Create a polygon with 10 sides, side = 4.0, center at (5.6, 7.8)
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // Display perimeter and area for polygon1
        System.out.println("Polygon 1 - Perimeter: " + polygon1.getPerimeter() +
                           ", Area: " + polygon1.getArea());

        // Display perimeter and area for polygon2
        System.out.println("Polygon 2 - Perimeter: " + polygon2.getPerimeter() +
                           ", Area: " + polygon2.getArea());

        // Display perimeter and area for polygon3
        System.out.println("Polygon 3 - Perimeter: " + polygon3.getPerimeter() +
                           ", Area: " + polygon3.getArea());
    }
}
