package core;

public class Task7_4 {

	public static void main(String[] args) {
		String[] wordsArray = TextCopy.inputTextCopy();
		System.out.println("Word with minimum different characters is :" + findMinDiffValue(wordsArray));
	}

	private static String findMinDiffValue(String[] wordsArray) {
		int indexOfMinDiffValue = wordsArray[0].length();
		String stringMinDiffValue = wordsArray[0];
		for (int i = 0; i < wordsArray.length; i++) {
			if ((int) wordsArray[i].chars().distinct().count() < indexOfMinDiffValue) {
				indexOfMinDiffValue = (int) wordsArray[i].chars().distinct().count();
				stringMinDiffValue = wordsArray[i];
			}
		}
		return stringMinDiffValue;
	}
}
