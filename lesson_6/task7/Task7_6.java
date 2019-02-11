package core;

public class Task7_6 {

	public static void main(String[] args) {
		String[] wordsArray = TextCopy.inputTextCopy();
		printWordWithCodeRising(wordsArray);
	}

	public static void printWordWithCodeRising(String[] wordArray) {
		for (String word : wordArray) {
			int temp = 0;
			for (int i = 0; i < word.length() - 1; i++) {
				int charCode = word.charAt(i);
				int nextCharCode = word.charAt(i + 1);
				if (nextCharCode < charCode) {
					break;
				} else
					temp++;
				if (temp == word.length() - 1) {
					System.out.println("The word with a strict order of increasing their characters codes : " + word);
					return;
				}
			}
		}
	}
}
