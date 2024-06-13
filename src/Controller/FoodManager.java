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
import Model.Food;

public class FoodManager {
	public static FoodManager getInstance() {
	        return new FoodManager(); // Fixed the method name to lowercase "danhBA"
	    }
 public static List<Food> findAll(){
	 List<Food> foods= new ArrayList<>();
	
	 try {
		Connection conn = Connect.getConnection();
		Statement st = conn.createStatement();
		
		String query= "SELECT * FROM \"Food\"";
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String name = rs.getString("Name");
			String price = rs.getString("Price");
			byte[] image = rs.getBytes("Image");
			Food food = new Food(name, price,image);
			foods.add(food);
		}
		Connect.closeConnection(conn);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return foods;
 }
//Delete
/*public static void delete(String name) {
		String sql="DELETE FROM public.\"Food\"	WHERE \"Name\"='"+name+"';";
		try {
			Connection conn = Connect.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}*/
 public static void addFood(String name, String price, byte[] image) {
	 try {
		 Connection con = Connect.getConnection(); 
		 String sql = "INSERT INTO \"Food\"(\"Name\", \"Price\", \"Image\") VALUES (?, ?, ?);";

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