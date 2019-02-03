package core;

import java.util.Scanner;

public class Task2_10 {

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
			
		//10  проверить, является ли массив возрастающей последовательностью (каждое следующее число больше предыдущего)

		 boolean flag = true;
	        for (int i = 1; i < array.length; i++){
	             if (array[i] <= array[i-1]){
	                flag = false;
	                break;
	            }
	        }
	        if(flag){
	            System.out.println("Массив является возрастающей последовательностью (каждое следующее число больше предыдущего)");
	        } else {
	            System.out.println("Массив не является строго возрастающей последовательностью (каждое следующее число должно быть больше предыдущего)");
	        }
	}

}
