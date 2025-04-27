package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTestData {
    public static void main(String[] args) {
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("Finally - Connected to TestDB!");

            // SQL Insert Statement
            String sql = "INSERT INTO test_table (name) VALUES (?)";

            // PreparedStatement to insert data safely
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "TestUser"); // Insert "TestUser" into 'name' column

            int rowsInserted = pstmt.executeUpdate(); // Execute insert
            if (rowsInserted > 0) {
                System.out.println("Success - new user was inserted !");
            } else {
                System.out.println("Insert operation did not insert any rows.");
            }

            // Close everything
            pstmt.close();
            conn.close();
            System.out.println("✅ Connection closed properly!");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to insert data into database!");
            e.printStackTrace();
        }
    }
}

