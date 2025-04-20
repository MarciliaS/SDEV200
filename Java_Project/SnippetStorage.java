import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * Utility class for saving and loading snippets to/from JSON file.
 */
public class SnippetStorage {
    public static final String FILE_NAME = "snippets.json";
    private static final Gson gson = new Gson();

    public static void save(List<CodeSnippet> snippets) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(snippets, writer);
        } catch (IOException e) {
            System.out.println("Error saving snippets: " + e.getMessage());
        }
    }

    public static List<CodeSnippet> load() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, new TypeToken<List<CodeSnippet>>(){}.getType());
        } catch (IOException e) {
            System.out.println("Error loading snippets: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
