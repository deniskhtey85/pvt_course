package core;

public class Task15 {

	public static void main(String[] args) {

		Massive massive = new Massive();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		massive.printMassive(array);
		massive.multiplyByN(array, 2);
		massive.devideByN(array, 2);
		massive.printMassive(massive.getReverseMassive(array));
		System.out.println(massive.getSumOfElements(array));
		System.out.println(massive.getMultiplyOfElements(array));
		massive.multipleBy2ElementWithIndexN(array, 2);
	}

}
