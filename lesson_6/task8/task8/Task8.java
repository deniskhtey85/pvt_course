package task8;

public class Task8 {

	public static void main(String[] args) {
		
		Tester tester = new Tester("Ivan", "Ivanov");
		tester.setName("Petr");
		tester.setSurname("Petrov");
		tester.setExpirienceInYears(2);
		tester.setEnglishLevel("A1");
		tester.setSalary(2500);
		
		System.out.println(tester.getName() + " " + tester.getSurname() + " "
		+ tester.getExperienceInYears() + " " + tester.getEnglishLevel() + " " + tester.getSalary());
		
		// System.out.println("Salary multiply by 2: " + tester.getSalaryMult2()); method isn't visible outside class Tester

		System.out.println("Expirience in month: " + tester.getExpirienceInMonths());
		
		tester.printTesterFullName();
		tester.printTesterInfo();
	}

}
