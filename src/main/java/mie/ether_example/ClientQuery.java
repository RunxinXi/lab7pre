package mie.ether_example;

import java.sql.*;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class ClientQuery implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/yourDatabase"; // Update with your database details
        String user = "username"; // Update with your database username
        String password = "password"; // Update with your database password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Results (id, owner) VALUES (?, ?)")) {

            // Assuming you have a method to get the owner's address
            String ownerAddress = getOwnerAddress(); // Implement this method

            // Example query data
            int queryId = 1; // This should come from your process variable

            pstmt.setInt(1, queryId);
            pstmt.setString(2, ownerAddress);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getOwnerAddress() {
        // Implement the logic to retrieve the owner's address
        return "ownerAddress"; // Placeholder
    }
}


