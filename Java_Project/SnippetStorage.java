

import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * Handles saving and loading code snippets to/from a JSON file.
 */
public class SnippetStorage {
    private static final String FILE_NAME = "snippets.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void save(List<CodeSnippet> snippets) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(snippets, writer);
            System.out.println("✅ Snippets saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error saving snippets: " + e.getMessage());
        }
    }

    public static List<CodeSnippet> load() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, new TypeToken<List<CodeSnippet>>() {}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // File doesn’t exist yet
        } catch (Exception e) {
            System.out.println("❌ Error loading snippets: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}



