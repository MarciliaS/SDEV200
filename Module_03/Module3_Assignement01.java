/*
Author: Marcilia Alves
Date written: 3/29/2025
Assignment: Module 03 Programming Assignment 01

This Java program creates a class GeometricObject that represents a geometric object.
Write a test program that creates two GeometricObject objects (using new GeometricObject() and new GeometricObject("blue", true)) and displays their area and perimeter.   
*/
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    public GeometricObject() {
        dateCreated = new java.util.Date(); 
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;    
    }

    public String getColor() {
        return color;
    }    

    public void setColor(String color) {
        this.color = color;
    }    

    public boolean isFilled() {
        return filled;
    }    

    public void setFilled(boolean filled) {
        this.filled = filled;
    }    

    public java.util.Date getDateCreated() {
        return dateCreated; 
    }

    public String toString() {
        return "created on " + dateCreated +
          " color: " + color + " and filled: " + filled;    
    }
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
}

class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
          " and the radius is " + radius);
    }

    @Override
    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle other) {
            return this.compareTo(other) == 0;
        }
        return false;
    }


    @Override
    public String toString() {
        return super.toString() + ", radius: " + radius;
    }
}


public class Module3_Assignement01 {
    public static void main(String[] args) {
        Circle[] circles = {
            new Circle(5.6, "red", true),
            new Circle(2.5, "blue", false),
            new Circle(5.6, "green", true),
            new Circle(1.0, "white", false)
        };

                System.out.println("\nComparing Circles for Equality:");
        for (int i = 0; i < circles.length; i++) {
            for (int j = i + 1; j < circles.length; j++) {
                if (circles[i].equals(circles[j])) {
                    System.out.println("Circle " + i + " and Circle " + j + " are equal.");
                }
            }
        }
    }
}
