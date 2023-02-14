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
	
	// Constructor
	public Email(){
		
		// Call getFirstName and getLastName
		this.firstName = setFirstName();
		this.lastName = setLastName();
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Combine elements to generate email
		if(department!=""){
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + '@' + department + "." + companySuffix;
		}
		else{
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + '@' + department + companySuffix;
		}
		System.out.println("Your email is: " + this.email);
		
		// Alternate Email
		changeEmail();
		
		// Call a method that returns a random password
		this.password = randomPassword(passwordLength);
		System.out.println("Your password is: " + this.password);
		
		// Change Password
		changePassword();
		
		// Set mail box capacity
		
	}
	
	// Set firstName and lastName
		public String setFirstName(){
			System.out.println("Enter your First Name:");
			Scanner scan = new Scanner(System.in);
			String firstName = scan.next();
			return firstName;
		}
		
		public String setLastName(){
			System.out.println("Enter your Last Name:");
			Scanner scan = new Scanner(System.in);
			String lastName = scan.next();
			return lastName;
		}
		
	// Ask for department 
	private String setDepartment(){
		System.out.println("New Worker: " + firstName + "\nDepartment Codes:\n1 for Sales\n2 for Development"
				+ "\n3 for Accounting\n0 for none\nEnter department code: ");
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
				System.out.println("The Enter your alternate email:");
				// Checking validity of email
				while(true){
					String alt = scan.next();
					String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
							+ "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
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
		System.out.println("Enter Password Length(between 8 to 20):");
		while(true){
			length = scan.nextInt();
			if(length>=8 && length<=20){
				char[] password = new char[length];
				for(int i=0; i<length; i++){
					int rand = (int) (Math.random() * passwordSet.length()); // Selects a random character in passwordSet
					password[i] = passwordSet.charAt(rand); // The character selected will be placed in i(th) position of password
				}
				return new String(password); // Converts set of characters into String and returns
			}
			System.out.println("Invalid length detected\nEnter valid length:");
			
		}
	}
	
	// Change Password
	private void changePassword(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to change password? \n1 for Yes\n2 for No\nEnter your choice:");
		while(true){
			int choice = scan.nextInt();
			if(choice == 1){
				System.out.println("Password Requirement\nMUST contain at least 8 characters and at most 20 characters"
						+ "\nMUST contain at least one uppercase letter"
						+ "\nMUST contain at least one lowercase letter"
						+ "\nMUST contain at least one number"
						+ "\nMUST contain at least one special character (@#$%^&-+=())"
						+ "\nNO spaces allowed"
						+ "\nEnter your password password:");
				// Checking validity of password
				while(true){
					String alt = scan.next();
					String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
					Pattern pat = Pattern.compile(regex);
			        if (pat.matcher(alt).matches()==true){
			           setPassword(alt);
			           System.out.println("Your password is: " + password);
			           break;
			        }
			        System.out.println("The input you have entered is Invalid\nEnter valid password:");
				}
				break;
			}
			else if(choice == 2){
				System.out.println("Your password is: " + password);
				break;
			}
			System.out.println("Invalid option");
			System.out.println("Enter valid choice:\n1 for Yes\n2 for No");
		}
	}
	
	// Set mail capacity
	public void setMailBoxCapacity(int capacity){
		this.mailBoxCapacity = capacity;
		
	}
	
	// Set alternative email
	public void setAlternateEmail(String altEmail){
		this.email = altEmail;
	}
	
	// set password
	public void setPassword(String password){
		this.password = password;
	}
	
	// Get methods
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public int getMailBoxCapacity(){
		return mailBoxCapacity;
	}
		
	public String getEmail(){
		return email;
	}
	
	// Display
	public String showInfo(){
		return "DISPLAY NAME: " + firstName + " " + lastName + 
			"\nCOMPANY EMAIL: " + email +
			"\nMAILBOX CAPACITY: " + mailBoxCapacity + " mb";
	}
}
