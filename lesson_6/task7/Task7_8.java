package core;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7_8 {

	public static void main(String[] args) {

		String[] wordsArray = TextCopy.inputTextCopy();
		System.out.println("Words with numbers only: ");
		findOnlyNumber(wordsArray).forEach(System.out::println);
		ArrayList<String> palindromes = palindromesCheck(findOnlyNumber(wordsArray));
		printPalindrome(palindromes);

	}

	public static void printPalindrome(ArrayList<String> palArray) {
		if (palArray.size() == 1) {
			System.out.println("Palindrome: " + palArray.get(0));
		} else if (palArray.size() > 1) {
			System.out.println("Palindrome: " + palArray.get(1));
		} else
			System.out.println("A polindrome not found not found.");
	}

	private static ArrayList<String> findOnlyNumber(String[] wordArray) {
		ArrayList<String> numbers = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher;
		for (String word : wordArray) {
			matcher = pattern.matcher(word);
			if (matcher.matches()) {
				numbers.add(word);
			}
		}
		return numbers;
	}

	private static ArrayList<String> palindromesCheck(ArrayList<String> wordArray) {
		ArrayList<String> palindromesArray = new ArrayList<>();
		for (String word : wordArray) {
			if (word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())) {
				palindromesArray.add(word);
			}
		}
		return palindromesArray;
	}
}
