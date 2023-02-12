package emailapp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your First Name and Last Name");
		Email em1 = new Email(scan.next(),scan.next());
		
		System.out.println(em1.showInfo());
	}

}
