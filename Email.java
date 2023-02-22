package emailapp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity;
	private int passwordLength;
	private String companySuffix = "ttg.com";
	
	Scanner scan = new Scanner(System.in);
	
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
		setMailBoxCapacity();
	}
	
	// Set firstName and lastName
	public String setFirstName(){
		System.out.println("Enter your First Name:");
		while(true){
		String firstName = scan.next();
		String regex = "^[a-zA-Z]{1,50}";
		Pattern pat = Pattern.compile(regex);
		if (pat.matcher(firstName).matches()==true){
			return firstName;
		}
		System.out.println("The input you have entered is Invalid\nEnter valid name");
		}
	}

	public String setLastName(){
		System.out.println("Enter your Last Name:");
		while(true){
			String lastName = scan.next();
			String regex = "^[a-zA-Z]{1,50}";
			Pattern pat = Pattern.compile(regex);
			if (pat.matcher(lastName).matches()==true)
				return lastName;
			System.out.println("The input you have entered is Invalid\nEnter valid name");
			}
	}

	// Ask for department 
	private String setDepartment(){
		System.out.println("New Worker: " + firstName + " " + lastName + "\nDepartment Codes:\n0. None\n1. Sales\n"
				+ "2. Development\n3. Accounting\nEnter department code:");
		while(true){
			int deptChoice = scan.nextInt();
			switch(deptChoice){
			case 1 :	return "sales";
			case 2 :	return "dev";
			case 3 :	return "acc";
			case 0 :	return "";
			default :   System.out.println("Enter valid choice:");
						break;
			}
		}
	}

	// Change email
	private void changeEmail(){
		System.out.println("Do you want to enter a alternate email?\n1. Yes\n2. No\nEnter your choice:");
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
			System.out.println("Enter valid choice:\n1. Yes\n2. No");
		}
	}

	// Generate a random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%";
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
		System.out.println("Do you want to change password?\n1. Yes\n2. No\nEnter your choice:");
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
			System.out.println("Enter valid choice:\n1. Yes\n2. No");
		}
	}

	// Set mail capacity
	public void setMailBoxCapacity(){
		if(department == "sales"){
			this.mailBoxCapacity = 200;
		}
		else if(department == "dev"){
			this.mailBoxCapacity = 300;
		}
		else if(department == "acc"){
			this.mailBoxCapacity = 400;
		}
		else{
			this.mailBoxCapacity = 500;
		}

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
}
