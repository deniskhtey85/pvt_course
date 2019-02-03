package core;

import java.util.Scanner;

public class Task2_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int size;
	    System.out.print("Enter array size:\n> ");
	    size = input.nextInt();
	    int[] array = new int[size];
	      for (int i = 0; i < size; ++i) {
	         array[i] = input.nextInt();
	      }
	    int[] randomArray = new int[size];  
	    for (int i = 0; i < randomArray.length; i++) { 
			 randomArray[i] = (int)(Math.random() * 10);
			 }
	    input.close();
	    
	    System.out.println("Every 3rd element of the array multiplied by 2: ");  
	    int i = 2;
	    while (i < array.length) 
	    {
	    	array[i] = array[i] * 2;
	    	i +=3;
	    }
	   	for (i = 0; i < array.length; i++) { // вывести все элементы массива в прямом порядке
			System.out.println(array[i]);
		}

	}

}
