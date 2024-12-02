//package example1.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class SimpleSELECTQueryExample {
//
//	public static void main(String[] args) {
//	//load the driver
//		String driverClassName="com.mysql.cj.jdbc.Driver";
//		String url="jdbc:mysql://localhost:3306/zomato";
//		String uid="root";
//		String pwd="password";
//		Connection dbConnetion=null;
//		Statement stmt=null;
//		ResultSet rs=null;
//		try {
//			Class.forName(driverClassName);
//			System.out.println("Driver loaded.");
//			
//			//establish connection
//			 dbConnetion=DriverManager.getConnection(url,uid,pwd);
//			System.out.println("Connected to DB");
//			//Obtain some statement 
//			 stmt=dbConnetion.createStatement();
//			System.out.println("Obtained the statement");
//			
//			String SQLQuery="select  reat_name ,rest_branch_count ,rest_cuisine from  restaurant_master";
//			 rs=stmt.executeQuery(SQLQuery);
//			System.out.println("Excuted SQL SELECT query and obtained ResultSet");
//			
//			//in case of SELECT query, obtain ResultSet and perform navigation
//			while(rs.next()) {
//				String restaurantName=rs.getString(1);
//				int branchCount=rs.getInt(2);
//				String restaurantCuisine=rs.getString(3);
//				System.out.println(restaurantName+" "+branchCount+" "+restaurantCuisine+" ");
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//		
//			//e.printStackTrace();
//		System.out.println("Unable to load the driver");
//		}
//		
//		finally {
//			//closing all the resources
//			try {
//				
//				rs.close();
//				stmt.close();
//				dbConnetion.close();
//			} catch (SQLException e) {
//			
//				e.printStackTrace();
//			}
//			
//		}
//		
//		
//		
//
//	}
//
//}
