package core;

public class Massive {

	public int[] array;
	int size;

	public Massive() {
	}

	public void printMassive(int[] array) {
		System.out.println("Your array is:");
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}

	public int[] getReverseMassive(int[] array) {
		int reverseArray[] = array.clone();
		for (int i = 0; i < array.length; i++) {
			reverseArray[i] = array[array.length - 1 - i];
		}
		return reverseArray;
	}

	public int getSumOfElements(int[] array) {
		int summ = 0;
		for (int i = 0; i < array.length; i++) {
			summ += array[i];
		}
		return summ;
	}

	public int getMultiplyOfElements(int[] array) {
		int product = 1;
		for (int i = 0; i < array.length; i++) {
			product *= array[i];
		}
		return product;
	}

	public int[] multiplyByN(int[] array, int n) {
		for (int i = 0; i <= array.length - 1; i++) {
			array[i] *= n;
		}
		return array;
	}

	public int[] devideByN(int[] array, int n) {
		for (int i = 0; i <= array.length - 1; i++) {
			array[i] = (int) (array[i] / n);
		}
		return array;
	}

	public int[] multipleBy2ElementWithIndexN(int[] array, int n) {
		for (int i = 1; i <= array.length; i++) {
			if (i % n == 0)
				array[i - 1] *= 2;
		}
		return array;
	}

}
