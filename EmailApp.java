package emailapp;

import java.sql.*;
import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/email";
		String user = "email";
		String pass = "email";

		try(Scanner scan = new Scanner(System.in)){

			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");  

			// 1. Get a Connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);

			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			while(true){
				System.out.println("1. Create New Worker\n2. Display details of all workers\nEnter your choice:");
				int choice = scan.nextInt();
				switch(choice){
				case 1:
					Email em = new Email();

					// 3. Execute SQL query
					String str = ("INSERT INTO email VALUES('" + em.getFirstName() + "','" + em.getLastName() + "','"
							+ em.getPassword() + "','" + em.getDepartment() + "','"
							+ em.getEmail() +"','" + em.getMailBoxCapacity() + "');");
					myStmt.executeUpdate(str);
					System.out.println("Successfully inserted into Database");
					break;
				
				case 2:
					// 3. Execute SQL query
					String st = ("SELECT * FROM email;");
					myRs = myStmt.executeQuery(st);
					while (myRs.next()) {
						String firstName = myRs.getString("firstname");
						String lastName = myRs.getString("lastname");
						String department = myRs.getString("department");
						String email = myRs.getString("email");
						int mailBoxCapacity = myRs.getInt("mailboxcapacity");
						System.out.println(firstName + " " + lastName + " " + department + " " + email + " " + mailBoxCapacity);
					}
					break;	
					
				default:
					System.out.println("Invalid Input");
				}
			}
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
