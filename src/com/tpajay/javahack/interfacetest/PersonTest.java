package com.tpajay.javahack.interfacetest;

//interface defines the API not the implementation
//Person iterface is defined, not additional developers
//can implement the interface and customize their Person(Jason, Evan, etc) methods
//because the interfaces tells them what methods to code
public class PersonTest {
	
	public static void main(String[] args){
		
		//Polymorphic, stored in Person variable as Evan is a Person
		Susie person1 = new Susie();
		Person person2 = new Jimmy();
		
		int age = person1.getAge();
		String school = person1.getSchoolName();
		System.out.println(">>>>>> Name: " + person1.getName());
		System.out.println(">>>>>> Age: " + age);
		System.out.println(">>>>>> School: " + school);
		
		System.out.println("----------------------------------");
		
		age = person2.getAge();
		System.out.println(">>>>>> Name: " + person2.getName());
		System.out.println(">>>>>> Age: " + age);
		
	}

}