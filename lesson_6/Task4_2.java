package core;

import java.util.Scanner;

public class Task4_2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		 System.out.print("Enter array size:\n> ");
		  int size = input.nextInt();
			    int[] array = new int[size];
			    System.out.print("Enter array's elements:\n> "); 
			    for (int i = 0; i < array.length; ++i) {
			       array[i] = input.nextInt();
			    }
		input.close();	
			
	    Massive mas = new Massive();
	    mas.printMassiveAsLine(array);
	    mas.printReverseMassiveAsLine(array);
	    System.out.println("Sum of all array's alements is: " + mas.getSumOfElements(array));
	    mas.multiplyBy3(array);
	    mas.printMassiveAsLine( mas.multiplyBy3(array));
	    System.out.println("Sum of all mult b3 array's elements: " + mas.getSumOfElements(mas.multiplyBy3(array)));
	    mas.printMassiveAsLine(array);
	     	    
	}
}
