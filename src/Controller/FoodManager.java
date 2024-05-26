package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public static void delete(Food food) {
		String sql="DELETE FROM public.\"Food\"	WHERE \"Name\"='"+food.getName()+"';";
		try {
			Connection conn = Connect.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}