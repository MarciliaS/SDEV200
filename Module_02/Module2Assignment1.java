/*
Author: Marcilia Alves
Date written: 3/29/2025
Assignment: Module 02 Programming Assignment 01

This Java program creates a class Date that represents a date in the Gregorian calendar.
Write a test program that creates two MyDate objects (using new MyDate() and new MyDate(34355555133101L)) and displays their year, month, and day.
*/
import java.util.Calendar;


final class Date {
    //These are private instance variables to store the year, month, and day.
    private int year;
    private int month; // 0-based: 0 for January
    private int day;
    
    
    /**
     * Constructor that creates a Date object representing the current date and time.
     */
    public Date() {
        Calendar cal = Calendar.getInstance(); //Creates a Calendar instance representing the current date/time.

        // Extracts and sets the current day, month, and year from the Calendar object.
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.month = cal.get(Calendar.MONTH);
        this.year = cal.get(Calendar.YEAR);
    }

    public Date(long milli) {
        setMilli(milli); // Delegates the date setting logic to setMilli() for reusability and cleaner code.
    }

    public void setMilli(long milli) {
        Calendar cal = Calendar.getInstance(); //Reuses the Calendar object and sets its time using the milliseconds provided.
        
        // Changing time to milli-second 
        cal.setTimeInMillis(milli);
        
        // Extracts and sets the current day, month, and year from the Calendar object.
        // Months are 0-based (January = 0, December = 11).
        this.day = cal.get(Calendar.DAY_OF_MONTH); // 1-based day of the month (1-31)
        this.month = cal.get(Calendar.MONTH); // 0-based month (January = 0)
        this.year = cal.get(Calendar.YEAR); // 4-digit year (e.g. 2022)
    }
    
    public int getDay() {
        return day; //Returns the value of day
    }

    /**
     * Converts the numeric (0-based) month value into a human-readable month name using a string array.
     * @return the human-readable month name
     */
    public String getMonth() {
        // Months array with 0-based month names
        String[] months = {"January", "February", "March", "April","May","June", "July", "August", "September", "October", "November", "December"};

        int i = month; // Using the month instance variable
        String monthName = months[i];

        return monthName;
    }

    public int getYear() {
        return year; // Returns the value of year
    }

}


public class Module2Assignment1 {
    //Defines a public class containing the main() method for testing the Date class functionality.
    public static void main(String[] args) {
        Date date1 = new Date(); //Creates an instance using the no-arg constructor, representing the current date.
        Date date2 = new Date(34355555133101L); //Creates a Date object representing the date 34355555133101L milliseconds

        // Prints the formatted current date (month name, day, year).
        System.out.println("Today is: " + date1.getMonth() + " "+  date1.getDay() + ", " + date1.getYear());
        
        // Prints the formatted date based on the milliseconds provided to the constructor.
        System.out.println("After setting" + " Time: " + date2.getMonth() + " " +  date2.getDay() + ", " + date2.getYear()); 
        
    }
}




