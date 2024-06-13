package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.Connect;
import Model.Coffee;


public class CoffeeManager {
	
	public static CoffeeManager getInstance() {
        return new CoffeeManager(); // Fixed the method name to lowercase "danhBA"
    }

 public static List<Coffee> findAll(){
	 List<Coffee> coffees = new ArrayList<>();
	 String query= "SELECT * FROM public.\"Coffee\"";
	 try {
		Connection connection = Connect.getConnection();
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String name = rs.getString("Name");
			String price = rs.getString("Price");
			byte[] image = rs.getBytes("Image");
			Coffee coffee = new Coffee(name, price,image);
			coffees.add(coffee);		
		}
		Connect.closeConnection(connection);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return coffees;
 }
 public static void addCoffee(String name, String price, byte[] image) {
	 try {
		 Connection con = Connect.getConnection(); 
		 String sql = "INSERT INTO \"Coffee\"(\"Name\", \"Price\", \"Image\") VALUES (?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setBytes(3, image);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Save successfully!");
			}
		 
	 } catch(SQLException e) {
		 e.printStackTrace();
	 }
	 
 }
}