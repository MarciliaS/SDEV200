package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    private Connection connection; // Connection object

    @Override
    public void start(Stage primaryStage) {
        Button btnConnect = new Button("Connect to Database");
        Button btnInsertNoBatch = new Button("Insert 1000 Random Records (No Batch)");

        VBox vbox = new VBox(10); // Stack buttons vertically
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(btnConnect, btnInsertNoBatch);

        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setTitle("Batch Update Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btnConnect.setOnAction(e -> showDBConnectionDialog());
        btnInsertNoBatch.setOnAction(e -> insertWithoutBatch());
    }

    private void showDBConnectionDialog() {
        // Create the dialog stage
        Stage dialog = new Stage();
        dialog.setTitle("Database Connection");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Form fields
        TextField tfURL = new TextField();
        TextField tfUsername = new TextField();
        PasswordField pfPassword = new PasswordField();
        Button btnConnect = new Button("Connect");

        tfURL.setText("jdbc:mysql://localhost:3306/yourDBName"); // Default
        tfUsername.setText("yourUsername"); // Default
        pfPassword.setText("yourPassword"); // Default

        // Add components to grid
        grid.add(new Label("Database URL:"), 0, 0);
        grid.add(tfURL, 1, 0);
        grid.add(new Label("Username:"), 0, 1);
        grid.add(tfUsername, 1, 1);
        grid.add(new Label("Password:"), 0, 2);
        grid.add(pfPassword, 1, 2);
        grid.add(btnConnect, 1, 3);

        btnConnect.setOnAction(e -> {
            try {
                connection = DriverManager.getConnection(
                        tfURL.getText(),
                        tfUsername.getText(),
                        pfPassword.getText()
                );
                System.out.println("Connected to database successfully!");
                dialog.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        dialog.setScene(scene);
        dialog.show();
    }

    private void insertWithoutBatch() {
        if (connection == null) {
            System.out.println("Please connect to the database first!");
            return;
        }

        String sql = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";

        try (java.sql.PreparedStatement ps = connection.prepareStatement(sql)) {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                ps.setDouble(1, Math.random());
                ps.setDouble(2, Math.random());
                ps.setDouble(3, Math.random());
                ps.executeUpdate();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken without batch: " + (endTime - startTime) + " milliseconds");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


