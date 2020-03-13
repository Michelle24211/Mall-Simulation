
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CardHolderDatabase {

	static Connection connection = null;
	static String databaseName = "";
	static String driverName =  "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?serverTimezone=EST5EDT";

	static String username = "root";
	static String password = "9172988869";

	public static Connection getConnection() {
		if(connection == null ) {
			try {
	            Class.forName(driverName);
	            try {
	            	connection = DriverManager.getConnection(url, username, password);
	            } catch (SQLException ex) {
	                System.out.println("Failed to create the database connection : " + ex);
	            }
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Driver not found.");
	        }
		}
		return connection;
	}

	public static void logout(){
        try {
            if (connection != null) {
            	connection.close();
            	connection = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
