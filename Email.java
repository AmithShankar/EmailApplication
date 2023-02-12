package emailapp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int passwordLength;
	private String companySuffix = "ttg.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName){
		Scanner scan = new Scanner(System.in);
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Combine elements to generate email
		if(department!=""){
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		}
		else{
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
		}
		System.out.println("Your email is: " + this.email);
		
		// Alternate Email
		changeEmail();
		
		// Call a method that returns a random password
		this.password = randomPassword(passwordLength);
		System.out.println("Your password is: " + this.password);
		
		// Set mail box capacity
		
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
	
	// Change email
	private void changeEmail(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to enter a alternate email? \n1 for Yes\n2 for No\nEnter your choice:");
		while(true){
			int choice = scan.nextInt();
			if(choice == 1){
				System.out.println("Enter your alternate email:");
				// Checking validity of email
				while(true){
					String alt = scan.next();
					String regex = "^(.+)@(.+)$";
					Pattern pat = Pattern.compile(regex);
			        if (pat.matcher(alt).matches()==true){
			           setAlternateEmail(alt);
			           System.out.println("Your email is: " + email);
			           break;
			        }
			        System.out.println("The input you have entered is Invalid\nEnter valid alternate email");
				}
				break;
			}
			else if(choice == 2){
				System.out.println("Your email is: " + email);
				break;
			}
			System.out.println("Invalid option");
			System.out.println("Enter valid choice:\n1 for Yes\n2 for No");
		}
	}
	
	// Generate a random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Password Length:");
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
		this.email = altEmail;
	}
	
	// Change the password
	public void changePassword(String password){
		this.password = password;
	}
	
	// Get methods
	public int getMailBoxCapacity(){
		return mailBoxCapacity;
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