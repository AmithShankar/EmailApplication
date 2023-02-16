package emailapp;

import java.sql.*;

public class EmailJDBC {
public static void main(String[] args) throws SQLException{

		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/email";
		String user = "email";
		String pass = "email";
		
		Email em = new Email();
		
		try{
			
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			// 1. Get a Connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String str = ("INSERT INTO email VALUES('" + em.getFirstName() + "','" + em.getLastName() + "','"
										+ em.getPassword() + "','" + em.getDepartment() + "','" + em.getEmail() +"');");
			System.out.println(str);
			myStmt.executeUpdate(str);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(myRs!=null){
				myRs.close();
			}
		}
		
	}
}
