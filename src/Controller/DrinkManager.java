package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.Connect;
import Model.Drink;
import Model.Food;

public class DrinkManager {
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
			String type = rs.getString("Type");
			Drink drink = new Drink(name, price,image);
			drinks.add(drink);		
		}
		Connect.closeConnection(connection);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return drinks;
 }
}