package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.Connect;

public class PurchaseManager {
    public static void insertPurchase(String product, int quantity, String price) {
        String sql = "INSERT INTO \"Purchase\" (\"Product\", \"Quantity\", \"Price\", \"Total\") VALUES (?, ?, ?, ?)";
        try (
            Connection conn = Connect.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            double total = quantity * Double.parseDouble(price);

            pstmt.setString(1, product);
            pstmt.setInt(2, quantity);
            pstmt.setString(3, price); 
            pstmt.setDouble(4, total); 

            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price format: " + price);
        }
    }
}
