package task8_7a;

import task8.Tester;

public class Task8_7a {

	public static void main(String[] args) {

		// Tester tester = new Tester("Ivan", "Ivanov"); //friendly isn't visible from
		// another package
		Tester tester = new Tester("Ivan", "Ivanov", 4, "A2", 200); // only public constructor is visible from another
																	// package
		// tester.setName("Petr"); //friendly isn't visible from another package 
		// tester.setSurname("Petrov");
		// tester.setExpirienceInYears(2);
		// tester.setEnglishLevel("A1");
		// tester.setSalary(2500);

		/*
		 * System.out.println(tester.getName() + " " + tester.getSurname() + " " +
		 * tester.getExperienceInYears() + " " + tester.getEnglishLevel() + " " +
		 * tester.getSalary());
		 */ // only public constructor is visible from another package

		// System.out.println("Salary multiply by 2: " + tester.getSalaryMult2()); //
		// private method isn't visible outside class Tester (only inside class)

		// System.out.println("Expirience in month: " + tester.getExpirienceInMonths());
		// //friendly method isn't visible outside class Tester, only public

		// tester.printTesterFullName(); //protected method isn't visible outside package
		// Tester, only public
		tester.printTesterInfo();

	}

}
