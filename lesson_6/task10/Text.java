package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Text {

	static String text = null;
	Scanner scanner = new Scanner(System.in).useDelimiter("esc");
	String[] sentence;
	String[] words;

	public Text() {
	}

	public String setText() {
		System.out.println("Input your text, use 'esc' to close input : ");
		text = this.scanner.next();
		return text;
	}

	public void getText() {
		System.out.println("Your text is: \n" + text);
	}

	public String[] stringArray() {
		String[] sentence = this.text.split("[.!?]\\s*");
		this.sentence = sentence;
		return sentence;

	}

	public void printSentence() {
		System.out.println("Your sentencies is (method from Text class): ");
		for (int i = 0; i < stringArray().length; ++i) {
			System.out.println(stringArray()[i]);
		}
	}

	public String[][] setWords() {
		String sentence[] = text.split("[.!?]\\s*");
		String words[][] = new String[sentence.length][];
		for (int i = 0; i < sentence.length; ++i) {
			words[i] = sentence[i].split("[\\p{Punct}\\s]+");
		}
		return words;
	}

	public void printWords() {
		String sentence[] = text.split("[.!?]\\s*");
		String words[][] = new String[sentence.length][];
		for (int i = 0; i < sentence.length; ++i) {
			words[i] = sentence[i].split("[\\p{Punct}\\s]+");

		}
		System.out.println(Arrays.deepToString(words));
	}

	public void changeText() {
		int x = EditCounter.editCounter;
		String tmp;
		String[] text = this.text.split(" "); 

		for (int i = 0; i < text.length; i++) {
			if (x < text[i].length()) {
				tmp = "";
				tmp += text[i].substring(0, x - 1);
				tmp += '%';
				tmp += text[i].substring(x, text[i].length());
				text[i] = tmp;
			}
			System.out.print(" " + text[i]);
		}

	}

}
