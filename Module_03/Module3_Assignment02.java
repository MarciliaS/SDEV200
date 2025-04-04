import java.math.BigInteger;
import java.util.Scanner;

/**
 * The Rational class represents a rational number with a numerator and a denominator.
 * It provides methods to add, subtract, multiply, and divide rational numbers.
 */
class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    /**
     * Constructs a Rational object with the given numerator and denominator.
     * The rational number is always stored in its reduced form.
     *
     * @param numerator   the numerator of the rational number
     * @param denominator the denominator of the rational number
     */
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.compareTo(BigInteger.ZERO) == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    /**
     * Adds another Rational number to this Rational number.
     *
     * other the Rational number to be added
     * return the sum of this Rational and the other Rational
     */
    public Rational add(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.denominator).add(other.numerator.multiply(denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Subtracts another Rational number from this Rational number.
     *
     * other the Rational number to be subtracted
     * return the difference between this Rational and the other Rational
     */
    public Rational subtract(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.denominator).subtract(other.numerator.multiply(denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Multiplies this Rational number by another Rational number.
     *
     *  other the Rational number to multiply with
     * return the product of this Rational and the other Rational
     */
    public Rational multiply(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.numerator);
        BigInteger newDenominator = denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Divides this Rational number by another Rational number.
     *
     *  other the Rational number to divide by
     * return the quotient of this Rational divided by the other Rational
     * throws IllegalArgumentException if the numerator of the other Rational is zero
     */
    public Rational divide(Rational other) {
        if (other.numerator.compareTo(BigInteger.ZERO) == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        BigInteger newNumerator = numerator.multiply(other.denominator);
        BigInteger newDenominator = denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Returns a string representation of the Rational number in the form "numerator/denominator".
     *
     * return the string representation of the Rational number
     */
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * The main method is the entry point of the program.
     * It demonstrates the use of the Rational class by performing arithmetic operations on Rational numbers.
     *
     *  args command-line arguments
     */
    
}


public class Module3_Assignment02{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first rational number
        System.out.print("Enter numerator: ");
        String[] firstRational = scanner.nextLine().split("/");
        BigInteger numerator1 = new BigInteger(firstRational[0]);
        BigInteger denominator1 = new BigInteger(firstRational[1]);

        Rational r1 = new Rational(numerator1, denominator1);

        // Prompt the user to enter the second rational number
        System.out.print("Enter the second number: ");
        String[] secondRational = scanner.nextLine().split("/");
        BigInteger numerator2 = new BigInteger(secondRational[0]);
        BigInteger denominator2 = new BigInteger(secondRational[1]);

        Rational r2 = new Rational(numerator2, denominator2);

        // Display the entered rational numbers
        System.out.println("First Rational: " + r1);
        System.out.println("Second Rational: " + r2);

        // Perform arithmetic operations and display the results
        Rational sum = r1.add(r2);
        Rational difference = r1.subtract(r2);
        Rational product = r1.multiply(r2);
        Rational quotient = r1.divide(r2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        // Demonstrate exception handling by attempting to divide by zero
        try {
            Rational r3 = r1.divide(new Rational(BigInteger.ZERO, BigInteger.ONE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}