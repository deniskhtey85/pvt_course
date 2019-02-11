package core;

public class Task7_3 {

	public static void main(String[] args) {
		String[] stringsArray = TextCopy.inputTextCopy();
		System.out.println("Average length = " + averageStringsLength(stringsArray));
		System.out.println("Strings with a length less than the average: ");
		for (String str : stringsArray) {
			if (str.length() < averageStringsLength(stringsArray)) {
				printLessThanAverage(str);
			}
		}

	}

	private static int averageStringsLength(String[] stringsArray) {
		int totalStringLength = 0;
		for (String string : stringsArray) {
			totalStringLength += string.length();
		}
		return totalStringLength / stringsArray.length;
	}

	private static void printLessThanAverage(String string) {
		System.out.println(string + " (String length is: " + string.length() + ")");

	}

}
