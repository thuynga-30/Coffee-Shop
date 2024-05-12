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
 public static List<Food> findAll(){
	 List<Food> foods= new ArrayList<>();
	 String query= "SELECT \"Name\", \"Price\", \"Image\" FROM public.\"Food\"";
	 try {
		Connection connection = Connect.getConnection();
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String name = rs.getString("Name");
			String price = rs.getString("Price");
			byte[] image = rs.getBytes("Image");
			String type = rs.getString("Type");
			Food food = new Food(name, price,image,type);
			foods.add(food);
		}
		Connect.closeConnection(connection);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return foods;
 }
public static void addFood(String name, String price, byte[] image, String type) {
	try {
		Connection connection = Connect.getConnection();
		String sql = "INSERT INTO public.\"Food\" (\"Name\", \"Price\", \"Image\", \"Type\") VALUES (?, ?, ?, ?);";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2,price);
		st.setBytes(3, image);
		st.setString(4, type);
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
