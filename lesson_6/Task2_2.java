package core;

import java.util.Scanner;

public class Task2_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int size;
	    System.out.print("Enter array size:\n> ");
	    size = input.nextInt();
	    int[] array = new int[size];
	      for (int i = 0; i < size; ++i) {
	         array[i] = input.nextInt();
	      }
	     
	    //2 A product of all array's elements  
	    System.out.println("A product of all array's elements:");	
			int product = 1;
		      for (int i = 0; i < size; ++i){
		            product *= array[i];
		         }
		      System.out.println(product);	  
	   input.close();
	}

}
