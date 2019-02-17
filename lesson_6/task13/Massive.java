package core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Massive {

	int[] array;
	int size;
	int sumOfElements;
	int multOfElements = 1;

	public Massive() {
	}

	public void inputSize() {
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Input array size(positive integer number > 0): ");
			try {
				size = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + " You entered not a number. Try again. ");
				size = 0;
			} finally {
				System.out.println("Array size is: " + size);
			}
		}

		while (size <= 0);
	}

	public int[] devideEachElementByN(int n) {
		int[] result = array;
		try {
			for (int i = 0; i < array.length; i++) {
				result[i] = array[i] / n;

			}
		} catch (ArithmeticException e) {
			System.out.println("Exceptiont : " + e.getMessage());
		} finally {
			System.out.println("Actual value of");
		}
		return result;
	}

	public int getElementByIndex(int i) {
		try {
			return this.array[i];
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("Element with index " + i + " is not found");
			return this.array.length;
		}
	}

	public int getElementByIndex2(int i) {
		try {
			return this.array[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Element with index " + i + " is not found");
			return this.array.length;

		} catch (NullPointerException e) {
			System.out.println("Element with index " + i + " is not found");
			return this.array.length;
		}
	}

	public int[] fillArrayRandomNumbers() {
		array = new int[size];
		int min = -100;
		int max = 100;
		for (int i = 0; i < array.length; i++) {
			array[i] = min + (int) (Math.random() * (max - min));
		}
		printArray(array);
		return array;
	}

	public static void printArray(int[] array) {
		System.out.println("Your array is:");
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}

	public int calcSumOfElements() {
		for (int x : array) {
			this.sumOfElements += x;
		}
		return sumOfElements;
	}

	public void printSumOfElements() {
		calcSumOfElements();
		System.out.println("Sum of all array elements = " + sumOfElements);
	}

	public int calcMultOfElements() {
		for (int x : array) {
			this.multOfElements *= x;
		}
		return multOfElements;
	}

	public void printMultOfElements() {
		calcMultOfElements();
		System.out.println("Mult of all array elements = " + multOfElements);
	}

}
