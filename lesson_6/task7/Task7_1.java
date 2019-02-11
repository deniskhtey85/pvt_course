package core;

public class Task7_1 {

	public static void main(String[] args) {
		String[] stringsArray = TextCopy.inputTextCopy();
		System.out.println("The longest string is: " + "\n" + findLongestString(stringsArray) + " (String length is: "
				+ findLongestString(stringsArray).length() + ")");
		System.out.println("The shortest string is: " + "\n" + findShortestString(stringsArray) + " (String length is: "
				+ findShortestString(stringsArray).length() + ")");
	}

	private static String findShortestString(String[] stringsArray) {
		String shortestString = stringsArray[0];
		for (int i = 0; i < stringsArray.length; i++) {
			if (stringsArray[i].length() < shortestString.length()) {
				shortestString = stringsArray[i];
			}
		}
		return shortestString;
	}

	private static String findLongestString(String[] stringsArray) {
		String longestString = stringsArray[0];
		for (int i = 0; i < stringsArray.length; i++) {
			if (stringsArray[i].length() > longestString.length()) {
				longestString = stringsArray[i];
			}
		}
		return longestString;
	}

}