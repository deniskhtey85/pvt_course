package core;

public class Task4_1 {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setName("Ivan");
		person.setSurname("Ivanov");
		person.setAge(19);
		person.setPhone(230123);
		Person person2 = new Person();
		person2.setName("Piotr");
		person2.setSurname("Petrov");
		person2.setAge(17);
		person2.setPhone(213056);
		
		person.printAllInformation();
		person2.printAllInformation();
		person.printName();
		System.out.print(" is adult? :" + person.isAdult(person.getAge()));
		System.out.println();
		person2.printName();
		System.out.print(" is adult? :" + person2.isAdult(person2.getAge()));
	}

}
