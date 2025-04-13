import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Module04_assignment02 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords filename.java");
            System.exit(1);
        }

        File file = new File(args[0]);

        if (file.exists()) {
            System.out.println("The number of keywords in " + args[0] + " is " + countKeywords(file));
        } else {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case",
                "catch", "char", "class", "const", "continue", "default", "do", "double",
                "else", "enum", "extends", "for", "final", "finally", "float", "goto", "if",
                "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        boolean inBlockComment = false;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            // Skip block comments /* */
            if (inBlockComment) {
                if (line.contains("*/")) {
                    inBlockComment = false;
                    line = line.substring(line.indexOf("*/") + 2);
                } else {
                    continue; // Skip entire line
                }
            }

            // Remove line comments //
            if (line.contains("//")) {
                line = line.substring(0, line.indexOf("//"));
            }

            // Handle block comment start
            if (line.contains("/*")) {
                inBlockComment = true;
                line = line.substring(0, line.indexOf("/*"));
            }

            // Remove string literals "..."
            line = line.replaceAll("\".*?\"", " ");

            // Tokenize words
            String[] words = line.split("\\W+"); // Split by non-word characters

            for (String word : words) {
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
        }

        return count;
    }
}
