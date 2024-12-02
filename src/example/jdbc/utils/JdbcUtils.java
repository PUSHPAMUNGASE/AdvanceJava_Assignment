package example.jdbc.utils;



import java.sql.Connection;

import java.sql.DriverManager;

public class JdbcUtils {
	//this is a utility class for obtaining a Connection and returning the same
	public static Connection getConnection() throws Exception{
		String url="jdbc:mysql://localhost:3306/Assignment_Pushpa";
		String uid="root";
		String pwd="password";
		Connection dbConnection= DriverManager.getConnection(url,uid,pwd);
		return dbConnection;
	}

}
