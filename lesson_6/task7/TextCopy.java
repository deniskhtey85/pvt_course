package core;

import java.util.Scanner;

public class TextCopy {
	
	public static String[] inputTextCopy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input total string number: ");
		int stringCounter = scanner.nextInt();
		scanner.nextLine();
		String[] stringArray = new String[stringCounter];
		for (int i = 0; i < stringCounter; i++) {
			System.out.println("Input " + (i+1) + " string: ");
			stringArray[i] = scanner.nextLine();
		}
		scanner.close();
		return stringArray;
	}
	
	public static void printTextCopy(String[] sentencies) {
		for (String out : sentencies) {
			System.out.println(out);
		}
	}

}
