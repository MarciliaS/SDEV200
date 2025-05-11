package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX application for managing simple code snippets.
 * Snippets are stored in memory (not saved to file).
 */
public class SnippetManagerApp extends Application {

    // Input fields
    private TextField titleField;
    private TextField languageField;
    private TextArea contentArea;

    // Display for saved snippets
    private ListView<CodeSnippet> snippetListView;

    // Internal list of snippets (in memory only)
    private List<CodeSnippet> snippets = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Code Snippet Manager");

        // --- Create input fields ---
        titleField = new TextField();
        titleField.setPromptText("Enter Title");

        languageField = new TextField();
        languageField.setPromptText("Enter Language");

        contentArea = new TextArea();
        contentArea.setPromptText("Enter your code here...");
        contentArea.setPrefRowCount(10);

        // --- ListView to display saved snippets ---
        snippetListView = new ListView<>();

        // --- Buttons for user interaction ---
        Button saveButton = new Button("Save Snippet");
        Button loadButton = new Button("Load Selected");
        Button deleteButton = new Button("Delete Selected");

        // --- Save Button Event ---
        saveButton.setOnAction(e -> {
            String title = titleField.getText().trim();
            String language = languageField.getText().trim();
            String content = contentArea.getText().trim();

            // Validate input
            if (title.isEmpty() || language.isEmpty() || content.isEmpty()) {
                showAlert("All fields must be filled.");
                return;
            }

            // Create and store snippet
            CodeSnippet snippet = new CodeSnippet(title, language, content);
            snippets.add(snippet);
            snippetListView.getItems().add(snippet);

            clearFields();
        });

        // --- Load Button Event ---
        loadButton.setOnAction(e -> {
            CodeSnippet selected = snippetListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                titleField.setText(selected.getTitle());
                languageField.setText(selected.getLanguage());
                contentArea.setText(selected.getContent());
            }
        });

        // --- Delete Button Event ---
        deleteButton.setOnAction(e -> {
            CodeSnippet selected = snippetListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                snippets.remove(selected);
                snippetListView.getItems().remove(selected);
                clearFields();
                showAlert("Snippet deleted.");
            } else {
                showAlert("Please select a snippet to delete.");
            }
        });

        // --- Layout for input section ---
        VBox inputs = new VBox(10, titleField, languageField, contentArea, saveButton, loadButton, deleteButton);
        inputs.setPadding(new Insets(10));
        inputs.setPrefWidth(400);

        // --- Layout for snippet list section ---
        VBox listViewBox = new VBox(10, new Label("Saved Snippets:"), snippetListView);
        listViewBox.setPadding(new Insets(10));
        listViewBox.setPrefWidth(300);

        // --- Main layout ---
        HBox root = new HBox(10, inputs, listViewBox);
        Scene scene = new Scene(root, 720, 400);

        // Show window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Clear all input fields.
     */
    private void clearFields() {
        titleField.clear();
        languageField.clear();
        contentArea.clear();
    }

    /**
     * Show a simple message alert to the user.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Launch the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
