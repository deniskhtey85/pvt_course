package core;

public class Paragraph extends Text implements InterfacePrint{
	
	public String paragraph;
	private int sentenceCout;

	public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }
 
	@Override
	public void printValue() {
		System.out.println("Your paragraph is (overrided method from Paragraph class): \")");
		System.out.println(this.paragraph); 
	}

	@Override
	public void printValue(String copy) {
				
	}
	
	
	
	
		

}
