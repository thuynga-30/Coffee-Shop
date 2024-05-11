package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {
		Connection c = null ;
		
		
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			String url = "jdbc:postgresql://localhost:5432/DACS" ;
			String username= "postgres" ;
			String password = "123" ;
			
			
			c = DriverManager.getConnection(url,username,password);
		
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
		return c ;
	}
		
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {}
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	public static Connect getInstance() {
		// TODO Auto-generated method stub
		return new Connect();
	}

}
