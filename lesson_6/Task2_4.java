package core;

import java.util.Scanner;

public class Task2_4 {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
		    int size;
		    System.out.print("Enter array size:\n> ");
		    size = input.nextInt();
		    
		    int[] randomArray = new int[size];  
		    for (int i = 0; i < randomArray.length; i++) { 
				 randomArray[i] = (int)(Math.random() * 10);
				 }
		    input.close();
		    
		  //4
		    System.out.println("Displaying all the randomArray's elements in direct order:");
			for (int i = 0; i < randomArray.length; i++) { // вывести все элементы массива в прямом порядке
				System.out.println(randomArray[i]);
			}
			
			System.out.println("Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести сообщение, что их нет");
			int count = 0;								// Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести сообщение, что их нет
			for (int i = 0; i < randomArray.length; i++) {
				if (randomArray[i] == 0) {
					
				//	System.out.println("Нулевой элемент: " + i);
					count++;
				}
			 }
			if (count == 0)
				System.out.println("Нулевых элементов нет");
			else System.out.println("Количество нулевых элементов = " + count);

	}

}
