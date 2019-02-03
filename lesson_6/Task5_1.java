package core;

public class Task5_1 {

	public static void main(String[] args) {
		
		Tester tester1 = new Tester("Ivan");
		Tester tester2 = new Tester("Petr", "Petrov", 2.5);
		Tester tester3 = new Tester("Dmitriy", "Dmitrov", 6, "A1", 250);
			
		tester1.getTesterInfo();
		tester2.getTesterInfo();
		tester3.getTesterInfo();
			
		tester1.updateTesterInfo(1.8);
		tester1.getTesterInfo();
		tester2.updateTesterInfo("B2");
		tester2.getTesterInfo();
		tester3.updateTesterInfo(150);
		tester3.getTesterInfo();
		
		Tester.getNumOfTesters();
		
	}

}
