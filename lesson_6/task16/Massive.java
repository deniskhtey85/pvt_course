package core;

public class Massive {

	public int[] createRandomMassive(int size) {
		int[] array = new int[size];
		int startValue = 0;
		int endValue = 10;
		for (int i = 0; i < array.length; i++) {
			array[i] = startValue + (int) (Math.random() * (endValue - startValue));
		}
		return array;
	}

	public boolean checkAscSort(int[] array) {
		boolean temp = true;
		int i = 0;
		while (temp && i < array.length - 1) {
			if (array[i] - array[i + 1] > 0) {
				temp = false;
			}
			i++;
		}
		return temp;
	}

	public boolean checkDescSort(int[] array) {
		boolean temp = true;
		int i = 0;
		while (temp && i < array.length - 1) {
			if (array[i] - array[i + 1] < 0) {
				temp = false;
			}
			i++;
		}
		return temp;
	}

	public boolean checkOnlyEvenContains(int[] array) {
		for (int i : array) {
			if (i % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean checkOnlyOddContains(int[] array) {
		for (int i : array) {
			if (i % 2 == 0) {
				return false;
			}
		}
		return true;
	}

	public int[] allElementsPowN(int[] array, int n) {
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = (int) Math.pow(array[i], n);
		}
		return newArray;
	}

	public int[] moveMassiveElementsRight(int[] array, int index) {
		int[] newArray = new int[array.length];

		for (int i = 0; i < newArray.length; i++) {
			int newIndex = i + index;
			if (newIndex < newArray.length) {
				newArray[newIndex] = array[i];
			} else {
				newArray[newIndex - newArray.length] = array[i];
			}
		}
		return newArray;
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

	public int getMultOfElements(int[] array) {
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

	public int[] bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

}