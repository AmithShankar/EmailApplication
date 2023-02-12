package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int passwordLength;
	private String alternateEmail;
	private String companySuffix = "ttg.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(passwordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	// Ask for department 
	private String setDepartment(){
		System.out.println("New Worker: " + firstName + "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner scan = new Scanner(System.in);
		int deptChoice = scan.nextInt();
		if(deptChoice == 1){
			return "sales";
		}
		else if(deptChoice == 2){
			return "dev";
		}
		else if(deptChoice == 3){
			return "acc";
		}
		else {
			return "";
		}
	}
	
	// Generate a random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Password Length");
		length = scan.nextInt();
		char[] password = new char[length];
		for(int i=0; i<length; i++){
			int rand = (int) (Math.random() * passwordSet.length()); // Selects a random character in passwordSet
			password[i] = passwordSet.charAt(rand); // The character which is selected will to placed in the i(th) position of password
		}
		return new String(password); // Converts set of characters into String and returns
	}
	
	// Set the mail capacity
	public void setMailBoxCapacity(int capacity){
		this.mailBoxCapacity = capacity;
		
	}
	
	// Set the alternative email
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password){
		this.password = password;
	}
	
	// Get methods
	public int getMailBoxCapacity(){
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail(){
		return alternateEmail;
	}
	
	public String getPassword(){
		return password;
	}
	
	// Display
	public String showInfo(){
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailBoxCapacity + " mb";
	}
}
