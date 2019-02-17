package core;

public class Task13 {

	public static void main(String[] args) {

		Massive array1 = new Massive();

		array1.inputSize();
		array1.fillArrayRandomNumbers();
		array1.printSumOfElements();
		array1.printMultOfElements();
		array1.getElementByIndex(22);
		array1.getElementByIndex2(14);

		Massive.printArray(array1.devideEachElementByN(array1.multOfElements));
	}

}
