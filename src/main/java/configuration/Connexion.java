package configuration;



import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	public static Connection getConnection() throws URISyntaxException, SQLException {
	    String dbUrl = System.getenv("JDBC_DATABASE_URL");
	    return DriverManager.getConnection(dbUrl);
	}
}
