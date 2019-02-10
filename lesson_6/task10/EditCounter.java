package core;

import java.util.Scanner;

public class EditCounter {

	static int editCounter = 0;

	Scanner scanner = new Scanner(System.in);

	public EditCounter() {
		do {
			System.out.println("Please enter a positive integer number!");
			while (!scanner.hasNextInt()) {
				System.out.println("That not a vaild number! Please enter a positive integer number");
				scanner.next();
			}
			editCounter = scanner.nextInt();
		} while (editCounter <= 0);
		System.out.println("Thank you! n = " + editCounter
				+ "; Each n-th letter of each word will be replaced with the symbol “%”.");
	}

	public void getEditCounter() {
		System.out.println(
				"n = " + editCounter + "; Each n-th letter of each word will be replaced with the symbol “%”.");
	}
	
	

}
