package core;

import java.util.ArrayList;
import java.util.Arrays;

public class Sentence extends Text implements InterfacePrint{
	
 private String sentence;
	 
	 public Sentence() {
		
	    }
	 
	 @Override
	 public void printValue(String paragraph) {
		 System.out.println("Your sentencies is (overrided method from Sentence class): \")");
		 ArrayList<String> items = new ArrayList<String>(Arrays.asList(paragraph.split("[\\.|\\?|\\!]")));
		 for (int i = 0; i < items.size(); i++) {
	            System.out.println(items.get(i).trim());
	        }
	 }

	@Override
	public void printValue() {
	}
	

}
