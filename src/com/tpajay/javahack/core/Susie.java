package com.tpajay.javahack.core;

public class Susie implements Person, School {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		String hello = "Hey! My name is Susie.";
		return hello;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		int age = 13;
		return age;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String name = "Susie";
		return name;
	}

	@Override
	public String getSchoolName() {
		// TODO Auto-generated method stub
		String schoolname = "MiddleSchool";
		return schoolname;
	}

}
