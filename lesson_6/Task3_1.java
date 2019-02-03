package core;

import java.util.Random;

public class Task3_1 {

	public static void main(String[] args) {
		Random generator = new Random();
		int rndNumber1 = generator.nextInt(100);
		System.out.println("Random number_1 = " + rndNumber1);
		int rndNumber2 = generator.nextInt(100);
		System.out.println("Random number_2 = " + rndNumber2);
		
		System.out.println("Min number is: " + returnMinNumber(rndNumber1, rndNumber2));
	}	
		public static int returnMinNumber(int a, int b) {
			if ( a > b) {
				return b;
			} else {
				return a;
			}
		}
}
