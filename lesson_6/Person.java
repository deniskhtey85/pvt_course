package core;

public class Person {
	
	public String name;
	public String surname;
	public int age;
	public int phone;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname() {
		return surname;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setPhone(int phone) { 
		this.phone = phone;
	}
	public int getPhone() { 
		return phone;
	}
	public void printAllInformation(){ // print name + surname + age + phone
		System.out.println(name + " " + surname + " " + age + " " + phone);
	}
	public void printName() { //print name + surname
		System.out.print(name + " " + surname );
	}
	public boolean isAdult(int age) { // return true/false for condition age > 18
	return (age > 18);
	}
	

}
