package com.tpajay.javahack.core;

public class Jimmy implements Person {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		String hello = "Hey! My name is Jimmy.";
		return hello;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String name = "Jimmy";
		return name;
	}	

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		int age=10;
		return age;
	}

}
