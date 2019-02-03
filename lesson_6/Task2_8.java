package core;

import java.util.Scanner;

public class Task2_8 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	    int size;
	    System.out.print("Enter array size:\n> ");
	    size = input.nextInt();
	    int[] randomArray = new int[size];  
	    for (int i = 0; i < randomArray.length; i++) { 
			 randomArray[i] = (int)(Math.random() * 100);
			 }
	    input.close();
	    
	  //8
	    System.out.println("Displaying all the array's elements in direct order:");
		for (int i = 0; i < randomArray.length; i++) { 
			System.out.println(randomArray[i]);
		}
	  	System.out.println("Найти максимальный и минимальный элемент");
	  	int indexOfMin = 0;
	  	int indexOfMax = 0;
	  	for (int i = 0; i < randomArray.length; i++) {
	  		if (randomArray[i] > randomArray[indexOfMax]){
	  		    indexOfMax = i;
	  		    }
	  		    else if (randomArray[i] < randomArray[indexOfMin])
	  		    {
	  		       indexOfMin = i;
	  		    }	
	  		}
	  		System.out.println("Значение максимального элемента : " + randomArray[indexOfMax] + "; значение минимального элемента: " + randomArray[indexOfMin]);

	}

}
