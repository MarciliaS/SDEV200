package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class SnippetManagerApp extends Application {

    private TextField titleField;
    private TextField languageField;
    private TextArea contentArea;
    private ListView<CodeSnippet> snippetListView;
    private List<CodeSnippet> snippets = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Code Snippet Manager");

        // Create UI controls
        titleField = new TextField();
        titleField.setPromptText("Enter Title");

        languageField = new TextField();
        languageField.setPromptText("Enter Language");

        contentArea = new TextArea();
        contentArea.setPromptText("Enter your code here...");
        contentArea.setPrefRowCount(10);

        snippetListView = new ListView<>();

        Button saveButton = new Button("Save Snippet");
        Button loadButton = new Button("Load Selected Snippet");

        // --- EVENTS (required 2 events) ---
        saveButton.setOnAction(e -> saveSnippet()); // Event 1
        loadButton.setOnAction(e -> loadSelectedSnippet()); // Event 2

        // Layout
        VBox inputBox = new VBox(10, titleField, languageField, contentArea, saveButton, loadButton);
        inputBox.setPadding(new Insets(10));
        inputBox.setPrefWidth(400);

        VBox listBox = new VBox(10, new Label("Saved Snippets:"), snippetListView);
        listBox.setPadding(new Insets(10));
        listBox.setPrefWidth(300);

        HBox root = new HBox(10, inputBox, listBox);

        Scene scene = new Scene(root, 720, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- EVENT 1: Save a new snippet ---
    private void saveSnippet() {
        String title = titleField.getText().trim();
        String language = languageField.getText().trim();
        String content = contentArea.getText().trim();

        if (title.isEmpty() || language.isEmpty() || content.isEmpty()) {
            showAlert("All fields must be filled in.");
            return;
        }

        CodeSnippet snippet = new CodeSnippet(title, language, content);
        snippets.add(snippet);
        snippetListView.getItems().add(snippet);

        clearFields();
    }

    // --- EVENT 2: Load the selected snippet ---
    private void loadSelectedSnippet() {
        CodeSnippet selected = snippetListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            titleField.setText(selected.getTitle());
            languageField.setText(selected.getLanguage());
            contentArea.setText(selected.getContent());
        }
    }

    // Helper to clear input fields
    private void clearFields() {
        titleField.clear();
        languageField.clear();
        contentArea.clear();
    }

    // Helper to show warning alerts
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
