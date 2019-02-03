package core;

public class Massive {
	
	public void printMassiveAsLine(int[] anyArrayToPrint) {
	System.out.println("Displaying all the array's elements in direct order:");
		for (int i = 0; i < anyArrayToPrint.length; i++) { 
			System.out.print(anyArrayToPrint[i] + " ");
		}
		System.out.println();
	}
	
	public void printReverseMassiveAsLine(int[] anyArrayToPrint) {
	System.out.println("Displaying all the array's elements in reverse order:");
		for (int i = anyArrayToPrint.length - 1; i >= 0; i--) { 
			System.out.print(anyArrayToPrint[i] + " ");
		}
		System.out.println();
	}
	
	public int getSumOfElements(int[] anyArrayToSumElements) {
		int sum = 0;
		for (int i = 0; i < anyArrayToSumElements.length; i++) { 
			sum += anyArrayToSumElements[i];
		}
		return sum;
	}
	
	public int[] multiplyBy3(int[] anyArrayMultiplyBy3) { // multiply all array's elements by 3
		int[] resultArray = new int[anyArrayMultiplyBy3.length];
		for (int i = 0; i < anyArrayMultiplyBy3.length; i++) { 
			resultArray[i] = anyArrayMultiplyBy3[i] * 3;
		}
		return resultArray;
	}
	
}
