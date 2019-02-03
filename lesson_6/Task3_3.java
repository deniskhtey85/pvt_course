package core;

import java.util.Random;

public class Task3_3 {

	public static void main(String[] args) {
		Random generator = new Random();
		int rndNumber1 = generator.nextInt(100);
		System.out.println("Random number_1 = " + rndNumber1);
		System.out.println(rndNumber1 + " raised to the power of 2 = " + powerOf2(rndNumber1));
	}
	public static int powerOf2(int a) {
		int result = (int)Math.pow(a, 2);
		return result;
	}
}
