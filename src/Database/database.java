package Database;

import Model.Food;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class database {

    static String driver = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/DACS";
    static String username = "postgres";
    static String password = "123";
 public static database getInstance() {
        return new database(); // Fixed the method name to lowercase "danhBA"
    }
   
   public ArrayList<Food> selectAll() {
        ArrayList<Food> ketqua = new ArrayList<>();
        try {
            // Establish a database connection
            Connection con = JDBCUtil.getConnection();

            // Create a statement object
            Statement st = con.createStatement();

            // Execute the SQL query
            String sql = "SELECT * FROM \"Food\"";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
               String name = rs.getString("Name");
               String price = rs.getString("Price");
               byte[] image = rs.getBytes("Image");
               String type = rs.getString("Tpye");
               Food foods = new Food(name, price, image, type);
               ketqua.add(foods);
            }

            // Close the connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketqua;
    }

}
