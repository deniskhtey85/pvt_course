package core;

public class Task7_7 {

	public static void main(String[] args) {

		String[] wordsArray = TextCopy.inputTextCopy();
		diffSymbolsCheck(wordsArray);
	}

	public static void diffSymbolsCheck(String[] wordArray) {
		boolean flag = false;
		for (String word : wordArray) {
			if (word.length() == word.chars().distinct().count()) {
				System.out.println("A word consisting of different characters: " + word);
				break;
			} else
				flag = true;
		}
		if (flag == true) {
			System.out.println("A word consisting of different characters not found.");
		}
	}

}
