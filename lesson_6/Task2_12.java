package core;

import java.util.Scanner;

public class Task2_12 {

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
	    
	    System.out.println("Displaying all the array's elements in direct order:");
		for (int i = 0; i < array.length; i++) { // ������� ��� �������� ������� � ������ �������
			System.out.println(array[i]);
		}
	    
	    //12
	    System.out.println("���������� �������� ��� �������� ������ �� 2 ������� (1-� ������� ������ 3-�, 2-� ����� 4-� � �.�.)");
	    int[] resultArray = new int[size];
		int n = 2;
		for (int i = 0, k = size - n; i < size; i++, k++) {
			if (k == size) {
				k = 0;
			}
			resultArray[i] = array[k];
			System.out.println(resultArray[i]);
		}

	}

}
