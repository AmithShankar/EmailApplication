package emailapp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Email em = new Email();
			
		System.out.println(em.showInfo());
	}

}
