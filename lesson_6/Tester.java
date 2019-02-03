package core;

public class Tester {
	
	public String name;
	public String surname;
	public double expirienceInYears;
	public String englishLevel;
	private int salary;
	
	private int id;
	private static int idCounter=1;
		
	public Tester() {
		id = idCounter++;
	}
	
	public Tester(String name) {
		this();
		this.name = name; 
	}
	
	public Tester(String name, String surname) {
		this(name);
		this.surname = surname; 
	}
	
	public Tester(String name, String surname, double expirienceInYears) {
		this(name, surname);
		this.expirienceInYears = expirienceInYears; 
	}
	
	public Tester(String name, String surname, double expirienceInYears, String englishLevel) {
		this(name, surname, expirienceInYears);
		this.englishLevel = englishLevel; 
	}
	
	public Tester(String name, String surname, double expirienceInYears, String englishLevel, int salary) {
		this(name, surname, expirienceInYears, englishLevel);
		this.salary = salary; 
	}
	
	public int updateTesterInfo (int salary) {
		return this.salary = salary;
	}
	
	public double updateTesterInfo (double expirienceInYears) {
		return this.expirienceInYears = expirienceInYears;
	}
	
	public String updateTesterInfo (String englishLevel) {
		return this.englishLevel = englishLevel;
	}
	
	public static void getNumOfTesters(){
        System.out.println("Total: " + (idCounter - 1) + " testers");
    }
			
	public void getTesterInfo() {
		System.out.println("Id " + id + " Name: " + name + " " + surname + ", expirience: " + expirienceInYears + ", english level: " + englishLevel + ", salary: " + salary);
	}
	
}
