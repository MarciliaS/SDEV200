package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import database.DBUtil;
import java.sql.*;

public class StaffApp extends Application {
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);

        pane.add(new Label("ID:"), 0, 0);
        pane.add(tfId, 1, 0);
        pane.add(new Label("Last Name:"), 0, 1);
        pane.add(tfLastName, 1, 1);
        pane.add(new Label("First Name:"), 0, 2);
        pane.add(tfFirstName, 1, 2);
        pane.add(new Label("MI:"), 0, 3);
        pane.add(tfMi, 1, 3);
        pane.add(new Label("Address:"), 0, 4);
        pane.add(tfAddress, 1, 4);
        pane.add(new Label("City:"), 0, 5);
        pane.add(tfCity, 1, 5);
        pane.add(new Label("State:"), 0, 6);
        pane.add(tfState, 1, 6);
        pane.add(new Label("Telephone:"), 0, 7);
        pane.add(tfTelephone, 1, 7);
        pane.add(new Label("Email:"), 0, 8);
        pane.add(tfEmail, 1, 8);

        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");

        pane.add(btView, 2, 0);
        pane.add(btInsert, 2, 1);
        pane.add(btUpdate, 2, 2);

        // Button Actions
        btView.setOnAction(e -> viewStaff());
        btInsert.setOnAction(e -> insertStaff());
        btUpdate.setOnAction(e -> updateStaff());

        Scene scene = new Scene(pane, 650, 400);
        primaryStage.setTitle("Staff Management App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void viewStaff() {
        String id = tfId.getText();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM Staff WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tfLastName.setText(rs.getString("lastName"));
                tfFirstName.setText(rs.getString("firstName"));
                tfMi.setText(rs.getString("mi"));
                tfAddress.setText(rs.getString("address"));
                tfCity.setText(rs.getString("city"));
                tfState.setText(rs.getString("state"));
                tfTelephone.setText(rs.getString("telephone"));
                tfEmail.setText(rs.getString("email"));
            } else {
                clearFields();
                showAlert(Alert.AlertType.INFORMATION, "No staff found with ID: " + id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error viewing staff.");
        }
    }

    private void insertStaff() {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tfId.getText());
            pstmt.setString(2, tfLastName.getText());
            pstmt.setString(3, tfFirstName.getText());
            pstmt.setString(4, tfMi.getText());
            pstmt.setString(5, tfAddress.getText());
            pstmt.setString(6, tfCity.getText());
            pstmt.setString(7, tfState.getText());
            pstmt.setString(8, tfTelephone.getText());
            pstmt.setString(9, tfEmail.getText());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Staff inserted successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error inserting staff.");
        }
    }

    private void updateStaff() {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? " +
                         "WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tfLastName.getText());
            pstmt.setString(2, tfFirstName.getText());
            pstmt.setString(3, tfMi.getText());
            pstmt.setString(4, tfAddress.getText());
            pstmt.setString(5, tfCity.getText());
            pstmt.setString(6, tfState.getText());
            pstmt.setString(7, tfTelephone.getText());
            pstmt.setString(8, tfEmail.getText());
            pstmt.setString(9, tfId.getText());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Staff updated successfully!");
            } else {
                showAlert(Alert.AlertType.WARNING, "No staff found with ID to update.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error updating staff.");
        }
    }

    private void clearFields() {
        tfLastName.clear();
        tfFirstName.clear();
        tfMi.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfTelephone.clear();
        tfEmail.clear();
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

