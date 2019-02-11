package core;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7_5 {

	public static void main(String[] args) {
		String[] wordsArray = TextCopy.inputTextCopy();
		System.out.println("Total number of words with latin characters only = "
									+ getWordsWithLatinChars(wordsArray).size());
		System.out.println("Total number of word with the equal number of vowels and consonants letters = "
									+ getWordEqualVC(getWordsWithLatinChars(wordsArray)));
	}

	private static ArrayList<String> getWordsWithLatinChars(String[] wordArray) {
		ArrayList<String> wordsWithLatinChars = new ArrayList<String>();
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher;

		for (String word : wordArray) {
			matcher = pattern.matcher(word);
			if (matcher.matches()) {
				wordsWithLatinChars.add(word);
			}
		}
		return wordsWithLatinChars;
	}

	private static int getWordEqualVC(ArrayList<String> wordsWithLatinChars) {
		int wordCounter = 0;
		for (String word : wordsWithLatinChars) {
			word = word.toLowerCase();
			int vowelCounter = 0;
			int consonantCounter = 0;
			
			for (int i = 0; i < word.length(); i++) {
				if ((word.charAt(i) == 'a') || (word.charAt(i) == 'e') || (word.charAt(i) == 'i')
						|| (word.charAt(i) == 'o') || (word.charAt(i) == 'u') || (word.charAt(i) == 'y')) {
					vowelCounter++;
				} else
					consonantCounter++;
			}
			if (vowelCounter == consonantCounter) {
				wordCounter++;
			}
		}
		return wordCounter;
	}

}
