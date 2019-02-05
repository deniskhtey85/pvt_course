package task8;

public class Tester {

	public String name;
	public String surname;
	public int expirienceInYears;
	String englishLevel;
	private double salary;

	Tester() {
	}

	Tester(String name) {
		this();
		this.name = name;
	}

	Tester(String name, String surname) {
		this(name);
		this.surname = surname;
	}

	Tester(String name, String surname, int expirienceInYears) {
		this(name, surname);
		this.expirienceInYears = expirienceInYears;
	}

	Tester(String name, String surname, int expirienceInYears, String englishLevel) {
		this(name, surname, expirienceInYears);
		this.englishLevel = englishLevel;
	}

	public Tester(String name, String surname, int expirienceInYears, String englishLevel, double salary) {
		this(name, surname, expirienceInYears, englishLevel);
		this.salary = salary;
	}

	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	

	String getSurname() {
		return surname;
	}
	
	void setSurname(String surname) {
		this.surname = surname;
	}

	int getExperienceInYears() {
		return expirienceInYears;
	}
	
	void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}
	
	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}
	
	private double getSalaryMult2() {
		int multIndex =2;
		return salary * multIndex;
	}
	
	int getExpirienceInMonths() {
		int numberOfMonthsInYear = 12;
		return expirienceInYears * numberOfMonthsInYear;
	}
	
	protected void printTesterFullName() {
		String copy = "Tester Full Name: ";
		System.out.println(copy + name + " " + surname);
	}
	
	public void printTesterInfo() {
		System.out.printf("Tester full info: name %s, surname %s, expirience in yars %s, english level %s, salary %s", name, surname, expirienceInYears, englishLevel, salary);
	}

}
