package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}