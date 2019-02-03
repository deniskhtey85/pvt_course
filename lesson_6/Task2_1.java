package core;

import java.util.Scanner;

public class Task2_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int size;
	    System.out.print("Enter array size:\n> ");
	    size = input.nextInt();
	    int[] array = new int[size];
	      for (int i = 0; i < size; ++i) {
	         array[i] = input.nextInt();
	      }
	      
	    //1 Displaying all the array's elements in direct and reverse order   
	    // 1.1 Direct order
		    System.out.println("Displaying all the array's elements in direct order:");
		    int i = 0;
		    	while ( i < array.length)
		    	{
		    		System.out.println(array[i]);
		    		i++;
		    	}
/*				for (int i = 0; i < array.length; i++) { 
					System.out.println(array[i]);
				} */
		// 1.2 Reverse order
			System.out.println("Displaying all the array's elements in reverse order:");	
				for(int b = array.length - 1; b >= 0; b--) {
					System.out.println(array[b]);
				}
		input.close();
	}

}
