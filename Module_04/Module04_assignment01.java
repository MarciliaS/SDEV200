import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Module04_assignment01 {

    public static void main(String[] args) {

        File file = new File("Example.java");

        if (!file.exists()) {
            System.out.println("File not found: Example.java");
            return;
        }

        Stack<Character> stack = new Stack<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                        stack.push(currentChar);
                    } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Unmatched closing symbol: " + currentChar);
                            scanner.close();
                            return;
                        }
                        char openChar = stack.pop();
                        if (!isMatch(openChar, currentChar)) {
                            System.out.println("Mismatched symbols: " + openChar + " and " + currentChar);
                            scanner.close();
                            return;
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("All grouping symbols match correctly!");
            } else {
                System.out.println("Unmatched opening symbols remain in the stack.");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
