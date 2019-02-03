package core;

import java.util.Random;

public class Task3_2 {

	public static void main(String[] args) {
		Random generator = new Random();
		int rndNumber1 = generator.nextInt(100);
		System.out.println("Random number_1 = " + rndNumber1);
		int rndNumber2 = generator.nextInt(100);
		System.out.println("Random number_2 = " + rndNumber2);
		
		System.out.println("Is the number " + rndNumber1 + " even? " + evenNumber(rndNumber1));
		System.out.println("Is the number " + rndNumber2 + " even? " + evenNumber(rndNumber2));

	}
	public static boolean evenNumber(int a){
		return (a%2==0);
	}
}
