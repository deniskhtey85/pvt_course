package core;

import java.util.Scanner;

public class Task2_11 {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	    int size;
	    System.out.print("Enter array size:\n> ");
	    size = input.nextInt();
	    double[] array = new double[size];
	      for (int i = 0; i < size; ++i) {
	         array[i] = input.nextInt();
	      }
	    input.close();
				
		//11 заменить все элементы массива на полусумму соседних элементов //поменять тип
	    System.out.println("заменить все элементы массива на полусумму соседних элементов");
	    double temp1, temp2; 	// temporary number of array's element
	    double[] tempArray = new double[size];
	    for (int i = 1, b = array.length - 1; i < b; i++){ // b = the last array element's number
	       temp1 = array[i - 1];
	       temp2 = array[i + 1];
	       tempArray[i] = (temp1 + temp2) / 2;
	     }
	     for (int i = 0; i < array.length; i++){
	    	 tempArray[0] = array[0];
	    	 tempArray[array.length - 1] = array[array.length - 1];
	        System.out.println(tempArray[i]);
	     }  
	}
}
