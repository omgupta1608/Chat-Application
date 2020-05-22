import java.sql.*;
public class DBConnection {
	
	private static Connection connect;
	private static String host = config.host;
	private static String user = config.username;
	private static String passwd = config.passwd;

	public static Connection makeConnection() throws Exception {
		
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://" + host + "/java-chat-app?"
		              + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&" + "user=" + user + "&password=" + passwd );

		    } catch (Exception e) {
		      throw e;
		    } 
		    
		    return connect;

	}
		
}
