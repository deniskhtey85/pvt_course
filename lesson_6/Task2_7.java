package core;

import java.util.Scanner;

public class Task2_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int size;
	    System.out.print("Enter array size:\n> ");
	    size = input.nextInt();
	    int[] array = new int[size];
	      for (int i = 0; i < size; ++i) {
	         array[i] = input.nextInt();
	      }
	    input.close();
	    
	    //7
        //пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д.
        System.out.println("Пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д.");
        int temp; 	// temporary number of array's element
        for (int i = 0, b = array.length - 1; i < b; i++, b--){ // b = the last array element's number
            temp = array[i];
            array[i] = array[b];
            array[b] = temp;
        }
        for (int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }

	}

}
