package core;

import java.util.Random;

public class Task3_4 {

	public static void main(String[] args) {
		Random generator = new Random();
		int rndNumber1 = generator.nextInt(100);
		System.out.println("Random number_1 = " + rndNumber1);
		System.out.println(rndNumber1 + " raised to the power of 3 = " + powerOf3(rndNumber1));
	}
	public static int powerOf3(int a) {
		int result = (int)Math.pow(a, 3);
		return result;
	}

}
