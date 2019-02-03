package core;

import java.util.Scanner;

public class Task2_6 {

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
		//6 пройти по массиву и поменять местами каждые 2 соседних элемента
		System.out.println("Поменять соседние элементы");
			for(int a, i = 1; i < array.length; i += 2) {
		        a = array[i];
		        array[i] = array[i-1];
		        array[i-1] = a;
		     }
		     for (int i=0; i < array.length; i++){
		        System.out.println(array[i]);
		     }
	}

}
