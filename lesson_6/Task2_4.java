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
			for (int i = 0; i < randomArray.length; i++) { // ������� ��� �������� ������� � ������ �������
				System.out.println(randomArray[i]);
			}
			
			System.out.println("����� � ������� ���������� ������� ���������. ���� ������� ��������� ��� - ������� ���������, ��� �� ���");
			int count = 0;								// ����� � ������� ���������� ������� ���������. ���� ������� ��������� ��� - ������� ���������, ��� �� ���
			for (int i = 0; i < randomArray.length; i++) {
				if (randomArray[i] == 0) {
					
				//	System.out.println("������� �������: " + i);
					count++;
				}
			 }
			if (count == 0)
				System.out.println("������� ��������� ���");
			else System.out.println("���������� ������� ��������� = " + count);

	}

}
