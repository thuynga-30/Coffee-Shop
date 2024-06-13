package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.Connect;
import Model.Drink;
import Model.Food;

public class DrinkManager {
	public static DrinkManager getInstance() {
        return new DrinkManager(); // Fixed the method name to lowercase "danhBA"
    }

 public static List<Drink> findAll(){
	 List<Drink> drinks = new ArrayList<>();
	 String query= "SELECT \"Name\", \"Price\", \"Image\" FROM public.\"Drink\"";
	 try {
		Connection connection = Connect.getConnection();
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String name = rs.getString("Name");
			String price = rs.getString("Price");
			byte[] image = rs.getBytes("Image");
			Drink drink = new Drink(name, price,image);
			drinks.add(drink);		
		}
		Connect.closeConnection(connection);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return drinks;
 }
 public static void addDrink(String name, String price, byte[] image) {
	 try {
		 Connection con = Connect.getConnection(); 
		 String sql = "INSERT INTO \"Drink\"(\"Name\", \"Price\", \"Image\") VALUES (?, ?, ?);";

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