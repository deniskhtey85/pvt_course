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
			
		//10  ���������, �������� �� ������ ������������ ������������������� (������ ��������� ����� ������ �����������)

		 boolean flag = true;
	        for (int i = 1; i < array.length; i++){
	             if (array[i] <= array[i-1]){
	                flag = false;
	                break;
	            }
	        }
	        if(flag){
	            System.out.println("������ �������� ������������ ������������������� (������ ��������� ����� ������ �����������)");
	        } else {
	            System.out.println("������ �� �������� ������ ������������ ������������������� (������ ��������� ����� ������ ���� ������ �����������)");
	        }
	}

}
