package core;

public class Task10 {

	public static void main(String[] args) {

		Text text = new Text();
		text.setText();
		text.getText();
		
	
		text.setWords();
		text.printSentence();
		text.printWords();
		
		EditCounter x = new EditCounter();
		text.changeText();

		Paragraph para = new Paragraph(Text.text); 
		para.printValue();
		
		Sentence sent = new Sentence();
		sent.printValue(Text.text);
	}
}
