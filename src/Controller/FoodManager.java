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
		Connection connection = Connect.getConnection();
		Statement st = connection.createStatement();
		
		String query= "SELECT * FROM \"Food\"";
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String name = rs.getString("Name");
			String price = rs.getString("Price");
			byte[] image = rs.getBytes("Image");
			
			Food food = new Food(name, price,image);
			foods.add(food);
		}
		Connect.closeConnection(connection);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return foods;
 }
public static void addFood(String name, String price, byte[] image) {
	try {
		Connection connection = Connect.getConnection();
		String sql = "INSERT INTO public.\"Food\" (\"Name\", \"Price\", \"Image\") VALUES (?, ?, ?);";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2,price);
		st.setBytes(3, image);
		int rows = st.executeUpdate();
		if (rows >0) {
			System.out.println("Inserted successfully!");
		}
		Connect.closeConnection(connection);
	} catch (SQLException e) {
		// TODO: handle exception
        e.printStackTrace();

	}
}
}
