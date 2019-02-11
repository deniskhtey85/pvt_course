package core;

public class Task7_2 {
	public static void main(String[] args) {
		String[] stringsArray = TextCopy.inputTextCopy();
		String ascCopy = "Strings are sorted by ascending:: ";
		String descCopy = "Strings are sorted by descending: ";
		String[] strArrayAsc = stringsArrayAsc(stringsArray);
		System.out.println(ascCopy);
		TextCopy.printTextCopy(strArrayAsc);
		String[] strArrayDesc = stringsArrayDesc(stringsArray);
		System.out.println(descCopy);
		TextCopy.printTextCopy(strArrayDesc);

	}

	private static String[] stringsArrayAsc(String[] stringsArray) {
		for (int i = 0; i < stringsArray.length; i++) {
			String temp;
			for (int k = 0; k < stringsArray.length - 1 - i; k++) {
				if (stringsArray[k].length() > stringsArray[k + 1].length()) {
					temp = stringsArray[k];
					stringsArray[k] = stringsArray[k + 1];
					stringsArray[k + 1] = temp;
				}
			}
		}
		return stringsArray;
	}

	private static String[] stringsArrayDesc(String[] stringsArray) {
		for (int i = 0; i < stringsArray.length; i++) {
			String temp;
			for (int k = 0; k < stringsArray.length - 1 - i; k++) {
				if (stringsArray[k].length() < stringsArray[k + 1].length()) {
					temp = stringsArray[k];
					stringsArray[k] = stringsArray[k + 1];
					stringsArray[k + 1] = temp;
				}
			}
		}
		return stringsArray;
	}

}
