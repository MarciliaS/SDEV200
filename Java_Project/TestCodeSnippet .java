import java.util.*;

/**
 * Manual test class for CodeSnippet and SnippetStorage.
 */
public class TestCodeSnippet {
    public static void main(String[] args) {
        // Create test snippets
        CodeSnippet snippet1 = new CodeSnippet("Hello World", "Java", "System.out.println(\"Hello World!\");");
        CodeSnippet snippet2 = new CodeSnippet("Loop", "Python", "for i in range(5): print(i)");

        // Display toString
        System.out.println("--- Snippet 1 ---");
        System.out.println(snippet1);

        System.out.println("--- Snippet 2 ---");
        System.out.println(snippet2);

        // Save test
        List<CodeSnippet> snippets = new ArrayList<>();
        snippets.add(snippet1);
        snippets.add(snippet2);
        SnippetStorage.save(snippets);
        System.out.println("Snippets saved to file.");

        // Load test
        List<CodeSnippet> loadedSnippets = SnippetStorage.load();
        System.out.println("Loaded Snippets:");
        for (CodeSnippet s : loadedSnippets) {
            System.out.println(s);
        }

        // Test setters
        snippet1.setTitle("Updated Title");
        snippet1.setContent("Updated content here...");
        System.out.println("--- Updated Snippet ---");
        System.out.println(snippet1);
    }
}

