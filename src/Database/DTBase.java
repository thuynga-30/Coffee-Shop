package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DTBase {
	 public static String getTotal() {
	        String sql = "SELECT SUM(\"Total\") FROM public.\"Purchase\"";
	        try {
	            Connection conn = Connect.getConnection();
	            PreparedStatement pst = conn.prepareStatement(sql);
	            ResultSet rSet = pst.executeQuery();
	            if (rSet.next()) {
	                return rSet.getString(1); // Get the result from the first column
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return "0"; // Return "0" if there is an error or no result

	 }
}
