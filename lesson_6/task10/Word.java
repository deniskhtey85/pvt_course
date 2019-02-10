package core;

public class Word extends Text implements InterfacePrint {
	
	 private String word;
	 
	 public Word(String word) {
	        this.word = word;
	    }

	 @Override
	 public void printValue() {
		 System.out.println(this.word); 
	 }

	@Override
	public void printValue(String copy) {
				
	}
}
